package FirstGame;
import Person.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int MAX_TURNS = 10;
    public static List<PersonBase> team1;
    public static List<PersonBase> team2;

    public static void main(String[] args) {
        List<PersonBase> team1 = createTeam1();
        List<PersonBase> team2 = createTeam2();
        performActions(team1, team2);

        System.out.println("Первая команда:");
        printTeam(team1);

        System.out.println("\nВторая команда:");
        printTeam(team2);

        for (int turn = 1; turn <= MAX_TURNS; turn++) {
            System.out.println("Ход " + turn + ":");
            // Выполнение действий для каждого персонажа в порядке инициативы
            performTeamAction(team1);
            performTeamAction(team2);

            // Вывод информации о последних действиях каждого персонажа
            printLastActions(team1);
            printLastActions(team2);


            // Визуализация состояния поля
            View.view(team1, team2);

            // Проверка условия завершения игры (например, победы одной из сторон)
            if (isGameOver(team1, team2)) {
                break;
            }
        }

        // Вывод игрового поля в консоль
        View.view(team1, team2);
    }

    private static boolean isGameOver(List<PersonBase> team1, List<PersonBase> team2) {
        return team1.isEmpty() || team2.isEmpty();
    }

    private static List<PersonBase> createTeam1() {
        List<PersonBase> team = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            switch (i % 4) {
                case 0:
                    team.add(new Peasant(generateUniqueName(team), new Coordinates(0, i), 100, 10, 5, 5, 0, 50, 1));
                    break;
                case 1:
                    team.add(new Wizard(generateUniqueName(team), new Coordinates(0, i), 150, 12, 6, 4, 50, 70, 3));
                    break;
                case 2:
                    team.add(new Archer(generateUniqueName(team), new Coordinates(0, i), 120, 15, 8, 3, 0, 60, 2, 10));
                    break;
                case 3:
                    team.add(new Spearman(generateUniqueName(team), new Coordinates(0, i), 130, 18, 7, 6, 0, 55, 4));
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
                    team.add(new Peasant(generateUniqueName(team), new Coordinates(9, i), 100, 10, 5, 5, 0, 50, 1));
                    break;
                case 1:
                    team.add(new Bandit(generateUniqueName(team), new Coordinates(9, i), 100, 10, 5, 5, 0, 50, 1));
                    break;
                case 2:
                    team.add(new Sniper(generateUniqueName(team), new Coordinates(9, i), 110, 20, 9, 2, 0, 40, 5));
                    break;
                case 3:
                    team.add(new Monk(generateUniqueName(team), new Coordinates(9, i), 140, 22, 10, 5, 0, 60, 6));
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
                List<PersonBase> enemies = new ArrayList<>(team2); // Создаем копию списка противников
                ((Archer) archer).searchNearestEnemy(enemies);
            }
        }

        for (PersonBase archer : team2) {
            if (archer instanceof Archer) {
                List<PersonBase> enemies = new ArrayList<>(team1); // Создаем копию списка противников
                ((Archer) archer).searchNearestEnemy(enemies);
            }
        }
    }

    private static void performTeamAction(List<PersonBase> team) {
        // Создание нового списка для сортировки персонажей по инициативе
        List<PersonBase> sortedTeam = new ArrayList<>(team);

        // Сортировка списка
        sortedTeam.sort(Comparator.comparingInt(PersonBase::getInitiative).reversed());

        // Выполнение действий для каждого персонажа в порядке инициативы
        for (PersonBase person : sortedTeam) {
            person.step();
        }
    }

    private static void performActions(List<PersonBase> team1, List<PersonBase> team2) {
        for (int turn = 1; turn <= MAX_TURNS; turn++) {
            System.out.println("Ход " + turn + ":");
            performTeamAction(team1);
            performTeamAction(team2);
            // Визуализация состояния поля
            View.view(team1, team2);
            if (isGameOver(team1, team2)) {
                break;
            }
        }
    }
    private static void printLastActions(List<PersonBase> team) {
        for (PersonBase person : team) {
            System.out.println(person.getInfo());
        }
    }
}
