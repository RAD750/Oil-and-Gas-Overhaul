package oilgasoverhaul.main.tileentities;
import buildcraft.api.core.Position;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;
import oilgasoverhaul.main.handlers.LiquidHelper;

public class TileEntityFrackingHead extends TileEntity implements ITankContainer {

	private final static int STEAM_RATE = 180;
	private final static int METHANE_DIVISOR = 40;
	private final static BiomeGenBase CORRECT_BIOME = BiomeGenBase.desertHills;
	private static LiquidStack waterLiquidDictionary;
	private static LiquidStack steamLiquidDictionary;
	private boolean isBiomeCorrect;
	private BiomeGenBase currentBiome;
	private int audioDuration = 0;
	
	public LiquidTank waterTank = new LiquidTank(1000);
	public LiquidTank steamTank = new LiquidTank(1000);
	public LiquidTank naturalGasTank = new LiquidTank(100);

	public TileEntityFrackingHead () {
		super();
		if (waterLiquidDictionary == null) {
			waterLiquidDictionary = LiquidDictionary.getLiquid("usefuladditions.saltWater", 1);
		}
		if (steamLiquidDictionary == null) {
			steamLiquidDictionary = LiquidDictionary.getLiquid("Steam", 1);
		}
	}
	
	@Override 
	public void updateEntity() {
		if(currentBiome == null) {
			currentBiome = super.worldObj.getBiomeGenForCoords(super.xCoord, super.zCoord);
			if (currentBiome.equals(CORRECT_BIOME)) {
				isBiomeCorrect = true;
			} else {
				isBiomeCorrect = false;
			};
		}

		if(isBiomeCorrect && this.waterTank.getLiquid() != null && this.steamTank.getLiquid() != null) {
			if (this.waterTank.getLiquid().amount >= 1000 && this.steamTank.getLiquid().amount >= STEAM_RATE) {
				
			
				int waterDrainableAmount = this.waterTank.getLiquid().amount;
				//simula fill natural gas
				int canFill = this.naturalGasTank.fill(LiquidDictionary.getLiquid("gasMethane", waterDrainableAmount / METHANE_DIVISOR), false);
				//se può riempire allora riempi
				if (canFill >= waterDrainableAmount / METHANE_DIVISOR) {
					int fillableAmount = this.naturalGasTank.fill(LiquidDictionary.getLiquid("gasMethane", waterDrainableAmount / METHANE_DIVISOR), true);
					this.waterTank.drain(waterDrainableAmount, true);
					this.steamTank.drain(STEAM_RATE, true);
					if(!worldObj.isRemote) {
						if(audioDuration > 0) {
							audioDuration--;
						} else {
							audioDuration = 27;
							worldObj.playSoundEffect(xCoord, yCoord, zCoord, "machines.OGO_groundwell", 1f, 1);
						}
					}
				}
			}
		}
		

	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		switch(from) {
		case WEST:
			if (resource.containsLiquid(waterLiquidDictionary)) {
				return this.waterTank.fill(resource, doFill);
			}
		case NORTH:
			if (resource.containsLiquid(steamLiquidDictionary)) {
				return this.steamTank.fill(resource, doFill);
			}
		default:
			return 0;
		}
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		switch(from) {
		case EAST:
			return this.naturalGasTank.drain(maxDrain, doDrain);
		default:
			return null;
		}
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		switch(direction) {
		case EAST:
			return new ILiquidTank[] {this.naturalGasTank};
		case WEST:
			return new ILiquidTank[] {this.waterTank};
		case NORTH:
			return new ILiquidTank[] {this.steamTank};
		default:
			return new ILiquidTank[] {};
		}
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		// TODO Auto-generated method stub
		return null;
	}

}
