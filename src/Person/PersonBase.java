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
    private String lastAction;


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
    public String getLastAction() {
        return lastAction;
    }
    public void setLastAction(String action) {
        this.lastAction = action;
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

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getInitiative() {return initiative;
    }

    public String getType() {
        return "Person"; // Пример общего типа персонажа
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(getClass().getSimpleName()).append(" ").append(getName()).append(" - ");

        // Действия за последний ход
        // Если персонаж был излечен
        if (getLastAction() != null && getLastAction().equals("heal")) {
            info.append("Лечил союзника");
        }
        // Если была выполнена магия возрождения
        else if (getLastAction() != null && getLastAction().equals("resurrection")) {
            info.append("Возрождал выбранного союзника");
        }
        // Если персонаж просто сделал шаг
        else {
            info.append("Сделал шаг");
        }

        return info.toString();
    }
}
