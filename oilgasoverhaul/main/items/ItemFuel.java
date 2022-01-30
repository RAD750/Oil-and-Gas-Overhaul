package oilgasoverhaul.main.items;

import java.util.List;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import oilgasoverhaul.main.CreativeTab;

public class ItemFuel extends Item {

	private String type;
	private String composition;
	private int heatValue;
	
	public ItemFuel(int id, int textureId, String itemName, int maxStackSize, int heatValue, String composition) {
		super(id-256);
		/**
		 * Registra un combustibile
		 * @param id ID dell'oggetto
		 * @param textureId ID della texture
		 * @param itemName nome oggetto
		 * @param maxStackSize Max stack size
		 * @return Item.
		 */
		this.setTextureFile("/oilgasoverhaul/textures/items.png");
		this.setIconIndex(textureId);
		this.setCreativeTab(CreativeTab.tabOGOMain);
		this.setItemName(itemName);
		this.setMaxStackSize(maxStackSize);
		this.composition = composition;
		this.heatValue = heatValue;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List toolTip, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, toolTip, par4);
		toolTip.add("\247bType: \247eFuel");
		if (composition != null) {
			toolTip.add("\247bComposition: \247e" + composition);
		}
		toolTip.add("\2477\247oSolid");
	}

}
