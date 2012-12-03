package ChristmasMod.client;

import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererLights extends TileEntitySpecialRenderer
{
	private ModelLights model = new ModelLights();
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.5F, (float)var6 + 0.5F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.bindTextureByName("/ChristmasMod/lightsstring.png");
		GL11.glPushMatrix();
		this.model.render(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
