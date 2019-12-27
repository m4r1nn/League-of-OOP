package players.constants;

public final class RogueConstants {
    private RogueConstants() { }

    // constants for rogue
    public static final int BASE_HP = 600;
    public static final int BONUS_HP_PER_LEVEL = 40;

    // constants for backstab
    public static final int BACKSTAB_BASE_DAMAGE = 200;
    public static final int BONUS_BACKSTAB_PER_LEVEL = 20;
    public static final int ROUNDS_NUMBER_FOR_CRITICAL = 3;
    public static final float CRITICAL_MODIF = 1.5f;

    // constants for paralysis
    public static final int PARALYSIS_BASIC_DAMAGE = 40;
    public static final int BONUS_PARALYSIS_PER_LEVEL = 10;
    public static final int ROUNDS_NUMBER_OF_PARALYSE = 3;

    // backstab modifiers
    public static final float BACKSTAB_ROGUE_MODIF = 1.2f;
    public static final float BACKSTAB_KNIGHT_MODIF = 0.9f;
    public static final float BACKSTAB_PYROMANCER_MODIF = 1.25f;
    public static final float BACKSTAB_WIZARD_MODIF = 1.25f;

    // paralysis modifiers
    public static final float PARALYSIS_ROGUE_MODIF = 0.9f;
    public static final float PARALYSIS_KNIGHT_MODIF = 0.8f;
    public static final float PARALYSIS_PYROMANCER_MODIF = 1.2f;
    public static final float PARALYSIS_WIZARD_MODIF = 1.25f;

    // land modifier
    public static final float LAND_MODIF = 1.15f;

    public static final float MIN_HP_COEF = 1f / 7f;
    public static final float MAX_HP_COEF = 1f / 5f;

    public static final float ATTACK_STRATEGY_HP = 6f / 7f;
    public static final float ATTACK_STRATEGY_MODIF = 0.4f;
    public static final float DEFENCE_STRATEGY_HP = 3f / 2f;
    public static final float DEFENCE_STRATEGY_MODIF = -0.1f;
}
