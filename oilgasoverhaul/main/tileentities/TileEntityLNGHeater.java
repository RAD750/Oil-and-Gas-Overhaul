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

public class TileEntityLNGHeater extends TileEntity implements ITankContainer {

	private final static int LNG_MULTIPLIER = 295;
	private static LiquidStack lngLiquidDictionary;
	
	public LiquidTank lngTank = new LiquidTank(10);
	public LiquidTank naturalGasTank = new LiquidTank(10000);
	private int audioDuration = 0;

	public TileEntityLNGHeater () {
		super();
		if (lngLiquidDictionary == null) {
			lngLiquidDictionary = LiquidDictionary.getLiquid("LNG", 1);
		}
	}
	
	@Override 
	public void updateEntity() {

		if (this.lngTank.getLiquid() != null) {
			int lngDrainableAmount = this.lngTank.getLiquid().amount;
			//simula fill LNG
			int canFill = this.naturalGasTank.fill(LiquidDictionary.getLiquid("gasMethane", lngDrainableAmount * LNG_MULTIPLIER), false);
			//se può riempire allora riempi
			if (canFill >= lngDrainableAmount * LNG_MULTIPLIER) {
				int fillableAmount = this.naturalGasTank.fill(LiquidDictionary.getLiquid("gasMethane", lngDrainableAmount * LNG_MULTIPLIER), true);
				this.lngTank.drain(lngDrainableAmount, true);
					if(!worldObj.isRemote) {
						if(audioDuration > 0) {
							audioDuration--;
						} else {
							audioDuration = 70;
							worldObj.playSoundEffect(xCoord, yCoord, zCoord, "machines.OGO_lngheater", 1f, 1);
						}
					}
			}
		}
		

	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		switch(from) {
		case WEST:
			if (resource.containsLiquid(lngLiquidDictionary)) {
				return this.lngTank.fill(resource, doFill);
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
			return new ILiquidTank[] {this.lngTank};
		case WEST:
			return new ILiquidTank[] {this.naturalGasTank};
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
