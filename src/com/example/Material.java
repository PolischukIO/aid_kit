package com.example;

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

}
