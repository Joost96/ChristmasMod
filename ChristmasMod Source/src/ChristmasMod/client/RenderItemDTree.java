package ChristmasMod.client;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.ItemStack;
import net.minecraft.src.Tessellator;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

public class RenderItemDTree implements IItemRenderer {

	private ModelDTree DTreeModel;

	public RenderItemDTree() {
		DTreeModel = new ModelDTree();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case ENTITY: renderDTree(-0.5F, 0F, -0.5F); break;
			case EQUIPPED: renderDTree(0F, 0.4F, 0F); break;
			case INVENTORY: renderDTree(1F, 0.65F, 1F); break;
			default: break;
		}

	}

	private void renderDTree(float x, float y, float z)  {
		Tessellator tesselator = Tessellator.instance;
		ForgeHooksClient.bindTexture("lightsstring" , 0);
		GL11.glPushMatrix(); //start
			GL11.glTranslatef(x, y, z); //size
	        DTreeModel.render(0.0625F);
	    GL11.glPopMatrix(); //end
	}

}