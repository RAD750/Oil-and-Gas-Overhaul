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

public class TileEntityLNGAbsorptionChiller extends TileEntity implements ITankContainer {

	private final static int STEAM_RATE = 720;
	private final static int LNG_DIVISOR = 300;
	private static LiquidStack methaneLiquidDictionary;
	private static LiquidStack steamLiquidDictionary;
	
	public LiquidTank lngTank = new LiquidTank(100);
	public LiquidTank steamTank = new LiquidTank(1000);
	public LiquidTank naturalGasTank = new LiquidTank(1000);

	public TileEntityLNGAbsorptionChiller () {
		super();
		if (methaneLiquidDictionary == null) {
			methaneLiquidDictionary = LiquidDictionary.getLiquid("gasMethane", 1);
		}
		if (steamLiquidDictionary == null) {
			steamLiquidDictionary = LiquidDictionary.getLiquid("Steam", 1);
		}
	}
	
	@Override 
	public void updateEntity() {

		if (this.naturalGasTank.getLiquid() != null && this.steamTank.getLiquid() != null) {
			if (this.naturalGasTank.getLiquid().amount >= 1000 && this.steamTank.getLiquid().amount >= STEAM_RATE) {
				
			
				int naturalGasDrainableAmount = this.naturalGasTank.getLiquid().amount;
				//simula fill LNG
				int canFill = this.lngTank.fill(LiquidDictionary.getLiquid("LNG", naturalGasDrainableAmount / LNG_DIVISOR), false);
				//se può riempire allora riempi
				if (canFill >= naturalGasDrainableAmount / LNG_DIVISOR) {
					int fillableAmount = this.lngTank.fill(LiquidDictionary.getLiquid("LNG", naturalGasDrainableAmount / LNG_DIVISOR), true);
					this.naturalGasTank.drain(naturalGasDrainableAmount, true);
					this.steamTank.drain(STEAM_RATE, true);
					/*
					if(!worldObj.isRemote) {
						if(audioDuration > 0) {
							audioDuration--;
						} else {
							audioDuration = 27;
							worldObj.playSoundEffect(xCoord, yCoord, zCoord, "machines.OGO_groundwell", 1f, 1);
						}
					}*/
				}
			}
		}
		

	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		switch(from) {
		case WEST:
			if (resource.containsLiquid(methaneLiquidDictionary)) {
				return this.naturalGasTank.fill(resource, doFill);
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
			return this.lngTank.drain(maxDrain, doDrain);
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
			return new ILiquidTank[] {this.lngTank};
		case WEST:
			return new ILiquidTank[] {this.naturalGasTank};
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
