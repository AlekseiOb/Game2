package Person;

// Монах
public class Monk extends PersonBase {
    public Monk(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold);
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
