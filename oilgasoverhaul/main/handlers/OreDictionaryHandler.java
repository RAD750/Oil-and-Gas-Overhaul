package oilgasoverhaul.main.handlers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import oilgasoverhaul.main.CreativeTab;
import oilgasoverhaul.main.blocks.Blocks;
import oilgasoverhaul.main.items.Items;

/* 
 * Registra tutti gli oggetti come OreDictionary
 */

public class OreDictionaryHandler {
	public static void initOreDictionary() {
		OreDictionary.registerOre("blockAsphalt", Blocks.asphalt);
		OreDictionary.registerOre("dustAlCl3", Items.AlCl3);
		OreDictionary.registerOre("dustWoodChips", Items.woodChips);
		OreDictionary.registerOre("dustWoodPellets", Items.woodPellets);
		OreDictionary.registerOre("dustParaffinedWood", Items.paraffinedWood);
	}
}
