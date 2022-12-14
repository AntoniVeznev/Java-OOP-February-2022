package Exercises.E06Reflection.P03BarracksWars_ANewFactory.models.units;

public class Pikeman extends AbstractUnit {

    private static final int PIKEMAN_HEALTH = 30;
    private static final int PIKEMAN_DAMAGE = 15;

    public Pikeman() {
        super(PIKEMAN_HEALTH, PIKEMAN_DAMAGE);
    }
}
