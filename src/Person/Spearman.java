package Person;

import java.util.List;

// Копейщик
public class Spearman extends PersonBase {
    public Spearman(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 2);
    }

    @Override
    public void step() {
        if (!isAlive()) {
            System.out.println(getName() + " мертв и не может совершить ход.");
            return;
        }

        // Поиск ближайшего противника
        List<PersonBase> enemies = getEnemies();
        if (enemies == null || enemies.isEmpty()) {
            System.out.println(getName() + " не обнаружил ближайших противников и остается на месте.");
            return;
        }

        PersonBase nearestEnemy = findNearestEnemy(enemies);
        if (nearestEnemy == null) {
            System.out.println(getName() + " не обнаружил ближайших противников и остается на месте.");
            return;
        }

        Coordinates enemyCoordinates = nearestEnemy.getCoordinates();
        Coordinates currentCoordinates = getCoordinates();

        // Разница между координатами по X и Y
        int dX = enemyCoordinates.getX() - currentCoordinates.getX();
        int dY = enemyCoordinates.getY() - currentCoordinates.getY();

        if (Math.abs(dX) <= 1 && Math.abs(dY) <= 1) {
            // Противник находится в соседней клетке, атакуем
            attack(nearestEnemy);
        } else {
            // Противник далеко, двигаемся в его направлении
            if (Math.abs(dX) > Math.abs(dY)) {
                // Двигаемся по X
                if (dX > 0) {
                    move(Direction.RIGHT);
                } else {
                    move(Direction.LEFT);
                }
            } else {
                // Двигаемся по Y
                if (dY > 0) {
                    move(Direction.DOWN);
                } else {
                    move(Direction.UP);
                }
            }
        }
    }

    // Метод атаки персонажа target
    public void attack() {
        attack(null);
    }

    // Метод атаки персонажа target
    public void attack(PersonBase target) {
        System.out.println(getName() + " атакует " + target.getName());
        // Реализация атаки
    }

    // Метод защиты персонажа
    public void defend() {
        System.out.println(getName() + " защищается.");
        // Реализация защиты
    }

    @Override
    public void SpecialAbility() {

    }

    // Метод специальной способности персонажа
    public void specialAbility() {
        System.out.println(getName() + " использует специальную способность.");
        // Реализация специальной способности
    }

    public void heal() {
        throw new UnsupportedOperationException("Копейщик не обладает способностью лечения");
    }

    public void setCoordinates(Coordinates coordinates) {
        super.setCoordinates(coordinates);
    }

    // Метод для поиска ближайшего противника из списка enemies
    private PersonBase findNearestEnemy(List<PersonBase> enemies) {
        double minDistance = Double.MAX_VALUE;
        PersonBase nearestEnemy = null;

        for (PersonBase enemy : enemies) {
            if (enemy.isAlive()) {
                double distance = getCoordinates().calculateDistance(enemy.getCoordinates());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestEnemy = enemy;
                }
            }
        }
        return nearestEnemy;
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

    // Метод для получения списка врагов из других команд
    private List<PersonBase> getEnemies() {
        // Реализация получения списка врагов
        return null; // Пример, замените на вашу реализацию
    }
}
