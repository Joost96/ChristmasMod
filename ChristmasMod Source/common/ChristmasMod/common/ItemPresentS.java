package ChristmasMod.common;
import net.minecraft.src.ItemBlock;
import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;


public class ItemPresentS extends ItemBlock {

	public ItemPresentS(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getItemNameIS(ItemStack i){
		switch(i.getItemDamage()){
		case 0:return "PresentS";
		case 1:return "PresentS";
		case 2:return "PresentS";
		default:return "";
		}
	}

	public int getMetadata(int par1)
	{
		return par1;
	}

	@SideOnly(Side.CLIENT)
	public int getIconFromDamage(int par1)
	{
		return ChristmasMod.PresentS.getBlockTextureFromSideAndMetadata(2, par1);
	}
}