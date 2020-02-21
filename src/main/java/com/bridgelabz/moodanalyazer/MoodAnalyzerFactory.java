package com.bridgelabz.moodanalyazer;

import com.bridgelabz.moodAnalyazerException.MoodAnalyzerException;
import com.bridgelabz.moodAnalyazerException.MoodAnalyzerException.MoodException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalyzerException {
        try {
            Constructor<?> moodconstructor = Class.forName("com.bridgelabz.moodanalyazer.MoodAnalyzer").getConstructor();
            Object object = moodconstructor.newInstance();
            MoodAnalyzer moodObject = (MoodAnalyzer) object;
            return moodObject;
        } catch (Exception e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.MoodException.ENTERED_NULL,"Invalid Message");
        }
    }
    public static MoodAnalyzer createMoodAnalyzer(String message) {

        try {
            Constructor<?> moodConstructor = Class.forName("com.bridgelabz.moodanalyazer.MoodAnalyzer").getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
            MoodAnalyzer moodAnalyzerObject = (MoodAnalyzer) moodObject;
            return moodAnalyzerObject;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Constructor getConstructor(String stringClass, Class stringMethod) throws MoodAnalyzerException {
        try {
            Class<?> aClass = Class.forName(stringClass);
            return aClass.getConstructor(stringMethod);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.MoodException.NO_SUCH_CLASS,"Class Not Found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodException.NO_SUCH_METHOD,"Method Not Found");
        }
    }
}