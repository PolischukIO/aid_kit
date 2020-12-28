import com.example.*;
import com.example.components.bandages.AdhesivePlaster;
import com.example.components.bandages.Bandage;
import com.example.components.bandages.BandagingMaterial;
import com.example.components.bandages.GauzeNapkin;
import com.example.components.ARMask;
import com.example.components.Garrot;
import com.example.components.Gloves;
import com.example.components.Notepad;
import com.example.enums.Material;
import com.example.interfaces.CuttingDevice;
import com.example.interfaces.Pen;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CollectionToolsTest {
    CuttingDevice scalpel = new CuttingDevice() {
        @Override
        public void cut() {}
        @Override
        public String toString() {return "Scalpel";}
    };
    Pen pencil = new Pen() {
        @Override
        public void write(Notepad notepad, String message) {
            notepad.writePage(message);
        }
        @Override
        public String toString() {return "Pencil"; }
    };

    @Test
    public void getMostFrequentBandageMaterials_TwoMostFrequentNames_True() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH, true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        FirstAidKit firstAidKit2 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH, true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit2.add(new GauzeNapkin(10, 50, Material.CLOTH, true));
        firstAidKit2.add(new GauzeNapkin(10, 50, Material.CLOTH, true));
        firstAidKit2.add(new GauzeNapkin(10, 50, Material.SILK, true));
        firstAidKit2.add(new GauzeNapkin(10, 50, Material.SILK, true));
        firstAidKit2.add(new GauzeNapkin(10, 50, Material.SILK, true));
        firstAidKit1.add(new GauzeNapkin(10, 50, Material.LEATHER, false));
        firstAidKit1.add(new GauzeNapkin(10, 50, Material.LEATHER, false));
        firstAidKit1.add(new GauzeNapkin(10, 50, Material.GAUZE, false));
        List<FirstAidKit> firstAidKitList = Arrays.asList(firstAidKit1, firstAidKit2);
        List<String> actual = FirstAidKit.getMostFrequentBandageMaterials(firstAidKitList);
        List<String> expected = Arrays.asList("Leather", "Cloth");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getClothMaxLength_Equals120_True() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE,true));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER,true));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH,true));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK,true));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK,true));
        int actual = FirstAidKit.getClothLengthSum(firstAidKit1.getBandages());
        int expected = 120;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAverageLength_Equals100_True() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE,true));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER,true));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH,true));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK,true));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK,true));
        double actual = FirstAidKit.getAverageLength(firstAidKit1.getBandages());
        double expected = 100;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void getMaxLength_Equals150_True() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE,true));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER,true));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH,true));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK,true));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK,true));
        int actual = FirstAidKit.getMaxLength(firstAidKit1.getBandages());
        int expected = 150;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getGroupByMaterialAndLength_Filter_True() {
        BandagingMaterial clothBandage = new Bandage(10, 50, Material.CLOTH,true);
        BandagingMaterial gauzeBandage = new Bandage(20, 100, Material.GAUZE,true);
        FirstAidKit firstAidKit1 = new FirstAidKit(clothBandage, scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(gauzeBandage);

        Map<Boolean, List<BandagingMaterial>> actual = firstAidKit1.getGroupByMaterialAndLength(p -> p.getMaterial().equals(Material.CLOTH) && p.getLength() > 30);
        Map<Boolean, List<BandagingMaterial>> expected = new HashMap<>();

        List<BandagingMaterial> expectedFalseList = Collections.singletonList(gauzeBandage);
        List<BandagingMaterial> expectedTrueList = Collections.singletonList(clothBandage);
        expected.put(false, expectedFalseList);
        expected.put(true, expectedTrueList);

        Assert.assertEquals(expected, actual);
    }
}