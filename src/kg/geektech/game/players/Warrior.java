package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int number = RPG_Game.random.nextInt(4) + 2;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this)
                heroes[i].setDamage(heroes[i].getDamage() * number);
        }
    }

}
