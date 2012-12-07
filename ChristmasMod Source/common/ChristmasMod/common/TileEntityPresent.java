package ChristmasMod.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class TileEntityPresent extends TileEntity 
{
	public ItemStack gift;
	public String giver;
	public String receiver;
	public boolean isLocked = false;
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		ItemStack item = par5EntityPlayer.getHeldItem();
		
		if (item == null)
		{
			return false;
		}
		else if (gift == null)
		{
			this.gift = item;
			this.giver = par5EntityPlayer.username;
			par5EntityPlayer.inventory.setInventorySlotContents(par5EntityPlayer.inventory.currentItem, new ItemStack(0, 0, 0));
		}
		else if (item.getItem() == ChristmasMod.GiftTag)
		{
			this.isLocked = true;
			ItemGiftTag tag = (ItemGiftTag) item.getItem();
			this.receiver = tag.getUserFromID(item.getItemDamage());
		}
		else
			return false;
        return true;
	}
	
	/**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.gift = ItemStack.loadItemStackFromNBT(par1NBTTagCompound);
        this.giver = par1NBTTagCompound.getString("giver");
        this.receiver = par1NBTTagCompound.getString("to");
        this.isLocked = par1NBTTagCompound.getBoolean("locked");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        
        if (this.gift != null)
        	this.gift.writeToNBT(par1NBTTagCompound);
        if (this.giver != null)
        	par1NBTTagCompound.setString("giver", this.giver);
        if (this.receiver != null)
        	par1NBTTagCompound.setString("to", this.receiver);
        par1NBTTagCompound.setBoolean("locked", this.isLocked);
    }
}

