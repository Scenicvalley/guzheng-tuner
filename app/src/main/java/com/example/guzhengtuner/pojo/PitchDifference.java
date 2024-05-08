package com.example.guzhengtuner.pojo;

import com.example.guzhengtuner.note.Note;

public class PitchDifference {
    private Note closest;
    private Double deviation;

    public PitchDifference(Note closest, Double deviation) {
        this.closest = closest;
        this.deviation = deviation;
    }

    public PitchDifference() {
    }

    public Note getClosest() {
        return closest;
    }

    public void setClosest(Note closest) {
        this.closest = closest;
    }

    public Double getDeviation() {
        return deviation;
    }

    public void setDeviation(Double deviation) {
        this.deviation = deviation;
    }
}
