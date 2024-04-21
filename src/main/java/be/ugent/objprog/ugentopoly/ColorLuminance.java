package be.ugent.objprog.ugentopoly;

import javafx.scene.paint.Color;

public final class ColorLuminance {
    public static double calculateLuminance(Color color) {
        // Formule Source:
        // https://stackoverflow.com/questions/596216/formula-to-determine-perceived-brightness-of-rgb-color
        return 0.2126*color.getRed() + 0.7152* color.getGreen() + 0.0722* color.getBlue();
    }
}
