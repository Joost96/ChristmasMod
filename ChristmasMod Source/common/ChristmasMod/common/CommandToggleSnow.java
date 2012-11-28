package ChristmasMod.common;

import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;

public class CommandToggleSnow  extends CommandBase
{
	@Override
    public String getCommandName()
    {
        return "togglesnow";
    }

    /**
     * Return the required permission level for this command.
     */
	//@Override
   // public int getRequiredPermissionLevel()
   // {
    //    return 5;
   // }
	public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender)
    {
    	return true;
    }

	@Override
	public void processCommand(ICommandSender par1ICommandSender, String[] var2) {
		this.togglesnow();
        notifyAdmins(par1ICommandSender, "Eternal snow is toggled", new Object[0]);
		
	}

	protected void togglesnow() {
		if (ChristmasMod.SetSnow == true)
		{
		ChristmasMod.SetSnow = false;
		}
		if (ChristmasMod.SetSnow == false)
		{
		ChristmasMod.SetSnow = true;
		}
		
	}
}