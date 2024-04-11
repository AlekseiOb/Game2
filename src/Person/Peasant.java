package Person;
import FirstGame.Main;

import java.util.ArrayList;
import java.util.List;

// Крестьянин
public class Peasant extends PersonBase {
    public Peasant(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 0);
    }

    public void step(List<PersonBase> team) {
        if (!isAlive()) {
            System.out.println(getName() + " мертв и не может совершить ход.");
            return;
        }

        // Поиск ближайшего лучника-арчера в соответствующей команде
        List<PersonBase> archersInTeam = getArchers(team); // Ищем лучников в переданной команде
        if (!archersInTeam.isEmpty()) {
            // Если найден лучник-арчер в переданной команде, передаем ему стрелы
            for (PersonBase archer : archersInTeam) {
                ((Archer) archer).receiveArrow(); // Примерный вызов метода передачи стрел
                System.out.println(getName() + " передает стрелы лучнику " + archer.getName());
            }
        } else {
            // Если лучник-арчер не обнаружен в переданной команде, крестьянин двигается дальше
            move(Direction.DOWN); // Примерный вызов движения вперед, измените на вашу логику
            System.out.println(getName() + " продолжает движение вперед.");
        }
    }

    // Метод для поиска лучников в команде
    private List<PersonBase> getArchers(List<PersonBase> allTeamMembers) {
        List<PersonBase> archers = new ArrayList<>();
        for (PersonBase person : allTeamMembers) {
            if (person instanceof Archer) {
                archers.add(person);
            }
        }
        return archers;
    }


    // Метод для движения персонажа в заданном направлении direction
    private void move(Direction direction) {
        Coordinates currentCoordinates = getCoordinates();
        int newX = currentCoordinates.getX();
        int newY = currentCoordinates.getY();

        switch (direction) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
        }

        // Обновляем координаты
        setCoordinates(new Coordinates(newX, newY));
        System.out.println(getName() + " двигается в направлении " + direction);
    }

    // Метод для передачи стрел лучнику-Archer, если он находится на соседней клетке
    private void passArrowToArcher(List<PersonBase> archers) {
        // Проверяем, есть ли лучник-Archer на соседней клетке
        for (PersonBase archer : archers) {
            Coordinates archerCoordinates = archer.getCoordinates();
            Coordinates peasantCoordinates = getCoordinates();

            // Проверяем, находятся ли лучник и крестьянин на соседних клетках
            if (Math.abs(archerCoordinates.getX() - peasantCoordinates.getX()) <= 1 &&
                    Math.abs(archerCoordinates.getY() - peasantCoordinates.getY()) <= 1) {
                // Если лучник находится на соседней клетке, передаем ему стрелу
                ((Archer) archer).receiveArrow();
                System.out.println(getName() + " передает стрелу лучнику " + archer.getName());
                return;
            }
        }
        // Если лучник-арчер не обнаружен, выводим сообщение об этом
        System.out.println(getName() + " не обнаружил лучника на соседних клетках и продолжает движение.");
    }

    public void attack(PersonBase target) {
    }

    public void SpecialAbility() {
    }

    public void heal() {
    }

    public void defend() {
    }
    @Override
    public String getType() {
        return "Peasant"; // Пример для класса Spearman
    }

}
