package Creational_Design_Pattern.Builder_Pattern;

class Home {

    private String foundation;
    private String size;
    private String color;
    private String buildingType;
    private String floor;
    private String structure;
    private String roof;
    private boolean hasGarden;
    private boolean hasSwimming;
    private boolean hasFurniture;

    public Home(HomeBuilder builder) {
        this.foundation = builder.foundation;
        this.size = builder.size;
        this.color = builder.color;
        this.buildingType = builder.buildingType;
        this.floor = builder.floor;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.hasGarden = builder.hasGarden;
        this.hasSwimming = builder.hasSwimming;
        this.hasFurniture = builder.hasFurniture;
    }

    @Override
    public String toString() {
        return "Home{" +
                "foundation='" + foundation + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", floor='" + floor + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", hasGarden=" + hasGarden +
                ", hasSwimming=" + hasSwimming +
                ", hasFurniture=" + hasFurniture +
                '}';
    }

    public static class HomeBuilder {
        private String foundation;
        private String size;
        private String color;
        private String buildingType;
        private String floor;
        private String structure;
        private String roof;
        private boolean hasGarden;
        private boolean hasSwimming;
        private boolean hasFurniture;

        //builder constructor with mandatory parameters
        public HomeBuilder(String foundation, String structure, String roof) {
            this.foundation = foundation;
            this.structure = structure;
            this.roof = roof;
        }
        //optional parameters

        public HomeBuilder setSize(String size) {
            this.size = size;
            return this;
        }

        public HomeBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public HomeBuilder setBuildingType(String buildingType) {
            this.buildingType = buildingType;
            return this;
        }

        public HomeBuilder setFloor(String floor) {
            this.floor = floor;
            return this;
        }


        public HomeBuilder setHasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HomeBuilder setHasSwimming(boolean hasSwimming) {
            this.hasSwimming = hasSwimming;
            return this;
        }

        public HomeBuilder setHasFurniture(boolean hasFurniture) {
            this.hasFurniture = hasFurniture;
            return this;
        }

        public Home build() {
            return new Home(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Home.HomeBuilder builder = new Home.HomeBuilder("Bricks","Concrete","Poles");
        Home flat = builder.setSize("120x200").setBuildingType("flat").setFloor("3").setHasGarden(true).setHasSwimming(true).build();
        System.out.println(flat);
    }
}
