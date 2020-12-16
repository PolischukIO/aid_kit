import com.example.*;
import com.example.bandages.AdhesivePlaster;
import com.example.bandages.Bandage;
import com.example.bandages.GauzeNapkin;
import com.example.bandages.MedicalScarf;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FirstAidKitTest {

    CuttingDevice scalpel = new CuttingDevice() {
        @Override
        public void cut() { System.out.println("incision was made with a scalpel");}
        @Override
        public String toString() {return "Scalpel";}
    };
    Pen pencil = new Pen() {
        @Override
        public void write(Notepad notepad, String message) {
            notepad.writePage(message);
            System.out.println("Message was written using pencil"); }
        @Override
        public String toString() {return "Pencil"; }
    };

    @Test
    public void EqualsTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        FirstAidKit firstAidKit2 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        Assert.assertTrue(firstAidKit1.equals(firstAidKit2) && firstAidKit2.equals(firstAidKit1));
        Assert.assertEquals(firstAidKit1.hashCode(), firstAidKit2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void ShouldThrowExceptionIfMissingAidKitComponent() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing bandage");
        FirstAidKit firstAidKit1 = new FirstAidKit(new AdhesivePlaster(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        System.out.println(firstAidKit1);

        firstAidKit1.getBandage();

        firstAidKit1.getGloves().takeOnGloves();
        firstAidKit1.getPen().write(firstAidKit1.getNotepad(), "Person is heavy bleeding");
        firstAidKit1.getArMask().doArtificalRespiration();
        firstAidKit1.getGarrot().stopBleeding(firstAidKit1.getNotepad());
        firstAidKit1.getBandage().bandageWound();
        firstAidKit1.getCuttingDevice().cut();
        firstAidKit1.getNotepad().readAll();
        firstAidKit1.getGloves().takeOffGloves();
    }
    @Test
    public void ShouldNotThrowExceptionIfMissingAidKitComponent() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.getBandage().bandageWound();
        firstAidKit1.add(new ARMask());
        firstAidKit1.add(new Garrot());
        firstAidKit1.add(new MedicalScarf(10, 50, Material.LEATHER));
        firstAidKit1.getBandage().bandageWound();
        firstAidKit1.add(new Bandage(20, 40, Material.GAUZE));
        firstAidKit1.getBandage().bandageWound();
        firstAidKit1.add(new AdhesivePlaster(10, 10, Material.GAUZE));
        System.out.println(firstAidKit1);
        firstAidKit1.getGloves().takeOnGloves();
        firstAidKit1.getPen().write(firstAidKit1.getNotepad(), "Person is heavy bleeding");
        firstAidKit1.getArMask().doArtificalRespiration();
        firstAidKit1.getGarrot().stopBleeding(firstAidKit1.getNotepad());
        firstAidKit1.getBandage().bandageWound();
        firstAidKit1.getCuttingDevice().cut();
        firstAidKit1.getNotepad().readAll();
        firstAidKit1.getGloves().takeOffGloves();
    }
}
