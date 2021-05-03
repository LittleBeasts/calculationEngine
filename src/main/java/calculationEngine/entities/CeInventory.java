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

    int maxItemSlots = 10;
    CeSlot[] slots = new CeSlot[maxItemSlots];

    public void loadSaveInventory(CeItem armorShoulder, CeItem armorShoes, CeItem armorLegs, CeItem armorChest, CeItem armorHead, CeItem weapon, CeSlot[] slots) {
        this.equippedArmorChest = armorChest;
        this.slots = slots;
        this.equippedArmorHead = armorHead;
        this.equippedArmorLegs = armorLegs;
        this.equippedArmorShoes = armorShoes;
        this.equippedArmorShoulder = armorShoulder;
    }

    public CeInventory() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new CeSlot();
        }
    }

    public void addItemToInventory(CeItem item) throws NoPlaceInInventoryException {
        if (item == null) {
            throw new NullPointerException();
        }
        boolean foundSlot = false;
        boolean addedItem = false;
        int firstEmptySlot = 0;
        for (int i = 0; i < slots.length; i++) {
            CeSlot slot = slots[i];
            if (slot.getItem() != null && slot.getItem().compareTo(item)) {
                slot.increaseAmount();
                foundSlot = true;
                addedItem = true;
                break;
            } else if (slot.getItem() == null && !foundSlot) {
                firstEmptySlot = i;
                foundSlot = true;
                break;
            }
        }
        if (!addedItem && foundSlot) slots[firstEmptySlot].setItem(item);
        if (!foundSlot) throw new NoPlaceInInventoryException();

    }

    public void useItem(CeItem item) throws ItemNotInInventoryException {
        boolean matchingItem = false;

        // maybe add exception for type cage

        for (CeSlot slot : slots) {
            CeItem slotItem = slot.getItem();
            if (slotItem != null) {
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
        if (!matchingItem) {
            throw new ItemNotInInventoryException(item);
        }
    }

    public void setEquippedArmorShoulder(CeItem equippedArmorShoulder) throws WrongItemException {
        if (this.equippedArmorShoulder != null)
            this.equippedArmorShoulder.unequip();
        if (equippedArmorShoulder.getType() == CeItemTypes.armorShoulder) {
            this.equippedArmorShoulder = equippedArmorShoulder;
            this.equippedArmorShoulder.equip();
        } else throw new WrongItemException(equippedArmorShoulder, "Armor type shoulderArmor");
    }

    public void setEquippedArmorShoes(CeItem equippedArmorShoes) throws WrongItemException {
        if (this.equippedArmorShoes != null)
            this.equippedArmorShoes.unequip();
        if (equippedArmorShoes.getType() == CeItemTypes.armorShoes) {
            this.equippedArmorShoes = equippedArmorShoes;
            this.equippedArmorShoes.equip();
        } else throw new WrongItemException(equippedArmorShoes, "Armor type armorShoes");
    }

    public void setEquippedArmorLegs(CeItem equippedArmorLegs) throws WrongItemException {
        if (this.equippedArmorLegs != null)
            this.equippedArmorLegs.unequip();
        if (equippedArmorLegs.getType() == CeItemTypes.armorLegs) {
            this.equippedArmorLegs = equippedArmorLegs;
            this.equippedArmorLegs.equip();
        } else throw new WrongItemException(equippedArmorLegs, "Armor type ArmorLegs");
    }

    public void setEquippedArmorChest(CeItem equippedArmorChest) throws WrongItemException {
        if (this.equippedArmorChest != null)
            this.equippedArmorChest.unequip();
        if (equippedArmorChest.getType() == CeItemTypes.armorChest) {
            this.equippedArmorChest = equippedArmorChest;
            this.equippedArmorChest.equip();
        } else throw new WrongItemException(equippedArmorChest, "Armor type ArmorChest");
    }

    public void setEquippedArmorHead(CeItem equippedArmorHead) throws WrongItemException {
        if (this.equippedArmorHead != null)
            this.equippedArmorHead.unequip();
        if (equippedArmorHead.getType() == CeItemTypes.armorHead) {
            this.equippedArmorHead = equippedArmorHead;
            this.equippedArmorHead.equip();
        } else throw new WrongItemException(equippedArmorHead, "Armor type armorHead");
    }

    public void setEquippedWeapon(CeItem equippedWeapon) throws WrongItemException {
        if (this.equippedWeapon != null)
            this.equippedWeapon.unequip();
        if (equippedWeapon.getType() == CeItemTypes.weapon) {
            this.equippedWeapon = equippedWeapon;
            this.equippedWeapon.equip();
        } else throw new WrongItemException(equippedWeapon, "Armor type weapon");
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

    public CeSlot[] getSlots() {
        return slots;
    }

    public int getMaxItemSlots() {
        return maxItemSlots;
    }
}
