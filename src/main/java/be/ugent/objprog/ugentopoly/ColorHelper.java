package be.ugent.objprog.ugentopoly;

import javafx.scene.paint.Color;

public final class ColorHelper {
    public static double calculateLuminance(Color color) {
        // Formule Source:
        // https://stackoverflow.com/questions/596216/formula-to-determine-perceived-brightness-of-rgb-color
        return 0.2126*color.getRed() + 0.7152* color.getGreen() + 0.0722* color.getBlue();
    }

    public static String toHexString(Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed()*255),
                (int)(color.getGreen()*255),
                (int)(color.getBlue()*255));
    }
}
