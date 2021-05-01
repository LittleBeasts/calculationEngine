package calculationEngine.battle;

import calculationEngine.CeExecuterService;
import calculationEngine.entities.*;
import calculationEngine.environment.CeLoot;
import calculationEngine.environment.CeRegions;

import java.util.ArrayList;
import java.util.List;

public class testBattle {

    public static void main(String[] args) throws InterruptedException {
        simulateAiBattle();
        simulateCatch();
        CeExecuterService.shutdownExecutor();
    }

    private static void simulateCatch() throws Exception {

        List<CeEntity> team = new ArrayList<>();
        List<CeAttack> attacks = new ArrayList<>();
        attacks.add(new CeAttack(CeAttacks.Punch));
        CePlayer cePlayer1 = new CePlayer(new CeStats(CeBeastTypes.PlayerStandard, CeNature.ANGRY, 1, 100, 100, 50, 200, 200, 200, 1), attacks, team, false);

        team.add(new CeEntity(CeRegions.ArkhamCity, cePlayer1));
        cePlayer1.setTeam(team);
        cePlayer1.setActiveMonsterIndex(0);
        cePlayer1.getInventory().addItemToInventory(CeLoot.lootItem("cage"));
        CeAi cePlayer2 = new CeAi(cePlayer1, CeRegions.ArkhamCity);
        CeBattle battle = new CeBattle(cePlayer1, cePlayer2);
        System.out.println("[Test Battle]: Battle started");

        while (battle.isFightOngoing()) {
            if (battle.getTurn() != null) {
                if (battle.getTurn().getNumber() == cePlayer1.getNumber()) {
                    System.out.println("[Test Battle]: Turn of: Player 1");
                    boolean caught = battle.catchBeast();
                    if (caught) System.out.println("[Test Battle]: Beast caught! CONGRATS");
                    else System.out.println("[Test Battle]: Beast doesn't like you");
                }
            } else {
                System.out.println("[Test Battle]: End of fight");
            }
            Thread.sleep(10);
        }
        System.out.println("[Test Battle]: End of fight");
    }

    private static void simulateAiBattle() throws InterruptedException {

        List<CeEntity> team = new ArrayList<>();
        List<CeAttack> attacks = new ArrayList<>();
        attacks.add(new CeAttack(CeAttacks.Punch));
        CePlayer cePlayer1 = new CePlayer(new CeStats(CeBeastTypes.PlayerStandard, CeNature.ANGRY, 1, 100, 100, 50, 200, 200, 200, 1), attacks, team, false);
        team.add(new CeEntity(CeRegions.ArkhamCity, cePlayer1));
        cePlayer1.setTeam(team);
        cePlayer1.setActiveMonsterIndex(0);
        CeAi cePlayer2 = new CeAi(cePlayer1, CeRegions.ArkhamCity);
        CeBattle battle = new CeBattle(cePlayer1, cePlayer2);
        System.out.println("[Test Battle]: Battle started");

        int counter = 0;
        while (battle.isFightOngoing()) {
            if (counter >= 100) System.out.println("[Test Battle]: Test Battle still running");
            counter++;
            if (battle.getTurn() != null) {
                if (counter >= 100) System.out.println("[Test Battle]: get turn not null");
                if (counter >= 100)
                    System.out.println("[Test Battle]: battle.getTurn.getNumber: " + battle.getTurn().getNumber());
                if (battle.getTurn().getNumber() == cePlayer1.getNumber()) {
                    System.out.println("[Test Battle]: Turn of: Player 1");
                    battle.useAttack(new CeAttack(CeAttacks.Punch));
                }
            } else {
                System.out.println("[Test Battle]: End of fight");
            }
            Thread.sleep(10);
        }
        System.out.println("[Test Battle]: End of fight");
    }
}
