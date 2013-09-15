package holo.grapple.client.render;

import holo.grapple.client.model.ModelGrappleLauncher;
import holo.grapple.client.model.ModelGrappleLauncherNoHook;
import holo.grapple.util.Utils;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderLauncher implements IItemRenderer
{
    protected ResourceLocation launcherTexture = new ResourceLocation(Utils.MOD_ID, ":textures/model/GrappleLauncher.png");

    protected ModelGrappleLauncher launcherModelHook;

    protected ModelGrappleLauncherNoHook launcherModelNoHook;

    public ItemRenderLauncher()
    {
        launcherModelHook = new ModelGrappleLauncher();
        launcherModelNoHook = new ModelGrappleLauncherNoHook();
    }

    @Override
    public boolean handleRenderType(final ItemStack item, final ItemRenderType type)
    {
        if (type.equals(ItemRenderType.FIRST_PERSON_MAP))
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(final ItemRenderType type, final ItemStack item, final ItemRendererHelper helper)
    {
        return false;
    }

    @Override
    public void renderItem(final ItemRenderType type, final ItemStack item, final Object... data)
    {
        switch (type)
        {
            case EQUIPPED:
            {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(launcherTexture);

                GL11.glRotatef(150F, 90F, 25F, -90F);

                GL11.glTranslatef(0.0F, -0.15F, -0.6F);

                GL11.glScalef(1.0F, 1.0F, 1.0F);

                launcherModelHook.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
            }
            case EQUIPPED_FIRST_PERSON:
            {
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(launcherTexture);

                GL11.glRotatef(150F, 90F, 25F, -90F);

                GL11.glTranslatef(0.0F, -0.15F, -0.6F);

                GL11.glScalef(1.0F, 1.0F, 1.0F);

                launcherModelHook.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
            }
            case ENTITY:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(launcherTexture);

                GL11.glRotatef(150F, 90F, 25F, -90F);

                GL11.glTranslatef(0.0F, -0.15F, -0.6F);

                GL11.glScalef(1.0F, 1.0F, 1.0F);

                launcherModelHook.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
                break;
            case INVENTORY:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(launcherTexture);

                GL11.glRotatef(150F, 90F, 25F, -90F);

                GL11.glTranslatef(0.0F, -0.15F, -0.6F);

                GL11.glScalef(1.0F, 1.0F, 1.0F);

                launcherModelHook.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

                GL11.glPopMatrix();
                break;
            default:
                break;
        }
    }

}
