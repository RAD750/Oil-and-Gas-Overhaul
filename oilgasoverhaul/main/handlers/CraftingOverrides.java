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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import oilgasoverhaul.main.Main;

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
	}
	
}
