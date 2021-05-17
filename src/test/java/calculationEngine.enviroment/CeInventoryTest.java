package calculationEngine.enviroment;

import calculationEngine.entities.CeInventory;
import calculationEngine.entities.CeSlot;
import calculationEngine.entities.NoPlaceInInventoryException;
import calculationEngine.environment.CeItem;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static config.LootConfig.itemList;
import static org.junit.Assert.*;

public class CeInventoryTest {
    CeInventory ceInventory;

    @Before
    public void setUp() {
        ceInventory = new CeInventory();
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

    @Test(expected = NullPointerException.class)
    public void addNullToInventory() throws NoPlaceInInventoryException {
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
