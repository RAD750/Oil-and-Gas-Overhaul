package oilgasoverhaul.main.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import oilgasoverhaul.main.CreativeTab;

public class ItemGeneric extends Item {
	
	private String information;

	public ItemGeneric(int id, int textureId, String itemName, int maxStackSize, String information) {
		super(id-256);
		/**
		 * Registra un oggetto generico
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
		this.information = information;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List toolTip, boolean par4)
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, toolTip, par4);
		toolTip.add(information);
			
	}

}
