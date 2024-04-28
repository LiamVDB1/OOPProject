package be.ugent.objprog.ugentopoly;

import javafx.scene.image.Image;

public enum Pion {

    WINA("WINA",  "token1.png"),
    VTK("VTK", "token2.png"),
    CHEMICA("Chemica",  "token3.png"),
    FILOLOGICA("Filologica", "token4.png"),
    GEOLOGICA("Geologica", "token5.png"),
    VBK("VBK", "token6.png"),
    VEK("VEK", "token7.png"),
    VLK("VLK", "token8.png");

    private final String text;
    private final Image image;

    Pion(String text, String imagePath){
        this.text = text;
        this.image = loadImage(imagePath);
    }

    public Image loadImage(String imagePath) {
        try {
            return new Image(this.getClass().getResourceAsStream("/be/ugent/objprog/ugentopoly/assets/" + imagePath));
        } catch (Exception e) {
            System.err.println("Error loading image: " + text + " at " + imagePath);
            return null;
        }
    }
    public String getText(){
        return text;
    }

    public Image getImage(){
        return image;
    }
    @Override
    public String toString(){
        return text;
    }
}

