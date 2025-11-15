package oilgasoverhaul.main.liquids;

import buildcraft.api.fuels.IronEngineFuel;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import railcraft.common.api.fuel.FuelManager;

public class Fuels {
	public static void initFuels() {
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("LPG", LiquidContainerRegistry.BUCKET_VOLUME), 134000);
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Naphtha", LiquidContainerRegistry.BUCKET_VOLUME), 160000);
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Heavy Fuel Oil", LiquidContainerRegistry.BUCKET_VOLUME), 216000);	
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Condensate", LiquidContainerRegistry.BUCKET_VOLUME), 35000);
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Ethanol", LiquidContainerRegistry.BUCKET_VOLUME), 105000);
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("E85 Gasoline", LiquidContainerRegistry.BUCKET_VOLUME), 132000);
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("LNG", LiquidContainerRegistry.BUCKET_VOLUME), 900000);
		FuelManager.addBoilerFuel(LiquidDictionary.getLiquid("Town Gas", LiquidContainerRegistry.BUCKET_VOLUME), 22000);
		
		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("Gasoline", LiquidContainerRegistry.BUCKET_VOLUME), 35, 30000));
		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("Naphtha", LiquidContainerRegistry.BUCKET_VOLUME), 20, 50000));
		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("E85 Gasoline", LiquidContainerRegistry.BUCKET_VOLUME), 30, 10000));
		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("E85 Gasoline", LiquidContainerRegistry.BUCKET_VOLUME), 35, 8000));
		}
}
