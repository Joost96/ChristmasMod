package ChristmasMod.common;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.World;

public class CommonProxy implements IGuiHandler

{
	public static void registerRenderInformation() {
		
		
	}
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }
  
}
