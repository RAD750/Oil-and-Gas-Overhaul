package oilgasoverhaul.main.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
public class Blocks {

	public static Block asphalt;
	
	public static void initBlocks() {
		asphalt = new GenericBlock(2100, 0, Material.rock, "asphaltBlock", 0.8f);
	}
	
	public static void registerBlocks() {
		GameRegistry.registerBlock(asphalt, "asphaltBlock");
	}
	
	public static void initLanguageRegistry() {
		LanguageRegistry.addName(asphalt, "Asphalt Block");

	}
}
