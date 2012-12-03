package ChristmasMod.client;

import net.minecraft.src.*;

public class ModelLights extends ModelBase
{
  //fields
    ModelRenderer Cord;
    ModelRenderer Light1;
    ModelRenderer Light2;
    ModelRenderer Light3;
    ModelRenderer Shape1;
  
  public ModelLights()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Cord = new ModelRenderer(this, 0, 0);
      Cord.addBox(0F, 0F, 0F, 16, 1, 1);
      Cord.setRotationPoint(-8F, 9F, 7F);
      Cord.setTextureSize(64, 32);
      Cord.mirror = true;
      setRotation(Cord, 0F, 0F, 0F);
      Light1 = new ModelRenderer(this, 0, 2);
      Light1.addBox(0F, 0F, 0F, 2, 2, 2);
      Light1.setRotationPoint(-7F, 10F, 6F);
      Light1.setTextureSize(64, 32);
      Light1.mirror = true;
      setRotation(Light1, 0F, 0F, 0F);
      Light2 = new ModelRenderer(this, 8, 2);
      Light2.addBox(0F, 0F, 0F, 2, 2, 2);
      Light2.setRotationPoint(-3F, 10F, 6F);
      Light2.setTextureSize(64, 32);
      Light2.mirror = true;
      setRotation(Light2, 0F, 0F, 0F);
      Light3 = new ModelRenderer(this, 0, 2);
      Light3.addBox(0F, 0F, 0F, 2, 2, 2);
      Light3.setRotationPoint(1F, 10F, 6F);
      Light3.setTextureSize(64, 32);
      Light3.mirror = true;
      setRotation(Light3, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 16, 2);
      Shape1.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape1.setRotationPoint(5F, 10F, 6F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    Cord.render(f5);
    Light1.render(f5);
    Light2.render(f5);
    Light3.render(f5);
    Shape1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
