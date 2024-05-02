package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.deckTypes.DeckType;
import be.ugent.objprog.ugentopoly.deckTypes.JailType;
import be.ugent.objprog.ugentopoly.deckTypes.deckFactories.*;
import be.ugent.objprog.ugentopoly.tiles.tileFactories.*;
import be.ugent.objprog.ugentopoly.fxmlControllers.UgentopolyController;
import be.ugent.objprog.ugentopoly.tiles.Eigendom;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import be.ugent.objprog.ugentopoly.layout.LogLayout;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Random;
//Het model, waar de logica van het spel in zit.
public class BoardModel {

    private static final Random RG = new Random();

    private final BoardView boardView;
    private final UgentopolyController ugentopolyController;

    //Settings van het bord bijhouden
    private int startBalance;
    private int startSalary;

    //Areas en Tiles bijhouden, met posities.
    private final Area[] areas;
    private final Tile[] tiles;

    //Vorige geklikte tile bijhouden
    private Tile prevTile;

    //Vorige InfoTab bijhouden

    private AnchorPane prevSpelerInfo;

    //Map voor de positie van de tile naar de parent gridpane
    private final Map<Integer, GridPane> posToParent;

    //Spelers
    private final List<Speler> spelers;
    private Speler currentSpeler;
    private Speler prevSpeler;

    private final List<DeckType> chanceDeck;
    private final List<DeckType> chestDeck;
    private Map<String, DeckFactory> deckTypeFactories;

    private int startPosition;
    private int jailPosition;
    private int laatsteWorp;
    private int bonusPot;
    private LogLayout log;

    public BoardModel(UgentopolyController ugentopolyController, BorderPane board, GridPane top, GridPane left, AnchorPane endGame, AnchorPane endGameInfo, GridPane right, GridPane bottom, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow, AnchorPane infoTab){
        this.ugentopolyController = ugentopolyController;
        boardView = new BoardView(this, board, endGame, endGameInfo, cardPane, boardShow, tileShow, infoTab);

        bonusPot = 0;
        areas = new Area[8]; tiles = new Tile[40];

        //Bord layout gaat altijd hetzelfde blijven. Daarom gehardcode
        posToParent = new HashMap<>();
        for (int i = 0; i < 40; i++){
            if (i == 0){ posToParent.put(i, bottom);
            } else if (i < 10){ posToParent.put(i, left);
            } else if (i < 21){ posToParent.put(i, top);
            } else if (i < 30){ posToParent.put(i, right);
            } else { posToParent.put(i, bottom);
            }
        }
        chanceDeck = new ArrayList<>();
        chestDeck = new ArrayList<>();
        spelers = new ArrayList<>();

        initialize();
    }

    //Initialize Section
    public void initialize(){
        //Deck Factories, moet gebruikt woren in 2 methoden. Daarom dat ik ze globaal aanmaak
        deckTypeFactories = Map.of(
                "JAIL", new JailTypeFactory(),
                "MONEY", new MoneyTypeFactory(),
                "MOVEREL", new MoveRelTypeFactory(),
                "MOVE", new MoveTypeFactory(),
                "PLAYERS_MONEY", new PlayersMoneyTypeFactory()
        );

        //XML en Properties inladen
        xmlSetup();
        propertySetup();

        //Kaarten maken
        setGridPositions();
        makeCards();

        //Start Game initaliseren
        new StartGame(this);
    }

    public void xmlSetup(){
        //XML File inladen
        try (InputStream input = UgentopolyController.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.xml")) {
            Document document = new SAXBuilder().build(input);

            //Root element ophalen
            Element root = document.getRootElement();

            //Settings instellen
            this.startBalance = root.getChild("settings").getAttribute("balance").getIntValue();
            this.startSalary = root.getChild("settings").getAttribute("start").getIntValue();

            //Areas instellen
            setAreas(root.getChild("areas"));

            //Tiles instellen
            setTiles(root.getChild("tiles"));

            //Kaarten instellen
            for (Element deck : root.getChildren("deck")) {
                // Voor 2 verschillenden soorten is het beter om een if else te gebruiken i.p.v. met factories te werken.
                if (deck.getAttributeValue("type").equals("CHANCE")){
                    setDeck(deck, chanceDeck);
                } else if (deck.getAttributeValue("type").equals("CHEST")){
                    setDeck(deck, chestDeck);
                }
            }

        } catch (IOException ex) { System.err.println("Error Loading the XML file - ugentopoly.xml");
        } catch (JDOMException JE){ System.err.println("JDOMException - ugentopoly.xml");
        }
    }

