package ChristmasMod.common;

import java.util.EnumSet;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.BiomeGenBase;
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
		if (ChristmasMod.SetSnow == true)
		{
			BiomeGenBase.swampland.temperature = 0.0F;
			BiomeGenBase.beach.temperature = 0.0F;
			BiomeGenBase.desert.temperature = 0.0F;
			BiomeGenBase.desertHills.temperature = 0.0F;
			BiomeGenBase.forest.temperature = 0.0F;
			BiomeGenBase.forestHills.temperature = 0.0F;
			BiomeGenBase.jungle.temperature = 0.0F;
			BiomeGenBase.jungleHills.temperature = 0.0F;
			BiomeGenBase.mushroomIsland.temperature = 0.0F;
			BiomeGenBase.mushroomIslandShore.temperature = 0.0F;
			BiomeGenBase.ocean.temperature = 0.0F;
			BiomeGenBase.plains.temperature = 0.0F;
			BiomeGenBase.river.temperature = 0.0F;
			BiomeGenBase.desert.setEnableSnow();
			BiomeGenBase.taiga.temperature = 0.0F;
			BiomeGenBase.taigaHills.temperature = 0.0F;
			BiomeGenBase.extremeHills.temperature = 0.0F;
			BiomeGenBase.extremeHillsEdge.temperature = 0.0F;
		}
		else if (ChristmasMod.SetSnow == false)
		{
			BiomeGenBase.swampland.setTemperatureRainfall(0.8f, 0.9f);
			BiomeGenBase.beach.setTemperatureRainfall(0.8f, 0.4f);
			BiomeGenBase.desert.setTemperatureRainfall(2.0f, 0.0f);
			BiomeGenBase.desertHills.setTemperatureRainfall(2.0f, 0.0f);;
			BiomeGenBase.forest.setTemperatureRainfall(0.7f, 0.8f);
			BiomeGenBase.forestHills.setTemperatureRainfall(0.7f, 0.8f);
			BiomeGenBase.jungle.setTemperatureRainfall(1.2f, 0.9f);
			BiomeGenBase.jungleHills.setTemperatureRainfall(1.2f, 0.9f);
			BiomeGenBase.mushroomIsland.setTemperatureRainfall(0.9f, 1.0f);
			BiomeGenBase.mushroomIslandShore.setTemperatureRainfall(0.9f, 1.0f);
			BiomeGenBase.ocean.setTemperatureRainfall(0.5f, 0.5f);
			BiomeGenBase.plains.setTemperatureRainfall(0.8f, 0.4f);
			BiomeGenBase.river.setTemperatureRainfall(0.5f, 0.5f);
			BiomeGenBase.taiga.setTemperatureRainfall(0.05f, 0.8f);
			BiomeGenBase.taigaHills.setTemperatureRainfall(0.05f, 0.8f);
			BiomeGenBase.extremeHills.setTemperatureRainfall(0.2f, 0.3f);
			BiomeGenBase.extremeHillsEdge.setTemperatureRainfall(0.2f, 0.3f);
		}
	}
}