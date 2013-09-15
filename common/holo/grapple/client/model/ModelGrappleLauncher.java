package holo.grapple.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGrappleLauncher extends ModelBase
{
    // fields
    ModelRenderer BarrelBottom;
    ModelRenderer BarrelLeft;
    ModelRenderer BarrelTop;
    ModelRenderer BarrelRight;
    ModelRenderer RidgeBL;
    ModelRenderer RidgeBR;
    ModelRenderer RidgeTL;
    ModelRenderer RidgeTR;
    ModelRenderer BackPanel;
    ModelRenderer ScopeBridge;
    ModelRenderer ScopeL;
    ModelRenderer ScopeR;
    ModelRenderer Handle;
    ModelRenderer HookHead;
    ModelRenderer HookRight;
    ModelRenderer HookLeft;
    ModelRenderer HookTop;
    ModelRenderer HookBottom;

    public ModelGrappleLauncher()
    {
        textureWidth = 128;
        textureHeight = 128;

        BarrelBottom = new ModelRenderer(this, 0, 0);
        BarrelBottom.addBox(-1F, 2F, -9F, 2, 1, 18);
        BarrelBottom.setRotationPoint(0F, 0F, 0F);
        BarrelBottom.setTextureSize(128, 128);
        BarrelBottom.mirror = true;
        setRotation(BarrelBottom, 0F, 0F, 0F);
        BarrelLeft = new ModelRenderer(this, 40, 0);
        BarrelLeft.addBox(-3F, -1F, -9F, 1, 2, 18);
        BarrelLeft.setRotationPoint(0F, 0F, 0F);
        BarrelLeft.setTextureSize(128, 128);
        BarrelLeft.mirror = true;
        setRotation(BarrelLeft, 0F, 0F, 0F);
        BarrelTop = new ModelRenderer(this, 0, 0);
        BarrelTop.addBox(-1F, -3F, -9F, 2, 1, 18);
        BarrelTop.setRotationPoint(0F, 0F, 0F);
        BarrelTop.setTextureSize(128, 128);
        BarrelTop.mirror = true;
        setRotation(BarrelTop, 0F, 0F, 0F);
        BarrelRight = new ModelRenderer(this, 40, 0);
        BarrelRight.addBox(2F, -1F, -9F, 1, 2, 18);
        BarrelRight.setRotationPoint(0F, 0F, 0F);
        BarrelRight.setTextureSize(128, 128);
        BarrelRight.mirror = true;
        setRotation(BarrelRight, 0F, 0F, 0F);
        RidgeBL = new ModelRenderer(this, 0, 20);
        RidgeBL.addBox(1F, 1F, 0F, 1, 1, 18);
        RidgeBL.setRotationPoint(0F, 0F, -9F);
        RidgeBL.setTextureSize(128, 128);
        RidgeBL.mirror = true;
        setRotation(RidgeBL, 0F, 0F, 0F);
        RidgeBR = new ModelRenderer(this, 0, 20);
        RidgeBR.addBox(-2F, 1F, 0F, 1, 1, 18);
        RidgeBR.setRotationPoint(0F, 0F, -9F);
        RidgeBR.setTextureSize(128, 128);
        RidgeBR.mirror = true;
        setRotation(RidgeBR, 0F, 0F, 0F);
        RidgeTL = new ModelRenderer(this, 0, 20);
        RidgeTL.addBox(1F, -2F, 0F, 1, 1, 18);
        RidgeTL.setRotationPoint(0F, 0F, -9F);
        RidgeTL.setTextureSize(128, 128);
        RidgeTL.mirror = true;
        setRotation(RidgeTL, 0F, 0F, 0F);
        RidgeTR = new ModelRenderer(this, 0, 20);
        RidgeTR.addBox(-2F, -2F, 0F, 1, 1, 18);
        RidgeTR.setRotationPoint(0F, 0F, -9F);
        RidgeTR.setTextureSize(128, 128);
        RidgeTR.mirror = true;
        setRotation(RidgeTR, 0F, 0F, 0F);
        BackPanel = new ModelRenderer(this, 50, 28);
        BackPanel.addBox(-2F, -2F, 0F, 4, 4, 1);
        BackPanel.setRotationPoint(0F, 0F, 8F);
        BackPanel.setTextureSize(128, 128);
        BackPanel.mirror = true;
        setRotation(BackPanel, 0F, 0F, 0F);
        ScopeBridge = new ModelRenderer(this, 39, 23);
        ScopeBridge.addBox(-2F, -3F, 0F, 4, 1, 1);
        ScopeBridge.setRotationPoint(0F, 0F, 0F);
        ScopeBridge.setTextureSize(128, 128);
        ScopeBridge.mirror = true;
        setRotation(ScopeBridge, 0F, 0F, 0F);
        ScopeL = new ModelRenderer(this, 39, 25);
        ScopeL.addBox(2F, -3F, -1F, 2, 2, 3);
        ScopeL.setRotationPoint(0F, 0F, 0F);
        ScopeL.setTextureSize(128, 128);
        ScopeL.mirror = true;
        setRotation(ScopeL, 0F, 0F, 0F);
        ScopeR = new ModelRenderer(this, 39, 25);
        ScopeR.addBox(-4F, -3F, -1F, 2, 2, 3);
        ScopeR.setRotationPoint(0F, 0F, 0F);
        ScopeR.setTextureSize(128, 128);
        ScopeR.mirror = true;
        setRotation(ScopeR, 0F, 0F, 0F);
        Handle = new ModelRenderer(this, 49, 23);
        Handle.addBox(-1F, 0F, -1F, 2, 3, 2);
        Handle.setRotationPoint(0F, 3F, 0F);
        Handle.setTextureSize(128, 128);
        Handle.mirror = true;
        setRotation(Handle, 0F, 0F, 0F);
        HookHead = new ModelRenderer(this, 51, 28);
        HookHead.addBox(-1F, -1F, -2F, 2, 2, 6);
        HookHead.setRotationPoint(0F, 0F, -10F);
        HookHead.setTextureSize(128, 128);
        HookHead.mirror = true;
        setRotation(HookHead, 0F, 0F, 0F);
        HookRight = new ModelRenderer(this, 51, 28);
        HookRight.addBox(-2F, -1F, -1F, 1, 2, 2);
        HookRight.setRotationPoint(0F, 0F, -10F);
        HookRight.setTextureSize(128, 128);
        HookRight.mirror = true;
        setRotation(HookRight, 0F, 0F, 0F);
        HookLeft = new ModelRenderer(this, 51, 28);
        HookLeft.addBox(1F, -1F, -1F, 1, 2, 2);
        HookLeft.setRotationPoint(0F, 0F, -10F);
        HookLeft.setTextureSize(128, 128);
        HookLeft.mirror = true;
        setRotation(HookLeft, 0F, 0F, 0F);
        HookTop = new ModelRenderer(this, 51, 28);
        HookTop.addBox(-1F, -2F, -1F, 2, 1, 2);
        HookTop.setRotationPoint(0F, 0F, -10F);
        HookTop.setTextureSize(128, 128);
        HookTop.mirror = true;
        setRotation(HookTop, 0F, 0F, 0F);
        HookBottom = new ModelRenderer(this, 51, 28);
        HookBottom.addBox(-1F, 1F, -1F, 2, 1, 2);
        HookBottom.setRotationPoint(0F, 0F, -10F);
        HookBottom.setTextureSize(128, 128);
        HookBottom.mirror = true;
        setRotation(HookBottom, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        BarrelBottom.renderWithRotation(f5);
        BarrelLeft.renderWithRotation(f5);
        BarrelTop.renderWithRotation(f5);
        BarrelRight.renderWithRotation(f5);
        RidgeBL.renderWithRotation(f5);
        RidgeBR.renderWithRotation(f5);
        RidgeTL.renderWithRotation(f5);
        RidgeTR.renderWithRotation(f5);
        BackPanel.renderWithRotation(f5);
        ScopeBridge.renderWithRotation(f5);
        ScopeL.renderWithRotation(f5);
        ScopeR.renderWithRotation(f5);
        Handle.renderWithRotation(f5);
        HookHead.renderWithRotation(f5);
        HookRight.renderWithRotation(f5);
        HookLeft.renderWithRotation(f5);
        HookTop.renderWithRotation(f5);
        HookBottom.renderWithRotation(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}
