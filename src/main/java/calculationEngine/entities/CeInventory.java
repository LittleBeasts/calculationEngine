package calculationEngine.entities;

import calculationEngine.battle.WrongItemException;
import calculationEngine.environment.CeItem;
import calculationEngine.environment.CeItemTypes;

public class CeInventory {

    CeItem equippedArmorShoulder;
    CeItem equippedArmorShoes;
    CeItem equippedArmorLegs;
    CeItem equippedArmorChest;
    CeItem equippedArmorHead;
    CeItem equippedWeapon;

    CeSlots[] slots = new CeSlots[10];

    public void loadSaveInventory(CeItem armorShoulder, CeItem armorShoes, CeItem armorLegs, CeItem armorChest, CeItem armorHead, CeItem weapon, CeSlots[] slots) {
        this.equippedArmorChest = armorChest;
        this.slots = slots;
        this.equippedArmorHead = armorHead;
        this.equippedArmorLegs = armorLegs;
        this.equippedArmorShoes = armorShoes;
        this.equippedArmorShoulder = armorShoulder;
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

    public void useItem(CeItem item) throws ItemNotInInventoryException {
        boolean matchingItem = false;

        // maybe add exception for type cage

        for (CeSlots slot : slots) {
            CeItem slotItem = slot.getItem();
            if (slotItem != null){
                if (slotItem.compareTo(item)) {
                    matchingItem = true;
                    int remainingAmount = slot.decreaseAmount();
                    if (remainingAmount <= 0) {
                        slot.reset();
                    }
                    break;
                }
            }
        }
        if (!matchingItem){
            throw new ItemNotInInventoryException(item);
        }
    }

    public void setEquippedArmorShoulder(CeItem equippedArmorShoulder) throws WrongItemException {
        if(equippedArmorShoulder.getType() == CeItemTypes.armorShoulder) this.equippedArmorShoulder = equippedArmorShoulder;
        else throw new WrongItemException(equippedArmorShoulder, "Armor type shoulderArmor");
    }

    public void setEquippedArmorShoes(CeItem equippedArmorShoes) throws WrongItemException {
        if(equippedArmorShoes.getType() == CeItemTypes.armorShoes) this.equippedArmorShoes = equippedArmorShoes;
        else throw new WrongItemException(equippedArmorShoes, "Armor type armorShoes");
    }

    public void setEquippedArmorLegs(CeItem equippedArmorLegs) throws WrongItemException {
        if(equippedArmorLegs.getType() == CeItemTypes.armorLegs) this.equippedArmorLegs = equippedArmorLegs;
        else throw new WrongItemException(equippedArmorLegs, "Armor type ArmorLegs");
    }

    public void setEquippedArmorChest(CeItem equippedArmorChest) throws WrongItemException {
        if(equippedArmorChest.getType() == CeItemTypes.armorChest) this.equippedArmorChest = equippedArmorChest;
        else throw new WrongItemException(equippedArmorChest, "Armor type ArmorChest");
    }

    public void setEquippedArmorHead(CeItem equippedArmorHead) throws WrongItemException {
        if(equippedArmorHead.getType() == CeItemTypes.armorHead) this.equippedArmorHead = equippedArmorHead;
        else throw new WrongItemException(equippedArmorHead, "Armor type armorHead");
    }

    public void setEquippedWeapon(CeItem equippedWeapon) throws WrongItemException {
        if(equippedWeapon.getType() == CeItemTypes.weapon) this.equippedWeapon = equippedWeapon;
        else throw new WrongItemException(equippedWeapon, "Armor type weapon");
    }

    public CeItem getEquippedArmorShoulder() {
        return equippedArmorShoulder;
    }

    public CeItem getEquippedArmorShoes() {
        return equippedArmorShoes;
    }

    public CeItem getEquippedArmorLegs() {
        return equippedArmorLegs;
    }

    public CeItem getEquippedArmorChest() {
        return equippedArmorChest;
    }

    public CeItem getEquippedArmorHead() {
        return equippedArmorHead;
    }

    public CeItem getEquippedWeapon() {
        return equippedWeapon;
    }

    public CeSlots[] getSlots() {
        return slots;
    }
}
