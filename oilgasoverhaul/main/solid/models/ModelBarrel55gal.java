package oilgasoverhaul.main.solid.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBarrel55gal extends ModelBase
{
	 //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape2a;
    ModelRenderer Shape3a;
    ModelRenderer Shape4a;
    ModelRenderer Shape5a;
  
  public ModelBarrel55gal()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 16, 6);
      Shape1.setRotationPoint(-8F, 8F, -3F);
      Shape1.setTextureSize(128, 128);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 27);
      Shape2.addBox(0F, 0F, 0F, 14, 16, 2);
      Shape2.setRotationPoint(-7F, 8F, 3F);
      Shape2.setTextureSize(128, 128);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 47);
      Shape3.addBox(0F, 0F, 0F, 12, 16, 1);
      Shape3.setRotationPoint(-6F, 8F, 5F);
      Shape3.setTextureSize(128, 128);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 78);
      Shape4.addBox(0F, 0F, 0F, 10, 16, 1);
      Shape4.setRotationPoint(-5F, 8F, 6F);
      Shape4.setTextureSize(128, 128);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 103);
      Shape5.addBox(0F, 0F, 0F, 6, 16, 1);
      Shape5.setRotationPoint(-3F, 8F, 7F);
      Shape5.setTextureSize(128, 128);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape2a = new ModelRenderer(this, 0, 27);
      Shape2a.addBox(0F, 0F, 0F, 14, 16, 2);
      Shape2a.setRotationPoint(-7F, 8F, -5F);
      Shape2a.setTextureSize(128, 128);
      Shape2a.mirror = true;
      setRotation(Shape2a, 0F, 0F, 0F);
      Shape3a = new ModelRenderer(this, 0, 47);
      Shape3a.addBox(0F, 0F, 0F, 12, 16, 1);
      Shape3a.setRotationPoint(-6F, 8F, -6F);
      Shape3a.setTextureSize(128, 128);
      Shape3a.mirror = true;
      setRotation(Shape3a, 0F, 0F, 0F);
      Shape4a = new ModelRenderer(this, 0, 78);
      Shape4a.addBox(0F, 0F, 0F, 10, 16, 1);
      Shape4a.setRotationPoint(-5F, 8F, -7F);
      Shape4a.setTextureSize(128, 128);
      Shape4a.mirror = true;
      setRotation(Shape4a, 0F, 0F, 0F);
      Shape5a = new ModelRenderer(this, 0, 103);
      Shape5a.addBox(0F, 0F, 0F, 6, 16, 1);
      Shape5a.setRotationPoint(-3F, 8F, -8F);
      Shape5a.setTextureSize(128, 128);
      Shape5a.mirror = true;
      setRotation(Shape5a, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape2a.render(f5);
    Shape3a.render(f5);
    Shape4a.render(f5);
    Shape5a.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}