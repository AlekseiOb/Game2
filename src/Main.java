import Person.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<PersonBase> team1 = createTeam1();
        List<PersonBase> team2 = createTeam2();

        System.out.println("Первая команда:");
        printTeam(team1);

        System.out.println("\nВторая команда:");
        printTeam(team2);

        System.out.println("\nПоиск ближайшего противника:");
        searchNearestEnemies(team1, team2);
    }

    private static List<PersonBase> createTeam1() {
        List<PersonBase> team = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            switch (i % 4) {
                case 0:
                    team.add(new Peasant(generateUniqueName(team), new Coordinates(i, 0), 100, 10, 5, 5, 0, 50, 1));
                    break;
                case 1:
                    team.add(new Wizard(generateUniqueName(team), new Coordinates(i, 0), 150, 12, 6, 4, 50, 70, 3));
                    break;
                case 2:
                    team.add(new Archer(generateUniqueName(team), new Coordinates(i, 0), 120, 15, 8, 3, 0, 60, 2));
                    break;
                case 3:
                    team.add(new Spearman(generateUniqueName(team), new Coordinates(i, 0), 130, 18, 7, 6, 0, 55, 4));
                    break;
            }
        }
        return team;
    }

    private static List<PersonBase> createTeam2() {
        List<PersonBase> team = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            switch (i % 4) {
                case 0:
                    team.add(new Peasant(generateUniqueName(team), new Coordinates(i, 9), 100, 10, 5, 5, 0, 50, 1));
                    break;
                case 1:
                    team.add(new Bandit(generateUniqueName(team), new Coordinates(i, 9), 100, 10, 5, 5, 0, 50, 1));
                    break;
                case 2:
                    team.add(new Sniper(generateUniqueName(team), new Coordinates(i, 9), 110, 20, 9, 2, 0, 40, 5));
                    break;
                case 3:
                    team.add(new Monk(generateUniqueName(team), new Coordinates(i, 9), 140, 22, 10, 5, 0, 60, 6));
                    break;
            }
        }
        return team;
    }

    private static String generateUniqueName(List<PersonBase> team) {
        String[] names = {"Иван", "Петр", "Алексей", "Сергей", "Михаил", "Николай", "Дмитрий", "Андрей", "Александр", "Владимир", "Артем", "Григорий", "Максим", "Егор", "Константин", "Федор", "Степан", "Павел", "Марк", "Евгений"};
        Random random = new Random();
        String name;
        do {
            name = names[random.nextInt(names.length)];
        } while (containsName(team, name));
        return name;
    }

    private static boolean containsName(List<PersonBase> team, String name) {
        for (PersonBase person : team) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void printTeam(List<PersonBase> team) {
        for (PersonBase person : team) {
            System.out.println(person.getClass().getSimpleName() + ": " + person.getName() + " - Координаты: " + person.getCoordinates());
        }
    }
    private static void searchNearestEnemies(List<PersonBase> team1, List<PersonBase> team2) {
        for (PersonBase archer : team1) {
            if (archer instanceof Archer) {
                ((Archer) archer).searchNearestEnemy(team2);
            }
        }
        for (PersonBase archer : team2) {
            if (archer instanceof Archer) {
                ((Archer) archer).searchNearestEnemy(team1);
            }
        }
    }
}
