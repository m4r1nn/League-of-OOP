package players.constants;

public final class WizardConstants {
    private WizardConstants() { }

    // constants for wizard
    public static final int BASE_HP = 400;
    public static final int BONUS_HP_PER_LEVEL = 30;

    // constants for drain
    public static final float DRAIN_PERCENT = 0.2f;
    public static final float BONUS_DRAIN_PER_LEVEL = 0.05f;
    public static final float MIN_HP_PERCENT = 0.3f;

    // constants for deflect
    public static final float DEFLECT_PERCENT = 0.35f;
    public static final float BONUS_DEFLECT_PER_LEVEL = 0.02f;
    public static final int MAX_BONUS_DEFLECT = 17;

    // drain modifiers
    public static final float DRAIN_ROGUE_MODIF = 0.8f;
    public static final float DRAIN_KNIGHT_MODIF = 1.2f;
    public static final float DRAIN_PYROMANCER_MODIF = 0.9f;
    public static final float DRAIN_WIZARD_MODIF = 1.05f;

    // deflect modifiers
    public static final float DEFLECT_ROGUE_DAMAGE = 1.2f;
    public static final float DEFLECT_KNIGHT_MODIF = 1.4f;
    public static final float DEFLECT_PYROMANCER_MODIF = 1.3f;
    public static final float DEFLECT_WIZARD_MODIF = 0f;

    // land modifier
    public static final float LAND_MODIF = 1.1f;

    // mark for choosing strategy
    public static final float MIN_HP_COEF = 1f / 4f;
    public static final float MAX_HP_COEF = 1f / 2f;

    // strategy race and hp modifiers
    public static final float ATTACK_STRATEGY_HP = 9f / 10f;
    public static final float ATTACK_STRATEGY_MODIF = 0.6f;
    public static final float DEFENCE_STRATEGY_HP = 6f / 5f;
    public static final float DEFENCE_STRATEGY_MODIF = -0.2f;
}
