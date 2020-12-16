package com.example.bandages;

import com.example.Material;

public class MedicalScarf extends BandagingMaterial {
    public MedicalScarf(int width, int length, Material material) {
        super(width, length, material);
    }

    @Override
    public void bandageWound() {
        System.out.println("Wound was bandaged by Medical scarf");
    }
}
