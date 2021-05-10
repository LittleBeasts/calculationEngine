package calculationEngine.environment;

import org.json.JSONObject;

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

    public void setItemFromSaveGame(JSONObject itemJson) {
        this.equipped = itemJson.getBoolean("equipped"); //TODO: needs to be in the savegame JSON
        setItem(itemJson);
    }

    public void setNewLootedItem(JSONObject itemJson) {
        this.equipped = false;
        setItem(itemJson);
    }

    private void setItem(JSONObject itemJson) {
        this.name =  itemJson.getString("name");
        this.spriteName =  itemJson.getString("spriteName");
        this.unique = itemJson.getBoolean("unique");
        this.type = CeItemTypes.valueOf(itemJson.getString("type"));
        this.uses = itemJson.getInt("uses");
        this.itemBonusStats = new CeItemBonusStats(CeLoot.jsonArrayToIntArray(itemJson.getJSONArray("bonusStats")));
        this.description = itemJson.getString("description");
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
