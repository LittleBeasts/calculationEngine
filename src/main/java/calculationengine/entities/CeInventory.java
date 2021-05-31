package calculationengine.entities;

import calculationengine.battle.WrongItemException;
import calculationengine.environment.CeItem;
import calculationengine.environment.CeItemTypes;

import java.util.ArrayList;

import static calculationengine.environment.CeItemTypes.armorChest;
import static calculationengine.environment.CeItemTypes.armorHead;
import static calculationengine.environment.CeItemTypes.armorLegs;
import static calculationengine.environment.CeItemTypes.armorShoes;
import static calculationengine.environment.CeItemTypes.armorShoulder;
import static calculationengine.environment.CeItemTypes.cage;
import static calculationengine.environment.CeItemTypes.consumable;
import static calculationengine.environment.CeItemTypes.weapon;

public class CeInventory {

    private CeItem equippedArmorShoulder;
    private CeItem equippedArmorShoes;
    private CeItem equippedArmorLegs;
    private CeItem equippedArmorChest;
    private CeItem equippedArmorHead;
    private CeItem equippedWeapon;

    private CeStats playerStats;

    private int maxItemSlots = 10;
    private CeSlot[] slots = new CeSlot[maxItemSlots];

    public void loadSaveInventory(CeItem armorShoulder, CeItem armorShoes, CeItem armorLegs, CeItem armorChest, CeItem armorHead, CeItem weapon, CeSlot[] slots) {
        this.slots = slots;
        this.equippedArmorShoulder = armorShoulder;
        this.equippedArmorShoes = armorShoes;
        this.equippedArmorLegs = armorLegs;
        this.equippedArmorChest = armorChest;
        this.equippedArmorHead = armorHead;
        this.equippedWeapon = weapon;
    }

    public CeInventory(CeStats ceStats) {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new CeSlot();
        }
        this.playerStats = ceStats;
    }

    public void addItemToInventory(CeItem item) throws NoPlaceInInventoryException {
        if (item == null) {
            throw new IllegalArgumentException();
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
            if (slotItem != null && slotItem.compareTo(item)) {
                matchingItem = true;
                //TODO: Add switch case for item type and call correct Methods
                slotItem.use(this.playerStats);
                int remainingAmount = slot.decreaseAmount();
                if (remainingAmount <= 0) {
                    slot.reset();
                }
                break;
            }
        }
        if (!matchingItem) {
            throw new ItemNotInInventoryException(item);
        }
    }

    public ArrayList<CeItem> getCages() {
        return getCeItems(cage);
    }

    public ArrayList<CeItem> getConsumables() {
        return getCeItems(consumable);
    }

    private ArrayList<CeItem> getCeItems(CeItemTypes itemType) {
        ArrayList<CeItem> items = new ArrayList<>();
        for (CeSlot slot : slots) {
            CeItem slotItem = slot.getItem();
            if (slotItem != null && slotItem.getType() == itemType) {
                items.add(slotItem);
            }
        }
        return items;
    }

    public void setEquippedItem(CeItem equippedItem) throws WrongItemException {
        switch (equippedItem.getType()) {
            case armorShoulder:
                setEquippedArmorShoulder(equippedItem);
                break;
            case armorShoes:
                setEquippedArmorShoes(equippedItem);
                break;
            case armorLegs:
                setEquippedArmorLegs(equippedItem);
                break;
            case armorChest:
                setEquippedArmorChest(equippedItem);
                break;
            case armorHead:
                setEquippedArmorHead(equippedItem);
                break;
            case weapon:
                setEquippedWeapon(equippedItem);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + equippedItem.getType());
        }

    }

    private void setEquippedArmorShoulder(CeItem equippedArmorShoulder) throws WrongItemException {
        if (this.equippedArmorShoulder != null) {
            this.playerStats.removeBonusStats(this.equippedArmorShoulder.getItemBonusStats());
            this.equippedArmorShoulder.unequip();
            // TODO: set to null
        }
        if (equippedArmorShoulder.getType() == armorShoulder) {
            this.equippedArmorShoulder = equippedArmorShoulder;
            this.equippedArmorShoulder.equip();
            this.playerStats.applyBonusStats(equippedArmorShoulder.getItemBonusStats());
        } else throw new WrongItemException(equippedArmorShoulder, "Armor type shoulderArmor");
    }

    private void setEquippedArmorShoes(CeItem equippedArmorShoes) throws WrongItemException {
        if (this.equippedArmorShoes != null) {
            this.playerStats.removeBonusStats(this.equippedArmorShoes.getItemBonusStats());
            this.equippedArmorShoes.unequip();
        }
        if (equippedArmorShoes.getType() == armorShoes) {
            this.equippedArmorShoes = equippedArmorShoes;
            this.equippedArmorShoes.equip();
            this.playerStats.applyBonusStats(equippedArmorShoes.getItemBonusStats());
        } else throw new WrongItemException(equippedArmorShoes, "Armor type armorShoes");
    }

    private void setEquippedArmorLegs(CeItem equippedArmorLegs) throws WrongItemException {
        if (this.equippedArmorLegs != null) {
            this.playerStats.removeBonusStats(this.equippedArmorLegs.getItemBonusStats());
            this.equippedArmorLegs.unequip();
        }
        if (equippedArmorLegs.getType() == armorLegs) {
            this.equippedArmorLegs = equippedArmorLegs;
            this.equippedArmorLegs.equip();
            this.playerStats.applyBonusStats(equippedArmorLegs.getItemBonusStats());
        } else throw new WrongItemException(equippedArmorLegs, "Armor type ArmorLegs");
    }

    private void setEquippedArmorChest(CeItem equippedArmorChest) throws WrongItemException {
        if (this.equippedArmorChest != null) {
            this.playerStats.removeBonusStats(this.equippedArmorChest.getItemBonusStats());
            this.equippedArmorChest.unequip();
        }
        if (equippedArmorChest.getType() == armorChest) {
            this.equippedArmorChest = equippedArmorChest;
            this.equippedArmorChest.equip();
            this.playerStats.applyBonusStats(equippedArmorChest.getItemBonusStats());
        } else throw new WrongItemException(equippedArmorChest, "Armor type ArmorChest");
    }

    private void setEquippedArmorHead(CeItem equippedArmorHead) throws WrongItemException {
        if (this.equippedArmorHead != null) {
            this.playerStats.removeBonusStats(this.equippedArmorHead.getItemBonusStats());
            this.equippedArmorHead.unequip();
        }
        if (equippedArmorHead.getType() == armorHead) {
            this.equippedArmorHead = equippedArmorHead;
            this.equippedArmorHead.equip();
            this.playerStats.applyBonusStats(equippedArmorHead.getItemBonusStats());
        } else throw new WrongItemException(equippedArmorHead, "Armor type armorHead");
    }

    private void setEquippedWeapon(CeItem equippedWeapon) throws WrongItemException {
        if (this.equippedWeapon != null) {
            this.playerStats.removeBonusStats(this.equippedWeapon.getItemBonusStats());
            this.equippedWeapon.unequip();
        }
        if (equippedWeapon.getType() == weapon) {
            this.equippedWeapon = equippedWeapon;
            this.equippedWeapon.equip();
            this.playerStats.applyBonusStats(equippedWeapon.getItemBonusStats());
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

    public void setPlayerStats(CeStats playerStats) {
        this.playerStats = playerStats;
    }
}
