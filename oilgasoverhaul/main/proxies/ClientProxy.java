package oilgasoverhaul.main.proxies;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.client.MinecraftForgeClient;
import oilgasoverhaul.main.Main;
import oilgasoverhaul.main.handlers.TextureFXHelper;
import oilgasoverhaul.main.handlers.TextureLiquidsFX;

public class ClientProxy extends CommonProxy {
	public ClientProxy() {
		

		
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		
	}

	@Init
	public void init(FMLInitializationEvent event) {
		super.init(event);
		MinecraftForgeClient.preloadTexture("/oilgasoverhaul/textures/cells.png");
		MinecraftForgeClient.preloadTexture("/oilgasoverhaul/textures/liquids.png");

		/*
		 * Texture FX per i liquidi
		 */
		
		//Desalted crude (0)
		TextureFXHelper.defineTextureFX(30, 40, 50, 60, 120, 150, 0);
		//Distillate reflux (1)
		TextureFXHelper.defineTextureFX(130, 150, 160, 170, 195, 205, 1);
		//Distillate residue (2)
		TextureFXHelper.defineTextureFX(85, 95, 65, 75, 50, 60, 2);
		//LPG (3)
		TextureFXHelper.defineTextureFX(160, 170, 190, 200, 215, 225, 3);
		// Gasoline (4)
		TextureFXHelper.defineTextureFX(160, 170, 190, 195, 53, 60, 4);
		// Naphtha (5)
		TextureFXHelper.defineTextureFX(220, 230, 190, 200, 35, 45, 5);
		// HFO (7) 
		TextureFXHelper.defineTextureFX(25, 32, 30, 35, 65, 70, 7);
		// Paraffin (8)
		TextureFXHelper.defineTextureFX(160, 165, 160, 165, 160, 165, 8);
		// Asphalt (9)
		TextureFXHelper.defineTextureFX(70, 75, 70, 75, 70, 75, 9);
		// Min. oil (10)
		TextureFXHelper.defineTextureFX(90, 95, 40, 45, 115, 200, 10);
	}

	@Mod.PostInit
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
