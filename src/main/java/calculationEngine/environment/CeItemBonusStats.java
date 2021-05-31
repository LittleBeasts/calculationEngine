package calculationengine.environment;

public class CeItemBonusStats {

    private int healthPoints;
    private int speed;
    private int stamina;
    private int attack;
    private int defense;
    private int critBonus;
    private int catchBonus;

    public CeItemBonusStats(int[] bonusStats) {
        this.healthPoints = bonusStats[0]; // healthPoints
        this.speed = bonusStats[1];//speed
        this.stamina = bonusStats[2];//stamina
        this.attack = bonusStats[3];//attack
        this.defense = bonusStats[4];//defense
        this.critBonus = bonusStats[5];//critBonus
        this.catchBonus = bonusStats[6];//catchBonus
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
