package com.example.components.bandages;

import com.example.enums.Material;

import java.util.Objects;

public abstract class BandagingMaterial {

    protected final int width;
    protected final int length;
    protected Material material;
    private boolean sterile;
//+
    public abstract void bandageWound();

    public Material getMaterial() {
        return material;
    }

    public int getLength() {
        return length;
    }

    protected BandagingMaterial(int width, int length, Material material, boolean sterile) {
        this.width = width;
        this.length = length;
        this.material = material;
        this.sterile = sterile;
    }

    public String toString() {
    return "Bandage with width: " + width +
            " length: " + length +
            " material: " + material.getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BandagingMaterial that = (BandagingMaterial) o;
        return width == that.width &&
                length == that.length &&
                material == that.material;
    }

    public boolean isSterile() {
        return sterile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, material);
    }
}
