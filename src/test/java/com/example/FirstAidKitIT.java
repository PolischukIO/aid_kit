package com.example;

import com.example.components.Gloves;
import com.example.components.bandages.Bandage;
import com.example.components.bandages.BandagingMaterial;
import com.example.exceptions.FirstAidKitException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class FirstAidKitIT {

    Gloves gloves = Mockito.mock(Gloves.class);
    FirstAidKit firstAidKitWithGloves = new FirstAidKit(gloves);

    FirstAidKit firstAidKit = Mockito.mock(FirstAidKit.class);

    @Test
    public void GlovesOn_EqualsTrue_True_Test() {
        final boolean expected = true;
        Mockito.doReturn(true).when(gloves).isON();
        boolean actual = firstAidKitWithGloves.isGlovesOn();
        Mockito.verify(gloves, Mockito.atLeastOnce()).isON();
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = FirstAidKitException.class)
    public void whenGetBandageThrowException() {
        Mockito.doThrow(new FirstAidKitException("Missing Bandage")).when(firstAidKit).getBandage();
        firstAidKit.getBandage();
    }

    @Test
    public void getMaxLength_Equals150_True() {
        List<BandagingMaterial> bandages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Bandage bandage = Mockito.mock(Bandage.class);
            Mockito.when(bandage.getLength()).thenReturn(20 + 10 * i);
            bandages.add(bandage);
        }
        Assert.assertEquals(FirstAidKit.getMaxLength(bandages), 60);
    }
}
