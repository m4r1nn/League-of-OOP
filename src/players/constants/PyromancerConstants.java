package players.constants;

public final class PyromancerConstants {
    private PyromancerConstants() { }

    // constants for pyromancer
    public static final int BASE_HP = 500;
    public static final int BONUS_HP_PER_LEVEL = 50;

    // constants for fireblast
    public static final int FIREBLAST_BASE_DAMAGE = 350;
    public static final int BONUS_FIREBLAST_PERLEVEL = 50;

    // constants for ignite
    public static final int IGNITE_BASE_DAMAGE = 150;
    public static final int BONUS_IGNITE_PER_LEVEL = 20;
    public static final int IGNITE_PASSIVE = 50;
    public static final int BONUS_IGNITE_PASSIVE_PER_LEVEL = 30;
    public static final int ROUNDS_IGNITE_PASSIVE = 2;

    // fireblast modifers
    public static final float FIREBLAST_ROGUE_MODIF = 0.8f;
    public static final float FIREBLAST_KNIGHT_MODIF = 1.2f;
    public static final float FIREBLAST_PYROMANCER_MODIF = 0.9f;
    public static final float FIREBLAST_WIZARD_MODIF = 1.05f;

    // ignite modifiers
    public static final float IGNITE_ROGUE_MODIF = 0.8f;
    public static final float IGNITE_KNIGHT_MODIF = 1.2f;
    public static final float IGNITE_PYROMANCER_MODIF = 0.9f;
    public static final float IGNITE_WIZARD_MODIF = 1.05f;

    // land modifier
    public static final float LAND_MODIF = 1.25f;

    // mark for choosing strategy
    public static final float MIN_HP_COEF = 1f / 4f;
    public static final float MAX_HP_COEF = 1f / 3f;

    // strategy race and hp modifiers
    public static final float ATTACK_STRATEGY_HP = 3f / 4f;
    public static final float ATTACK_STRATEGY_MODIF = 0.7f;
    public static final float DEFENCE_STRATEGY_HP = 4f / 3f;
    public static final float DEFENCE_STRATEGY_MODIF = -0.3f;
}
