package com.example.bandages;

import com.example.Material;

public class Bandage extends BandagingMaterial {

    public Bandage(int width, int length, Material material, boolean sterile) {
        super(width, length, material, sterile);
    }

    @Override
    public void bandageWound() {
        System.out.println("Wound was bandaged by bandage");
    }
}
