package holo.grapple.proxy;

import holo.grapple.client.render.ItemRenderLauncher;
import holo.grapple.client.render.RenderGrappleHook;
import holo.grapple.entity.mob.EntityHook;
import holo.grapple.helper.ItemHelper;

import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void initClient()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityHook.class, new RenderGrappleHook());
        MinecraftForgeClient.registerItemRenderer(ItemHelper.grappleHook.itemID, new ItemRenderLauncher());
    }
}
