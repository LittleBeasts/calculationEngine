package calculationEngine.entities;

import calculationEngine.environment.CeItem;

public class CeInventory {

    CeItem armorShoulder;
    CeItem armorShoes;
    CeItem armorLegs;
    CeItem armorChest;
    CeItem armorHead;
    CeItem weapon;

    CeSlots[] slots = new CeSlots[10];

    public void loadSaveInventory(CeItem armorShoulder, CeItem armorShoes, CeItem armorLegs, CeItem armorChest, CeItem armorHead, CeItem weapon, CeSlots[] slots) {
        this.armorChest = armorChest;
        this.slots = slots;
        this.armorHead = armorHead;
        this.armorLegs = armorLegs;
        this.armorShoes = armorShoes;
        this.armorShoulder = armorShoulder;
    }

    public CeInventory(){
        for(int i = 0; i < slots.length; i++){
            slots[i] = new CeSlots();
        }
    }

    public void addItemToInventory(CeItem item) throws NoPlaceInInventoryException {
        boolean foundSlot = false;
        boolean addedItem = false;
        int firstEmptySlot = 0;
        for (int i = 0; i < slots.length; i++ ) {
            CeSlots slot = slots[i];
            if (slot.getItem() != null && slot.getItem().compareTo(item)) {
                slot.increaseAmount();
                foundSlot = true;
                addedItem = true;
            }
            else if (slot.getItem() == null && !foundSlot) {
                firstEmptySlot = i;
                foundSlot = true;
            }
        }
        if(!addedItem && foundSlot) slots[firstEmptySlot].setItem(item);
        if(!foundSlot) throw new NoPlaceInInventoryException();

    }

    public void useItem(CeItem item) throws Exception {
        boolean matchingItem = false;

        for (CeSlots slot : slots) {
            if (slot.getItem().compareTo(item)) {
                matchingItem = true;
                int remainingAmount = slot.decreaseAmount();
                if (remainingAmount <= 0) {
                    slot.reset();
                }
                break;
            }
        }
        if (!matchingItem) throw new ItemNotInInventoryException(item);
    }

    public CeItem getArmorShoulder() {
        return armorShoulder;
    }

    public CeItem getArmorShoes() {
        return armorShoes;
    }

    public CeItem getArmorLegs() {
        return armorLegs;
    }

    public CeItem getArmorChest() {
        return armorChest;
    }

    public CeItem getArmorHead() {
        return armorHead;
    }

    public CeItem getWeapon() {
        return weapon;
    }

    public CeSlots[] getSlots() {
        return slots;
    }
}
