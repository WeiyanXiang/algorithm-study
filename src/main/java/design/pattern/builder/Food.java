package design.pattern.builder;

/**
 * @author Weiyan Xiang on 2020/5/20
 */
public class Food {
    private String color;
    private String size;
    private String quality;

    public Food(Builder builder) {
        this.color = builder.color;
        this.size = builder.size;
        this.quality = builder.quality;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getQuality() {
        return quality;
    }

    static class Builder {
        private String color;
        private String size;
        private String quality;

        public Food build() {
            return new Food(this);
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder quality(String quality) {
            this.quality = quality;
            return this;
        }
    }

    public static void main(String[] args) {
        Builder build = new Builder();
        Food food = build.color("color").quality("good").size("1").build();
    }

}
