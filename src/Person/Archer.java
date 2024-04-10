package Person;

import java.util.List;

// Лучник
public class Archer extends PersonBase {
    private int arrows; // количество стрел

    public Archer(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold, int arrows) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 3);
        this.arrows = arrows;
    }

    @Override
    public void step() {
        System.out.println("Archer " + getName() + " делает шаг");
    }

    @Override
    public void attack(PersonBase target) {
        if (arrows <= 0) {
            System.out.println(getName() + " не имеет стрел.");
            return;
        }

        System.out.println(getName() + " стреляет в " + target.getName());
        arrows--; // Уменьшить количество стрел после выстрела
    }

    @Override
    public void heal() {
        // Реализация метода лечения для лучника
    }

    @Override
    public void defend() {
        // Реализация метода защиты для лучника
    }

    @Override
    public void SpecialAbility() {
        // Реализация специальной способности для лучника
    }


    public void step(List<PersonBase> enemies) {
        // Реализация метода шага для лучника
        searchNearestEnemy(enemies);
    }

    public void searchNearestEnemy(List<PersonBase> enemies) {
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

        if (nearestEnemy != null) {
            attack(nearestEnemy); // Атаковать ближайшего противника
        } else {
            System.out.println(getName() + " не найдено ближайших противников.");
        }
    }
    @Override
    public String getType() {
        return "Archer"; // Пример для класса Spearman
    }
}
