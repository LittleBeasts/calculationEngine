package calculationEngine.environment;

import calculationEngine.entities.CeStats;
import org.json.JSONObject;

public class CeItemEffects {

    effects effect;
    String description;
    int value;

    private enum effects{
        heal,
        increaseDamage,
        increaseSpeed,
        increaseAttack,
        increaseCritBonus,
        increaseDefense;
    }

    public CeItemEffects(JSONObject effectObject){
        this.effect = effects.valueOf(effectObject.getString("type"));
        this.value = effectObject.getInt("value");
    }

    public void use(CeStats ceStats, CeItemBonusStats ceItemBonusStats){
        switch (this.name()){
            case "heal":
                int hitPoints = ceStats.getCurrentHitPoints();
                hitPoints += ceItemBonusStats.getHealthPoints();
        }
    }

}

class a{
    public static void main(String[] args) {
        CeItemEffects effect = CeItemEffects.heal;
        System.out.println(effect.name());
    }
}
