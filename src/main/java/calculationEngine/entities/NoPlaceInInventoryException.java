package calculationengine.entities;

public class NoPlaceInInventoryException extends Exception{
    public NoPlaceInInventoryException() {
        super("Inventory Full");
    }
}
