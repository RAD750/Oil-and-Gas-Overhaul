package oilgasoverhaul.main.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import oilgasoverhaul.main.CreativeTab;

public class BlockOGOSlab extends BlockHalfSlab {
    public static final String[] type = new String[] {"asphalt"};

    public BlockOGOSlab(int par1, boolean par2)
    {
        super(par1, par2, Material.rock);
		super.setTextureFile("/oilgasoverhaul/textures/blocks.png");
        this.setCreativeTab(CreativeTab.tabOGOMain);
        this.setHardness(1.0f);
		this.setLightOpacity(0);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
    	if (par2 >= 8) {
    		return par2 - 8;
    	} 
    	return par2;
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int par1)
    {
        return this.getBlockTextureFromSideAndMetadata(par1, 0);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        //return Block.woodSingleSlab.blockID;
   		return Blocks.ogoSingleSlab.blockID;
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(Blocks.ogoSingleSlab.blockID, 2, par1 & type.length);
    }

    /**
     * Returns the slab block name with step type.
     */
    public String getFullSlabName(int par1)
    {
        if (par1 < 0 || par1 >= type.length)
        {
            par1 = 0;
        }

        return super.getBlockName() + "." + type[par1];
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        if (par1 != Blocks.ogoSlab.blockID)
        {
            for (int var4 = 0; var4 < type.length; ++var4)
            {
                par3List.add(new ItemStack(par1, 1, var4));
            }
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return super.blockID;
    }
}
