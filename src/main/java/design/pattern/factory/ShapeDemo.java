/**
 * 
 */
package design.pattern.factory;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class ShapeDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        factory.getShape("cycle").draw();
        factory.getShape("SQUARE").draw();
    }
}
