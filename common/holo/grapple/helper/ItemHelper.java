package holo.grapple.helper;

import holo.grapple.item.ItemGrappleHook;

import net.minecraft.item.Item;

public class ItemHelper
{
    public static Item grappleHook;

    public static void init()
    {
        grappleHook = new ItemGrappleHook(ConfigHelper.grappleHookID).setFull3D().setUnlocalizedName("grappleHook");
    }
}
