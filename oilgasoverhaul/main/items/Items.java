package oilgasoverhaul.main.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import oilgasoverhaul.main.CreativeTab;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	//ITEMS
	public static Item AlCl3, woodChips, woodPellets, paraffinedWood, hpPump, monammoniumPhosphate, EthylenePropyleneMix, AmmoniumSulfate, AmmoniumBisulfate, AmmoniumPersulfate, TitaniumIIIChloride, EmptyUncoatedCell, rawPolystyrene, polystyreneSheet, rawPET, petSheet;
	
	public static void initItems() {
		AlCl3 = new ItemCatalyst(22000, 0, "AlCl3", 64, "\247bFormula: \247eAlCl₃");
		woodChips = new ItemFuel(22010, 16, "woodChips", 64, 1700, null);
		woodPellets = new ItemFuel(22011, 17, "woodPellets", 64, 500, null);
		paraffinedWood = new ItemFuel(22012, 18, "paraffinedWood", 64, 12000, null);
		monammoniumPhosphate = new ItemGeneric(22013, 48, "monammoniumPhosphate", 64, "\247bFormula: \247e(NH₄)(H₂PO₄)");
		EthylenePropyleneMix = new ItemGeneric(22014, 49, "ethylenePropyleneMix", 64, "Gaseous Mixture");
		AmmoniumSulfate = new ItemGeneric(22015, 50, "ammoniumSulfate", 64, "\247bFormula: \247e(NH₄)₂SO₄");
		AmmoniumBisulfate = new ItemGeneric(22016, 50, "ammoniumBisulfate", 64, "\247bFormula: \247e(NH₄)HSO₄"); //stessa texture
		AmmoniumPersulfate = new ItemGeneric(22017, 51, "ammoniumPersulfate", 64, "\247bFormula: \247e(NH₄)₂S₂O₈");
		TitaniumIIIChloride = new ItemGeneric(22018, 52, "titaniumIIIChloride", 64,"\247bFormula: \247eTiCl₃");
		EmptyUncoatedCell = new ItemGeneric(22019, 33, "emptyUncoatedCell", 64, "\247bTo be coated with PTFE");
		rawPolystyrene = new ItemGeneric(22820, 69, "rawPolystyrene", 64, "Plastic resin");
		polystyreneSheet = new ItemGeneric(22821, 85, "polystyreneSheet", 64, "Formed plastic resin");
		rawPET = new ItemGeneric(22822, 68, "rawPET", 64, "Plastic resin");
		petSheet = new ItemGeneric(22823, 84, "petSheet", 64, "Plastic resin");
		
		OreDictionary.registerOre("monammoniumPhosphate", new ItemStack(Items.monammoniumPhosphate));
		OreDictionary.registerOre("polymer_ps_raw", new ItemStack(Items.rawPolystyrene));
		OreDictionary.registerOre("polymer_ps_sheet", new ItemStack(Items.polystyreneSheet));
		OreDictionary.registerOre("polymer_pet_raw", new ItemStack(Items.rawPET));
		OreDictionary.registerOre("polymer_pet_sheet", new ItemStack(Items.petSheet));

	}

	public static void initLanguageRegistry() {
		LanguageRegistry.addName(AlCl3, "Aluminium (III) Chloride");
		LanguageRegistry.addName(woodChips, "Wood Chips");
		LanguageRegistry.addName(woodPellets, "Wood Pellets");
		LanguageRegistry.addName(paraffinedWood, "Paraffined Wood");
		LanguageRegistry.addName(monammoniumPhosphate, "Monoammonium Phosphate");
		LanguageRegistry.addName(EthylenePropyleneMix, "Ethylene-Propylene Mix");
		LanguageRegistry.addName(AmmoniumSulfate, "Ammonium Sulfate");
		LanguageRegistry.addName(AmmoniumBisulfate, "Ammonium Bisulfate");
		LanguageRegistry.addName(AmmoniumPersulfate, "Ammonium Persulfate");
		LanguageRegistry.addName(TitaniumIIIChloride, "Titanium (III) Chloride");
		LanguageRegistry.addName(EmptyUncoatedCell, "Empty Uncoated Cell");
		LanguageRegistry.addName(rawPolystyrene, "Raw Polystyrene");
		LanguageRegistry.addName(polystyreneSheet, "Polystyrene Sheet");
		LanguageRegistry.addName(rawPET, "Raw PET");
		LanguageRegistry.addName(petSheet, "PET Sheet");
	}
}




