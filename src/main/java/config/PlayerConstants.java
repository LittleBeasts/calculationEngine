package config;

import calculationengine.entities.CeAttack;
import calculationengine.entities.CeAttacks;

public class PlayerConstants {

    public static final String[] PLAYER_ACTIONS = new String[] {"Attack", "Catch", "Tame", "Pick Beast", "Item"};
    public static final CeAttack[] PLAYER_STANDARD_CE_ATTACKS = new CeAttack[]{new CeAttack(CeAttacks.Catch), new CeAttack(CeAttacks.Flee), new CeAttack(CeAttacks.Punch)};

 }
