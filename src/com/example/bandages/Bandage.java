package com.example.bandages;

import com.example.Material;

public class Bandage extends BandagingMaterial {

    public Bandage(int width, int length, Material material) {
        super(width, length, material);
    }

    @Override
    public void bandageWound() {
        System.out.println("Wound was bandaged by bandage");
    }
}
