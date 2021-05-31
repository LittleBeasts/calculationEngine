package calculationengine.environment;

import org.json.JSONArray;
import org.json.JSONObject;
import static config.LootConstants.itemList;

public class CeLoot {

    public static CeItem lootItem(String itemKey) {
        JSONObject itemJson = new JSONObject(itemList.get(itemKey).toString());
        CeItem ceItem = new CeItem();
        ceItem.setNewLootedItem(itemJson);
        // Todo add to Inventory and skip return?
        return ceItem;
    }

    public static int[] jsonArrayToIntArray(JSONArray jsonArray) {
        int[] intArray = new int[7];
        for (int i = 0; i <= 6; i++) {
            intArray[i] = jsonArray.getInt(i);
        }
        return intArray;
    }

//    private static boolean sourceHasRarity(JSONObject drop) {
//        return !drop.get("rarity").toString().equals("");
//    }
//
//    private static boolean sourceHasItem(JSONObject drop) {
//        return !drop.get("item").toString().equals("");
//    }
//
//    private static JSONObject getDrop(String rarity) {
//        Random random = new Random();
//        //  System.out.println(jsonItemTable.get(rarity));
//        JSONObject itemTable = (JSONObject) jsonItemTable.get(rarity);
//        JSONArray items = itemTable.getJSONArray("items");
//        int roll = random.nextInt(101);
//        int cumulativeProbability = 0;
//        for (Object o : items) {
//            JSONObject oItem = (JSONObject) o;
//            int iProb = Integer.parseInt((String) oItem.get("probability"));
//            cumulativeProbability += iProb;
//            if (roll < cumulativeProbability) {
//                return oItem;
//            }
//        }
//        return null;
//    }
}
