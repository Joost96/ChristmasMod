package ChristmasMod.client;
import ChristmasMod.common.CommonProxy;
import ChristmasMod.common.EntitySanta;
import net.minecraft.src.RenderLiving;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

   
   public static void registerRenderInformation()
   {
       
   
		MinecraftForgeClient.preloadTexture("/ChristmasMod/terrain.png");
		MinecraftForgeClient.preloadTexture("/ChristmasMod/item.png");
		MinecraftForgeClient.preloadTexture("/ChristmasMod/SSuit_1.png");
		MinecraftForgeClient.preloadTexture("/ChristmasMod/SSuit_2.png");
		MinecraftForgeClient.preloadTexture("/ChristmasMod/Santa.png");
		
		RenderingRegistry.instance().registerEntityRenderingHandler(EntitySanta.class, new RenderLiving(new ModelSanta(), 0.5F));
		
	}

}
