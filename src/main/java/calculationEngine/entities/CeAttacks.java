package calculationEngine.entities;

public enum CeAttacks {

    Punch(CeBeastTypes.PlayerStandard, 10, 10, 2, 20, "Punch"), //TODO: Add attacks
    Incinerate(CeBeastTypes.Fire, 15, 8, 0, 5,"Incinerate"),
    Drain(CeBeastTypes.Earth, 10, 10, 3, 10, "Drain Sanity"),
    Charge(CeBeastTypes.Boss, 20, 5, 2, 5, "Charge Attack"),
    Whip(CeBeastTypes.Boss, 12, 8, 5, 7, "Water Whip"),
    Scratch(CeBeastTypes.PlayerStandard, 10, 10, 2, 20, "Scratch"),
    Arcane(CeBeastTypes.Earth, 20, 7, 2, 5, "Arcane Blast"),
    Sucker(CeBeastTypes.Earth, 12, 10, 8, 15,  "Sucker Punch"),
    Acid(CeBeastTypes.Water, 10, 10, 5, 15, "Acid Downpour"),
    FireBall(CeBeastTypes.Fire, 15, 10, 3, 15, "Fire Ball"),
    Bite(CeBeastTypes.PlayerStandard, 10, 10, 3, 20, "Bite"),
    Flee(CeBeastTypes.PlayerStandard, 0, 0, 0, 0, "Flee"),
    Catch(CeBeastTypes.PlayerStandard, 10, 10, 2, 3, "Catch");

    private final String name;
    private final int baseDamage;
    private final int baseAccuracy;
    private final CeBeastTypes type;
    private final int baseCriticalChance;
    private final int executions;


    CeAttacks(CeBeastTypes type, int baseDamage, int baseAccuracy, int baseCriticalChance, int executions, String name) {
        this.type = type;
        this.baseDamage = baseDamage;
        this.baseAccuracy = baseAccuracy;
        this.baseCriticalChance = baseCriticalChance;
        this.executions = executions;
        this.name = name;
    }

    public CeBeastTypes getType() {
        return type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseAccuracy() {
        return baseAccuracy;
    }

    public int getBaseCriticalChance() {
        return baseCriticalChance;
    }

    public int getExecutions() {
        return executions;
    }

    public String getName() {
        return name;
    }
}
