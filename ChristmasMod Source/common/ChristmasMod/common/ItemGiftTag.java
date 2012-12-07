package ChristmasMod.common;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import ChristmasMod.client.GuiGiftTag;

import net.minecraft.src.*;

public class ItemGiftTag extends Item
{

	private static Map<String, String> tagData = new HashMap<String, String>();
	
	public ItemGiftTag(int par1)
	{
		super(par1);
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		HashMap<String, String> loaded = (HashMap<String, String>) loadHashMap(par3World);
		if (loaded != null)
			tagData = loaded;
		if (ChristmasMod.isClient() && par1ItemStack.getItemDamage() == 0)
			ModLoader.openGUI(par2EntityPlayer, new GuiGiftTag(par1ItemStack, par2EntityPlayer, par3World, this));
        return true;
    }
	
	public int getUniqueID()
	{
		if (tagData == null)
				return 1;
		else
			return tagData.keySet().toArray().length + 1;
	}
	
	public void setOrCreateData(int id, String user)
	{
		tagData.put(id + "", user);
	}
	
	public String getUserFromID(int id)
	{
		return (String) tagData.get(id);
	}
	
	public String getTextureFile()
	{
		return "/ChristmasMod/item.png";
	}
	
	public Map<String, String> loadHashMap(World world)
    {
    	try {
			world.checkSessionLock();
		} catch (MinecraftException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String moder = null;
    		File file = new File ("" + ModLoader.getMinecraftInstance().getMinecraftDir() + "/saves/" + world.getSaveHandler().getSaveDirectoryName() + "","xmas.dat");
    	if (!file.exists()) {
    		saveHashMap(this.tagData, world);
    		return null;}
    	Path path = (Path) Paths.get(file.getAbsolutePath());
    	Charset ENCODING = StandardCharsets.UTF_8;
    	try {
			moder = Files.readAllLines((java.nio.file.Path) path, ENCODING).toString();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	String str = moder;
    	Properties props = new Properties();
    	try {
			props.load(new StringReader(str.substring(1, str.length() - 1).replace(", ", "\n")));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}       
    	Map<String, String> map2 = new HashMap<String, String>();
    	for (Map.Entry<Object, Object> e : props.entrySet()) {
    	    map2.put((String)e.getKey(), (String)e.getValue());
    	}
    	return map2;
    }
    
    private static void saveHashMap(Map map, World world) {
    	try {
    	File file = new File(ModLoader.getMinecraftInstance().getMinecraftDir() + "/saves/" + world.getSaveHandler().getSaveDirectoryName() + "","xtags.dat");
    	System.out.println("FILE: " + file);
    	if (!file.exists()) {
    	file.mkdirs();
    	file.createNewFile();
    	}
    	FileWriter fstream = new FileWriter(ModLoader.getMinecraftInstance().getMinecraftDir() + "/saves/" + world.getSaveHandler().getSaveDirectoryName() + "xtags.dat");
    	  BufferedWriter out = new BufferedWriter(fstream);
    	  out.write(map.toString());
    	  out.close();
    	}
    	catch(Exception exception) {
    	exception.printStackTrace();
    	}
    }

}
