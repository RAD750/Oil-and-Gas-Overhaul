package oilgasoverhaul.main.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import oilgasoverhaul.main.CreativeTab;
import oilgasoverhaul.main.tileentities.TileEntityBarrel55gal;

public class BlockBarrel55gal extends BlockContainer {

	String blockName;
	float hardness;
	
	protected BlockBarrel55gal(int par1, int par2, Material par3Material, String blockName, float hardness) {
		super(par1, par2, par3Material);
		this.setTextureFile("/oilgasoverhaul/textures/blocks.png");
		this.setBlockName(blockName);
		this.setHardness(hardness);
		this.setCreativeTab(CreativeTab.tabOGOMain);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity) {
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityBarrel55gal();
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int idDropped(int par1, int par2) {
		return blockID;
	}

	public int quantityDropped() {
		return 1;
	}
	
}