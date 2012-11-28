package ChristmasMod.common;
import java.awt.Color;
import java.util.EnumSet;

import ChristmasMod.client.ClientProxy;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.Mod.ServerStopping;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.SidedProxy;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "ChristmasMod", name = "ChristmasMod", version = "0.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class ChristmasMod {
	public static MinecraftServer server;
	public static NBTTagCompound worldData;
	
	public static Block Star;
	public static Block PresentS;
	public static Block PresentM;
	public static Block PresentB;
	public static Block Lights;
	public static Block Bells;
	public static Block Stocking;
	public static Block Wreath;
	public static Block GLight;
	public static Block BLight;
	public static Block RLight;
	public static Block Candle;

	public static Item Light;
	public static Item Boots;
	public static Item Helmet;
	public static Item Plate;
	public static Item Legs;

	public static Item Chocolate;
	public static Item CandyCane;
	public static Item Candy;
	public static Item Gingerbread;
	public static Item Dough;
	public static CreativeTabs TabChrist;
	public static EnumArmorMaterial SSuit;
	public static boolean SetSnow;
	public void addCommands(ServerCommandManager manager)
	{
		manager.registerCommand(new CommandToggleSnow());
	}
	@SidedProxy(clientSide = "ChristmasMod.client.ClientProxy", serverSide = "ChristmasMod.common.CommonProxy")
	public static CommonProxy proxy;
	@Init
	public void load(FMLInitializationEvent event)
	{
		ClientProxy.registerRenderInformation();

		MinecraftForge.EVENT_BUS.register(new CommandEventHandler());
		LanguageRegistry.instance().addStringLocalization("entity.Santa.name", "en_US", "Santa");
		EntityRegistry.registerGlobalEntityID(EntitySanta.class, "Santa", ModLoader.getUniqueEntityId(), 11 ,115);
		
		TabChrist = new TabChrist(12, "ChristmasMod");
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
		BiomeGenBase.taiga.temperature = 0.0F;
		BiomeGenBase.taigaHills.temperature = 0.0F;
		BiomeGenBase.extremeHills.temperature = 0.0F;
		BiomeGenBase.extremeHillsEdge.temperature = 0.0F;

		TickRegistry.registerTickHandler(new CommonTickHandler(), Side.SERVER);

		Star = (BlockStar)(new BlockStar(162, 17)).setHardness(0.0F).setLightValue(.7F).setStepSound(Block.soundClothFootstep).setBlockName("Star");

		Chocolate = new ItemCandy(5005, 4, true).setIconCoord(16, 0).setItemName("Chocolate");
		CandyCane = new ItemCandy(5006, 8, true).setIconCoord(18, 0).setItemName("CandyCane");
		Candy = new ItemCandy(5007, 2, true).setIconCoord(17, 0).setItemName("Candy");
		Dough = new ItemDough(5008).setIconIndex(20).setItemName("Dough");
		Gingerbread = new ItemGingerbread(5009, 2, true).setIconCoord(19, 0).setItemName("GingerBread");

		PresentS = new BlockPresentS(155).setHardness(3F).setStepSound(Block.soundStoneFootstep).setBlockName("PresentS");
		PresentM = new BlockPresentM(156).setHardness(3F).setStepSound(Block.soundStoneFootstep).setBlockName("PresentM");
		PresentB = new BlockPresentB(157).setHardness(3F).setStepSound(Block.soundStoneFootstep).setBlockName("PresentB");
		Candle = (new BlockCandle(161, 16)).setHardness(0.0F).setLightValue(0.9375F).setStepSound(Block.soundWoodFootstep).setBlockName("Candle").setRequiresSelfNotify();

		Light = new ItemLight(5000).setIconIndex(0).setItemName("Light");
		Lights = new BlockLights(151, 3).setHardness(0.2F).setLightValue(0.8F).setStepSound(Block.soundWoodFootstep).setBlockName("Lights");
		GLight = new BlockGLight(152, 10).setHardness(0.2F).setLightValue(0.8F).setStepSound(Block.soundWoodFootstep).setBlockName("GLight");
		BLight = new BlockBLight(153, 11).setHardness(0.2F).setLightValue(0.8F).setStepSound(Block.soundWoodFootstep).setBlockName("BLight");
		RLight = new BlockRLight(154, 12).setHardness(0.2F).setLightValue(0.8F).setStepSound(Block.soundWoodFootstep).setBlockName("RLight");

		Bells = new BlockBells(158, 13).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setBlockName("Bells");
		Stocking = new BlockStockings(159 ,14).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setBlockName("Stocking");
		Wreath = new BlockBells(160, 15).setHardness(0.5F).setStepSound(Block.soundClothFootstep).setBlockName("Wreath");

		SSuit = EnumHelper.addArmorMaterial("SSuit", 5, new int[]{1, 3, 2, 1}, 15);
		Boots = (new SSuit(5001, SSuit, 3, 3)).setIconCoord(4, 0).setItemName("Boots");
		Helmet = (new SSuit(5002, SSuit, 3, 0)).setIconCoord(1, 0).setItemName("Helmer");
		Plate = (new SSuit(5003, SSuit, 3, 1)).setIconCoord(2, 0).setItemName("Plate");
		Legs = (new SSuit(5004, SSuit, 3, 2)).setIconCoord(3, 0).setItemName("Legs");


		GameRegistry.registerBlock(Lights);
		GameRegistry.registerBlock(GLight);
		GameRegistry.registerBlock(BLight);
		GameRegistry.registerBlock(RLight);
		
		GameRegistry.registerTileEntity(TileEntityPresentS.class, "PresentS");
		GameRegistry.registerBlock(PresentS, ItemPresentS.class);
		GameRegistry.registerBlock(PresentM, ItemPresentM.class);
		GameRegistry.registerBlock(PresentB, ItemPresentB.class);
		//GameRegistry.registerBlock(Stocking, ItemStocking.class);
		GameRegistry.registerBlock(Candle);
		GameRegistry.registerBlock(Stocking);

		GameRegistry.registerBlock(Star);
		GameRegistry.registerBlock(Bells);
		GameRegistry.registerBlock(Wreath);
		LanguageRegistry.addName(Bells, "Bells");
		LanguageRegistry.addName(Stocking, "Stocking");
		LanguageRegistry.addName(Wreath, "Wreath");

		LanguageRegistry.addName(Boots, "Santa Boots");
		LanguageRegistry.addName(Helmet, "Santa Helmet");
		LanguageRegistry.addName(Plate, "Santa Suit");
		LanguageRegistry.addName(Legs, "Santa Legs");

		LanguageRegistry.addName(Chocolate, "Chocolate");
		LanguageRegistry.addName(CandyCane, "CandyCane");
		LanguageRegistry.addName(Candy, "Candy");
		LanguageRegistry.addName(Dough, "Dough");
		LanguageRegistry.addName(Gingerbread, "Gingerbread");

		LanguageRegistry.addName(new ItemStack(PresentS,1,0), "Small Present");
		LanguageRegistry.addName(new ItemStack(PresentS,1,1), "Small Present");
		LanguageRegistry.addName(new ItemStack(PresentS,1,2), "Small Present");

		LanguageRegistry.addName(new ItemStack(PresentM,2,0), "Present");
		LanguageRegistry.addName(new ItemStack(PresentM,2,1), "Present");
		LanguageRegistry.addName(new ItemStack(PresentM,2,2), "Present");

		LanguageRegistry.addName(new ItemStack(PresentB,3,0), "Big Present");
		LanguageRegistry.addName(new ItemStack(PresentB,3,1), "Big Present");
		LanguageRegistry.addName(new ItemStack(PresentB,3,2), "Big Present");
		LanguageRegistry.addName(Candle, "Candle");

		LanguageRegistry.addName(Lights, "Lights");
		LanguageRegistry.addName(GLight,"Green Light");
		LanguageRegistry.addName(BLight,"Bleu Light");
		LanguageRegistry.addName(RLight,"Red Light");
		LanguageRegistry.addName(Light,"Light");
		LanguageRegistry.addName(Star,"Christmas peak");

		GameRegistry.addRecipe(new ItemStack(PresentS,1,0), " X ","XYX"," X ", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,2), Character.valueOf('Y'), Block.planks);
		GameRegistry.addRecipe(new ItemStack(PresentS,1,1), " X ","XYX"," X ", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,4), Character.valueOf('Y'), Block.planks);
		GameRegistry.addRecipe(new ItemStack(PresentS,1,2), " X ","XYX"," X ", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,1), Character.valueOf('Y'), Block.planks);

		GameRegistry.addRecipe(new ItemStack(PresentM,1,0), "XYX","YYY","XYX", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,2), Character.valueOf('Y'), Block.planks);
		GameRegistry.addRecipe(new ItemStack(PresentM,1,1), "XYX","YYY","XYX", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,4), Character.valueOf('Y'), Block.planks);
		GameRegistry.addRecipe(new ItemStack(PresentM,1,2), "XYX","YYY","XYX", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,1), Character.valueOf('Y'), Block.planks);

		GameRegistry.addRecipe(new ItemStack(PresentB,1,0), "YYY","YXY","YYY", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,2), Character.valueOf('Y'), Block.planks);
		GameRegistry.addRecipe(new ItemStack(PresentB,1,1), "YYY","YXY","YYY", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,4), Character.valueOf('Y'), Block.planks);
		GameRegistry.addRecipe(new ItemStack(PresentB,1,2), "YYY","YXY","YYY", Character.valueOf('X'), new ItemStack(Item.dyePowder,1,1), Character.valueOf('Y'), Block.planks);

		GameRegistry.addRecipe(new ItemStack(Light,8),"Y","X", Character.valueOf('X'), new ItemStack(Item.ingotIron,1), Character.valueOf('Y'), new ItemStack(Item.lightStoneDust,0));
		GameRegistry.addRecipe(new ItemStack(Bells,1)," X ","X X", Character.valueOf('X'), new ItemStack(Item.ingotGold,1));
		GameRegistry.addRecipe(new ItemStack(Wreath,1),"XXX","X X","XXX", Character.valueOf('X'), new ItemStack(Item.seeds,1));
		GameRegistry.addRecipe(new ItemStack(Stocking,1),"X","X", Character.valueOf('X'), Block.cloth);

		GameRegistry.addRecipe(new ItemStack(Lights,1),"XX","XX", Character.valueOf('X'), new ItemStack(Light,1));
		GameRegistry.addRecipe(new ItemStack(GLight,1),"Y","X","Y", Character.valueOf('X'), new ItemStack(Light,1), Character.valueOf('Y'), new ItemStack(Item.dyePowder,1,2));
		GameRegistry.addRecipe(new ItemStack(BLight,1),"Y","X","Y", Character.valueOf('X'), new ItemStack(Light,1), Character.valueOf('Y'), new ItemStack(Item.dyePowder,1,4));
		GameRegistry.addRecipe(new ItemStack(RLight,1),"Y","X","Y", Character.valueOf('X'), new ItemStack(Light,1), Character.valueOf('Y'), new ItemStack(Item.dyePowder,1,1));

		GameRegistry.addRecipe(new ItemStack(Boots,1),"X X","X X", Character.valueOf('X'), new ItemStack(Block.cloth,1,14));
		GameRegistry.addRecipe(new ItemStack(Legs,1),"XXX","X X","X X", Character.valueOf('X'), new ItemStack(Block.cloth,1,14));
		GameRegistry.addRecipe(new ItemStack(Plate,1),"X X","XXX","XXX", Character.valueOf('X'), new ItemStack(Block.cloth,1,14));
		GameRegistry.addRecipe(new ItemStack(Helmet,1),"XXX","X X", Character.valueOf('X'), new ItemStack(Block.cloth,1,14));

		GameRegistry.addRecipe(new ItemStack(Candle,4),"Y","X", Character.valueOf('X'), new ItemStack(Item.clay,1), Character.valueOf('Y'), new ItemStack(Item.coal,1,0));
		GameRegistry.addRecipe(new ItemStack(Candle,4),"Y","X", Character.valueOf('X'), new ItemStack(Item.clay,1), Character.valueOf('Y'), new ItemStack(Item.coal,1,1));

		GameRegistry.addRecipe(new ItemStack(Candy,4),"XXX","XXX", Character.valueOf('X'), new ItemStack(Item.sugar,1));
		GameRegistry.addRecipe(new ItemStack(CandyCane,1),"XX"," X"," X", Character.valueOf('X'), new ItemStack(Candy,1));


		GameRegistry.addSmelting(Dough.shiftedIndex, new ItemStack(Gingerbread), 0.1F); 
		GameRegistry.addShapelessRecipe(new ItemStack(Dough), new ItemStack(Item.sugar), new ItemStack(Item.wheat));
		GameRegistry.addShapelessRecipe(new ItemStack(Chocolate), new ItemStack(Item.dyePowder, 1, 3), new ItemStack(Item.dyePowder, 1, 3));
	}
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event)
	{
		server = ModLoader.getMinecraftServerInstance();
		ICommandManager commandManager = server.getCommandManager();
		ServerCommandManager serverCommandManager = ((ServerCommandManager) commandManager); 
		addCommands(serverCommandManager);
	}


}
