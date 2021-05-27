package calculationEngine.environment;

import calculationEngine.entities.CeBeasts;
import calculationEngine.entities.CeInventory;
import calculationEngine.entities.CeStats;
import calculationEngine.entities.NoPlaceInInventoryException;

public class TestItems {
    public static void main(String[] args) throws NoPlaceInInventoryException {
        System.out.println(CeLoot.lootItem("cage").toString());
        CeInventory inventory = new CeInventory(new CeStats(CeBeasts.StinkenderFeuerFurz));
        inventory.addItemToInventory(CeLoot.lootItem("cage"));
        System.out.println("Amount: " + inventory.getSlots()[0].getAmount()); // should be 1
        inventory.addItemToInventory(CeLoot.lootItem("cage"));
        System.out.println("Amount: " + inventory.getSlots()[0].getAmount()); // should be 2
        inventory.addItemToInventory(CeLoot.lootItem("aHealingPotion"));
        System.out.println(inventory.getSlots()[1].getItem().toString());

    }
}
