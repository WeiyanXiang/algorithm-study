/**
 *
 */
package design.pattern.factory;

import static design.pattern.factory.ShapeType.CYCLE;
import static design.pattern.factory.ShapeType.SQUARE;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class ShapeDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        factory.get(CYCLE).draw();
        factory.get(SQUARE).draw();
    }
}
