package com.bidahochi.BlockMod.blocks.bridgestuff;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileBridgeA_X_Side_Center_Top2 extends TileEntity {
    public int dir=0;

    public TileBridgeA_X_Side_Center_Top2(int dir) {
        super();
        this.dir = dir;
    }

    public TileBridgeA_X_Side_Center_Top2() {}

    @Override
    public boolean shouldRenderInPass(int pass){ return pass==0; }


    @Override
    public S35PacketUpdateTileEntity getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        if(pkt ==null){return;}
        readFromNBT(pkt.func_148857_g());
        markDirty();
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);
        tag.setInteger("direction", dir);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);
        dir = tag.getInteger("direction");
        if(worldObj!=null && worldObj.isRemote) {
            markDirty();
        }
    }

    public TileBridgeA_X_Side_Center_Top2 setFacing(int direction){
        dir=(byte) direction;
        this.markDirty();
        return this;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return AxisAlignedBB.getBoundingBox(xCoord-1, yCoord-5, zCoord-1, xCoord + 6, yCoord + 1, zCoord + 1);
    }
}
