package ChristmasMod.common;
import net.minecraft.src.ItemBlock;
import java.util.List;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemPresentM extends ItemBlock {

	public ItemPresentM(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getItemNameIS(ItemStack i){
		switch(i.getItemDamage()){
		case 0:return "PresentM";
		case 1:return "PresentM";
		case 2:return "PresentM";
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
		return ChristmasMod.PresentM.getBlockTextureFromSideAndMetadata(2, par1);
	}
}