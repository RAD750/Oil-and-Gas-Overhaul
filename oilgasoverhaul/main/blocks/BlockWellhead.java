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
import oilgasoverhaul.main.tileentities.TileEntityWellhead;

public class BlockWellhead extends BlockContainer {

	ForgeDirection dir;
	String blockName;
	float hardness;
	
	protected BlockWellhead(int par1, int par2, Material par3Material, String blockName, float hardness) {
		super(par1, par2, par3Material);
		this.setTextureFile("/oilgasoverhaul/textures/blocks.png");
		this.setBlockName(blockName);
		this.setHardness(hardness);
		this.setCreativeTab(CreativeTab.tabOGOMain);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity) {
//		super.onBlockPlacedBy(world, x, y, z, entity);
//		if ((entity instanceof EntityPlayer)) {
//			int yaw = (int) entity.rotationYaw;
//
//			if (yaw < 0)
//				yaw += 360;
//			yaw += 22;
//			yaw %= 360;
//			int facing = yaw / 45;
//			
//			world.setBlockMetadataWithNotify(x, y, z, facing / 2);
//			if(facing/2 == 0) {
//				dir = ForgeDirection.NORTH;
//			} else if(facing/2 == 1) {
//				dir = ForgeDirection.EAST;
//			} else if(facing/2 == 2) {
//				dir = ForgeDirection.SOUTH;
//			} else if(facing/2 ==  3) {
//				dir = ForgeDirection.WEST;
//			} else {
//				dir = ForgeDirection.EAST;
//			}
//			
//		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityWellhead();
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