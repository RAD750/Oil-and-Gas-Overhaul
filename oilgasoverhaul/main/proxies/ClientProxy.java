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
import net.minecraftforge.common.MinecraftForge;
import oilgasoverhaul.main.Main;
import oilgasoverhaul.main.handlers.SoundHandler;
import oilgasoverhaul.main.handlers.TextureFXHelper;
import oilgasoverhaul.main.handlers.TextureLiquidsFX;
import oilgasoverhaul.main.solid.rendertables.RenderTableBarrel55gal;
import oilgasoverhaul.main.solid.rendertables.RenderTableFrackingHead;
import oilgasoverhaul.main.solid.rendertables.RenderTableWellhead;
import oilgasoverhaul.main.tileentities.TileEntityBarrel55gal;
import oilgasoverhaul.main.tileentities.TileEntityFrackingHead;
import oilgasoverhaul.main.tileentities.TileEntityWellhead;

public class ClientProxy extends CommonProxy {
	public ClientProxy() {
		

		
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}

	@Init
	public void init(FMLInitializationEvent event) {
		super.init(event);
		MinecraftForgeClient.preloadTexture("/oilgasoverhaul/textures/cells.png");
		MinecraftForgeClient.preloadTexture("/oilgasoverhaul/textures/liquids.png");
		MinecraftForgeClient.preloadTexture("/oilgasoverhaul/textures/blocks.png");
		MinecraftForgeClient.preloadTexture("/oilgasoverhaul/textures/items.png");

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
		TextureFXHelper.defineTextureFX(158, 170, 190, 192, 53, 60, 4);
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
		// Condensate (11)
		TextureFXHelper.defineTextureFX(140, 145, 185, 190, 193, 198, 11);
	    //Ethylene (12)
		TextureFXHelper.defineTextureFX(226, 229, 207, 210, 230, 235, 12);
		//Ethyl sulfate (13)
		TextureFXHelper.defineTextureFX(239, 246, 210, 218, 165, 172, 13);
	    //Ethanol (14)
		TextureFXHelper.defineTextureFX(170, 175, 62, 70, 60, 65, 14);
		//E85 Gas (15)
		TextureFXHelper.defineTextureFX(165, 175, 195, 200, 57, 65, 15);
		
		/*
		 * Modeli 3D
		 */
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWellhead.class, new RenderTableWellhead());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel55gal.class, new RenderTableBarrel55gal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrackingHead.class, new RenderTableFrackingHead());


	}

	@Mod.PostInit
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}
