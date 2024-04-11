package Person;

import java.util.List;

// Волшебник
public class Wizard extends PersonBase {
    private int mana;

    public Wizard(String name, Coordinates coordinates, int health, int strength, int agility, int defense, int mana, int stamina, int gold) {
        super(name, coordinates, health, strength, agility, defense, mana, stamina, gold, 1);
        this.mana = mana;
    }

    @Override
    public void step() {
        System.out.println("Wizard " + getName() + " делает шаг");
    }

    @Override
    public void attack(PersonBase target) {
    }

    // Лечение
    public void heal() {
        if (mana >= 10) {
            // Выполняем лечение и вычитаем затраченную ману
            System.out.println("Wizard " + getName() + " исцеляет союзника");
            mana -= 10;
        } else {
            // Если маны недостаточно, пропускаем ход и копим ману
            System.out.println("Wizard " + getName() + " не хватает маны для лечения");
            accumulateMana();
        }
    }

    // Магия возрождения
    public void resurrection(List<PersonBase> team) {
        if (mana >= 50 && countDeadAllies(team) > 3) {
            // Выполняем возрождение и вычитаем затраченную ману
            System.out.println("Wizard " + getName() + " возрождает выбранного союзника");
            mana -= 50;
        } else if (countDeadAllies(team) > 3) {
            // Если маны недостаточно, пропускаем ход и копим ману
            System.out.println("Wizard " + getName() + " не хватает маны для возрождения");
            accumulateMana();
        }
    }

    // Подсчет мертвых союзников в команде
    private int countDeadAllies(List<PersonBase> team) {
        int count = 0;
        for (PersonBase ally : team) {
            if (!ally.isAlive()) {
                count++;
            }
        }
        return count;
    }

    // Накопление маны
    private void accumulateMana() {
        mana += 10; //увеличиваем ману на 10 единиц каждый ход
    }

    @Override
    public void defend() {
    }

    @Override
    public void SpecialAbility() {
    }

    @Override
    public String getType() {
        return "Wizard";
    }
}
