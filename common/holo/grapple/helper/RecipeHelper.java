package holo.grapple.helper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ItemHelper.grappleHook, 1), new Object[]
        { " xz", "xzx", "xzx", 'x', Item.ingotIron, 'z', Item.silk });
    }
}
