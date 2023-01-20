package oilgasoverhaul.main.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
public class Blocks {

	public static Block asphalt;
	public static Block wellHead;
	public static Block barrel55gal;
	public static Block frackingHead;
	
	public static void initBlocks() {
		asphalt = new GenericBlock(2100, 0, Material.rock, "asphaltBlock", 0.8f);
		wellHead = new BlockWellhead(2200, 1, Material.iron, "wellHead", 0.8f);
		barrel55gal = new BlockBarrel55gal(2201, 2, Material.iron, "barrel55gal", 0.8f);
		frackingHead = new BlockFrackingHead(2202, 3, Material.iron, "frackingHead", 2.0f);

	}
	
	public static void registerBlocks() {
		GameRegistry.registerBlock(asphalt, "asphaltBlock");
		GameRegistry.registerBlock(wellHead, "wellHead");
		GameRegistry.registerBlock(barrel55gal, "barrel55gal");
		GameRegistry.registerBlock(frackingHead, "frackingHead");

	}
	
	public static void initLanguageRegistry() {
		LanguageRegistry.addName(asphalt, "Asphalt Block");
		LanguageRegistry.addName(wellHead, "Well Head");
		LanguageRegistry.addName(barrel55gal, "55 Gallon Barrel");
		LanguageRegistry.addName(frackingHead, "Fracking Head");
	}
}
