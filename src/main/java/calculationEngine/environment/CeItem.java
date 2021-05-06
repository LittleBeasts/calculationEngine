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
        this.itemBonusStats = new CeItemBonusStats(itemBonusStats);
        this.description = description;
    }

    public void setNewLootedItem(String name, String spriteName, boolean unique, String type, int uses, int[] itemBonusStats, String description) {
        this.name = name;
        this.spriteName = spriteName;
        this.equipped = false;
        this.unique = unique;
        this.type = CeItemTypes.valueOf(type);
        this.uses = uses;
        this.itemBonusStats = new CeItemBonusStats(itemBonusStats);
        this.description = description;
    }

    public void equip() {
        this.equipped = true;
    }

    public void unequip() {
        this.equipped = false;
    }

    public int use() {
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

    @Override
    public String toString() {
        return "CeItem{" +
                "name='" + name + '\'' +
                ", spriteName='" + spriteName + '\'' +
                ", equipped=" + equipped +
                ", unique=" + unique +
                ", type=" + type +
                ", uses=" + uses +
                ", itemBonusStats=" + itemBonusStats.toString() +
                ", description='" + description + '\'' +
                '}';
    }

    public boolean compareTo(CeItem ceItem) {
        return this.name.equals(ceItem.name);
    }
}
