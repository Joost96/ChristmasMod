package ChristmasMod.common;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockPresentB extends Block {

	public BlockPresentB(int i) {
		super(i, Material.wood);
		this.setCreativeTab(ChristmasMod.TabChrist);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.8125F, 1F);
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
		case 0:return 8;
		case 1:return 9;
		default:return 7;
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
