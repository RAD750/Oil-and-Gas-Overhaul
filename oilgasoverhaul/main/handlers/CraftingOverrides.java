package oilgasoverhaul.main.handlers;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import oilgasoverhaul.main.Main;
import oilgasoverhaul.main.items.Items;

public class CraftingOverrides {

	public static Logger oilgasLog = Logger.getLogger("oilgasoverhaul");


	//crediti a Gregorius!!
	public static boolean removeRecipe(ItemStack aOutput) {
		if (aOutput == null) return false;
		boolean rReturn = false;
		ItemStack tStack;
		ArrayList<IRecipe> tList = (ArrayList<IRecipe>)CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < tList.size(); i++) {
			if ((tStack = tList.get(i).getRecipeOutput()) != null) {
				if (tStack.isItemEqual(aOutput)) {
					oilgasLog.info("Rimossa ricetta: " + tList.get(i).getRecipeOutput());
					tList.remove(i--);
					rReturn = true;
				}
			}
		}
		return rReturn;
	}

	public static boolean removeExtractorRecipe(ItemStack output) {
		if (output == null) return false;
		boolean result = false;
		List recipeList = ic2.api.Ic2Recipes.getExtractorRecipes();
		for (int i = 0; i < recipeList.size(); i++) {
			Entry<ItemStack, ItemStack> recipe = (Entry<ItemStack, ItemStack>) recipeList.get(i);
			if (recipe.getValue() != null) {
				if (recipe.getValue().isItemEqual(output)) {
					recipeList.remove(i--);
					oilgasLog.info("Rimossa ricetta Extractor: " + recipe.getKey());
					result = true;
				}
			}
		}
		return result;
	}

	public static boolean removeMaceratorRecipe(ItemStack output) {
		if (output == null) return false;
		boolean result = false;
		List recipeList = ic2.api.Ic2Recipes.getMaceratorRecipes();
		for (int i = 0; i < recipeList.size(); i++) {
			Entry<ItemStack, ItemStack> recipe = (Entry<ItemStack, ItemStack>) recipeList.get(i);
			if (recipe.getValue() != null) {
				if (recipe.getValue().isItemEqual(output)) {
					recipeList.remove(i--);
					oilgasLog.info("Rimossa ricetta Macerator: " + recipe.getKey());
					result = true;
				}
			}
		}
		return result;
	}

	public static boolean removeCompressorRecipe(ItemStack output) {
		if (output == null) return false;
		boolean result = false;
		List recipeList = ic2.api.Ic2Recipes.getCompressorRecipes();
		for (int i = 0; i < recipeList.size(); i++) {
			Entry<ItemStack, ItemStack> recipe = (Entry<ItemStack, ItemStack>) recipeList.get(i);
			if (recipe.getValue() != null) {
				if (recipe.getValue().isItemEqual(output)) {
					recipeList.remove(i--);
					oilgasLog.info("Rimossa ricetta Macerator: " + recipe.getKey());
					result = true;
				}
			}
		}
		return result;
	}


	public static void removeSmeltingMetaRecipe(ItemStack output) {
		try {
			FurnaceRecipes recipes = FurnaceRecipes.smelting();        

			Field field = FurnaceRecipes.class.getDeclaredField("metaSmeltingList");
			field.setAccessible(true);


			Map<List<Integer>, ItemStack> smeltingList = FurnaceRecipes.smelting().getMetaSmeltingList();

			for (Iterator<Map.Entry<List<Integer>, ItemStack>> it = smeltingList.entrySet().iterator(); it.hasNext();) {
				Map.Entry<List<Integer>, ItemStack> entry = it.next();
				ItemStack itemStack = entry.getValue();
				if (itemStack.isItemEqual(output)) {
					oilgasLog.info("Rimossa metaricetta fornace: " + entry.getValue());
					it.remove();
				}
			}

			field.set(recipes, smeltingList);    



		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeSmeltingRecipe(ItemStack output) {
		try {
			FurnaceRecipes recipes = FurnaceRecipes.smelting();        

			Field field = FurnaceRecipes.class.getDeclaredField("smeltingList");
			field.setAccessible(true);


			Map smeltingList = FurnaceRecipes.smelting().getMetaSmeltingList();

			for (Iterator<Map.Entry<Integer, ItemStack>> it = smeltingList.entrySet().iterator(); it.hasNext();) {
				Map.Entry<Integer, ItemStack> entry = it.next();
				ItemStack itemStack = entry.getValue();
				if (itemStack.isItemEqual(output)) {
					oilgasLog.info("Rimossa ricetta fornace: " + entry.getValue());
					it.remove();
				}
			}

			field.set(recipes, smeltingList);    



		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeSmeltingRecipe(String oreDictName) {

		ArrayList<ItemStack> ores;
		ores = OreDictionary.getOres(oreDictName);
		if ( ores.size() > 0 ) {
			for (int i = 0; i < ores.size(); i++) {
				removeSmeltingRecipe(ores.get(i));
			}
		} else {
			Main.oilgasLog.warning("Missing OreDict Item!! " + oreDictName);
		}
	}

	public static void removeSmeltingMetaRecipe(String oreDictName) {

		ArrayList<ItemStack> ores;
		ores = OreDictionary.getOres(oreDictName);
		if ( ores.size() > 0 ) {
			for (int i = 0; i < ores.size(); i++) {
				removeSmeltingMetaRecipe(ores.get(i));
			}
		} else {
			Main.oilgasLog.warning("Missing OreDict Item!! " + oreDictName);
		}
	}



	public static void initOverrides() {
		Main.oilgasLog.info("Lo spirito di Gregorius è forte, avvia la rimozione degli exploit");
		GameRegistry.addSmelting(Item.ingotIron.itemID, new ItemStack(Item.ingotIron), 0);
		//levare i crafting per qualunque tipo di gomma
		ItemStack rubber = ic2.api.Items.getItem("rubber").copy();
		rubber.stackSize = 1;
		removeSmeltingMetaRecipe(rubber);
		removeSmeltingMetaRecipe("itemRubber");
		removeExtractorRecipe(rubber);
		removeRecipe(ic2.api.Items.getItem("cell"));
		//levare smelting per MineFactory
		Item rawPlastic = BadModHandler.universalItemGetter("item.rawPlasticItem");
		if (rawPlastic != null) {
			Main.oilgasLog.info("Plastica MFR trovata, avvia la sterminazione profonda degli exploit");
			removeSmeltingMetaRecipe(new ItemStack(rawPlastic));		
		} else {
			Main.oilgasLog.warning("Minefactory non trovata, quindi non è stata rimossa la ricetta della plastica");
		}

		Main.oilgasLog.info("Incomincia la complicazione della Buildcraft");
		//Modifica BC: rimozione crafting di tutti i tubi

		Item stonePipe = BadModHandler.universalItemGetter("item.PipeItemsStone");
		if (stonePipe != null) {
			removeRecipe(new ItemStack(stonePipe));
			GameRegistry.addRecipe(new ItemStack(stonePipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Block.stone});
		}
		Item woodenPipe = BadModHandler.universalItemGetter("item.PipeItemsWood");
		if (woodenPipe != null) {
			removeRecipe(new ItemStack(woodenPipe));
			GameRegistry.addRecipe(new ItemStack(woodenPipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Block.planks});
		}
		Item cobblestonePipe = BadModHandler.universalItemGetter("item.PipeItemsCobblestone");
		if (cobblestonePipe != null) {
			removeRecipe(new ItemStack(cobblestonePipe));
			GameRegistry.addRecipe(new ItemStack(cobblestonePipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Block.cobblestone});
		}
		Item ironPipe = BadModHandler.universalItemGetter("item.PipeItemsIron");
		if (ironPipe != null) {
			removeRecipe(new ItemStack(ironPipe));
			GameRegistry.addRecipe(new ItemStack(ironPipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Item.ingotIron});
		}
		Item goldPipe = BadModHandler.universalItemGetter("item.PipeItemsGold");
		if (goldPipe != null) {
			removeRecipe(new ItemStack(goldPipe));
			GameRegistry.addRecipe(new ItemStack(goldPipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Item.ingotGold});
		}
		Item diamondPipe = BadModHandler.universalItemGetter("item.PipeItemsDiamond");
		if (diamondPipe != null) {
			removeRecipe(new ItemStack(diamondPipe));
			GameRegistry.addRecipe(new ItemStack(diamondPipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Item.diamond});
		}
		Item obsidianPipe = BadModHandler.universalItemGetter("item.PipeItemsObsidian");
		if (obsidianPipe != null) {
			removeRecipe(new ItemStack(obsidianPipe));
			GameRegistry.addRecipe(new ItemStack(obsidianPipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Block.obsidian});
		}
		Item sandstonePipe = BadModHandler.universalItemGetter("item.PipeItemsSandstone");
		if (sandstonePipe != null) {
			removeRecipe(new ItemStack(sandstonePipe));
			GameRegistry.addRecipe(new ItemStack(sandstonePipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Block.sandStone});
		}
		Item voidPipe = BadModHandler.universalItemGetter("item.PipeItemsVoid");
		if (voidPipe != null) {
			removeRecipe(new ItemStack(voidPipe));
			GameRegistry.addRecipe(new ItemStack(voidPipe, 8), new Object[] {"NGN", "G G", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet});
		}
		Item emeraldPipe = BadModHandler.universalItemGetter("item.emeraldPipe");
		if (emeraldPipe != null) {
			removeRecipe(new ItemStack(emeraldPipe));
			GameRegistry.addRecipe(new ItemStack(emeraldPipe, 8), new Object[] {"NGN", "GMG", "NGN", 'N', Items.pa6Fiber, 'G', Items.petSheet, 'M', Item.emerald});
		}
		Item pipeWaterproof = BadModHandler.universalItemGetter("item.pipeWaterproof");
		if (pipeWaterproof != null) {
			removeRecipe(new ItemStack(pipeWaterproof));
			GregtechCompat.addWiremillRecipe(CraftingHelpers.getOreDict("Tetrafluoroethylene Cell"), new ItemStack(pipeWaterproof), 50, 70);
		}
		
		//MERDA
		Main.oilgasLog.info("Lo spirito di Kiiw è fortissimo, incomincia la disinfestazione della MErda ricordando che i tuoi problemi di impotenza sono perchéééé non usi la Logistic®");
		//Modifica MErda: cambio glass fiber
		Item mim = BadModHandler.universalItemGetter("item.mim");
		if (mim != null) {
			removeRecipe(new ItemStack(mim, 1, 14));
			GameRegistry.addRecipe(new ItemStack(mim, 4, 14), new Object[] {"VVV", "QQQ", "VVV", 'V', Items.pvcSheet, 'Q', CraftingHelpers.getOreDict("dustQuartz")});
		}
		
		/*DEBUG
		
		for (int i = 1; i < Item.itemsList.length; i++) {
			if (Item.itemsList[i] != null) {
				Main.oilgasLog.warning("ITEM: " + i + " - " + Item.itemsList[i].getItemName());
			}
		}
		*/

	}

}