    public void propertySetup(){
        try (InputStream input = UgentopolyController.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.properties")){
            Properties properties = new Properties();
            properties.load(input);
            for (Tile tile : tiles){ tile.setText(properties.getProperty(tile.getId())); }
            for (DeckType card: chanceDeck){ card.setText(properties.getProperty(card.getId())); }
            for (DeckType card: chestDeck){ card.setText(properties.getProperty(card.getId())); }
        } catch (IOException ex ){ System.err.println("Error Loading the Properties File - ugentopoly.properties");
        }
    }


    public void setAreas(Element areas){
        List<Element> children = areas.getChildren("area");
        for (int i = 0; i < children.size(); i ++){
            Element area = children.get(i);

            Area newArea = new Area(area.getAttributeValue("id"), area.getAttributeValue("color"));
            this.areas[i] = newArea;
        }
    }
    public void setTiles(Element streets) {
        Map<String, TileFactory> factories = Map.of(
                "CHANCE", new ChanceFactory(),
                "CHEST", new ChestFactory(),
                "FREE_PARKING", new FreeParkingFactory(),
                "GO_TO_JAIL", new GoToJailFactory(),
                "JAIL", new JailFactory(),
                "RAILWAY", new RailwayFactory(),
                "START", new StartFactory(),
                "STREET", new StreetFactory(),
                "TAX", new TaxFactory(),
                "UTILITY", new UtilityFactory()
        );
        Map<String, Area> areaMap = Map.of(
                "area1", areas[0],
                "area2", areas[1],
                "area3", areas[2],
                "area4", areas[3],
                "area5", areas[4],
                "area6", areas[5],
                "area7", areas[6],
                "area8", areas[7]
        );
        List<Element> children = streets.getChildren("tile");
        for (Element child : children) {
            String type = child.getAttributeValue("type");

            TileFactory factory = factories.get(type);
            if (factory != null) {
                Tile tile = factory.createTile(child, areaMap, this);
                this.tiles[tile.getPosition()] = tile;
            }
        }
    }

    public void setDeck(Element deck, List<DeckType> deckList){
        List<Element> children = deck.getChildren("card");
        for (Element child: children){
            String type = child.getAttributeValue("type");
            DeckFactory factory = deckTypeFactories.get(type);
            if (factory != null){
                DeckType deckType = factory.createDeckType(this, child, deckList);
                deckList.add(deckType);
            }
        }
    }

    public void setGridPositions(){
        // De waarden 10, 21 en 30 zijn voor de top, left, right en bottom. De speciale waarden van gridPos is omdat de tiles in een andere volgorde staan.
        // Het bord is altijd in 40 tiles, dus heb ik deze waarden gehardcode.
        for (int i = 0; i < tiles.length; i ++){
            int gridPos;
            if (i == 0){ gridPos = 0;
            } else if (i < 10){ gridPos = 9 - i;
            } else if (i < 21){ gridPos = i - 10;
            } else if (i < 30){ gridPos = i - 21;
            } else { gridPos = 10 - (i - 30); }
            tiles[i].setGridPos(gridPos);
        }
    }

    public void makeCards(){
        for (Tile tile : tiles){
            tile.initializeCards();
            Card card = tile.getCard();
            GridPane parent = posToParent.get(tile.getPosition());
            boardView.placeCard(card, parent, tile.getGridPos1(), tile.getGridPos2());
        }
    }

    //Getters and Setters Section
    public UgentopolyController getController() { return ugentopolyController; }
    public List<Speler> getSpelers() { return spelers; }
    public int getStartBalance() { return startBalance; }
    public Speler getCurrentSpeler() { return currentSpeler; }
    public int getLaatsteWorp() { return laatsteWorp; }
    public int getBonusPot() { return bonusPot; }
    public Tile getTile(int position) {
        return tiles[position];
    }
    public int getStartPosition(){
        return startPosition;
    }

