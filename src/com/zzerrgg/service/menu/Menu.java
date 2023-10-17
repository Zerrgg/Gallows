package com.zzerrgg.service.menu;


public enum Menu {

    START("1 - Старт новой игры", "1"),
    STOP("2 - Завершение игры", "2"),

    DEFAULT("Сделайте ввод 1 или 2 соответствующие пунктам меню", "-1");
    private final String title;

    private final String code;

    Menu(String title, String code){
        this.title = title;
        this.code = code;
    }

    public void printTitle(){
        System.out.println(this.getTitle());
    }

    public static void print() {
        System.out.println("\nСделайте ваш выбор: \n" +
                Menu.START.title + "\n" +
                Menu.STOP.title);

    }

    public static Menu getMenuByCod(String code) {
        for (Menu value : Menu.values()) {
            if(value.code.equals(code)){
                return value;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }
}
