package ChristmasMod.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class BlockPresentB extends Block {

	private ItemStack gift;
	private String giver;
	private String receiver;
	
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
		gift = getGift(par2, par3, par4, par1World);
		giver = getGiver(par2, par3, par4, par1World);
		
		ItemStack item = par5EntityPlayer.getHeldItem();
		
		if (item == null)
		{
			return false;
		}
		else if (gift == null)
		{
			this.gift = item;
			this.giver = par5EntityPlayer.username;
			setGift(item, par2, par3, par4, par1World);
			setGiver(par5EntityPlayer.username, par2, par3, par4, par1World);
			par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(0, 0, 0));
		}
        return true;
    }
	
	public ItemStack getGift(int x, int y, int z, World world)
    {
    	try {
			world.checkSessionLock();
		} catch (MinecraftException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ItemStack moder = null;
    	try {
    		File file = new File ("" + ModLoader.getMinecraftInstance().getMinecraftDir() + "/saves/" + world.getSaveHandler().getSaveDirectoryName() + "","xmas.dat");
    	if (!file.exists()) {
    		setGift(this.gift, x, y, z, world);
    		return null;
    	}
    	FileInputStream fileinputstream = new FileInputStream(file);
    	NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(fileinputstream);
    	if (nbttagcompound.hasKey("gift" + x + y + z)) {
    		moder= ItemStack.loadItemStackFromNBT(nbttagcompound.getCompoundTag("gift" + x + y + z));
    	}
    	fileinputstream.close();
    	}
    	catch (Exception exception) {
    	exception.printStackTrace();
    	}
    	return moder;
    }
    
    private static void setGift(ItemStack par1, int intX, int intY, int intZ, World world) {
    	try {
    	File file = new File(ModLoader.getMinecraftInstance().getMinecraftDir() + "/saves/" + world.getSaveHandler().getSaveDirectoryName() + "","xmas.dat");
    	System.out.println("FILE: " + file);
    	if (!file.exists()) {
    	file.createNewFile();
    	}
    	FileOutputStream fileoutputstream = new FileOutputStream(file);
    	NBTTagCompound nbttagcompound = new NBTTagCompound();
    	nbttagcompound.setString("gift" + intX + intY + intZ, par1.toString());

    	CompressedStreamTools.writeCompressed(nbttagcompound, fileoutputstream);
    	fileoutputstream.close();
    	}
    	catch(Exception exception) {
    	exception.printStackTrace();
    	}
    }
    
    public String getGiver(int x, int y, int z, World world)
    {
    	try {
			world.checkSessionLock();
		} catch (MinecraftException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String moder = null;
    	try {
    		File file = new File ("" + ModLoader.getMinecraftInstance().getMinecraftDir() + "/saves/" + world.getSaveHandler().getSaveDirectoryName() + "","xmas.dat");
    	if (!file.exists()) {
    		if (giver != null)
    			setGiver(this.giver, x, y, z, world);
    		return null;
    	}
    	FileInputStream fileinputstream = new FileInputStream(file);
    	NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(fileinputstream);
    	if (nbttagcompound.hasKey("giver" + x + y + z)) {
    		moder= nbttagcompound.getString("giver" + x + y + z);
    	}
    	fileinputstream.close();
    	}
    	catch (Exception exception) {
    	exception.printStackTrace();
    	}
    	return moder;
    }
    
    private static void setGiver(String par1, int intX, int intY, int intZ, World world) {
    	try {
    	File file = new File(ModLoader.getMinecraftInstance().getMinecraftDir() + "/saves/" + world.getSaveHandler().getSaveDirectoryName() + "","xmas.dat");
    	System.out.println("FILE: " + file);
    	if (!file.exists()) {
    	file.createNewFile();
    	}
    	FileOutputStream fileoutputstream = new FileOutputStream(file);
    	NBTTagCompound nbttagcompound = new NBTTagCompound();
    	nbttagcompound.setString("giver" + intX + intY + intZ, par1);

    	CompressedStreamTools.writeCompressed(nbttagcompound, fileoutputstream);
    	fileoutputstream.close();
    	}
    	catch(Exception exception) {
    	exception.printStackTrace();
    	}
    }

}
