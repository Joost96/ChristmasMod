package ChristmasMod.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.*;

public class BlockPresentB extends BlockContainer {
	
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
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		TileEntityPresent present = (TileEntityPresent) par1World.getBlockTileEntity(par2, par3, par4);
		return present.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }
	
	@Override
	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) 
    {
		TileEntityPresent present = (TileEntityPresent) par1World.getBlockTileEntity(par2, par3, par4);
		String player = par6EntityPlayer.username;
		if (player == present.giver)
			par6EntityPlayer.dropPlayerItem(present.gift);
		if (player == present.receiver)
		{
			int nowDate = Calendar.getInstance().get(Calendar.DATE);
			int nowMonth = Calendar.getInstance().get(Calendar.MONTH);
			if (nowDate == Config.openDay && nowMonth == Config.openMonth)
				par6EntityPlayer.dropPlayerItem(present.gift);
		}
    }
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityPresent();
	}

}
