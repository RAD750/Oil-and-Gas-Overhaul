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
import railcraft.common.api.crafting.IRollingMachineCraftingManager;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

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
		
		ItemStack condensate = CraftingHelpers.getOreDict("Condensate Cell").copy();
		ItemStack gasoline3x = gasoline.copy();
		gasoline.stackSize = 2;
		gasoline3x.stackSize = 3;
		GregtechCompat.addChemicalRecipe(gasoline, condensate, gasoline3x, 0);
		
		//Valvola - machine.beta.tank.iron.valve
		ItemStack valve = railcraft.common.api.core.items.ItemRegistry.getItem("machine.beta.tank.iron.valve", 1);
		
		//Tank - machine.beta.tank.iron.wall
		ItemStack tank = railcraft.common.api.core.items.ItemRegistry.getItem("machine.beta.tank.iron.wall", 1);
		
		//Turbocompressor - part.turbocompressor
		ItemStack turbopump = railcraft.common.api.core.items.ItemRegistry.getItem("part.turbocompressor", 1);
		
		//diesel pump - part.dieselPump
		ItemStack dieselpump = railcraft.common.api.core.items.ItemRegistry.getItem("part.dieselpump", 1);
				
		//mining pipe
		ItemStack pipe = ic2.api.Items.getItem("miningPipe");
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.wellHead, 1), new Object[] {
				"PVG", "VTV", "DVD", 'P', pipe, 'V', valve, 'G', turbopump, 'T', tank, 'D', dieselpump
		});	
		

		
		//barile
		
		ItemStack barrel55gal = new ItemStack(Blocks.barrel55gal);
		barrel55gal.stackSize = 4;
		GregtechCompat.addBenderRecipe(tank, barrel55gal, 100, 60);
		
		
		naphtha.stackSize = 1;
		ItemStack hydroCell = ic2.api.Items.getItem("electrolyzedWaterCell").copy();
		ItemStack ethylene = CraftingHelpers.getOreDict("Ethylene Cell").copy();
		GregtechCompat.addChemicalRecipe(naphtha, hydroCell, ethylene, 300);
	
		condensate.stackSize = 2;
		GregtechCompat.addChemicalRecipe(condensate, hydroCell, ethylene, 300);
		
		ItemStack h2so4Cell = GregtechCompat.getGregTechItem(2, 1, 40);
		ItemStack ethylSulfateCell = CraftingHelpers.getOreDict("Ethyl Sulfate Cell").copy();
		ItemStack ethanol = CraftingHelpers.getOreDict("Ethanol Cell").copy();
		GregtechCompat.addAlloySmelterRecipe(ethylene, h2so4Cell, ethylSulfateCell, 900, 350);
		GregtechCompat.addBlastRecipe(ethylSulfateCell, hydroCell, ethanol, h2so4Cell, 100, 1100, 1400);
		ItemStack E85Gasoline = CraftingHelpers.getOreDict("E85 Gasoline Cell").copy();
		gasoline.stackSize = 13;
		condensate.stackSize = 13;
		ethanol.stackSize = 51;
		E85Gasoline.stackSize = 64;
		GregtechCompat.addChemicalRecipe(gasoline, ethanol, E85Gasoline, 100);
		GregtechCompat.addChemicalRecipe(condensate, ethanol, E85Gasoline, 100);
		E85Gasoline.stackSize = 1;
		GregtechCompat.addCannerRecipe(E85Gasoline, emptyCanister, filledCanister, cell, 100, 2);

		
		
		ItemStack ingotIridium = CraftingHelpers.getOreDict("ingotIridium");
		ItemStack feedwaterPump = railcraft.common.api.core.items.ItemRegistry.getItem("part.feedwaterpump", 1);
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.frackingHead, 1), new Object[] {
				"FFF", "IVI", "FPF",
				'F', feedwaterPump,
				'I', ingotIridium,
				'V', valve,
				'P', pipe
		});
		
		
		ItemStack lng = CraftingHelpers.getOreDict("LNG Cell").copy();
		ItemStack ammonia = CraftingHelpers.getOreDict("Ammonia Cell").copy();
		ItemStack nitrogen = GregtechCompat.getGregTechItem(2, 1, 15).copy();
		ItemStack hydrogen = GregtechCompat.getGregTechItem(2, 1, 0).copy();
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.lngAbsorptionChiller, 1), new Object[] {
				"NVN", "VHV", "TWF", 'N', ammonia, 'V', valve, 'F', feedwaterPump, 'H', hydrogen, 'W', new ItemStack(Item.bucketWater), 'T', turbopump
		});
		
		
		hydrogen.stackSize = 3;
		
		GregtechCompat.addChemicalRecipe(nitrogen, hydrogen, ammonia, 60);

		ItemStack liquidFirebox = railcraft.common.api.core.items.ItemRegistry.getItem("machine.beta.boiler.firebox.liquid", 1);
		ItemStack lpBoiler = railcraft.common.api.core.items.ItemRegistry.getItem("machine.beta.boiler.tank.pressure.low", 1);
		
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.lngHeater, 1), new Object[] {
				" I ", "VBV", " F ", 'I', new ItemStack(Item.ingotIron), 'V', valve, 'F', liquidFirebox, 'B', lpBoiler
		});
				
		
		ItemStack h2po4 = CraftingHelpers.getOreDict("Phosphoric Acid Cell").copy();
		ItemStack phosphorus = GregtechCompat.getGregTechItem(1, 1, 45);
				
		h2so4Cell.stackSize = 5;
		h2po4.stackSize = 3;
		
		GregtechCompat.addChemicalRecipe(phosphorus, h2so4Cell , h2po4, 50);
		
		h2po4.stackSize = 1;
		ammonia.stackSize = 1;
		GregtechCompat.addChemicalRecipe(h2po4, ammonia , new ItemStack(Items.monammoniumPhosphate, 1), 50);
		
		ItemStack air = CraftingHelpers.getOreDict("molecule_2o");
		air.stackSize = 64;
		
		ItemStack oxygen = CraftingHelpers.getOreDict("cellOxygen");
		oxygen.stackSize = 15;
		
		ItemStack argon = CraftingHelpers.getOreDict("Argon Cell");
		argon.stackSize = 4;
		
		ItemStack co2 = CraftingHelpers.getOreDict("Carbon Dioxide Cell");
		co2.stackSize = 1;
		
		
		nitrogen.stackSize = 45;
		
		GregtechCompat.addDistillationRecipe(air, 0, nitrogen, oxygen, argon, co2, 0, 0);
		
		//Gestione svuotamento celle	
		cell.stackSize = 1;
		lpg.stackSize = 1;
		gasoline.stackSize = 1;
		naphtha.stackSize = 1;
		condensate.stackSize = 1;
		distillateReflux.stackSize = 1;
		distillateResidue.stackSize = 1;
		desaltedCrude.stackSize = 1;
		hfo.stackSize = 1;
		paraffin.stackSize = 1;
		asphalt.stackSize = 1;
		mineralOil.stackSize = 1;
		ethylene.stackSize = 1;
		ethylSulfateCell.stackSize = 1;
		ethanol.stackSize = 1;
		E85Gasoline.stackSize = 1;
		lng.stackSize = 1;
		ammonia.stackSize = 1;
		h2po4.stackSize = 1;
		argon.stackSize = 1;
		co2.stackSize = 1;
		
		ic2.api.Ic2Recipes.addExtractorRecipe(lpg, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(gasoline, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(naphtha, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(condensate, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(distillateReflux, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(distillateResidue, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(desaltedCrude, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(hfo, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(paraffin, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(asphalt, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(mineralOil, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(ethylene, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(ethylSulfateCell, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(E85Gasoline, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(ethanol, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(lng, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(ammonia, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(h2po4, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(argon, cell);
		ic2.api.Ic2Recipes.addExtractorRecipe(co2, cell);

	}
}
