package oilgasoverhaul.main.handlers;

import cpw.mods.fml.client.TextureFXManager;

public class TextureFXHelper {
	
	final static String textureFile = "/oilgasoverhaul/textures/liquids.png";
	
	/**
	 * Define a TextureFX for a given liquid texture ID
	 * @param redMin Minimum red value
	 * @param redMax Maximum red value
	 * @param greenMin Minimum green value
	 * @param greenMax Maximum green value
	 * @param blueMin Minimum blue value
	 * @param blueMax Maximum blue value
	 * @param textureId Texture ID of the liquid
	 */
	
	public static void defineTextureFX(int redMin, int redMax, int greenMin, int greenMax, int blueMin, int blueMax, int textureId) {
		TextureLiquidsFX DistillateResidueFX = new TextureLiquidsFX(redMin, redMax, greenMin, greenMax, blueMin, blueMax, textureId, textureFile);
		DistillateResidueFX.tileImage = 3595;
		TextureFXManager.instance().addAnimation(DistillateResidueFX);
	}
}
