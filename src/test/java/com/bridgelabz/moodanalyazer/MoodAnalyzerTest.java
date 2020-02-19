package com.bridgelabz.moodanalyazer;

import com.bridgelabz.moodAnalyazerException.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMessageMoodShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I Am In Sad Mood");
        try {
            String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("SAD",mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMessageMoodShouldReturnSad() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I Am In Any Mood");
        try {
           String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodShouldReturnException() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        try {
            moodAnalyzer.analyseMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.MoodException.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenEmptyMoodShouldReturnException() {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer(" ");
        try
        {
            moodAnalyzer.analyseMood();
        }
        catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.MoodException.ENTERED_EMPTY,e.type);
        }

    }
}