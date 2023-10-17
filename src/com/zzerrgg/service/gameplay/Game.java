package com.zzerrgg.service.gameplay;

import com.zzerrgg.service.menu.Menu;

import java.util.Scanner;

import static com.zzerrgg.service.menu.Menu.*;

public class Game {

    private final LogicGames logicGames;

    public Game() {
        this.logicGames = new LogicGames();
    }

    public void start() {
        Menu.print();
        loop();
    }

    private void loop(){
        Scanner scanner = new Scanner(System.in);
        boolean isGameStart = true;

        while (isGameStart) {
            String playerChoice = scanner.nextLine();
            Menu menuByCod = Menu.getMenuByCod(playerChoice);

            if(menuByCod == null) {
                menuByCod = DEFAULT;
            }

            switch (menuByCod) {
                case START:
                    System.out.println("Да начнется битва");
                    logicGames.start();
                    break;
                case STOP:
                    System.out.println("Вы вышли из битвы");
                    isGameStart = false;
                    break;
                case DEFAULT:
                default:
                    DEFAULT.printTitle();
            }
        }

        System.exit(0);
    }
}
