package Person;

// Разбойник
public class Bandit extends PersonBase {
    public Bandit(String name, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, health, strength, agility, defense, mana, stamina, gold);
    }

    public void attack(PersonBase target) {
    }

    public void defend() {
    }

    public void SpecialAbility() {
    }

    public void heal() {
    }

    public void stealGold() {
    }
}