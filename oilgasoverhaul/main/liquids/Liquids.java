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
		LiquidHelper.addLiquid("Ethylene", 3812, 12, 21512, 12, "Alkene", "C₂H₄", "Gas");
		
		//Ethyl sulfate
		LiquidHelper.addLiquid("Ethyl Sulfate", 3813, 13, 21513, 13, "Ester", null, "Liquid");
		
		//Ethanol
		LiquidHelper.addLiquid("Ethanol", 3814, 14, 21514, 14, "Alcohol", null, "Liquid");
				
		//E85 Gas
		LiquidHelper.addLiquid("E85 Gasoline", 3815, 15, 21515, 15, "Mixture", "85% Ethanol, Gasoline", "Liquid");
		
		//LNG
		LiquidHelper.addLiquid("LNG", 3816, 16, 21516, 16, "Liquefied Gas", "CH₄", "Gas");
		
		//Ammoniaca
		LiquidHelper.addLiquid("Ammonia", 3817, 17, 21517, 17, "Ammonia", "NH₃", "Liquid Solution");
		
		//Gas di città
		LiquidHelper.addLiquid("Town Gas", 3818, 18, 21518, 18, "Mixture", "CO, H₂, CH₄", "Gas");
		
		//H2PO4 condivide texture con Ammoniaca
		LiquidHelper.addLiquid("Phosphoric Acid", 3819, 19, 21519, 19, "Acid", "H₂PO₄", "Liquid Solution");
		
		//CO2
		LiquidHelper.addLiquid("Carbon Dioxide", 3820, 20, 21520, 20, "Gas", "CO₂", "Gas");
		
		//Argon
		LiquidHelper.addLiquid("Argon", 3821, 21, 21521, 21, "Noble Gas", "Ar", "Gas");
		
		//SF6
		LiquidHelper.addLiquid("Sulfur Hexafluoride", 3822, 22, 21522, 22, "Gas", "SF₆", "Gas");
		
	    //Propylene
		LiquidHelper.addLiquid("Propylene", 3823, 23, 21523, 23, "Alkene", "CH₃CH=CH₂", "Gas");
		
		//Hydrogen peroxide
		LiquidHelper.addLiquid("Hydrogen Peroxide", 3824, 24, 21524, 24, "Peroxide", "H₂O₂", "Liquid");
		
		//HCl
		LiquidHelper.addLiquid("Hydrochloric Acid", 3825, 25, 21525, 25, "Acid", "HCl", "Liquid Solution");
		
		//HF
		LiquidHelper.addLiquid("Hydrofluoric Acid", 3826, 26, 21526, 26, "Acid", "HF", "Liquid Solution");
		
		//CHCl3
		LiquidHelper.addLiquid("Chloroform", 3827, 27, 21527, 27, "Acid", "CHCl₃", "Liquid");
		
		//Tetrafluoroethylene
		LiquidHelper.addLiquid("Tetrafluoroethylene", 3828, 28, 21528, 28, "Alkene", "C₂F₄", "Gas");
		
		//Benzene
		LiquidHelper.addLiquid("Benzene", 3829, 29, 21529, 29, "Aromatic hydrocarbon", "C₆H₆", "Liquid");
		
		//Toluene
		LiquidHelper.addLiquid("Toluene", 3830, 30, 21530, 30, "Aromatic hydrocarbon", "C₆H₅CH₃", "Liquid");
		
		//Xylene
		LiquidHelper.addLiquid("Xylene", 3831, 31, 21531, 31, "Aromatic hydrocarbon", "(CH₃)C₆H₄", "Liquid");
		
		//Pygas (reformate)
		LiquidHelper.addLiquid("Reformate", 3832, 32, 21532, 32, "Light hydrocarbons mixture", "Benzene, Toluene, Xylene", "Liquid");
		
		//Ethylbenzene
		LiquidHelper.addLiquid("Ethylbenzene", 3833, 33, 21533, 33, "Aromatic hydrocarbon", "C₈H₁₀", "Liquid");
		
		//Styrene
		LiquidHelper.addLiquid("Styrene", 3834, 34, 21534, 34, "Aromatic hydrocarbon", "C₈H₈", "Liquid");
		
		//Terephtalic acid
		LiquidHelper.addLiquid("Terephthalic Acid", 3825, 35, 21535, 35, "Acid", "C₈H₆O₄", "Liquid Solution");
		
		//Ethylene glycol
		LiquidHelper.addLiquid("Ethylene Glycol", 3826, 36, 21536, 36, "Glycol (diol)", "C₂H₆O₂", "Liquid");
		
		//Ethylene oxide
		LiquidHelper.addLiquid("Ethylene Oxide", 3827, 37, 21537, 37, "Cyclic ether (epoxide)", "C₂H₄O", "Liquid");
	}
}
