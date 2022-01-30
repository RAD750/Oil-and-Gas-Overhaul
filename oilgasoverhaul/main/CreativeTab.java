package oilgasoverhaul.main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import oilgasoverhaul.main.blocks.Blocks;
import oilgasoverhaul.main.items.Items;

public class CreativeTab extends CreativeTabs {

	private String name;
	public static CreativeTabs tabOGOMain = new CreativeTab(CreativeTabs.getNextID(), "Oil & Gas Overhaul");

	public CreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		this.name = par2Str;
	}
	
	@Override
	public String toString() {
		return super.getTabLabel();
	}
	
	@SideOnly(Side.CLIENT) 
	public ItemStack getIconItemStack() {
		if(this.name == tabOGOMain.getTabLabel()) {
			return new ItemStack(Blocks.asphalt);
		}
		return null;
	}
	
	
	@Override
	public String getTranslatedTabLabel() {
		return this.name;
	}

}
