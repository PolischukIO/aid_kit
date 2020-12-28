package com.example.components.bandages;

import com.example.enums.Material;

public class GauzeNapkin extends BandagingMaterial {

    public GauzeNapkin(int width, int length, Material material, boolean sterile) {
        super(width, length, material, sterile);
    }

    @Override
    public void bandageWound() { System.out.println("Wound was bandaged by gauze napkin"); }
}
