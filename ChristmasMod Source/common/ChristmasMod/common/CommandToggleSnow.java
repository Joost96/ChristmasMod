package ChristmasMod.common;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldServer;

public class CommandToggleSnow  extends CommandBase
{
	@Override
    public String getCommandName()
    {
        return "togglesnow";
    }
	
	public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender)
    {
    	return true;
    }

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] var2) {
		this.togglesnow();
        notifyAdmins(par1ICommandSender, "Eternal snow is set to "+ ChristmasMod.SetSnow ,  new Object[0]);
		
	}

	protected void togglesnow() {
		if (ChristmasMod.SetSnow == true)
		{
		ChristmasMod.SetSnow = false;
		WorldServer var4 = MinecraftServer.getServer().worldServers[0];
		WorldInfo var5 = var4.getWorldInfo();
		var5.setRaining(false);
		}
		else if (ChristmasMod.SetSnow == false)
		{
		ChristmasMod.SetSnow = true;
		}
		
	}
}