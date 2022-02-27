package oilgasoverhaul.main.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityWellhead extends TileEntity implements ITankContainer {

	public LiquidTank pumpedTank = new LiquidTank(1000);
	public LiquidTank condensateTank = new LiquidTank(1000);
	public LiquidTank naturalGasTank = new LiquidTank(1000);
	public LiquidTank crudeTank = new LiquidTank(1000);

	@Override 
	public void updateEntity() {
		TileEntity pump = worldObj.getBlockTileEntity(this.xCoord, this.yCoord - 1, this.zCoord);
		if (worldObj.getBlockId(this.xCoord, this.yCoord - 1, this.zCoord) == 164 && pump instanceof ITankContainer) {
			ITankContainer pumpTank = (ITankContainer) pump;
			LiquidStack pumpLiquid = pumpTank.drain(ForgeDirection.UP, 1000, false);
			if (pumpLiquid != null && pumpLiquid.isLiquidEqual(LiquidDictionary.getLiquid("Oil", pumpLiquid.amount))) {
				int pumpedLiquidAmount = pumpedTank.fill(pumpLiquid, false);
				LiquidStack transferredLiquid = pumpTank.drain(ForgeDirection.UP, pumpedLiquidAmount, true);
				pumpedTank.fill(transferredLiquid, true);
			}
		}

		if(this.pumpedTank.getLiquid() != null) {
			LiquidStack drainable = this.pumpedTank.drain(1000, false);
			if (drainable != null) {
				int drainableAmount = drainable.amount;
				int fillableAmount = this.crudeTank.fill(LiquidDictionary.getLiquid("Oil", drainableAmount), true);
				this.pumpedTank.drain(fillableAmount, true);
				int condensateAmount = fillableAmount / 10;
				int methaneAmount = fillableAmount / 5;
				this.condensateTank.fill(LiquidDictionary.getLiquid("Condensate", condensateAmount), true);
				this.naturalGasTank.fill(LiquidDictionary.getLiquid("gasMethane", methaneAmount), true);
			}
		}
	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		//		if(resource.isLiquidEqual(LiquidDictionary.getLiquid("Oil", resource.amount)) && from == from.DOWN) {	
		//			if(this.pumpedTank.getLiquid() == null) {
		//				if(resource.amount <= this.pumpedTank.getCapacity()) {
		//					this.pumpedTank.fill(resource, doFill);
		//					return resource.amount;
		//				}
		//			}
		//			if((this.pumpedTank.getLiquid().amount + resource.amount) <= this.pumpedTank.getCapacity()) {
		//				this.pumpedTank.fill(resource, doFill);
		//				return resource.amount;
		//			}
		//		}
		return 0;
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		switch(from) {
		case UP:
			return this.naturalGasTank.drain(maxDrain, doDrain);
		case EAST:
			return this.condensateTank.drain(maxDrain, doDrain);
		case WEST:
			return this.crudeTank.drain(maxDrain, doDrain);
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
		case DOWN:
			return new ILiquidTank[] {this.pumpedTank};
		case UP: 
			return new ILiquidTank[] {this.naturalGasTank};
		case EAST:
			return new ILiquidTank [] {this.condensateTank};
		case WEST:
			return new ILiquidTank [] {this.crudeTank};
		default:
			return null;
		}
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		// TODO Auto-generated method stub
		return null;
	}

}
