package calculationEngine.environment;

public class CeItem {

    private String name;
    private String spriteName;
    private boolean equipped;
    private boolean unique;
    private CeItemTypes type;
    private int uses;
    private CeItemBonusStats itemBonusStats;
    private String description;

    public CeItem() {
    }

    public void setItemFromSaveGame(String name, String spriteName, boolean equipped, boolean unique, String type, int uses, int[] itemBonusStats, String description) {
        this.name = name;
        this.spriteName = spriteName;
        this.equipped = equipped;
        this.unique = unique;
        this.type = CeItemTypes.valueOf(type);
        this.uses = uses;
        this.itemBonusStats = new CeItemBonusStats(itemBonusStats[0], itemBonusStats[1], itemBonusStats[2], itemBonusStats[3], itemBonusStats[4], itemBonusStats[5], itemBonusStats[6]);
        this.description = description;
    }

    public void setNewLootedItem(String name, String spriteName, boolean unique, String type, int uses, int[] itemBonusStats, String description) {
        this.name = name;
        this.spriteName = spriteName;
        this.equipped = false;
        this.unique = unique;
        this.type = CeItemTypes.valueOf(type);
        this.uses = uses;
        this.itemBonusStats = new CeItemBonusStats(itemBonusStats[0], itemBonusStats[1], itemBonusStats[2], itemBonusStats[3], itemBonusStats[4], itemBonusStats[5], itemBonusStats[6]);
        this.description = description;
    }

    public void equip() {
        this.equipped = true;
    }

    public void unequip(){
        this.equipped = false;
    }

    public int use(){
        this.uses--;
        return this.uses; //return remaining uses, so they can be handled in the iventory handler
    }

    public String getName() {
        return name;
    }

    public String getSpriteName() {
        return spriteName;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public boolean isUnique() {
        return unique;
    }

    public CeItemTypes getType() {
        return type;
    }

    public int getUses() {
        return uses;
    }

    public CeItemBonusStats getItemBonusStats() {
        return itemBonusStats;
    }

    public String getDescription() {
        return description;
    }
}
