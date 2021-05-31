package calculationengine.environment;

import calculationengine.battle.WrongItemException;
import calculationengine.entities.CeAttack;
import calculationengine.entities.CeAttacks;
import calculationengine.entities.CeBeastTypes;
import calculationengine.entities.CeBeasts;
import calculationengine.entities.CeEntity;
import calculationengine.entities.CeInventory;
import calculationengine.entities.CeNature;
import calculationengine.entities.CePlayer;
import calculationengine.entities.CeStats;
import calculationengine.entities.ItemNotInInventoryException;
import calculationengine.entities.NoPlaceInInventoryException;

import java.util.ArrayList;
import java.util.List;

public class TestItems {
    public static void main(String[] args) throws NoPlaceInInventoryException {
        System.out.println(CeLootUtils.lootItem("cage").toString());
        CeInventory inventory = new CeInventory(new CeStats(CeBeasts.StinkenderFeuerFurz));
        inventory.addItemToInventory(CeLootUtils.lootItem("cage"));
        System.out.println("Amount: " + inventory.getSlots()[0].getAmount()); // should be 1
        inventory.addItemToInventory(CeLootUtils.lootItem("cage"));
        System.out.println("Amount: " + inventory.getSlots()[0].getAmount()); // should be 2
        inventory.addItemToInventory(CeLootUtils.lootItem("aHealingPotion"));
        System.out.println(inventory.getSlots()[1].getItem().toString());

        List<CeEntity> team = new ArrayList<>();
        List<CeAttack> attacks = new ArrayList<>();
        attacks.add(new CeAttack(CeAttacks.Punch));
        CePlayer cePlayer1 = new CePlayer(new CeStats(CeBeastTypes.PlayerStandard, CeNature.ANGRY, 1, 100, 100, 50, 200, 200, 200, 1), attacks, team, false);

        System.out.println(cePlayer1.getCeStats().getCurrentHitPoints());
        System.out.println(cePlayer1.getCeStats().toString());
        cePlayer1.getInventory().addItemToInventory(CeLootUtils.lootItem("aGreaterHealingPotion"));
        try {
            cePlayer1.getInventory().useItem(CeLootUtils.lootItem("aGreaterHealingPotion"));
            System.out.println(cePlayer1.getCeStats().getCurrentHitPoints());
        } catch (ItemNotInInventoryException itemNotInInventoryException) {
            itemNotInInventoryException.printStackTrace();
        }
        cePlayer1.getInventory().addItemToInventory(CeLootUtils.lootItem("stickOfBeating"));
        try {
            cePlayer1.getInventory().setEquippedItem(CeLootUtils.lootItem("stickOfBeating"));
        } catch (WrongItemException wrongItemException) {
            wrongItemException.printStackTrace();
        }
        System.out.println(cePlayer1.getCeStats().toString());
    }
}
