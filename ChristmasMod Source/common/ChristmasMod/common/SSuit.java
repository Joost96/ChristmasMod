package ChristmasMod.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class SSuit extends ItemArmor implements  IArmorTextureProvider
{
	  public SSuit(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
      {
              super(i, enumarmormaterial, j, k);
              this.setCreativeTab(ChristmasMod.TabChrist);
      }
	  public String getArmorTextureFile(ItemStack itemstack)
      {
              if(itemstack.itemID == ChristmasMod.Helmet.shiftedIndex || itemstack.itemID ==ChristmasMod.Plate.shiftedIndex || itemstack.itemID == ChristmasMod.Boots.shiftedIndex)
              {
                      return "/ChristmasMod/SSuit_1.png";
              }
              if(itemstack.itemID == ChristmasMod.Legs.shiftedIndex)
              {
                      return "/ChristmasMod/SSuit_2.png";
              }
              return "/ChristmasMod/SSuit_1.png";
      }
      
	  public String getTextureFile()
		{
			return "/ChristmasMod/item.png";
		}


}