package holo.grapple.helper;

import net.minecraftforge.common.Configuration;

public class ConfigHelper
{
    public static int grappleHookID;

    public static void init(final Configuration config)
    {
        initItems(config);
    }

    public static void initItems(final Configuration config)
    {
        int itemID = 5500;
        grappleHookID = config.getItem("Grapple Hook", ++itemID).getInt();
    }
}