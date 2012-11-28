package ChristmasMod.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class ItemLight extends Item {

	protected ItemLight(int i) {
		super(i);
		this.setCreativeTab(ChristmasMod.TabChrist);
	}
	public String getTextureFile()
	{
		return "/ChristmasMod/item.png";
	}

}
