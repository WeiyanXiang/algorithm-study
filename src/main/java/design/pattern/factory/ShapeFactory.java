/**
 * 
 */
package design.pattern.factory;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class ShapeFactory {

    public Shape getShape(String shape) {
        if (("cycle").equalsIgnoreCase(shape)) {
            return new Cycle();
        } else if (("square").equalsIgnoreCase(shape)) {
            return new Square();
        }
        return null;
    }

}
