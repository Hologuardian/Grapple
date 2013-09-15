package holo.grapple.client.render;

import holo.grapple.entity.mob.EntityHook;
import holo.grapple.utils.lib.Utils;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGrappleHook extends Render
{
    private static final ResourceLocation texture = new ResourceLocation(Utils.MOD_ID, "textures/mob/Hook.png");

    /**
     * Actually renders the fishing line and hook
     */
    public void doRenderGrappleHook(final EntityHook entity, final double par2, final double par4, final double par6, final float par8, final float par9)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        bindEntityTexture(entity);
        Tessellator tessellator = Tessellator.instance;
        float f2 = 0;
        float f3 = 9 / 8;
        float f4 = 0;
        float f5 = 8 / 8;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.5F;
        GL11.glRotatef(180.0F - renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(0.0F - f7, 0.0F - f8, 0.0D, f2, f5);
        tessellator.addVertexWithUV(f6 - f7, 0.0F - f8, 0.0D, f3, f5);
        tessellator.addVertexWithUV(f6 - f7, 1.0F - f8, 0.0D, f3, f4);
        tessellator.addVertexWithUV(0.0F - f7, 1.0F - f8, 0.0D, f2, f4);
        tessellator.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();

        if (entity.thrower != null)
        {
            float f9 = entity.thrower.getSwingProgress(par9);
            float f10 = MathHelper.sin(MathHelper.sqrt_float(f9) * (float) Math.PI);
            Vec3 vec3 = entity.worldObj.getWorldVec3Pool().getVecFromPool(-0.38D, -0.15D, 0.6D);
            vec3.rotateAroundX((-(entity.thrower.prevRotationPitch + ((entity.thrower.rotationPitch - entity.thrower.prevRotationPitch) * par9)) * (float) Math.PI) / 180.0F);
            vec3.rotateAroundY((-(entity.thrower.prevRotationYaw + ((entity.thrower.rotationYaw - entity.thrower.prevRotationYaw) * par9)) * (float) Math.PI) / 180.0F);
            vec3.rotateAroundY(f10 * 0.5F);
            vec3.rotateAroundX(-f10 * 0.7F);
            double d3 = entity.thrower.prevPosX + ((entity.thrower.posX - entity.thrower.prevPosX) * par9) + vec3.xCoord;
            double d4 = entity.thrower.prevPosY + ((entity.thrower.posY - entity.thrower.prevPosY) * par9) + vec3.yCoord;
            double d5 = entity.thrower.prevPosZ + ((entity.thrower.posZ - entity.thrower.prevPosZ) * par9) + vec3.zCoord;
            double d6 = entity.thrower == Minecraft.getMinecraft().thePlayer ? 0.0D : (double) entity.thrower.getEyeHeight();

            if ((renderManager.options.thirdPersonView > 0) || (entity.thrower != Minecraft.getMinecraft().thePlayer))
            {
                float f11 = ((entity.thrower.prevRenderYawOffset + ((entity.thrower.renderYawOffset - entity.thrower.prevRenderYawOffset) * par9)) * (float) Math.PI) / 180.0F;
                double d7 = MathHelper.sin(f11);
                double d8 = MathHelper.cos(f11);
                d3 = (entity.thrower.prevPosX + ((entity.thrower.posX - entity.thrower.prevPosX) * par9)) - (d8 * 0.35D) - (d7 * 0.85D);
                d4 = (entity.thrower.prevPosY + d6 + ((entity.thrower.posY - entity.thrower.prevPosY) * par9)) - 0.45D;
                d5 = ((entity.thrower.prevPosZ + ((entity.thrower.posZ - entity.thrower.prevPosZ) * par9)) - (d7 * 0.35D)) + (d8 * 0.85D);
            }

            double d9 = entity.prevPosX + ((entity.posX - entity.prevPosX) * par9);
            double d10 = entity.prevPosY + ((entity.posY - entity.prevPosY) * par9) + 0.25D;
            double d11 = entity.prevPosZ + ((entity.posZ - entity.prevPosZ) * par9);
            double d12 = ((float) (d3 - d9));
            double d13 = ((float) (d4 - d10));
            double d14 = ((float) (d5 - d11));
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);
            tessellator.startDrawing(3);
            tessellator.setColorOpaque_I(0);
            byte b2 = 16;

            for (int i = 0; i <= b2; ++i)
            {
                float f12 = (float) i / (float) b2;
                tessellator.addVertex(par2 + (d12 * f12), par4 + (d13 * ((f12 * f12) + f12) * 0.5D) + 0.25D, par6 + (d14 * f12));
            }

            tessellator.draw();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then handing it off to a worker function which does the actual
     * work. In all probabilty, the class Render is generic (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1, double d2,
     * float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9)
    {
        doRenderGrappleHook((EntityHook) par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(final Entity entity)
    {
        return texture;
    }
}