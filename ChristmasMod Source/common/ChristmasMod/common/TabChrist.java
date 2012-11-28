package ChristmasMod.common;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;

public class TabChrist extends CreativeTabs {
	public TabChrist(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return ChristmasMod.Wreath.blockID;
	}

	public String getTranslatedTabLabel()
	{
		return "ChristmasMod";
	}
}
