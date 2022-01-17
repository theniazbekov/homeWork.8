package kg.geektech.game.players;

public class Berserk extends Hero {
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this) {
                heroes[i].setDamage(heroes[i].getDamage() + boss.getDamage());
            }
        }
    }
}
