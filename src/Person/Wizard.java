package Person;

// Волшебник
public class Wizard extends PersonBase {
    public Wizard(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold,1);
    }

    public void step() {
        System.out.println("Wizard " + getName() + " делает шаг");
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
        return "Wizard"; // Пример для класса Spearman
    }
}