    public void setStartPosition(int startPosition){
        this.startPosition = startPosition;
    }
    public void setJailPosition(int jailPosition){
        this.jailPosition = jailPosition;
    }
    public void setLog(LogLayout log){
        this.log = log;
    }
    public void setPrevTile(Tile tile){
        prevTile = tile;
    }

    //Start Spel Section
    public void startSpel(){
        Stage stage = (Stage) boardView.getSpelBord().getScene().getWindow();
        stage.show();
        currentSpeler = spelers.get(0);
        setupInfoBoard();
        setupPions();
        log.updateLog("Het spel is gestart");
        log.updateLog("Het is de beurt aan " + currentSpeler.getNaam());
        boardView.startSpelAlert();
    }
    public void addSpeler(Speler speler){
        speler.setSpelerIndex(spelers.size());
        spelers.add(speler);
    }
    public void showSpelerInfo(Speler speler) {
        boardView.showSpelerInfo(prevSpelerInfo, speler.getSpelerInfo());
        prevSpelerInfo = speler.getSpelerInfo();
    }
    public void setupInfoBoard(){
        spelers.forEach(speler -> {
            boardView.placeButton(speler.getSpelerButton(), speler.getSpelerIndex(), speler.getWhiteText());
            boardView.placeSpelerInfo(speler.getSpelerInfo());
            boardView.placeCurrentSpelerLayout(speler.getCurrentSpelerLayout());
        });
        showSpelerInfo(spelers.get(0));
    }
    public void setupPions(){
        spelers.forEach(speler -> {
            boardView.placePion(speler.getPionImage(), speler.getCurrentTile().getTileCard(), speler.getSpelerIndex());
        });
        boardView.showCurrentSpeler(null, currentSpeler.getCurrentSpelerLayout());
    }

    //Board Logica
    public void showTile(Tile tile){
        boardView.showTile(prevTile, tile);
    }

    public void showBoard(){
        boardView.showBoard(prevTile);
    }

    public void moveSpeler(int steps, boolean doubleThrow){
        log.updateLog(currentSpeler.getNaam() + " gooit " + steps);
        this.laatsteWorp = steps;
        this.prevSpeler = currentSpeler;
        if (currentSpeler.getInJail()){
            if (doubleThrow){
                currentSpeler.leaveJail();
                boardView.escapedJail(currentSpeler, false);
                movePionSteps(currentSpeler, steps);
            }
            changeCurrentSpeler(currentSpeler);
        } else {
            if (doubleThrow) {
                currentSpeler.addDubbelThrow();
                movePionSteps(currentSpeler, steps);
                if (currentSpeler.getDubbelThrowCounter() == 3) {
                    goToJail(currentSpeler);
                    changeCurrentSpeler(currentSpeler);
                    log.updateLog("3 maal dubbel gegooid, " + currentSpeler.getNaam() + " gaat naar de gevangenis");
                }
                if (currentSpeler.getInJail()){
                    changeCurrentSpeler(currentSpeler);
                }
            } else {
                currentSpeler.notDubbelThrow();
                movePionSteps(currentSpeler, steps);
                changeCurrentSpeler(currentSpeler);
            }
        }
    }

    public void movePion(Speler speler, int oldPosition, int newPosition, boolean collect){
        boardView.removePion(speler.getPionImage(), speler.getCurrentTile().getTileCard());
        speler.setPosition(newPosition);
        if (collect){
            if (newPosition == startPosition){
                speler.updateSaldo(startSalary * 2);
                log.updateLog(speler.getNaam() + " is geland op de Start en krijgt  $" + startSalary * 2);
            } else if ((oldPosition < startPosition || oldPosition > newPosition) && newPosition > startPosition){
                speler.updateSaldo(startSalary);
                log.updateLog(speler.getNaam() + " is gepasseerd de Start en krijgt $" + startSalary);
            }
        }
        boardView.placePion(speler.getPionImage(), speler.getCurrentTile().getTileCard(), speler.getSpelerIndex());
        currentSpeler.getCurrentTile().action();
        log.updateLog(speler.getNaam() + " gaat naar " + speler.getCurrentTile().getText());
    }

