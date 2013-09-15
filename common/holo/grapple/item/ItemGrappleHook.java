package holo.grapple.item;

import holo.grapple.entity.mob.EntityHook;
import holo.grapple.utils.lib.Utils;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrappleHook extends Item
{
    public ItemGrappleHook(final int id)
    {
        super(id);
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer player)
    {

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / ((itemRand.nextFloat() * 0.4F) + 0.8F));

        if (!world.isRemote)
        {
            destroyHooks(world, player);

            EntityHook entity = new EntityHook(world, player);
            world.spawnEntityInWorld(entity);
            stack.getTagCompound().setBoolean(Utils.LAUNCHER_ACTIVE, true);
        }
        return stack;
    }

    private void destroyHooks(final World world, final EntityPlayer player)
    {
        List<EntityThrowable> entitys = world.getEntitiesWithinAABB(EntityHook.class, player.boundingBox.expand(128.0F, 128.0F, 128.0F));
        if (!entitys.isEmpty())
        {
            for (EntityThrowable hook : entitys)
            {
                if (hook.getThrower() instanceof EntityPlayer)
                {
                    EntityPlayer thrower = (EntityPlayer) hook.getThrower();
                    if (thrower.username.equalsIgnoreCase(player.username))
                    {
                        hook.setDead();
                    }
                }
            }
        }
    }
}