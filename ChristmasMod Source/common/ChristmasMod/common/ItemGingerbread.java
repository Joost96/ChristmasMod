package ChristmasMod.common;

import net.minecraft.src.ItemFood;

public class ItemGingerbread extends ItemFood {

	public ItemGingerbread(int par1, int par2, boolean par3) {
		super(par1, par2, par3);
		this.setCreativeTab(ChristmasMod.TabChrist);
	}
	public String getTextureFile()
	{
		return "/ChristmasMod/item.png";
	}

}