package oilgasoverhaul.main.proxies;

import java.util.ArrayList;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import oilgasoverhaul.main.handlers.LiquidHelper;
import oilgasoverhaul.main.liquids.Fuels;
import oilgasoverhaul.main.liquids.Liquids;
import railcraft.common.api.fuel.FuelManager;

public class CommonProxy {
	public CommonProxy() {
	}

	@Mod.PreInit
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Mod.Init
	public void init(FMLInitializationEvent event) {
		Liquids.initLiquids();
		Fuels.initFuels();
	}

	@Mod.PostInit
	public void postInit(FMLPostInitializationEvent event) {
	}
}