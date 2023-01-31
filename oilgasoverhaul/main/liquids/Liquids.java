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
		
		//Condensate (Drip Gas)
		LiquidHelper.addLiquid("Condensate", 3811, 11, 21511, 11, "Mixture", "Light Hydrocarbons", "Liquid");
	
	    //Ethylene
		LiquidHelper.addLiquid("Ethylene", 3812, 12, 21512, 12, "Alkene", null, "Gas");
		
		//Ethyl sulfate
		LiquidHelper.addLiquid("Ethyl Sulfate", 3813, 13, 21513, 13, "Ester", null, "Liquid");
		
		//Ethanol
		LiquidHelper.addLiquid("Ethanol", 3814, 14, 21514, 14, "Alcohol", null, "Liquid");
				
		//E80 Gas
		LiquidHelper.addLiquid("E85 Gasoline", 3815, 15, 21515, 15, "Mixture", "85% Ethanol, Gasoline", "Liquid");
		
		//LNG
		LiquidHelper.addLiquid("LNG", 3816, 16, 21516, 16, "Liquefied Gas", "CH₄", "Gas");
		
		//Ammoniaca
		LiquidHelper.addLiquid("Ammonia", 3817, 17, 21517, 17, "Ammonia", "NH₃", "Liquid Solution");
	}
}
