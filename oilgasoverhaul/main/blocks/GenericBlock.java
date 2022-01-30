package oilgasoverhaul.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import oilgasoverhaul.main.CreativeTab;

public class GenericBlock extends Block {

	public GenericBlock(int id, int textureID, Material material, String blockName, float hardness) {
		super(id, textureID, material);
		super.setBlockName(blockName);
		super.setHardness(hardness);
		super.setTextureFile("/oilgasoverhaul/textures/blocks.png");
		super.setCreativeTab(CreativeTab.tabOGOMain);
	}

}
