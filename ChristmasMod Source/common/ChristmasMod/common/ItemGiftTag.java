package ChristmasMod.common;

import java.util.*;

import ChristmasMod.client.GuiGiftTag;

import net.minecraft.src.*;

public class ItemGiftTag extends Item
{

	private Map tagData = new HashMap();
	
	public ItemGiftTag(int par1)
	{
		super(par1);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		if (ChristmasMod.isClient() && par1ItemStack.getItemDamage() == 0)
			ModLoader.openGUI(par2EntityPlayer, new GuiGiftTag(par1ItemStack, par2EntityPlayer, par3World, this));
        return true;
    }
	
	public int getUniqueID()
	{
		return tagData.keySet().toArray().length + 1;
	}
	
	public void setOrCreateData(int id, String user)
	{
		tagData.put(id, user);
	}
	
	public String getUserFromID(int id)
	{
		return (String) tagData.get(id);
	}
	
	public String getTextureFile()
	{
		return "/ChristmasMod/item.png";
	}

}
