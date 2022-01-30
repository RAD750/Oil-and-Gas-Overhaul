package oilgasoverhaul.main.handlers;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import oilgasoverhaul.main.Main;

public class CraftingHelpers {
	public static void addShapelessRecipe(ItemStack result, Object... input) {
		GameRegistry.addShapelessRecipe(result, input);
	}

	public static void addShapedOreRecipe(ItemStack result, Object... input) {
		IRecipe recipe = new ShapedOreRecipe(result, input);
		addRecipe(recipe);
	}

	public static void addShapelessOreRecipe(ItemStack result, Object... input) {
		IRecipe recipe = new ShapelessOreRecipe(result, input);
		addRecipe(recipe);
	}

	public static void addRecipe(IRecipe recipe) {
		GameRegistry.addRecipe(recipe);
	}

	/**
	 * Get an Ore Dictionary Item
	 * @param oreDictName Ore Dictionary Item Name
	 * @return The requested ItemStack, or null if not found (Check log) 
	 */
	public static ItemStack getOreDict(String oreDictName) {
		ArrayList<ItemStack> ores;
		ores = OreDictionary.getOres(oreDictName);
		if ( ores.size() > 0 ) {
			ItemStack oreItemStack = ores.get(0);
			return oreItemStack;
		} else {
			Main.oilgasLog.warning("Missing OreDict Item!! " + oreDictName);
			return null;
		}
	}
}
