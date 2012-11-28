package ChristmasMod.common;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.Material;
import net.minecraftforge.common.IShearable;

public class BlockStar extends Block
{
    protected BlockStar(int par1, int par2)
    {
        super(par1, par2, Material.vine);
        float var3 = 0.4F;
        
        this.setCreativeTab(ChristmasMod.TabChrist);
    }

	@SideOnly(Side.CLIENT)
	public String getTextureFile()
	{
		return "/ChristmasMod/terrain.png";
	}
	 public int getRenderType()
	    {
	        return 1;
	    }
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
}