/**
 *
 */
package design.pattern.factory;

/**
 * @author weiyan.xiang
 * @date 25 Jan 2018
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("this is square");
    }

    @Override
    public ShapeType type() {
        return ShapeType.SQUARE;
    }

}
