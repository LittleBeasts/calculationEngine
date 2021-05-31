package calculationengine.entities;

import config.PlayerConstants;

import java.util.List;

public class CePlayer extends CeEntity {

    private List<CeEntity> team;
    private boolean isAI;
    private int playerNumber;
    private int activeMonsterIndex = 0;
    private final CeAttack[] playerStandardCeAttacks = PlayerConstants.PLAYER_STANDARD_CE_ATTACKS;
    private CeInventory inventory;

    public CePlayer(CeStats ceStats, List<CeAttack> ceAttacks, List<CeEntity> team, boolean isAI) {
        super(ceStats, ceAttacks, Integer.MAX_VALUE, false);
        this.team = team;
        this.isAI = isAI;
        this.inventory = new CeInventory(this.getCeStats());
    }

    // Constructor for AI
    public CePlayer(){
        super();
        this.isAI = true;
    }

    public CeInventory getInventory() {
        return inventory;
    }

    public List<CeEntity> getTeam() {
        return team;
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI() {
        this.isAI = true;
    }

    public void setNumber(int number) {
        this.playerNumber = number;
    }

    public void setTeam(List<CeEntity> team) {
        this.team = team;
    }

    public int getNumber() {
        return playerNumber;
    }

    public void setActiveMonsterIndex(int activeMonsterIndex) {
        if (activeMonsterIndex < team.size() && activeMonsterIndex > 0) this.activeMonsterIndex = activeMonsterIndex;
    }

    public int getActiveMonsterIndex() {
        return activeMonsterIndex;
    }

    public CeAttack[] getPlayerStandardAttacks() {
        return playerStandardCeAttacks;
    }
}
