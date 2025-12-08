package oilgasoverhaul.main.blocks;

import static net.minecraftforge.common.ForgeDirection.EAST;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ForgeDirection;
import oilgasoverhaul.main.CreativeTab;
import oilgasoverhaul.main.tileentities.TileEntityLNGAbsorptionChiller;

public class BlockLNGAbsorptionChiller extends BlockContainer {

	ForgeDirection dir;
	String blockName;
	float hardness;	
	
	protected BlockLNGAbsorptionChiller(int par1, int par2, Material par3Material, String blockName, float hardness) {
		super(par1, par2, par3Material);
		this.setTextureFile("/oilgasoverhaul/textures/blocks.png");
		this.setBlockName(blockName);
		this.setHardness(hardness);
		this.setCreativeTab(CreativeTab.tabOGOMain);
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityLNGAbsorptionChiller();
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
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isBlockSolidOnSide(par2, par3-1, par4, ForgeDirection.DOWN, true))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
    }
	
	@Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face)
    {
        return true;
    }
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
		
		return 200;
	}
	
	@Override
    public int getFireSpreadSpeed(World world, int x, int y, int z, int metadata, ForgeDirection face)
    {	

		return 200;
    }
	
	@Override
	
    public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            EntityTNTPrimed var5 = new EntityTNTPrimed(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F));
            var5.fuse = 0;
            par1World.spawnEntityInWorld(var5);
        }
    }
			
}