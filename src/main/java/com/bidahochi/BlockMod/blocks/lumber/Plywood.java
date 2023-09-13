package com.bidahochi.BlockMod.blocks.lumber;

import com.bidahochi.BlockMod.FoxBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class Plywood extends Block {

    int varia=16;

    public IIcon[] textures = new IIcon[varia];

    public Plywood(Material p_i45394_1_) {
        super(p_i45394_1_);
        setBlockName("plywood");
        setHardness(1F);
        setResistance(3F);
        setHarvestLevel("axe", 0);
        setStepSound(soundTypeWood);
        setBlockTextureName(FoxBlocks.MODID+":lumber/plywood/plywood");
        setCreativeTab(FoxBlocks.foxBlocksCreativeTabHome);
    }

    public void registerBlockIcons(IIconRegister reg) {
        for ( int i = 0; i < 8 ; i++) {
            this.textures[i] = reg.registerIcon(this.textureName+"_"+ i);
        }
    }
    public IIcon getIcon ( int side, int meta){
        if (meta > 7 ) meta = 0;
        return this.textures[meta];
    }
    public int damageDropped( int oldmeta){
        return oldmeta;
    }
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int i = 0; i < 8; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
