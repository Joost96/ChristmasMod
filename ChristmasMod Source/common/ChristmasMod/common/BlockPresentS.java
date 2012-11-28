package ChristmasMod.common;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockPresentS extends BlockContainer {

	public BlockPresentS(int i) {
		super(i, Material.wood);
		this.setCreativeTab(ChristmasMod.TabChrist);
		this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.25F, 0.625F);
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
		case 0:return 1;
		case 1:return 2;
		default:return 0;
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
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityPresentS();
	}
	// public String idDropped(int par1, Random par2Random, int par3)
	//    {
	     //   return TileEntityPresentS.inside;
	  //  }

}