    public void movePionSteps(Speler speler, int steps){
        int oldPosition = speler.getPositie();
        int newPosition = (oldPosition + steps + 40) % 40;
        movePion(speler, oldPosition, newPosition, true);
    }

    private void changeCurrentSpeler(Speler oldSpeler){
        currentSpeler = spelers.get((oldSpeler.getSpelerIndex() + 1) % spelers.size());
        boardView.showCurrentSpeler(oldSpeler.getCurrentSpelerLayout(), currentSpeler.getCurrentSpelerLayout());
        log.updateLog("Het is de beurt aan " + currentSpeler.getNaam());
    }

    public void goToJail(Speler speler){
        if (currentSpeler.hasOutOfJailKaart()){
            currentSpeler.useOutOfJailKaart();
            boardView.escapedJail(speler, true);
        } else {
            movePion(speler, speler.getPositie(), jailPosition, false);
            speler.goToJail();
            showTile(tiles[jailPosition]);
            boardView.showToJail(speler);
        }
    }

    public void showBuyEigendom(Eigendom eigendom){
        showTile(eigendom);
        boardView.showBuying(eigendom);
    }

    public void buyEigendom(Eigendom eigendom){
        prevSpeler.addProperty(eigendom);
        prevSpeler.updateSaldo(-eigendom.getCost());
        eigendom.setEigenaar(prevSpeler);
        log.updateLog(prevSpeler.getNaam() + " koopt " + eigendom.getText() + " voor " + eigendom.getCost());
    }

    public void betaalHuur(Eigendom eigendom){
        showTile(eigendom);
        currentSpeler.updateSaldo(-eigendom.getHuur());
        eigendom.getEigenaar().updateSaldo(eigendom.getHuur());
        boardView.showBetaalHuur(eigendom, currentSpeler, eigendom.getEigenaar());
    }

    public void payBonusPot(int amount, Speler speler, Tile tile){
        speler.updateSaldo(-amount);
        showTile(tile);
        boardView.showTaxPaid(amount, speler);
        bonusPot += amount;
    }

    public void giveBonusPot(Speler speler, Tile tile){
        speler.updateSaldo(bonusPot);
        bonusPot = 0;
        showTile(tile);
        boardView.showGaveBonusPot(speler);
    }

    //Deck kaarten Logica
    public  void takeChanceCard(Tile tile){
        showTile(tile);
        int index = RG.nextInt(chanceDeck.size());
        DeckType card = chanceDeck.get(index);
        card.action();
    }

    public void takeChestCard(Tile tile){
        showTile(tile);
        int index = RG.nextInt(chestDeck.size());
        DeckType card = chestDeck.get(index);
        card.action();
    }

    public void moneyDeckCard(DeckType card, int amount){
        currentSpeler.updateSaldo(amount);
        boardView.showMoneyDeck(currentSpeler, card.getText());
    }

    public void moveRelDeckCard(DeckType card, int steps){
        boardView.showRelMoveCard(currentSpeler, card.getText());
        movePionSteps(currentSpeler, steps);
    }

    public void moveDeckCard(DeckType card, boolean collect, int position){
        boardView.showMoveCard(currentSpeler,  card.getText());
        movePion(currentSpeler, currentSpeler.getPositie(), position, collect);
    }

    public void playersMoneyDeckCard(DeckType card, int amount){
        for (Speler speler : spelers){
            if (speler != currentSpeler){
                speler.updateSaldo(- amount);
            }
        }
        currentSpeler.updateSaldo(amount * spelers.size() - 1);
        boardView.showPlayersMoneyDeck(currentSpeler, card.getText());
    }

    public void jailDeckCard(JailType card, List<DeckType> deckList){
        boardView.showJailDeck(currentSpeler, card.getText());
        deckList.remove(card);
        currentSpeler.addOutOfJailKaart(card, deckList);
    }

    //Einde Spel Logica
    public void failliet(Speler speler){
        boardView.showFailliet(speler);
        Speler winner = spelers.stream().max(Comparator.comparing(Speler::getSaldo)).orElse(null);
        log.updateLog(speler.getNaam() + " is failliet");
        log.updateLog(winner.getNaam() + " heeft gewonnen!");
        boardView.showWinner(winner);
    }
}
