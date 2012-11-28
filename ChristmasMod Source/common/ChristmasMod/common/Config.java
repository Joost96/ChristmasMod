package ChristmasMod.common;

import java.io.File;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;

public class Config 
{
		static Configuration configuration = new Configuration(new File(new File(".").getAbsolutePath(), "config/christmas.cfg"));
		public static int starID = configurationProperties();
		public static int chocoID;
		public static int caneID;
		public static int candyID;
		public static int doughID;
		public static int gingerID;
		public static int smPresID;
		public static int mdPresID;
		public static int lgPresID;
		public static int candleID;
		public static int lightID;
		public static int lightsID;
		public static int gLightID;
		public static int bLightID;
		public static int rLightID;
		public static int bellsID;
		public static int stockID;
	    public static int wreathID;
	    public static int sSuitID;
	    public static int bootsID;
	    public static int helmetID;
	    public static int plateID;
	    public static int legsID;
	    public static int configurationProperties()
	    {
	            configuration.load();
	            starID = Integer.parseInt(configuration.getBlock(Configuration.CATEGORY_BLOCK, "Star", 150).value);
	            chocoID = Integer.parseInt(configuration.getBlock(Configuration.CATEGORY_ITEM, "Chocolate", 5005).value);
	            caneID = Integer.parseInt(configuration.getBlock(Configuration.CATEGORY_ITEM, "CandyCane", 5006).value);
	            candyID = Integer.parseInt(configuration.getBlock(Configuration.CATEGORY_ITEM, "Candy", 5007).value);
	            doughID = Integer.parseInt(configuration.getBlock(Configuration.CATEGORY_ITEM, "Dough", 5008).value);
	            gingerID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "Gingerbread", 5009).value);
	            smPresID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "PresentS", 155).value);
	            mdPresID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "PresentM", 156).value);
	            lgPresID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "PresentB", 157).value);
	            candleID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "Candle", 161).value);
	            lightID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "Light", 5000).value);
	            lightsID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "Lights", 151).value);
	            gLightID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "GreenLights", 152).value);
	            bLightID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "BlueLights", 153).value);
	            rLightID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "RedLights", 154).value);
	            bellsID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "Bells", 158).value);
	            stockID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "Stocking", 159).value);
	            wreathID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_BLOCK, "Wreath", 160).value);
	            bootsID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "SantaBoots", 5001).value);
	            helmetID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "SantaHelm", 5002).value);
	            plateID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "SantaChest", 5003).value);
	            legsID = Integer.parseInt(configuration.getItem(Configuration.CATEGORY_ITEM, "SantaLegs", 5004).value);
	            configuration.save();
	            return starID;
	    }
}
