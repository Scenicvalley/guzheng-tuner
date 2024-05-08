package com.example.guzhengtuner.util;

import com.example.guzhengtuner.note.Note;
import com.example.guzhengtuner.pojo.PitchDifference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sampler {
    //最后这个方法就是从一组样本中抽取到最接近音频出现次数最多的样本，然后将偏差求平均后，组成一个新的样本
    public static PitchDifference calculateAverageDifference(List<PitchDifference> samples) {
        //提取出出现频率最高的音高
        Note mostFrequentNote = extractMostFrequentNote(samples);
        List<PitchDifference> filteredSamples = filterByNote(samples, mostFrequentNote);

        Double deviationSum = 0.0;
        int sameNoteCount = 0;
        for (PitchDifference pitchDifference : filteredSamples) {
            deviationSum += pitchDifference.getDeviation();
            sameNoteCount++;
        }

        if (sameNoteCount > 0) {
            Double averageDeviation = deviationSum / sameNoteCount;

            return new PitchDifference(mostFrequentNote, averageDeviation);
        }

        return null;
    }

    //这里把采样集过滤一下,只留下出现频率最高的音频
    static List<PitchDifference> filterByNote(List<PitchDifference> samples, Note note) {
        List<PitchDifference> filteredSamples = new ArrayList<>();

        for (PitchDifference sample : samples) {
            if (sample.getClosest() == note) {
                filteredSamples.add(sample);
            }
        }

        return filteredSamples;
    }

    static Note extractMostFrequentNote(List<PitchDifference> samples) {
        //用一个map来记录每个最接近音阶出现的频率
        Map<Note, Integer> noteFrequencies = new HashMap<>();

        for (PitchDifference pitchDifference : samples) {
            Note closest = pitchDifference.getClosest();
            if (noteFrequencies.containsKey(closest)) {
                Integer count = noteFrequencies.get(closest);
                noteFrequencies.put(closest, count + 1);
            } else {
                noteFrequencies.put(closest, 1);
            }
        }

        Note mostFrequentNote = null;
        int mostOccurrences = 0;
        for (Note note : noteFrequencies.keySet()) {
            Integer occurrences = noteFrequencies.get(note);
            if (occurrences > mostOccurrences) {
                mostFrequentNote = note;
                mostOccurrences = occurrences;
            }
        }

        return mostFrequentNote;
    }
}
