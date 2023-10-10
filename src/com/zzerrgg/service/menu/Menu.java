package com.zzerrgg.service.menu;

import com.zzerrgg.service.gameplay.GamePlay;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    GamePlay gamePlay = new GamePlay();

    public void printMenu() {
        String firstMenuItem = "1 - Старт новой игры";
        String secondMenuItem = "2 - Завершение игры";
        System.out.println("\nСделайте ваш выбор: \n" +
                firstMenuItem + "\n" +
                secondMenuItem);
        while (true) {
            String playerChoice = scanner.nextLine();
            if (!playerChoice.equals("1") && !playerChoice.equals("2")) {
                System.out.println("Сделайте ввод 1 или 2 соответствующие пунктам меню");
            } else {
                switch (playerChoice) {
                    case "1":
                        System.out.println("Да начнется битва");
                        gamePlay.startNewGame();
                        break;
                    case "2":
                        System.out.println("Вы вышли из битвы");
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
