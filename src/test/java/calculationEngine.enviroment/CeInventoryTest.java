package calculationEngine.enviroment;

import calculationEngine.entities.CeInventory;
import calculationEngine.entities.CeSlot;
import calculationEngine.entities.NoPlaceInInventoryException;
import calculationEngine.environment.CeItem;
import calculationEngine.environment.CeLoot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CeInventoryTest {
    CeInventory ceInventory;

    @Before
    public void setUp() {
        ceInventory = new CeInventory();
    }

    @Test
    public void checkIfItemAddedToInventory() throws NoPlaceInInventoryException {
        CeItem ceItem = new CeItem();
        int[] itemBonusStats = {10, 10, 10, 10, 10, 10, 0};
        ceItem.setNewLootedItem("Cage", "sprite_name", false, "cage", 1, itemBonusStats, "amazing cage");
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
        CeItem ceItem = new CeItem();
        int[] itemBonusStats = {10, 10, 10, 10, 10, 10, 0};
        ceItem.setNewLootedItem("Cage", "sprite_name", false, "cage", 1, itemBonusStats, "amazing cage");
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
            CeItem ceItem = new CeItem();
            int[] itemBonusStats = {10, 10, 10, 10, 10, 10, 0};
            ceItem.setNewLootedItem("Cage"+i, "sprite_name", false, "cage", 1, itemBonusStats, "amazing cage");
            ceInventory.addItemToInventory(ceItem);
        }
    }

}
