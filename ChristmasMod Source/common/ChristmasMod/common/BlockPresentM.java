package ChristmasMod.common;

import java.util.List;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockPresentM extends Block {

	public BlockPresentM(int i) {
		super(i, Material.wood);
		this.setCreativeTab(ChristmasMod.TabChrist);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8125F, 0.75F, 0.8125F);
	}
    public boolean isOpaqueCube()
    {
        return false;
       
    }
   
    public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT) //Client side only
	public int getBlockTextureFromSideAndMetadata(int i,int l){ //Tells it which texture from the sprite sheet
		switch(l){
		case 0:return 5;
		case 1:return 6;
		default:return 4;
		}
	}
	public void getSubBlocks(int i,CreativeTabs tab, List list){
		list.add(new ItemStack(i,1,0));
		list.add(new ItemStack(i,1,1));
		list.add(new ItemStack(i,1,2));
	}

	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return "/ChristmasMod/terrain.png";
	}

}
