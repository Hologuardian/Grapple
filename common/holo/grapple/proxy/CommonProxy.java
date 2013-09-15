package holo.grapple.proxy;

import holo.grapple.helper.ConfigHelper;
import holo.grapple.helper.EntityHelper;
import holo.grapple.helper.ItemHelper;
import holo.grapple.helper.RecipeHelper;

import net.minecraftforge.common.Configuration;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void init()
    {
        ItemHelper.init();
        EntityHelper.init();
        RecipeHelper.init();
    }

    public void initClient()
    {}

    public void configRegistry(final FMLPreInitializationEvent event)
    {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        ConfigHelper.init(config);
        if (config.hasChanged())
        {
            config.save();
        }
    }
}
