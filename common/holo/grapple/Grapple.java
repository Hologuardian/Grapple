package holo.grapple;

import holo.grapple.proxy.CommonProxy;
import holo.grapple.utils.lib.Utils;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Utils.MOD_ID, name = Utils.MOD_ID)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Grapple
{
    @Instance(Utils.MOD_ID)
    public static Grapple instance;

    @SidedProxy(clientSide = Utils.CLIENT_PROXY, serverSide = Utils.COMMON_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        instance = this;
        proxy.configRegistry(event);
        proxy.init();
        proxy.initClient();
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {}

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {

    }

    @EventHandler
    public void serverStarting(final FMLServerStartingEvent event)
    {}
}