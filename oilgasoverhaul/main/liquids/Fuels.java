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

		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("Gasoline", LiquidContainerRegistry.BUCKET_VOLUME), 25, 30000));
		IronEngineFuel.fuels.add(new IronEngineFuel(LiquidDictionary.getLiquid("Naphtha", LiquidContainerRegistry.BUCKET_VOLUME), 15, 50000));

	}
}
