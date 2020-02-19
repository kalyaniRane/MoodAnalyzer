package com.bridgelabz.moodanalyazer;

import com.bridgelabz.moodAnalyazerException.MoodAnalyzerException;

public class MoodAnalyzer {

    private  String message;

    public MoodAnalyzer() {
    }

    public MoodAnalyzer(String message) {
        this.message=message;
    }

    public String analyseMood() throws MoodAnalyzerException {

        try
        {
            if(message.contains(" "))
            {
                throw new MoodAnalyzerException(MoodAnalyzerException.MoodException.ENTERED_EMPTY);
            }
           else if (message.contains("Sad"))
           {
                return "SAD";
           }
           else
           {    return "HAPPY";}
       }
       catch(NullPointerException n) {
           throw new MoodAnalyzerException(MoodAnalyzerException.MoodException.ENTERED_NULL);
       }
    }
}
