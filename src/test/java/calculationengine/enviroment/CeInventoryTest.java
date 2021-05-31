package calculationengine.enviroment;

import calculationengine.entities.CeBeasts;
import calculationengine.entities.CeInventory;
import calculationengine.entities.CeSlot;
import calculationengine.entities.CeStats;
import calculationengine.entities.NoPlaceInInventoryException;
import calculationengine.environment.CeItem;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static config.LootConstants.itemList;
import static org.junit.Assert.assertEquals;

public class CeInventoryTest {
    private CeInventory ceInventory;

    @Before
    public void setUp() {
        ceInventory = new CeInventory(new CeStats(CeBeasts.StinkenderFeuerFurz));
    }

    @Test
    public void checkIfItemAddedToInventory() throws NoPlaceInInventoryException {
        JSONObject itemJson = new JSONObject(itemList.get("cage").toString());
        CeItem ceItem = new CeItem();
        ceItem.setNewLootedItem(itemJson);
        ceInventory.addItemToInventory(ceItem);
        CeSlot[] slots = ceInventory.getSlots();
        for (CeSlot slot : slots) {
            if (slot.getItem() != null && slot.getItem().equals(ceItem)) {
                assertEquals(ceItem, slot.getItem());
                break;
            }
        }
    }

    @Test
    public void addItemTwoTimesToInventory() throws NoPlaceInInventoryException {
        JSONObject itemJson = new JSONObject(itemList.get("cage").toString());
        CeItem ceItem = new CeItem();
        ceItem.setNewLootedItem(itemJson);
        int amountToAdd = 2;
        for (int i = 0; i < amountToAdd; i++) {
            ceInventory.addItemToInventory(ceItem);
        }
        CeSlot[] slots = ceInventory.getSlots();
        int itemAmount = 0;
        for (CeSlot slot : slots) {
            if (slot.getItem() != null && slot.getItem().equals(ceItem)) {
                itemAmount = slot.getAmount();
            }
        }
        assertEquals(itemAmount, amountToAdd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullToInventory() throws IllegalArgumentException, NoPlaceInInventoryException {
        ceInventory.addItemToInventory(null);
    }

    @Test(expected = NoPlaceInInventoryException.class)
    public void addElvenItemsToInventory() throws NoPlaceInInventoryException {
        int amountToAdd = ceInventory.getMaxItemSlots()+1 ;
        for (int i = 0; i < amountToAdd; i++) {
            JSONObject itemJson = new JSONObject(itemList.get("cage").toString());
            itemJson.put("name", "cage" + i);
            CeItem ceItem = new CeItem();
            ceItem.setNewLootedItem(itemJson);
            ceInventory.addItemToInventory(ceItem);
        }
    }

}
