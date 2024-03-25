package Person;

import java.util.List;

// Лучник
public class Archer extends PersonBase {
    public Archer(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold);
    }

    public void searchNearestEnemy(List<PersonBase> enemies) {
        double minDistance = Double.MAX_VALUE;
        PersonBase nearestEnemy = null;

        for (PersonBase enemy : enemies) {
            double distance = this.getCoordinates().calculateDistance(enemy.getCoordinates());
            if (distance < minDistance) {
                minDistance = distance;
                nearestEnemy = enemy;
            }
        }

        if (nearestEnemy != null) {
            System.out.println("Ближайший противник для " + this.getName() + " - " + nearestEnemy.getName());
        } else {
            System.out.println("Для " + this.getName() + " не найдено ближайших противников.");
        }
    }
    public void attack(PersonBase target) {
    }

    public void heal() {
    }

    public void defend() {
    }

    public void SpecialAbility() {
    }
    public void receiveArrow() {
    }
}