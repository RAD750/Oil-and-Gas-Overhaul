package oilgasoverhaul.main.handlers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.registry.GameRegistry;
import ljdp.minechem.api.core.Chemical;
import ljdp.minechem.api.core.Element;
import ljdp.minechem.api.core.EnumElement;
import ljdp.minechem.api.recipe.DecomposerRecipe;
import ljdp.minechem.api.recipe.SynthesisRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import oilgasoverhaul.main.Main;
import oilgasoverhaul.main.blocks.Blocks;
import oilgasoverhaul.main.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingHandler {

	public static void initCrafting() {
		
		/*
		 * GREGTECH SINTASSI
		 * 
		 * getGregTechItem(TIPO, QTA, META)
		 * 
		 * TIPO: 0. Lingotti 1. Polveri 2. Celle
		 */
		
		// Desalificazione
		ItemStack desaltedCrude = CraftingHelpers.getOreDict("Desalted Crude Cell").copy();
		GregtechCompat.addChemicalRecipe(GregtechCompat.getGregTechItem(2, 1, 17), ic2.api.Items.getItem("waterCell"), desaltedCrude, 120);
		
		// Distillazione (prima parte)
		desaltedCrude.stackSize = 64;
		ItemStack distillateReflux = CraftingHelpers.getOreDict("Distillate Reflux Cell").copy();
		distillateReflux.stackSize = 9;
		ItemStack naphtha = CraftingHelpers.getOreDict("Naphtha Cell").copy();
		naphtha.stackSize = 8;
		ItemStack diesel = GregtechCompat.getGregTechItem(2, 14, 18);
		ItemStack distillateResidue = CraftingHelpers.getOreDict("Distillate Residue Cell").copy();
		distillateResidue.stackSize = 33;
		
		
		GregtechCompat.addDistillationRecipe(desaltedCrude, 0, distillateReflux, naphtha, diesel, distillateResidue, 2800, 192);
		
		
		//Distillazione (2a parte)
		
		ItemStack lpg = CraftingHelpers.getOreDict("LPG Cell").copy();
		lpg.stackSize = 3;
		ItemStack gasoline = CraftingHelpers.getOreDict("Gasoline Cell").copy();
		gasoline.stackSize = 6;
		
		GregtechCompat.addDistillationRecipe(distillateReflux, 0, lpg, gasoline, null, null, 1600, 96);
		
		//Distillazione (3a parte)
		
		ItemStack hfo = CraftingHelpers.getOreDict("Heavy Fuel Oil Cell").copy();
		hfo.stackSize = 17;
		ItemStack paraffin = CraftingHelpers.getOreDict("Paraffin Cell").copy();
		paraffin.stackSize = 5;
		ItemStack mineralOil = CraftingHelpers.getOreDict("Mineral Oil Cell").copy();
		mineralOil.stackSize = 3;
		ItemStack asphalt = CraftingHelpers.getOreDict("Asphalt Cell").copy();
		asphalt.stackSize = 8;
		
		GregtechCompat.addDistillationRecipe(distillateResidue, 0, hfo, paraffin, mineralOil, asphalt, 2500, 400);
		
		// Reforming
		
		// HFO + AlCl3 -> Diesel
		
		ItemStack AlCl3 = new ItemStack(Items.AlCl3);
		diesel.stackSize = 48;
		hfo.stackSize = 32;
		GregtechCompat.addChemicalRecipe(hfo, AlCl3, diesel, 1400);
		
		// Nafta + Pt -> Benzina
		naphtha.stackSize = 32;
		gasoline.stackSize = 32;
		ItemStack platinumDust = GregtechCompat.getGregTechItem(1, 1, 27);
		GregtechCompat.addChemicalRecipe(naphtha, platinumDust, gasoline, 900);
		
		// Benzina + Pt -> GPL
		lpg.stackSize = 32;
		GregtechCompat.addChemicalRecipe(gasoline, platinumDust, lpg, 900);
		
		
		// Wooden Pulp -> Pellet
		ItemStack woodPulp = GregtechCompat.getGregTechItem(1, 8, 15);
		ItemStack woodPellet = new ItemStack(Items.woodPellets);
		woodPellet.stackSize = 4;
		
		ic2.api.Ic2Recipes.addCompressorRecipe(woodPulp, woodPellet);
		
		//Planks -> Chips (e pulp)
		ItemStack planks = new ItemStack(Block.planks, 1, 0);
		ItemStack woodChips = new ItemStack(Items.woodChips);
		woodChips.stackSize = 4;
		woodPulp.stackSize = 1;
		GregtechCompat.addSawmillRecipe(planks, 0, woodChips, woodPulp, null);
		planks = new ItemStack(Block.planks, 1, 1);
		GregtechCompat.addSawmillRecipe(planks, 0, woodChips, woodPulp, null);
		planks = new ItemStack(Block.planks, 1, 2);
		GregtechCompat.addSawmillRecipe(planks, 0, woodChips, woodPulp, null);
		planks = new ItemStack(Block.planks, 1, 3);
		GregtechCompat.addSawmillRecipe(planks, 0, woodChips, woodPulp, null);
		
		//Chips -> Pulp
		woodChips.stackSize = 1;
		woodPulp.stackSize = 4;
		GregtechCompat.addSawmillRecipe(woodChips, 0, woodPulp, null, null);
		
		//Pulp -> Wood with Paraffin
		woodPulp.stackSize = 1;
		paraffin.stackSize = 1;
		ItemStack paraffinedWood = new ItemStack(Items.paraffinedWood);
		GregtechCompat.addAlloySmelterRecipe(woodPulp, paraffin, paraffinedWood, 120, 3);
		
		
		//Asphalt
		ItemStack asphaltBlock = new ItemStack(Blocks.asphalt).copy();
		ItemStack gravel = new ItemStack(Block.gravel).copy();
		asphaltBlock.stackSize = 32;
		asphalt.stackSize = 1;
		gravel.stackSize = 32;
		GregtechCompat.addAlloySmelterRecipe(gravel, asphalt, asphaltBlock, 500, 40);
	
		//AlCl3
		
		ItemStack aluminiumDust = GregtechCompat.getGregTechItem(1, 0, 18);
		ItemStack chlorine = GregtechCompat.getGregTechItem(2, 3, 13);
		ItemStack aluminiumChloride = new ItemStack(Items.AlCl3);
		GregtechCompat.addChemicalRecipe(aluminiumDust, chlorine, aluminiumChloride, 400);
		
		
		//Benzina in tanica
		ItemStack cell = ic2.api.Items.getItem("cell").copy();
		ItemStack filledCanister = ic2.api.Items.getItem("filledFuelCan");
		ItemStack emptyCanister = ic2.api.Items.getItem("fuelCan");
		gasoline.stackSize = 4;
		cell.stackSize = 4;
		
		GregtechCompat.addCannerRecipe(gasoline, emptyCanister, filledCanister, cell, 100, 2);
		
		//Miscela (solo con EnhGeology)
		
		ItemStack fuelMixture = CraftingHelpers.getOreDict("canisterFuelMixture");
		mineralOil.stackSize = 1;
		cell.stackSize = 1;
		
		if (fuelMixture != null) {
			GregtechCompat.addCannerRecipe(filledCanister, mineralOil, fuelMixture, cell, 100, 1);
		} else {
			Main.oilgasLog.warning("Cannot find Enhanced Geology, fuel mixture recipe disabled");
		}
	}
}
