package Person;

// Копейщик
public class Spearman extends PersonBase {
    public Spearman(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 2);
    }

    public void step() {
        System.out.println("Spearman " + getName() + " делает шаг");
    }

    public void attack(PersonBase target) {
    }

    public void heal() {
    }

    public void defend() {
    }

    public void SpecialAbility() {
    }
}
