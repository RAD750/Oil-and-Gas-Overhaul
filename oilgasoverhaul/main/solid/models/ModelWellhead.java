package oilgasoverhaul.main.solid.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWellhead extends ModelBase
{
  //fields
    ModelRenderer Faceplate1;
    ModelRenderer Faceplate2;
    ModelRenderer Faceplate3;
    ModelRenderer Faceplate4;
    ModelRenderer Riser;
    ModelRenderer Crossbrace;
    ModelRenderer DegasPipe1;
    ModelRenderer DegasPipe2;
    ModelRenderer DegasPipe3;
    ModelRenderer DegasPipe4;
    ModelRenderer DegasPipe5;
    ModelRenderer DegasPipe6;
    ModelRenderer Cap;
    ModelRenderer BOPCap;
    ModelRenderer BlowoutPreventer;
  
  public ModelWellhead()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Faceplate1 = new ModelRenderer(this, 0, 10);
      Faceplate1.addBox(0F, 0F, 0F, 8, 1, 8);
      Faceplate1.setRotationPoint(-4F, 8F, -4F);
      Faceplate1.setTextureSize(64, 32);
      Faceplate1.mirror = true;
      setRotation(Faceplate1, 0F, 0F, 0F);
      Faceplate2 = new ModelRenderer(this, 0, 0);
      Faceplate2.addBox(0F, 0F, 0F, 8, 1, 8);
      Faceplate2.setRotationPoint(-4F, 23F, -4F);
      Faceplate2.setTextureSize(64, 32);
      Faceplate2.mirror = true;
      setRotation(Faceplate2, 0F, 0F, 0F);
      Faceplate3 = new ModelRenderer(this, 33, 0);
      Faceplate3.addBox(0F, 0F, 0F, 8, 8, 1);
      Faceplate3.setRotationPoint(-4F, 12F, -8F);
      Faceplate3.setTextureSize(64, 32);
      Faceplate3.mirror = true;
      setRotation(Faceplate3, 0F, 0F, 0F);
      Faceplate4 = new ModelRenderer(this, 33, 10);
      Faceplate4.addBox(0F, 0F, 0F, 8, 8, 1);
      Faceplate4.setRotationPoint(-4F, 12F, 7F);
      Faceplate4.setTextureSize(64, 32);
      Faceplate4.mirror = true;
      setRotation(Faceplate4, 0F, 0F, 0F);
      Riser = new ModelRenderer(this, 52, 0);
      Riser.addBox(0F, 0F, 0F, 5, 14, 5);
      Riser.setRotationPoint(-2.5F, 9F, -2.5F);
      Riser.setTextureSize(64, 32);
      Riser.mirror = true;
      setRotation(Riser, 0F, 0F, 0F);
      Crossbrace = new ModelRenderer(this, 73, 0);
      Crossbrace.addBox(0F, 0F, 0F, 4, 4, 14);
      Crossbrace.setRotationPoint(-2F, 14F, -7F);
      Crossbrace.setTextureSize(64, 32);
      Crossbrace.mirror = true;
      setRotation(Crossbrace, 0F, 0F, 0F);
      DegasPipe1 = new ModelRenderer(this, 35, 24);
      DegasPipe1.addBox(0F, 0F, 0F, 4, 1, 1);
      DegasPipe1.setRotationPoint(2F, 14F, -6F);
      DegasPipe1.setTextureSize(64, 32);
      DegasPipe1.mirror = true;
      setRotation(DegasPipe1, 0F, 0F, 0F);
      DegasPipe2 = new ModelRenderer(this, 24, 20);
      DegasPipe2.addBox(0F, 0F, 0F, 1, 10, 1);
      DegasPipe2.setRotationPoint(6F, 5F, -6F);
      DegasPipe2.setTextureSize(64, 32);
      DegasPipe2.mirror = true;
      setRotation(DegasPipe2, 0F, 0F, 0F);
      DegasPipe3 = new ModelRenderer(this, 0, 20);
      DegasPipe3.addBox(0F, 0F, 0F, 1, 1, 10);
      DegasPipe3.setRotationPoint(6F, 5F, -5F);
      DegasPipe3.setTextureSize(64, 32);
      DegasPipe3.mirror = true;
      setRotation(DegasPipe3, 0F, 0F, 0F);
      DegasPipe4 = new ModelRenderer(this, 111, 0);
      DegasPipe4.addBox(0F, 0F, 0F, 1, 23, 1);
      DegasPipe4.setRotationPoint(6F, 1F, 5F);
      DegasPipe4.setTextureSize(64, 32);
      DegasPipe4.mirror = true;
      setRotation(DegasPipe4, 0F, 0F, 0F);
      DegasPipe5 = new ModelRenderer(this, 30, 21);
      DegasPipe5.addBox(0F, 0F, 0F, 1, 4, 1);
      DegasPipe5.setRotationPoint(0F, 10F, 5F);
      DegasPipe5.setTextureSize(64, 32);
      DegasPipe5.mirror = true;
      setRotation(DegasPipe5, 0F, 0F, 0F);
      DegasPipe6 = new ModelRenderer(this, 30, 27);
      DegasPipe6.addBox(0F, 0F, 0F, 6, 1, 1);
      DegasPipe6.setRotationPoint(0F, 9F, 5F);
      DegasPipe6.setTextureSize(64, 32);
      DegasPipe6.mirror = true;
      setRotation(DegasPipe6, 0F, 0F, 0F);
      Cap = new ModelRenderer(this, 36, 20);
      Cap.addBox(0F, 0F, 0F, 2, 1, 2);
      Cap.setRotationPoint(5.5F, 0F, 4.5F);
      Cap.setTextureSize(64, 32);
      Cap.mirror = true;
      setRotation(Cap, 0F, 0F, 0F);
      BOPCap = new ModelRenderer(this, 47, 20);
      BOPCap.addBox(0F, 0F, 0F, 2, 1, 1);
      BOPCap.setRotationPoint(-4F, 15F, -0.5F);
      BOPCap.setTextureSize(64, 32);
      BOPCap.mirror = true;
      setRotation(BOPCap, 0F, 0F, 0F);
      BlowoutPreventer = new ModelRenderer(this, 47, 20);
      BlowoutPreventer.addBox(0F, 0F, 0F, 4, 3, 3);
      BlowoutPreventer.setRotationPoint(-8F, 14F, -1.5F);
      BlowoutPreventer.setTextureSize(64, 32);
      BlowoutPreventer.mirror = true;
      setRotation(BlowoutPreventer, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Faceplate1.render(f5);
    Faceplate2.render(f5);
    Faceplate3.render(f5);
    Faceplate4.render(f5);
    Riser.render(f5);
    Crossbrace.render(f5);
    DegasPipe1.render(f5);
    DegasPipe2.render(f5);
    DegasPipe3.render(f5);
    DegasPipe4.render(f5);
    DegasPipe5.render(f5);
    DegasPipe6.render(f5);
    Cap.render(f5);
    BOPCap.render(f5);
    BlowoutPreventer.render(f5);
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