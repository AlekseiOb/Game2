package Person;

// Волшебник
public class Wizard extends PersonBase {
    public Wizard(String name, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, health, strength, agility, defense, mana, stamina, gold);
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
