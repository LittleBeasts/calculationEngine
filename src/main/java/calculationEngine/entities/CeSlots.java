package calculationEngine.entities;

import calculationEngine.environment.CeItem;

public class CeSlots {

    private CeItem item;
    private int amount;

    public CeSlots() {
        this.item = null;
        this.amount = 0;
    }

    public void increaseAmount(){
        this.amount++;
    }

    public void reset(){
        this.amount = 0;
        this.item = null;
    }

    public int decreaseAmount(){
        this.amount--;
        return this.amount;
    }

    public CeItem getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public void setItem(CeItem item) {
        this.item = item;
        this.amount = 1;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
