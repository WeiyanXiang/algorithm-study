package knowledge.enumpractice;

/**
 * @author Weiyan Xiang on 2020/10/23
 */
public enum MainFoodType {
    RICE("rice"),
    NOODLE("noodle"),
    PASTA("pasta"),
    BREAD("bread");

    private String type;

    MainFoodType(String type) {
        this.type = type;
    }

    public static MainFoodType getMainFoodType(String type) {
        for (MainFoodType enumType : values()) {
            if (enumType.type.equals(type)) return enumType;
        }
        throw new IllegalArgumentException("invalid main food type");
    }
}
