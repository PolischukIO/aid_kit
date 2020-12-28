package com.example.enums;

public enum Material {

    RUBBER ("Rubber"),
    LEATHER ("Leather"),
    CLOTH ("Cloth"),
    GAUZE("Gauze"),
    SILK ("Silk");

    private final String material;
//+
    Material(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

//    @Override
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for(Material string : Material.values()) s.append(string.getMaterial()).append(", ");
//        return s.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Material.RUBBER);
//    }
}
