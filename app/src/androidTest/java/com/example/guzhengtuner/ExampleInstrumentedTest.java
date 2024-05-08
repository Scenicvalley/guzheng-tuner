package com.example.guzhengtuner;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.guzhengtuner.note.NoteFrequencyCalculator;
import com.example.guzhengtuner.note.Pitch;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.guzhengtuner", appContext.getPackageName());

        NoteFrequencyCalculator calculator=new NoteFrequencyCalculator();
        System.out.println(calculator.getFrequency(Pitch.D6));
        System.out.println(calculator.getFrequency(Pitch.B5));
        System.out.println(calculator.getFrequency(Pitch.A5));
        System.out.println(calculator.getFrequency(Pitch.F5_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E5));
        System.out.println(calculator.getFrequency(Pitch.D5));

        System.out.println(calculator.getFrequency(Pitch.B4));
        System.out.println(calculator.getFrequency(Pitch.A4));
        System.out.println(calculator.getFrequency(Pitch.F4_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E4));
        System.out.println(calculator.getFrequency(Pitch.D4));

        System.out.println(calculator.getFrequency(Pitch.B3));
        System.out.println(calculator.getFrequency(Pitch.A3));
        System.out.println(calculator.getFrequency(Pitch.F3_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E3));
        System.out.println(calculator.getFrequency(Pitch.D3));

        System.out.println(calculator.getFrequency(Pitch.B2));
        System.out.println(calculator.getFrequency(Pitch.A2));
        System.out.println(calculator.getFrequency(Pitch.F2_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E2));
        System.out.println(calculator.getFrequency(Pitch.D2));

    }

    @Test
    public void test(){
        NoteFrequencyCalculator calculator=new NoteFrequencyCalculator();
        System.out.println(calculator.getFrequency(Pitch.D6));
        Log.e("leg",calculator.getFrequency(Pitch.D6)+"!");
        System.out.println(calculator.getFrequency(Pitch.B5));
        System.out.println(calculator.getFrequency(Pitch.A5));
        System.out.println(calculator.getFrequency(Pitch.F5_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E5));
        System.out.println(calculator.getFrequency(Pitch.D5));

        System.out.println(calculator.getFrequency(Pitch.B4));
        System.out.println(calculator.getFrequency(Pitch.A4));
        System.out.println(calculator.getFrequency(Pitch.F4_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E4));
        System.out.println(calculator.getFrequency(Pitch.D4));

        System.out.println(calculator.getFrequency(Pitch.B3));
        System.out.println(calculator.getFrequency(Pitch.A3));
        System.out.println(calculator.getFrequency(Pitch.F3_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E3));
        System.out.println(calculator.getFrequency(Pitch.D3));

        System.out.println(calculator.getFrequency(Pitch.B2));
        System.out.println(calculator.getFrequency(Pitch.A2));
        System.out.println(calculator.getFrequency(Pitch.F2_SHARP));
        System.out.println(calculator.getFrequency(Pitch.E2));
        System.out.println(calculator.getFrequency(Pitch.D2));

    }
}