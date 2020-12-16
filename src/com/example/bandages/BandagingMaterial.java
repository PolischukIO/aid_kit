package com.example.bandages;

import com.example.Material;

import java.util.Objects;

public abstract class BandagingMaterial {
    protected final int width;
    protected final int length;
    protected Material material;
//+
    public abstract void bandageWound();

    protected BandagingMaterial(int width, int length, Material material) {
        this.width = width;
        this.length = length;
        this.material = material;
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

    @Override
    public int hashCode() {
        return Objects.hash(width, length, material);
    }
}
