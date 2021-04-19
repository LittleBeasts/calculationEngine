package calculationEngine.environment;

public class CeItemBonusStats {

    private int healthPoints;
    private int speed;
    private int stamina;
    private int attack;
    private int defense;
    private int critBonus;
    private int catchBonus;

    public CeItemBonusStats(int healthPoints, int speed, int stamina, int attack, int defense, int critBonus, int catchBonus) {
        this.healthPoints = healthPoints;
        this.speed = speed;
        this.stamina = stamina;
        this.attack = attack;
        this.defense = defense;
        this.critBonus = critBonus;
        this.catchBonus = catchBonus;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCritBonus() {
        return critBonus;
    }

    public int getCatchBonus() {
        return catchBonus;
    }

    @Override
    public String toString() {
        return "CeItemBonusStats{" +
                "healthPoints=" + healthPoints +
                ", speed=" + speed +
                ", stamina=" + stamina +
                ", attack=" + attack +
                ", defense=" + defense +
                ", critBonus=" + critBonus +
                ", catchBonus=" + catchBonus +
                '}';
    }
}
