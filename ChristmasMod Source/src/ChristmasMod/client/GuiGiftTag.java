package ChristmasMod.client;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import ChristmasMod.common.*;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class GuiGiftTag extends GuiScreen
{
	/**
     * This String is just a local copy of the characters allowed in text rendering of minecraft.
     */
    private static final String allowedCharacters = ChatAllowedCharacters.allowedCharacters;
	
	private GuiTextField inputTo;
    private GuiTextField inputFrom;
    private ItemStack itemTag;
    private ItemGiftTag giftTag;
    private EntityPlayer user;
    private World world;
    
    /**
     * Start the GUI, sets the info from the item
     * @param tagItem
     * @param player
     * @param par3World
     */
    public GuiGiftTag(ItemStack tagItem, EntityPlayer player, World par3World, ItemGiftTag tag)
    {
    	this.itemTag = tagItem;
    	this.user = player;
    	this.world = par3World;
    	this.giftTag = tag;
    	this.allowUserInput = true;
    }
    
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.controlList.clear();
        Keyboard.enableRepeatEvents(true);
        this.inputTo = new GuiTextField(this.fontRenderer, this.width / 2 - 100, this.height / 4 + 60, 100, 10);
        this.inputFrom = new GuiTextField(this.fontRenderer, this.width / 2 - 100, this.height / 4 + 85, 100, 10);
        this.controlList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Done"));
    }
    
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
    	Keyboard.enableRepeatEvents(false);
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
    	this.allowUserInput = true;
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "Edit Gift Tag Info", this.width / 2, 40, 16777215);
        this.inputTo.drawTextBox();
        this.inputTo.setVisible(true);
        this.inputFrom.drawTextBox();
        this.inputFrom.setVisible(true);
        this.inputFrom.setText(this.user.username);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.width / 2), 0.0F, 50.0F);
        float var4 = 93.75F;
        GL11.glScalef(-var4, -var4, -var4);
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        GL11.glPopMatrix();
        super.drawScreen(par1, par2, par3);
    }
    
    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
            if (par1GuiButton.id == 0)
            {
            	int id;
            	InventoryPlayer inv = this.user.inventory;
                if (this.itemTag.getItemDamage() == 0)
                	id = giftTag.getUniqueID();
                else id = this.itemTag.getItemDamage();
                this.giftTag.setOrCreateData(id, this.inputTo.getText());
            	if(inv.getCurrentItem().stackSize == 1)
                	inv.setInventorySlotContents(this.user.inventory.currentItem, new ItemStack(ChristmasMod.GiftTag, 1, id));
            	else
            	{
            		inv.setInventorySlotContents(this.user.inventory.currentItem, new ItemStack(ChristmasMod.GiftTag, inv.getCurrentItem().stackSize - 1, id));
            		this.user.dropPlayerItem(new ItemStack(ChristmasMod.GiftTag, 1, id));
            	}
                this.user.closeScreen();
            }
        }
    }
    
    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        if (par2 == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }
        else if (par2 == 14)
        {
        	String newText = this.inputTo.getText().substring(0, this.inputTo.getText().toString().length() - 1);
        	this.inputTo.setText(newText);
        }
        else if (allowedCharacters.indexOf(par1) >= 0)
        {
            this.inputTo.setText(this.inputTo.getText() + par1);
        }
    }
}
