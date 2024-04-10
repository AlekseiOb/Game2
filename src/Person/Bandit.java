package Person;

import java.util.List;

// Разбойник
public class Bandit extends PersonBase {
    public Bandit(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 1);
    }

    @Override
    public void step() {
        if (!isAlive()) {
            System.out.println(getName() + " мертв и не может совершить ход.");
            return;
        }

        List<PersonBase> enemies = getEnemies();
        if (enemies == null || enemies.isEmpty()) {
            System.out.println(getName() + " не обнаружил ближайших противников и двигается вперед.");
            move(Direction.LEFT);
            return;
        }

        PersonBase nearestEnemy = findNearestEnemy(enemies);
        if (nearestEnemy == null) {
            System.out.println(getName() + " не обнаружил ближайших противников и двигается вперед.");
            move(Direction.LEFT);
            return;
        }

        Coordinates enemyCoordinates = nearestEnemy.getCoordinates();
        Coordinates currentCoordinates = getCoordinates();

        int dX = enemyCoordinates.getX() - currentCoordinates.getX();
        int dY = enemyCoordinates.getY() - currentCoordinates.getY();

        if (Math.abs(dX) <= 1 && Math.abs(dY) <= 1) {
            attack(nearestEnemy);
        } else {
            if (Math.abs(dX) > Math.abs(dY)) {
                if (dX > 0) {
                    move(Direction.LEFT);
                } else {
                    move(Direction.RIGHT);
                }
            } else {
                if (dY > 0) {
                    move(Direction.DOWN);
                } else {
                    move(Direction.UP);
                }
            }
        }
    }

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

    public void attack(PersonBase target) {
    }

    public void defend() {
    }

    public void SpecialAbility() {
    }

    public void heal() {
    }

    public void setCoordinates(Coordinates coordinates) {
        super.setCoordinates(coordinates);
    }

    private List<PersonBase> getEnemies() {
        // Реализация метода
        return null;
    }

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

    @Override
    public String getType() {
        return "Bandit"; // Пример для класса Spearman
    }
}