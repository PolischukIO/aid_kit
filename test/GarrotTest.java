import com.example.Garrot;
import com.example.Notepad;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GarrotTest {

    @Test
    public void StopBleeding_EqualsCurrentTime_True() {
        Garrot garrot = new Garrot();
        Notepad notepad = new Notepad(25);
        garrot.stopBleeding(notepad);
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Assert.assertEquals(formatter.format(localTime), formatter.format(garrot.getTime()));
    }
}
