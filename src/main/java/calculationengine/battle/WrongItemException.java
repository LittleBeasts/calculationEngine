package calculationengine.battle;

import calculationengine.environment.CeItem;

public class WrongItemException extends Exception{
    public WrongItemException(CeItem item, String expected) {
        super("Wrong Item: expected: " + expected + " got: " + item.getName());
    }
}
