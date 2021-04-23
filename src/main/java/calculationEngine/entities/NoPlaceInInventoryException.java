package calculationEngine.entities;

import calculationEngine.environment.CeItem;

public class NoPlaceInInventoryException extends Exception{
    public NoPlaceInInventoryException() {
        super("Inventory Full");
    }
}
