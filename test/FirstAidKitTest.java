import com.example.*;
import com.example.bandages.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FirstAidKitTest {

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
    public void EqualsTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        FirstAidKit firstAidKit2 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        Assert.assertTrue(firstAidKit1.equals(firstAidKit2) && firstAidKit2.equals(firstAidKit1));
        Assert.assertEquals(firstAidKit1.hashCode(), firstAidKit2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void ShouldThrowExceptionIfMissingAidKitComponent() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing bandage");
        FirstAidKit firstAidKit1 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));

        firstAidKit1.getBandage();
        firstAidKit1.getBandage();
    }

    @Test
    public void BandagingMaterialTest() {

        BandagingMaterial bandagingMaterial = new GauzeNapkin(10, 50, Material.CLOTH,true);
        FirstAidKit firstAidKit1 = new FirstAidKit(bandagingMaterial, scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);

        bandagingMaterial = new MedicalScarf(10, 50, Material.LEATHER,true);
        firstAidKit1.add(bandagingMaterial);
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);

        bandagingMaterial = new Bandage(20, 40, Material.GAUZE,true);
        firstAidKit1.add(bandagingMaterial);
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);

        bandagingMaterial = new AdhesivePlaster(10, 10, Material.GAUZE,true);
        firstAidKit1.add(bandagingMaterial);
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);
    }
    @Test
    public void FirstAidKitFunctionalityTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.getGloves().takeOnGloves();
        firstAidKit1.getArMask().doArtificalRespiration();
        firstAidKit1.getNotepad().writePage("Patient heavily injured");
        firstAidKit1.getGarrot().stopBleeding(firstAidKit1.getNotepad());
        firstAidKit1.getBandage().bandageWound();
        firstAidKit1.getCuttingDevice().cut();
        firstAidKit1.getGloves().takeOffGloves();
        firstAidKit1.getNotepad().readAll();
    }

    @Test
    public void FirstAidKitToStringTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH,true), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        String actual = firstAidKit1.toString();
        String expected = "First Aid Kit consists of: " + System.lineSeparator() +
                "Bandage with width: 10 length: 50 material: Cloth " + System.lineSeparator() +
                "Scalpel" + System.lineSeparator() +
                "Notepad with 50 pages" + System.lineSeparator() +
                "Gloves with material: Rubber" + System.lineSeparator() +
                "Pencil" + System.lineSeparator() +
                "Garrot which was installed in null" + System.lineSeparator() +
                "ARMask";
        Assert.assertEquals(actual, expected);
    }

}
