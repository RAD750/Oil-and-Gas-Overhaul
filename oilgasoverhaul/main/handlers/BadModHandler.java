package oilgasoverhaul.main.handlers;

import net.minecraft.item.Item;

public class BadModHandler {
	public static Item universalItemGetter(int id) {
		return Item.itemsList[id];
	}
	
	public static Item universalItemGetter(String itemName) {
		for (int i = 0; i < Item.itemsList.length; i++) {
			if(Item.itemsList[i] != null && Item.itemsList[i].getItemName() != null && Item.itemsList[i].getItemName().equals(itemName)) {
				return Item.itemsList[i];
			}
		}
		return null;
	}
}
