package Person;

// Крестьянин
public class Peasant extends PersonBase {
    public Peasant(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 0);
    }

    public void step() {
        System.out.println("Peasant " + getName() + " делает шаг");
    }
    public void attack(PersonBase target) {
    }

    public void SpecialAbility() {
    }

    public void heal() {
    }

    public void defend() {
    }

}
