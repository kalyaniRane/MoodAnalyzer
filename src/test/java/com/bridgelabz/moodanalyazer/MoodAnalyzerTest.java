package com.bridgelabz.moodanalyazer;

import com.bridgelabz.moodAnalyazerException.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    @Test
    public void givenMessageMoodShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I Am In Sad Mood");
        try {
            String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMessageMoodShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I Am In Any Mood");
        try {
            String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodShouldReturnException() {
        String mood = null;
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            mood = moodAnalyzer.analyseMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.MoodException.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenEmptyMoodShouldReturnException() {
        String mood = null;
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try {
            mood = moodAnalyzer.analyseMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.MoodException.ENTERED_EMPTY, e.type);
            return;
        }
        Assert.assertEquals("Empty String", mood);
    }

    @Test
    public void givenMoodAnalyzer_WhenProper_ShouldReturnObject() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyazer.MoodAnalyzer").getConstructor(String.class);
            Object myObj = constructor.newInstance("I Am In Happy Mood");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) myObj;

            String mood = moodAnalyzer.analyseMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClassName_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = null;
        try {
            moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I Am In Happy Mood");
        Assert.assertEquals(new MoodAnalyzer("I Am In Happy Mood"), moodAnalyzer);
    }

    @Test
    public void givenMoodAnalyzerClassName_WhenImProper_ShouldeReturn() {
        try {
            MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyazer.MoodAnalyzerrrr",String.class);
        }catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.MoodException.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethodName_WhenImProper_ShouldeReturnException() {
        try {
            MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyazer.MoodAnalyzer",Integer.class);
        }catch (MoodAnalyzerException e)
        {
            Assert.assertEquals(MoodAnalyzerException.MoodException.NO_SUCH_METHOD,e.type);
        }
    }
}