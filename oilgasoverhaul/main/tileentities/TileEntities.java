package oilgasoverhaul.main.tileentities;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntities {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityWellhead.class, "ogoTileEntityWellhead");
		GameRegistry.registerTileEntity(TileEntityBarrel55gal.class, "TileEntityBarrel55gal");
	}
}
