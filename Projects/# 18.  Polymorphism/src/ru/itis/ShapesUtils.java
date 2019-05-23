package ru.itis;

public class ShapesUtils {
    public static void rotateAll(Pivoted pivotedFigures[], double fi) {
        for (int i = 0; i < pivotedFigures.length; i++) {
            pivotedFigures[i].rotate(fi);
        }
    }

    public static void scaleAll(Scalable scalableFigures[], double value) {
        for (int i = 0; i < scalableFigures.length; i++) {
            scalableFigures[i].scale(value);
        }
    }
}
