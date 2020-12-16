package com.example;

import com.example.bandages.BandagingMaterial;
import com.example.exceptions.FirstAidKitException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class FirstAidKit {

    private final List<BandagingMaterial> bandage;
    private CuttingDevice cuttingDevice;
    private Notepad notepad;
    private final Gloves gloves;
    private Pen pen;
    private final List<Garrot> garrot;
    private final List<ARMask> arMask;

    {
        bandage = new ArrayList<>();
        garrot = new ArrayList<>();
        arMask = new ArrayList<>();
    }

    public FirstAidKit(BandagingMaterial bandage, CuttingDevice cuttingDevice, Notepad notepad, Pen pen, Garrot garrot, ARMask arMask, Gloves gloves) {
        this.bandage.add(bandage);
        this.cuttingDevice = cuttingDevice;
        this.notepad = notepad;
        this.pen = pen;
        this.garrot.add(garrot);
        this.arMask.add(arMask);
        this.gloves = gloves;
    }

    public BandagingMaterial getBandage() throws FirstAidKitException {
        if (bandage.isEmpty()) throw new FirstAidKitException("Missing bandage");
        BandagingMaterial temp = bandage.get(bandage.size() - 1);
        bandage.remove(bandage.size() - 1);
        return temp;
    }

    public CuttingDevice getCuttingDevice() throws FirstAidKitException {
        if (cuttingDevice == null) throw new FirstAidKitException("Missing scalpel");
        return cuttingDevice;
    }

    public Gloves getGloves() throws FirstAidKitException {
        if (gloves == null) throw new FirstAidKitException("Missing gloves");
        return gloves;
    }

    public Notepad getNotepad() throws FirstAidKitException {
        if (notepad == null) throw new FirstAidKitException("Missing notepad");
        return notepad;
    }

    public Pen getPen() throws FirstAidKitException {
        if (pen == null) throw new FirstAidKitException("Missing pen");
        return pen;
    }

    public Garrot getGarrot() throws FirstAidKitException {
        if (garrot.isEmpty()) throw new FirstAidKitException("Missing garrot");
        Garrot temp = garrot.get(garrot.size() - 1);
        garrot.remove(garrot.size() - 1);
        return temp;
    }

    public ARMask getArMask() throws FirstAidKitException {
        if (arMask.isEmpty()) throw new FirstAidKitException("Missing mask");
        ARMask temp = arMask.get(arMask.size() - 1);
        arMask.remove(arMask.size() - 1);
        return temp;
    }

    public void add(BandagingMaterial bandagingMaterial) {
        bandage.add(bandagingMaterial);
    }

    public void add(Garrot garrot) {
        this.garrot.add(garrot);
    }

    public void add(ARMask arMask) {
        this.arMask.add(arMask);
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<BandagingMaterial> iterator = bandage.iterator();

        stringBuilder.append("First Aid Kit consists of: ").append(System.lineSeparator());

        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next()).append(" ");
        }
        stringBuilder.append(System.lineSeparator());

        stringBuilder.append(cuttingDevice).append(System.lineSeparator());
        stringBuilder.append(notepad).append(System.lineSeparator());
        stringBuilder.append(gloves).append(System.lineSeparator());
        stringBuilder.append(pen).append(System.lineSeparator());
        for (Garrot temp : garrot) {
            stringBuilder.append(temp);
        }
        stringBuilder.append(System.lineSeparator());
        for (ARMask temp : arMask) {
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirstAidKit that = (FirstAidKit) o;
        return Objects.equals(bandage, that.bandage) &&
                Objects.equals(notepad, that.notepad) &&
                Objects.equals(gloves, that.gloves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bandage, notepad, gloves);
    }

    public void setCuttingDevice(CuttingDevice scalpel) {
        this.cuttingDevice = scalpel;
    }

    public void setPen(Pen pencil) {
        this.pen = pencil;
    }

    public void setNotepad(Notepad notepad) {
        this.notepad = notepad;
    }
}
