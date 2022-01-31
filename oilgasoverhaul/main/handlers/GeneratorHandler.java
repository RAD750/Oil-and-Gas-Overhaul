package oilgasoverhaul.main.handlers;

import net.minecraft.item.ItemStack;

public class GeneratorHandler {
	public static void addGeneratorFuels() {
		ItemStack cell = ic2.api.Items.getItem("cell").copy();
		ItemStack lpg = CraftingHelpers.getOreDict("LPG Cell").copy();
		ItemStack gasoline = CraftingHelpers.getOreDict("Gasoline Cell").copy();
		ItemStack naphtha = CraftingHelpers.getOreDict("Naphtha Cell").copy();
		ItemStack hfo = CraftingHelpers.getOreDict("Heavy Fuel Oil Cell").copy();
		ItemStack paraffin = CraftingHelpers.getOreDict("Paraffin Cell").copy();
		ItemStack mineralOil = CraftingHelpers.getOreDict("Mineral Oil Cell").copy();

		//Gas Turbine
		GregtechCompat.addFuel(lpg, cell, 52, 1);
		GregtechCompat.addFuel(gasoline, cell, 68, 1);
		GregtechCompat.addFuel(naphtha, cell, 76, 1);
		
		//Semifluid
		GregtechCompat.addFuel(hfo, cell, 82, 3);
		GregtechCompat.addFuel(paraffin, cell, 84, 3);
		GregtechCompat.addFuel(mineralOil, cell, 83, 3);
	}
}
