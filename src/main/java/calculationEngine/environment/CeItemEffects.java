package calculationEngine.environment;

import calculationEngine.entities.CeStats;
import config.BattleConstants;
import org.json.JSONObject;

public class CeItemEffects {

    private Effects effect;
    private String description;
    private int value;

    private static final boolean debug = BattleConstants.battleDebug;

    private enum Effects {
        healing,
        increaseSpeed,
        increaseAttack,
        increaseCritBonus,
        increaseDefense,
        catchBeast,
        defaultEffect
    }

    public CeItemEffects(JSONObject effectObject){
        this.effect = Effects.valueOf(effectObject.getString("type"));
        this.value = effectObject.getInt("value");
        this.description = effectObject.getString("description");
    }

    public void use(CeStats ceStats){
        switch (this.effect.name()){
            case "healing":
                int hitPoints = ceStats.getCurrentHitPoints();
                hitPoints += this.value;
                ceStats.setCurrentHitPoints(hitPoints);
                if (debug) System.out.println("[CeItemEffects] healing by " + this.value + " points");
                break;
            case "increaseSpeed":
                int speed = ceStats.getSpeed();
                speed += this.value;
                ceStats.setSpeed(speed);
                break;
            case "increaseAttack":
                int attack = ceStats.getAttack();
                attack += this.value;
                ceStats.setAttack(attack);
                break;
            case "increaseCritBonus":
                int critBonus = ceStats.getCritBonus();
                critBonus += this.value;
                ceStats.setCritBonus(critBonus);
                break;
            case "increaseDefense":
                int defense = ceStats.getDefense();
                defense += this.value;
                ceStats.setDefense(defense);
                break;
            default: break;
        }
    }

    public Effects getEffect() {
        return effect;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }
}