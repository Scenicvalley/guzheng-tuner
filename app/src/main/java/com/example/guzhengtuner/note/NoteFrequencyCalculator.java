package com.example.guzhengtuner.note;

import java.util.Arrays;
import java.util.List;

public class NoteFrequencyCalculator {
    private static List<String> notes = Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");
    private float referenceFrequency =440;

    public NoteFrequencyCalculator() {
    }


    public double getFrequency(Note note) {

        //半色调
        int semitonesPerOctave = 12;

        //参考倍频程
        int referenceOctave = 4;

        double distance = semitonesPerOctave * (note.getOctave() - referenceOctave);
        distance += notes.indexOf(note.getName() + note.getSign()) - notes.indexOf("A");

        return referenceFrequency * Math.pow(2, distance / 12);
    }
}
