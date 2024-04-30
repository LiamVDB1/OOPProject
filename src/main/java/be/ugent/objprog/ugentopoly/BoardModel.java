package be.ugent.objprog.ugentopoly;

import be.ugent.objprog.ugentopoly.factories.*;
import be.ugent.objprog.ugentopoly.fxmlControllers.UgentopolyController;
import be.ugent.objprog.ugentopoly.tiles.Eigendom;
import be.ugent.objprog.ugentopoly.tiles.Tile;
import javafx.beans.InvalidationListener;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class BoardModel implements javafx.beans.Observable {
    //UI elementen
    /*
    private final BorderPane board;
    private final GridPane top;
    private final GridPane left;
    private final StackPane center;
    private final GridPane right;
    private final GridPane bottom;
    */

    private final BoardView boardView;
    private final UgentopolyController ugentopolyController;

    //Settings van het bord bijhouden
    private int startBalance;
    private int startSalary;

    //Areas en Tiles bijhouden, met posities.
    private Area[] areas;
    private Tile[] tiles;

    //Vorige geklikte tile bijhouden
    private Tile prevTile;

    //Vorige InfoTab bijhouden

    private AnchorPane prevSpelerInfo;

    //Map voor de positie van de tile naar de parent gridpane
    private final Map<Integer, GridPane> posToParent;

    //Spelers
    private List<Speler> spelers = new ArrayList<>();
    private Speler currentSpeler;
    private Speler prevSpeler;

    private int startPosition;
    private int jailPosition;
    private int laatsteWorp;
    private int bonusPot;

    public BoardModel(UgentopolyController ugentopolyController, BorderPane board, GridPane top, GridPane left, StackPane center, GridPane right, GridPane bottom, AnchorPane cardPane, AnchorPane boardShow, AnchorPane tileShow, AnchorPane infoTab){
        // this.board = board; this.top = top; this.left = left; this.center = center; this.right = right; this.bottom = bottom;

        this.ugentopolyController = ugentopolyController;
        boardView = new BoardView(this, board, top, left, center, right, bottom, cardPane, boardShow, tileShow, infoTab);

        bonusPot = 0;
        areas = new Area[8]; tiles = new Tile[40];

        posToParent = new HashMap<>();
        for (int i = 0; i < 40; i++){
            if (i == 0){ posToParent.put(i, bottom);
            } else if (i < 10){ posToParent.put(i, left);
            } else if (i < 21){ posToParent.put(i, top);
            } else if (i < 30){ posToParent.put(i, right);
            } else { posToParent.put(i, bottom);
            }
        }

        initialize();
    }

    public void initialize(){
        //XML en Properties inladen
        xmlSetup();
        propertySetup();

        //Kaarten maken
        setGridPositions();
        makeCards();

        //Start Game initaliseren
        new StartGame(this);
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }

    public UgentopolyController getController() { return ugentopolyController; }
    public List<Speler> getSpelers() { return spelers; }

    public int getStartBalance() { return startBalance; }

    public Speler getCurrentSpeler() { return currentSpeler; }
    public int getLaatsteWorp() { return laatsteWorp; }
    public int getBonusPot() { return bonusPot; }

    public void xmlSetup(){
        //XML File inladen
        try (InputStream input = UgentopolyController.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.deel1.xml")) {
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

        } catch (IOException ex) { System.err.println("Error Loading the XML file - ugentopoly.deel1.xml");
        } catch (JDOMException JE){ System.err.println("JDOMException - ugentopoly.deel1.xml");
        }
    }

    public void propertySetup(){
        try (InputStream input = UgentopolyController.class.getResourceAsStream("/be/ugent/objprog/ugentopoly/ugentopoly.deel1.properties")){
            Properties properties = new Properties();
            properties.load(input);
            for (Tile tile : tiles){ tile.setText(properties.getProperty(tile.getId())); }
        } catch (IOException ex ){ System.err.println("Error Loading the Properties File - ugentopoly.deel1.properties");
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

    public void setStartPosition(int startPosition){
        this.startPosition = startPosition;
    }
    public void setJailPosition(int jailPosition){
        this.jailPosition = jailPosition;
    }

    public int getStartPosition(){
        return startPosition;
    }

    public void makeCards(){
        for (Tile tile : tiles){
            tile.initializeCards();
            Card card = tile.getCard();
            GridPane parent = posToParent.get(tile.getPosition());
            boardView.placeCard(card, parent, tile.getGridPos1(), tile.getGridPos2());
        }
    }

    public void showTile(Tile tile){
        boardView.showTile(prevTile, tile);
    }

    public void setPrevTile(Tile tile){
        prevTile = tile;
    }

    public void showBoard(){
        boardView.showBoard(prevTile);
    }

    public void addSpeler(Speler speler){
        speler.setSpelerIndex(spelers.size());
        spelers.add(speler);
    }

    public void startSpel(){
        Stage stage = (Stage) boardView.getSpelBord().getScene().getWindow();
        stage.show();
        currentSpeler = spelers.get(0);
        setupInfoBoard();
        setupPions();
    }

    public Tile getTile(int position) {
        return tiles[position];
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

    public void movePion(Speler speler, int steps){
        boardView.removePion(speler.getPionImage(), speler.getCurrentTile().getTileCard());
        int oldPosition = speler.getPositie();
        speler.movePion(steps);
        if (speler.getPositie() == startPosition){
            speler.updateSaldo(startSalary * 2);
        } else if ((oldPosition < startPosition || oldPosition > speler.getPositie()) && speler.getPositie() > startPosition){
            speler.updateSaldo(startSalary);
        }
        boardView.placePion(speler.getPionImage(), speler.getCurrentTile().getTileCard(), speler.getSpelerIndex());
        currentSpeler.getCurrentTile().action();
    }

    public void moveSpeler(int steps, boolean doubleThrow){
        prevSpeler = currentSpeler;
        this.laatsteWorp = steps;
        if (doubleThrow){
            movePion(currentSpeler, steps);
        } else {
            movePion(currentSpeler, steps);
            currentSpeler = spelers.get((currentSpeler.getSpelerIndex() + 1) % spelers.size());
            boardView.showCurrentSpeler(prevSpeler.getCurrentSpelerLayout(), currentSpeler.getCurrentSpelerLayout());
        }
    }

    public void showBuyProperty(Eigendom eigendom){
        showTile(eigendom);
        boardView.showBuying(eigendom);
    }

    public void buyEigendom(Eigendom eigendom){
        prevSpeler.addProperty(eigendom);
        prevSpeler.updateSaldo(-eigendom.getCost());
        eigendom.setEigenaar(prevSpeler);
    }

    public void showBetaalHuur(Eigendom eigendom){
        showTile(eigendom);
        currentSpeler.updateSaldo(-eigendom.getHuur());
        eigendom.getEigenaar().updateSaldo(eigendom.getHuur());
        boardView.showBetaalHuur(eigendom, currentSpeler, eigendom.getEigenaar());
    }

    public void showFailliet(Speler speler){
        //TODO
    }

    public void payBonusPot(int amount, Speler speler, Tile tile){
        speler.updateSaldo(-amount);
        showTile(tile);
        boardView.showTaxPaid(amount, speler);
        bonusPot += amount;
    }

    public void giveBonusPot(Speler speler, Tile tile){
        speler.updateSaldo(bonusPot);
        showTile(tile);
        boardView.showGaveBonusPot(speler);
        bonusPot = 0;
    }

    public void goToJail(Speler speler){
        speler.setPosition(jailPosition);
        showTile(tiles[jailPosition]);
        boardView.showJail(speler);
    }

}
