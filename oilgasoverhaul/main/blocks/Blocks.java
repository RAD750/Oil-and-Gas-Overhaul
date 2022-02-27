package oilgasoverhaul.main.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
public class Blocks {

	public static Block asphalt;
	public static Block wellHead;
	
	public static void initBlocks() {
		asphalt = new GenericBlock(2100, 0, Material.rock, "asphaltBlock", 0.8f);
		wellHead = new BlockWellhead(2200, 1, Material.iron, "wellHead", 0.8f);
	}
	
	public static void registerBlocks() {
		GameRegistry.registerBlock(asphalt, "asphaltBlock");
		GameRegistry.registerBlock(wellHead, "wellHead");
	}
	
	public static void initLanguageRegistry() {
		LanguageRegistry.addName(asphalt, "Asphalt Block");
		LanguageRegistry.addName(wellHead, "Well Head");
	}
}
