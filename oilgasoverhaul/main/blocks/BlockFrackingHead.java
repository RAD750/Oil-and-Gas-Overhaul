package oilgasoverhaul.main.blocks;

import static net.minecraftforge.common.ForgeDirection.EAST;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ForgeDirection;
import oilgasoverhaul.main.CreativeTab;
import oilgasoverhaul.main.tileentities.TileEntityFrackingHead;

public class BlockFrackingHead extends BlockContainer {

	ForgeDirection dir;
	String blockName;
	float hardness;
	private final static BiomeGenBase CORRECT_BIOME = BiomeGenBase.desertHills;
	
	
	protected BlockFrackingHead(int par1, int par2, Material par3Material, String blockName, float hardness) {
		super(par1, par2, par3Material);
		this.setTextureFile("/oilgasoverhaul/textures/blocks.png");
		this.setBlockName(blockName);
		this.setHardness(hardness);
		this.setCreativeTab(CreativeTab.tabOGOMain);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity) {
		if (!world.isRemote) {
			EntityPlayer player = (EntityPlayer)entity;
			if (!world.getBiomeGenForCoords(x, z).equals(CORRECT_BIOME)) {
				player.sendChatToPlayer("\2474\247lAvvertenza:\247r\247e il litotipo sottostante potrebbe essere inadatto");
			}
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityFrackingHead();
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
			
}