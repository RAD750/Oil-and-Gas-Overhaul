package oilgasoverhaul.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.BaseMod;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import oilgasoverhaul.main.blocks.Blocks;
import oilgasoverhaul.main.handlers.CraftingHandler;
import oilgasoverhaul.main.handlers.GeneratorHandler;
import oilgasoverhaul.main.handlers.MinablesHandler;
import oilgasoverhaul.main.handlers.OreDictionaryHandler;
import oilgasoverhaul.main.items.Items;
import oilgasoverhaul.main.proxies.CommonProxy;
import oilgasoverhaul.main.tileentities.TileEntities;

@Mod(name="Oil & Gas Overhaul", version="1.5", modid="oilgasoverhaul", dependencies="required-after:IC2; after:factorization; after:Railcraft; after:ThermalExpansion; after:ThermalExpansion|Transport; after:ThermalExpansion|Energy; after:ThermalExpansion|Factory; after:XyCraft; after:MetallurgyCore; after:MetallurgyBase; after:MetallurgyEnder; after:MetallurgyFantasy; after:MetallurgyNether; after:MetallurgyPrecious; after:MetallurgyUtility; after:BuildCraft|Silicon; after:BuildCraft|Core; after:BuildCraft|Transport; after:BuildCraft|Factory; after:BuildCraft|Energy; after:BuildCraft|Builders; after:enhancedgeology; after:railcraft;")
public class Main extends BaseMod{
	
	public static Logger oilgasLog = Logger.getLogger("oilgasoverhaul");
	
	@SidedProxy(clientSide="oilgasoverhaul.main.proxies.ClientProxy", serverSide="oilgasoverhaul.main.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@Override
	public String getVersion() {
		return "1.5";
	}

	@Override
	public void load() {
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
		oilgasLog.info("Lego11 si distanzia completamente dall'industria Oil & Gas e ricorda che l'elettrico, il rinnovabile ed il nucleare sono il futuro.");			
	}
	
	
	@Init
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		Items.initItems();
		Items.initLanguageRegistry();
		Blocks.initBlocks();
		Blocks.registerBlocks();
		Blocks.initLanguageRegistry();
		TileEntities.registerTileEntities();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		CraftingHandler.initCrafting();
		OreDictionaryHandler.initOreDictionary();
		GameRegistry.registerFuelHandler(new oilgasoverhaul.main.handlers.FuelHandler());
		GeneratorHandler.addGeneratorFuels();
		MinablesHandler.addMinables();
	    proxy.postInit(event);
	}
}
