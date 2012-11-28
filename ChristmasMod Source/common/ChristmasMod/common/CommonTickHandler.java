package ChristmasMod.common;

import java.util.EnumSet;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldServer;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class CommonTickHandler implements ITickHandler
{
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		if(type.equals(EnumSet.of(TickType.SERVER)))
		{
			onTickInGame();
		}
	}


	public EnumSet ticks()
	{
		return EnumSet.of(TickType.SERVER);
	}

	public String getLabel()
	{
		return null;
	}


	private void onTickInGame() 
	{
		if (ChristmasMod.SetSnow == true)
		{
			WorldServer var4 = MinecraftServer.getServer().worldServers[0];
			WorldInfo var5 = var4.getWorldInfo();
			var5.setRaining(true);
		}
	}
}