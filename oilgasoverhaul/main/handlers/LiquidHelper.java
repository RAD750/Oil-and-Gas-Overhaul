package oilgasoverhaul.main.handlers;

import java.util.ArrayList;
import java.util.List;

import buildcraft.api.core.Position;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import net.minecraftforge.oredict.OreDictionary;
import oilgasoverhaul.main.CreativeTab;
import oilgasoverhaul.main.Main;
import oilgasoverhaul.main.items.ItemCell;

public class LiquidHelper {
	public static List<LiquidStack> liquids = new ArrayList<LiquidStack>();
	public static List<Item> items = new ArrayList<Item>();

	/**
	 * Adds a Liquid or Gas to the mod, with tooltip (thanks to Alex & Lorenzo)
	 * @param name The name of the liquid
	 * @param id The ID of the Liquid
	 * @param index The index of the Texture
	 * @param cellID The cell ID
	 * @param cellIndex The texture of the cell ID 
	 * @param toolTip The Tooltip given
	 */

	public static void addLiquid(String name, int id, int index, int cellID, int cellIndex, String type, String composition, String phase) {
		
		List toolTip = new ArrayList<String>();
		
		if (type != null) {
			toolTip.add("\247bType: \247e" + type);
		}
		if (composition != null) {
			toolTip.add("\247bComposition: \247e" + composition);
		}
		if (phase != null) {
			toolTip.add("\2477\247o" + phase);
		}
		
		
		
		Item itemCell = new ItemCell(cellID, toolTip);
		itemCell.setItemName(name.toLowerCase() + "Cell");
		itemCell.setIconIndex(cellIndex);
		itemCell.setTextureFile("/oilgasoverhaul/textures/cells.png");
		itemCell.setCreativeTab(CreativeTab.tabOGOMain);
		items.add(itemCell);
		OreDictionary.registerOre(name + " Cell", itemCell);

		GameRegistry.registerItem(itemCell, name.toLowerCase() + "Cell");
		LanguageRegistry.addName(itemCell, name + " Cell");

		Item liquidItem = new Item(id-256);
		liquidItem.setIconIndex(index);
		liquidItem.setTextureFile("/oilgasoverhaul/textures/liquids.png");
		liquidItem.setItemName("liquid" + name);
		
		
		ItemStack liquidItemStack = new ItemStack(liquidItem, 1);

		LiquidStack liquidStack = new LiquidStack(liquidItem, LiquidContainerRegistry.BUCKET_VOLUME);

		liquidStack = LiquidDictionary.getOrCreateLiquid(name, liquidStack);		
		LanguageRegistry.addName(liquidItem, name);

		liquids.add(liquidStack);	

		LiquidContainerData liquidData = new LiquidContainerData(liquidStack,
				new ItemStack(itemCell, 1), ic2.api.Items.getItem("cell"));
		LiquidContainerRegistry.registerLiquid(liquidData);
		Main.oilgasLog.info("Added Liquid: " + name);
		
	}
	
    public static int outputLiquidOnSide(LiquidTank tank, World world, Position position) {
        TileEntity tileEntity = world.getBlockTileEntity((int) position.x, (int) position.y, (int) position.z);
        if (tileEntity != null && tileEntity instanceof ITankContainer && tank.getLiquid().amount > 0) {
            int amount = ((ITankContainer) tileEntity).fill(position.orientation, tank.getLiquid(), true);
            tank.drain(amount, true);
            return amount;
        }
        return 0;
    }
}
