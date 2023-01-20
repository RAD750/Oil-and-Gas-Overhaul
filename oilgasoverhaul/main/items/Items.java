package oilgasoverhaul.main.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import oilgasoverhaul.main.CreativeTab;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	//ITEMS
	public static Item AlCl3, woodChips, woodPellets, paraffinedWood, hpPump;
	
	public static void initItems() {
		AlCl3 = new ItemCatalyst(22000, 0, "AlCl3", 64, "AlCl₃");
		woodChips = new ItemFuel(22010, 16, "woodChips", 64, 1700, null);
		woodPellets = new ItemFuel(22011, 17, "woodPellets", 64, 500, null);
		paraffinedWood = new ItemFuel(22012, 18, "paraffinedWood", 64, 12000, null);
	}

	public static void initLanguageRegistry() {
		LanguageRegistry.addName(AlCl3, "Aluminium Chloride (III)");
		LanguageRegistry.addName(woodChips, "Wood Chips");
		LanguageRegistry.addName(woodPellets, "Wood Pellets");
		LanguageRegistry.addName(paraffinedWood, "Paraffined Wood");
	}
}




