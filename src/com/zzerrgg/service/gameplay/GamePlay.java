package com.zzerrgg.service.gameplay;

import com.zzerrgg.dictionary.Dictionary;
import com.zzerrgg.image.AsciiGallows;
import com.zzerrgg.info.GameStatistic;
import com.zzerrgg.service.menu.Menu;

import java.util.Random;
import java.util.Scanner;

public class GamePlay {

    Dictionary dictionary = new Dictionary();

    Scanner scanner = new Scanner(System.in);

    GameStatistic gameStatistic = new GameStatistic();

    AsciiGallows asciiGallows = new AsciiGallows();

    public void startNewGame() {
        Menu menu = new Menu();
        String word = generateWord();
        gameStatistic.initialize(word);
        gameStatistic.setGeneratedWord(word);
        String replaceWord = word.replaceAll("[^ ]", "_");
        while (gameStatistic.getIncorrectLettersCount() != 6) {
            System.out.print("\nВаш ответ: ");
            if (scanner.hasNext()) {
                char letter = scanner.next().toLowerCase().charAt(0);
                replaceWord = changeWord(word, letter, replaceWord);
                processGuess(letter, word);
                System.out.println("Слово: " + replaceWord);
                System.out.println("Ошибки (" + gameStatistic.getIncorrectLettersCount() + ")" +
                        gameStatistic.getIncorrectLetters());
                System.out.println("Буква: " + letter);
                if (replaceWord.equals(gameStatistic.getGeneratedWord())) {
                    System.out.println("\nВы избежали смертной казни за невежество.");
                    menu.printMenu();
                }
            }
        }
        System.out.println("\nВы не смогли отгадать слово и вас повесили.");
        menu.printMenu();
    }

    private void processGuess(char guessLetter, String word) {
        if (!word.contains(String.valueOf(guessLetter))) {
            String errorLetter = gameStatistic.getIncorrectLetters();
            gameStatistic.setIncorrectLetters(errorLetter + guessLetter + ", ");
            int errorCount = gameStatistic.getIncorrectLettersCount();
            gameStatistic.setIncorrectLettersCount(++errorCount);
            System.out.println(asciiGallows.stage().get(gameStatistic.getIncorrectLettersCount()));
        } else {
            System.out.println(asciiGallows.stage().get(gameStatistic.getIncorrectLettersCount()));
        }
    }

    private String changeWord(String word, char letter, String replaceWord) {
        String replacedWord = replaceWord;
        char[] str = replacedWord.toCharArray();
        if (word.contains(String.valueOf(letter))) {
            for (int i = 0; i < word.length(); i++) {
                if (String.valueOf(letter).equals(String.valueOf(word.charAt(i)))) {
                    str[i] = letter;
                }
            }
            return new String(str);
        }
        return replacedWord;
    }


    private String generateWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(dictionary.words().size());
        return dictionary.words().get(randomIndex);
    }

}
