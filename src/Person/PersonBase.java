package Person;

public abstract class PersonBase {
    private String name; // имя
    private int health;  // здоровье
    private int strength;  // сила
    private int agility;  // ловкость
    private int defense;  // защита
    private int mana;  // магическая сила
    private int stamina;  // выносливость
    private int gold;  // золото
    private int initiative; // инициатива
    private boolean isAlive;
    private Coordinates coordinates; // координаты

    public PersonBase(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold, int initiative) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.defense = defense;
        this.mana = mana;
        this.stamina = stamina;
        this.gold = gold;
        this.isAlive = true;
        this.coordinates = coordinates;
        this.initiative = initiative;
    }

    public abstract void attack(PersonBase target);     // Метод атаки
    public abstract void heal();    // Метод лечения
    public abstract void defend();     // Метод защиты
    public abstract void SpecialAbility();     // Метод использования специальной способности
    public boolean isAlive() {
        return isAlive;         // Метод проверки жив ли персонаж
    }

    // Реализация метода step() из интерфейса
    public void step() {
        // логика для метода step()
    }
    @Override
    public String toString() {return name;
    }

    public String getName() {return name;
    }

    public Coordinates getCoordinates() {return coordinates;
    }

    public int getInitiative() {return initiative;
    }
}
