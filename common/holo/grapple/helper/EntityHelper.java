package holo.grapple.helper;

import holo.grapple.Grapple;
import holo.grapple.entity.mob.EntityHook;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHelper
{
    public static void init()
    {
        EntityRegistry.registerModEntity(EntityHook.class, "GrappleHook", 0, Grapple.instance, 128, 40, true);
    }
}
