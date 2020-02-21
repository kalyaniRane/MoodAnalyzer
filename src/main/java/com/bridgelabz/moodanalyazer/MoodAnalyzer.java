package com.bridgelabz.moodanalyazer;

import com.bridgelabz.moodAnalyazerException.MoodAnalyzerException;

public class MoodAnalyzer {

    private String message;

    public MoodAnalyzer() {
        this.message="default";
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalyzerException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalyzerException {

        try {
            if (message.isEmpty()) {
                throw new MoodAnalyzerException(MoodAnalyzerException.MoodException.ENTERED_EMPTY, "Empty Message");
            } else if (message.contains("Sad")) {
                return "SAD";
            } else {
                return "HAPPY";
            }
        } catch (NullPointerException n) {
            throw new MoodAnalyzerException(MoodAnalyzerException.MoodException.ENTERED_NULL, "Invalid Message");
        } catch (Exception e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.MoodException.ENTERED_EMPTY, "Empty Message");
        }
    }

    public boolean equals(Object another) {
        if (this.message.equals(((MoodAnalyzer) another).message)) {
            return true;
        }
        return false;
    }
}
