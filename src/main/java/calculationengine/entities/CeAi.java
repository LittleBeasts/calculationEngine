package calculationengine.entities;

import calculationengine.battle.CeBattle;
import calculationengine.environment.CeRegions;
import config.BattleConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CeAi extends CePlayer {
    private CeEntity currentMonster;
    private CeBattle battle;
    private static final boolean debug = BattleConstants.battleDebug;

    // Constructor for new Random Beast AI
    public CeAi(CePlayer player, CeRegions region) {
        super();
        CeEntity ceBeast = new CeEntity(region, player);
        finishAIConstruction(ceBeast);
    }

    // Constructor for Special defined Beast AI
    public CeAi(CeEntity ceEntity) {
        super();
        finishAIConstruction(ceEntity);
    }

    // Constructor for NPC with Team
    public CeAi(CePlayer player, CeBeastTypes type, List<CeEntity> team) {
        super();
        this.setTeam(team);
        this.setCeStats(new CeStats(player.getCeStats().getLevel(), type));
        this.currentMonster = this.getTeam().get(0);
    }

    public void useAttack(){
        battle.useAttack(pickAttack());
    }

    private void finishAIConstruction(CeEntity ceBeast){
        List<CeEntity> team = new ArrayList<>();
        team.add(
                ceBeast
        );
        this.setTeam(team);
        if (debug) System.out.println("[AI Construction]: AI CREATION: " + ceBeast.toString());
        this.setCeStats(ceBeast.getCeStats());
        this.getCeStats().setMaxHitPoints(0);
        this.getCeStats().setCurrentHitPoints(0);
        this.currentMonster = this.getTeam().get(0);
    }

    private CeAttack pickAttack() {
        List<CeAttack> ceAttacks = this.currentMonster.getAttacks();
        Random random = new Random();
        int ind = random.nextInt(ceAttacks.size());
        if (debug) System.out.println("[AI pickAttack]: " + ind);
        return ceAttacks.get(ind);
    }

    public void setBattle(CeBattle battle) {
        this.battle = battle;
    }
}
