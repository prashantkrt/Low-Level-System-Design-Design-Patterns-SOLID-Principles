package Creational_Design_Pattern.Builder_Pattern;

class House {

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

    // creation of multiple constructor
    // will be messy and challenging to understand in a case of object creation

    //constructor-1 with all params
    public House(String foundation, String size, String color, String buildingType, String floor, String structure, String roof, boolean hasGarden, boolean hasSwimming, boolean hasFurniture) {
        this.foundation = foundation;
        this.size = size;
        this.color = color;
        this.buildingType = buildingType;
        this.floor = floor;
        this.structure = structure;
        this.roof = roof;
        this.hasGarden = hasGarden;
        this.hasSwimming = hasSwimming;
        this.hasFurniture = hasFurniture;
    }

    //Constructor-2 with some mandatory params
    public House(String size, String floor, String foundation, String color) {
        this.size = size;
        this.floor = floor;
        this.foundation = foundation;
        this.color = color;
    }

// we won't be able to overload in the below case , we cannot do that
//    public House(String foundation, String size, String color) {
//        this.foundation = foundation;
//        this.size = size;
//        this.color = color;
//    }
//
//    public House(String buildingType, String floor, String structure) {
//        this.buildingType = buildingType;
//        this.floor = floor;
//        this.structure = structure;
//    }
}

public class WithoutBuilderPattern {
    public static void main(String[] args) {


    }
}
