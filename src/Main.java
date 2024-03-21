import Person.*;

public class Main {
    public static void main(String[] args) {
        Peasant peasant = new Peasant("Крестьянин", 100, 10, 5, 5, 0, 50, 1);
        Bandit bandit = new Bandit("Бандит", 100, 10, 5, 5, 0, 50, 1);
        Archer archer = new Archer("Лучник", 120, 15, 8, 3, 0, 60, 2);
        Wizard wizard = new Wizard("Волшебник", 150, 12, 6, 4, 50, 70, 3);
        Spearman spearman = new Spearman("Копейщик", 130, 18, 7, 6, 0, 55, 4);
        Sniper sniper = new Sniper("Снайпер", 110, 20, 9, 2, 0, 40, 5);
        Monk monk = new Monk("Монах", 140, 22, 10, 5, 0, 60, 6);

        System.out.println("Имя крестьянина: " + peasant.toString());
        System.out.println("Имя разбойника: " + bandit.toString());
        System.out.println("Имя снайпера: " + sniper.toString());
        System.out.println("Имя колдуна: " + wizard.toString());
        System.out.println("Имя копейщика: " + spearman.toString());
        System.out.println("Имя лучника: " + archer.toString());
        System.out.println("Имя монаха: " + monk.toString());
    }
}