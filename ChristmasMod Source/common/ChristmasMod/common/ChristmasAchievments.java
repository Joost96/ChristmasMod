package ChristmasMod.common;

import net.minecraft.src.*;
import net.minecraftforge.common.AchievementPage;

public class ChristmasAchievments 
{
	public static Achievement achCraftGift = new Achievement(2545, "Time To Wrap This Up", 10, 10, ChristmasMod.PresentS, null).registerAchievement();
	public static Achievement achGive = new Achievement(2545, "Better to Give...", 10, 20, ChristmasMod.PresentM, achCraftGift).registerAchievement();
	public static Achievement achReceive = new Achievement(2545, "...Than to Receive", 20, 30, ChristmasMod.PresentB, achGive).registerAchievement();
	public static Achievement achStocking = new Achievement(2545, "Stocking Stuffer", 0, 30, ChristmasMod.Stocking, achGive).registerAchievement();
	public static Achievement achNaughty = new Achievement(2545, "On the Naughty List", 0, 0, ChristmasMod.Helmet, null).registerAchievement();
	
	public static AchievementPage xmasAchPage = new AchievementPage("Christmas", achCraftGift, achGive, achReceive, achStocking, achNaughty);
	public static void register()
	{
		AchievementPage.registerAchievementPage(xmasAchPage);
	}
}
