package oilgasoverhaul.main.handlers;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import oilgasoverhaul.main.items.ItemFuel;
import oilgasoverhaul.main.items.Items;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item itemFuel = fuel.getItem();

		if (itemFuel == Items.woodChips) { return 250; }
		if (itemFuel == Items.woodPellets) { return 450; }
		if (itemFuel == Items.paraffinedWood) { return 7000; }
		return 0;

	}

}
