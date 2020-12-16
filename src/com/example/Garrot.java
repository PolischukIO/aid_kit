package com.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Garrot {

    private LocalTime time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public void stopBleeding(Notepad notepad) {
        System.out.println("Bleeding has stopeed using garrot");
        setApplicationDate(notepad);
    }

    private void setApplicationDate(Notepad notepad) {
        time = LocalTime.now();
        notepad.writePage("Garrot was installed at: " + formatter.format(time));
    }

    public String toString() {
        return "Garrot which was installed in " + time;
    }

    public LocalTime getTime() { return time; }
}
