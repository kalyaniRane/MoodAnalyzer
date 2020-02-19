package com.bridgelabz.moodAnalyazerException;

public class MoodAnalyzerException extends Exception
{
    public MoodException type;
    public MoodAnalyzerException(MoodException type, String message)
    {
        super(message);
        this.type=type;
    }

    public enum  MoodException
    {
        ENTERED_NULL,ENTERED_EMPTY
    }

}
