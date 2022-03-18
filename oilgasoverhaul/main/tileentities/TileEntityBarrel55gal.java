package oilgasoverhaul.main.tileentities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityBarrel55gal extends TileEntity implements ITankContainer {

	public LiquidTank tankBarrel = new LiquidTank(208000);
	@Override 
	public void updateEntity() {
	}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		switch(from) {
		case UP:
			if(this.tankBarrel.getLiquid() == null) {
				if(resource.amount <= this.tankBarrel.getCapacity()) {
					this.tankBarrel.fill(resource, doFill);
					return resource.amount;
				}
			}
			if((this.tankBarrel.getLiquid().amount + resource.amount) <= this.tankBarrel.getCapacity()) {
				this.tankBarrel.fill(resource, doFill);
				return resource.amount;
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
		case UP:
			return null;
		default:
			return this.tankBarrel.drain(maxDrain, doDrain);
		}
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		return new ILiquidTank[] {this.tankBarrel};
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);

		if (data.hasKey("stored") && data.hasKey("liquidId")) {
			LiquidStack liquid = new LiquidStack(data.getInteger("liquidId"), data.getInteger("stored"), 0);
			tankBarrel.setLiquid(liquid);
		} else {
			LiquidStack liquid = new LiquidStack(0, 0, 0);
			liquid.readFromNBT(data.getCompoundTag("tank"));
			tankBarrel.setLiquid(liquid);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);
		if (tankBarrel.getLiquid() != null) {
			data.setTag("tank", tankBarrel.getLiquid().writeToNBT(new NBTTagCompound()));
		}
	}

}
