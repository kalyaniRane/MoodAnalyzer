package com.bridgelabz.moodAnalyazerException;

public class MoodAnalyzerException extends RuntimeException
{
    public MoodException type;

    public MoodAnalyzerException(MoodException type, String message)
    {
        super(message);
        this.type=type;
    }

    public enum  MoodException
    {
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD
    }

    public MoodAnalyzerException(Throwable cause, MoodException type) {
        super(cause);
        this.type = type;
    }

    public MoodAnalyzerException(String message, Throwable cause, MoodException type) {
        super(message, cause);
        this.type = type;
    }
}
