/**
 * 
 */
package knowledge;

import java.util.Optional;

/**
 * @author weiyan.xiang
 * @date 26 Jan 2018
 */
public class OptionalDemo {

    private String demoField;

    /**
     * @param demoField
     */
    public OptionalDemo(String demoField) {
        this.demoField = demoField;
    }

    public Optional<String> getDemoField() {
        return Optional.ofNullable(demoField);
    }

    public void setDemoField(String demoField) {
        this.demoField = demoField;
    }

    public static void main(String[] args) {
        OptionalDemo testObj = new OptionalDemo(null);
        Optional<String> demoField = testObj.getDemoField();

    }
}
