package kg.geektech.game.players;


public abstract class Hero extends GameEntity
        implements HavingSuperAbility {
    private SuperAbility ability;
    private String name;

    public Hero(int health, int damage, SuperAbility ability, String name) {
        super(health, damage);
        this.ability = ability;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void setAbility(SuperAbility ability) {
        this.ability = ability;
    }

}
