package com.zzerrgg.statistic;

public class GameStatistic {

    private String generatedWord;

    private int incorrectLettersCount;

    private String incorrectLetters;

    public void initialize(String generatedWord) {
        this.generatedWord = generatedWord.toLowerCase();
        this.incorrectLettersCount = 0;
        this.incorrectLetters = "";
    }

    public String getGeneratedWord() {
        return generatedWord;
    }

    public int getIncorrectLettersCount() {
        return incorrectLettersCount;
    }

    public String getIncorrectLetters() {
        return incorrectLetters;
    }

    public void setIncorrectLettersCount(int incorrectLettersCount) {
        this.incorrectLettersCount = incorrectLettersCount;
    }

    public void setIncorrectLetters(String incorrectLetters) {
        this.incorrectLetters = incorrectLetters;
    }
}
