package Person;

// Снайпер
public class Sniper extends PersonBase {
    public Sniper(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 0);
    }

    public void step() {
        System.out.println("Sniper " + getName() + " делает шаг");
    }

    public void attack(PersonBase target) {
    }

    public void heal() {
    }

    public void defend() {
    }

    public void SpecialAbility() {
    }
    @Override
    public String getType() {
        return "Sniper"; // Пример для класса Spearman
    }
}
