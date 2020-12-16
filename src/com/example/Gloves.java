package com.example;

import java.util.Objects;

public class Gloves {
    private final Material material;
    private boolean equipped;
    public void takeOnGloves() {equipped = true;}
    public void takeOffGloves() {equipped = false;}

    public Gloves(Material material) {
        this.material = material;
    }

    public String toString() {
        return "Gloves with material: " + material.getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gloves gloves = (Gloves) o;
        return equipped == gloves.equipped &&
                material == gloves.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, equipped);
    }
}