package players.constants;

public final class KnightConstants {
    private KnightConstants() { }

    // constants for knight
    public static final int BASE_HP = 900;
    public static final int BONUS_HP_PER_LEVEL = 80;

    // constants for execute
    public static final int EXECUTE_BASE_DAMAGE = 200;
    public static final int BONUS_EXECUTE_PER_LEVEL = 30;
    public static final float HP_LIMIT_PERCENT = 0.2f;
    public static final float DEFAULT_PERCENT = 0.01f;
    public static final float MAX_LEVEL_BONUS = 20;

    // constants for slam
    public static final int SLAM_BASE_DAMAGE = 100;
    public static final int BONUS_SLAM_PER_LEVEL = 40;
    public static final int ROUNDS_OF_STUN = 1;

    // execute modifiers
    public static final float EXECUTE_ROGUE_MODIF = 1.15f;
    public static final float EXECUTE_KNIGHT_MODIF = 1f;
    public static final float EXECUTE_PYROMANCER_MODIF = 1.1f;
    public static final float EXECUTE_WIZARD_MODIF = 0.8f;

    // slam modifiers
    public static final float SLAM_ROGUE_MODIF = 0.8f;
    public static final float SLAM_KNIGHT_MODIF = 1.2f;
    public static final float SLAM_PYROMANCER_MODIF = 0.9f;
    public static final float SLAM_WIZARD_MODIF = 1.05f;

    // land modifier
    public static final float LAND_MODIF = 1.15f;

    // mark for choosing strategy
    public static final float MIN_HP_COEF = 1f / 3f;
    public static final float MAX_HP_COEF = 1f / 2f;

    // strategy race and hp modifiers
    public static final float ATTACK_STRATEGY_HP = 4f / 5f;
    public static final float ATTACK_STRATEGY_MODIF = 0.5f;
    public static final float DEFENCE_STRATEGY_HP = 5f / 4f;
    public static final float DEFENCE_STRATEGY_MODIF = -0.2f;
}
