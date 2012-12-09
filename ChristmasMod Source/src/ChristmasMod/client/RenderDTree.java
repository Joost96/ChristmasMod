package ChristmasMod.client;

import org.lwjgl.opengl.GL11;

import ChristmasMod.common.TileDTree;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

public class RenderDTree extends TileEntitySpecialRenderer {
    
	private ModelDTree modelDTree = new ModelDTree();

	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float tick) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.bindTextureByName("/ChristmasMod/lightsstring.png");
		GL11.glPushMatrix();
		this.modelDTree.render(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}