package oilgasoverhaul.main.liquids;

import java.util.ArrayList;

import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import oilgasoverhaul.main.handlers.LiquidHelper;
import oilgasoverhaul.main.handlers.TextureFXHelper;
import railcraft.common.api.fuel.FuelManager;

public class Liquids {
	public static void initLiquids() {
		// Desalted Crude Oil
		LiquidHelper.addLiquid("Desalted Crude", 3800, 0, 21500, 0, "Crude", null, "Liquid");
		
		// Distillate Reflux
		LiquidHelper.addLiquid("Distillate Reflux", 3801, 1, 21501, 1, "Mixture", "Light Hydrocarbons", "Liquid");
		
		// Distillate Residue
		LiquidHelper.addLiquid("Distillate Residue", 3802, 2, 21502, 2, "Mixture", "Heavy Hydrocarbons", "Liquid");
		
		// LPG
		LiquidHelper.addLiquid("LPG", 3803, 3, 21503, 3, "Liquefied Gas", "C₃H₈, C₄H₁₀", "Gas");

		// Gasoline
		LiquidHelper.addLiquid("Gasoline", 3804, 4, 21504, 4, "Distillate", "C₄ - C₁₂", "Liquid");
		
		// Naphtha
		LiquidHelper.addLiquid("Naphtha", 3805, 5, 21505, 5, "Distillate", "C₁₂ - C₁₅", "Liquid");
		
		// HFO
		LiquidHelper.addLiquid("Heavy Fuel Oil", 3807, 7, 21507, 7, "Vacuum Distillate", "C₂₄ - C₄₀", "Liquid");
		
		// Paraffin
		LiquidHelper.addLiquid("Paraffin", 3808, 8, 21508, 8, "Vacuum Distillate", "More than C₄₀", "Solid");

		// Asphalt
		LiquidHelper.addLiquid("Asphalt", 3809, 9, 21509, 9, "Vacuum Distillate", "More than C₄₀", "Solid");
		
		// Lubricant	
		LiquidHelper.addLiquid("Mineral Oil", 3810, 10, 21510, 10, "Vacuum Distillate", null, "Liquid");
	}
}
