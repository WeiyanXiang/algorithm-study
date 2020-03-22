/**
 *
 */
package design.pattern.factory;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class ShapeFactory {

    public Shape get(ShapeType shape) {
        switch (shape) {
            case CYCLE:
                return new Cycle();
            case SQUARE:
            default:
                return new Square();
        }
    }

}
