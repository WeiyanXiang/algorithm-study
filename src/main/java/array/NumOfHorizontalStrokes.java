package array;

/**
 * @author Weiyan Xiang on 2020/9/30
 * <p>
 * https://stackoverflow.com/questions/56373582/how-can-i-count-how-many-horizontal-brush-strokes-are-required-to-draw-an-array
 */
public class NumOfHorizontalStrokes {
    int BrushCount(int[] buildings) {
        int brushCount = 0;
        int prevHeight = 0;
        for (int i = 0; i < buildings.length; i++) {
            if (buildings[i] > prevHeight)
                brushCount = brushCount + (buildings[i] - prevHeight);
            prevHeight = buildings[i];
        }
        return brushCount;
    }
}
