package com.zzerrgg.service.gameplay;

import com.zzerrgg.dictionary.Dictionary;
import com.zzerrgg.imageInAscii.AsciiGallows;
import com.zzerrgg.service.menu.Menu;
import com.zzerrgg.statistic.GameStatistic;

import java.util.Random;
import java.util.Scanner;

public class LogicGames {

    Dictionary dictionary = new Dictionary();

    Scanner scanner = new Scanner(System.in);

    GameStatistic gameStatistic = new GameStatistic();

    AsciiGallows asciiGallows = new AsciiGallows();

    private String word;

    public void start() {
        initRandomWord();
        gameStatistic.initialize(word);
        String hiddenWord = word.replaceAll("[^ ]", "_");

        while (gameStatistic.getIncorrectLettersCount() != 6) {
            System.out.print("\nВаш ответ: ");

            if (scanner.hasNext()) {
                char letter = scanner.next().toLowerCase().charAt(0);
                hiddenWord = changeWord(word, letter, hiddenWord);
                processGuess(letter, word);
                System.out.println("Слово: " + hiddenWord);
                System.out.println("Ошибки (" + gameStatistic.getIncorrectLettersCount() + "): " +
                        gameStatistic.getIncorrectLetters());
                System.out.println("Буква: " + letter);

                if (isWordGuessed(hiddenWord)) return;

            }

        }

        System.out.println("\nВы не смогли отгадать слово и вас повесили.");
        Menu.print();
    }

    private boolean isWordGuessed(String hiddenWord) {

        if (hiddenWord.equals(gameStatistic.getGeneratedWord())) {
            System.out.println("\nВы избежали смертной казни за невежество.");
            Menu.print();
            return true;
        }

        return false;
    }

    private void processGuess(char guessLetter, String word) {

        if (!word.contains(String.valueOf(guessLetter))) {
            String errorLetter = gameStatistic.getIncorrectLetters();
            gameStatistic.setIncorrectLetters(errorLetter + guessLetter + ", ");
            int errorCount = gameStatistic.getIncorrectLettersCount();
            gameStatistic.setIncorrectLettersCount(++errorCount);
        }
            System.out.println(asciiGallows.stage().get(gameStatistic.getIncorrectLettersCount()));
    }

    private String changeWord(String word, char letter, String replaceWord) {
        char[] str = replaceWord.toCharArray();

        if (word.contains(String.valueOf(letter))) {
            for (int i = 0; i < word.length(); i++) {

                if (String.valueOf(letter).equals(String.valueOf(word.charAt(i)))) {
                    str[i] = letter;
                }

            }

            return new String(str);
        }

        return replaceWord;
    }

     private void initRandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(dictionary.words().size());
        word = dictionary.words().get(randomIndex);
    }



}
