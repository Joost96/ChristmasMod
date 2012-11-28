package ChristmasMod.common;

import net.minecraft.src.Item;

public class ItemDough extends Item {

	protected ItemDough(int par1) {
		super(par1);
		this.setCreativeTab(ChristmasMod.TabChrist);
	}
	public String getTextureFile()
	{
		return "/ChristmasMod/item.png";
	}

}
