package com.example.components;

import java.util.Arrays;
import java.util.Objects;

public class Notepad {

    private final int pageNumber;
    private int index;
    public String[] notepadContent;

    public Notepad(int pageNumber) {
        this.pageNumber = pageNumber;
        notepadContent = new String[pageNumber];
    }

    public void writePage(String string) { notepadContent[index++] = string; }

    public void writeSomePages(Notepad notepad) {}

    public String readAll() {
        String s = "";
        for (int i = 0; i < index; i++) {
            s += notepadContent[i];
        }
        return s;
    }

    public String toString() {
        return "Notepad with " + pageNumber + " pages";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notepad notepad = (Notepad) o;
        return pageNumber == notepad.pageNumber &&
                index == notepad.index &&
                Arrays.equals(notepadContent, notepad.notepadContent);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pageNumber, index);
        result = 31 * result + Arrays.hashCode(notepadContent);
        return result;
    }
}
