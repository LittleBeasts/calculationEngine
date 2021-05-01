package calculationEngine.entities;

import calculationEngine.environment.CeItem;

public class ItemNotInInventoryException extends Exception {
    public ItemNotInInventoryException(CeItem item){
        super("Item: " + item.getName() + "not found in Inventory");
    }
}
