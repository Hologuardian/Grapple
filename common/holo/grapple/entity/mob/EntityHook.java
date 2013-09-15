package holo.grapple.entity.mob;

import holo.grapple.item.ItemGrappleHook;
import holo.grapple.utils.helpers.NBTHelper;
import holo.grapple.utils.lib.Utils;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHook extends EntityThrowable
{
    public EntityLivingBase thrower = null;
    public Entity entityHit = null;
    public boolean hasCollided;
    private boolean hasEntityCollided;

    public EntityHook(final World world)
    {
        super(world);
    }

    public EntityHook(final World world, final EntityPlayer player)
    {
        super(world, player);
        thrower = player;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        EntityPlayer player = worldObj.getClosestPlayerToEntity(this, 64.0D);

        if ((player == null) || (player.getDistanceToEntity(this) > 64) || player.isSneaking())
        {
            setDead();
            for (ItemStack item : player.inventory.mainInventory)
            {
                if (item != null)
                {
                    if (item.getItem() instanceof ItemGrappleHook)
                    {
                        if (NBTHelper.getBoolean(item, Utils.LAUNCHER_ACTIVE))
                        {
                            NBTHelper.setBoolean(item, Utils.LAUNCHER_ACTIVE, false);
                        }
                    }
                }
            }
        }
        thrower = player;
        if (hasCollided)
        {
            moveEntities(this, player, 1.0F);
        } else if (hasEntityCollided)
        {
            entityHit = getClosestEntity(worldObj);

            moveEntities(player, entityHit, 1.0F);
            moveEntities(entityHit, this, 1.0F);

            if (entityHit.getDistanceToEntity(player) < 2)
            {
                setDead();
                return;
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(final MovingObjectPosition pos)
    {
        if ((pos.entityHit == null) && !hasEntityCollided)
        {
            if (worldObj.getBlockId(pos.blockX, pos.blockY, pos.blockZ) != 0)
            {
                hasCollided = true;

                motionX = 0;
                motionY = 0;
                motionZ = 0;
            }
        } else if (pos.entityHit != getThrower())
        {
            entityHit = pos.entityHit;
            hasCollided = false;
            hasEntityCollided = true;
            motionX = 0;
            motionY = 0;
            motionZ = 0;
        }
    }

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    @Override
    protected float getGravityVelocity()
    {
        return hasCollided || hasEntityCollided ? 0 : 0.03F;
    }

    public Entity getClosestEntity(final World world)
    {
        Entity retEnt = null;
        float entDist = Float.MAX_VALUE;
        @SuppressWarnings("unchecked")
        List<Entity> entityList = world.loadedEntityList;
        for (Entity entity : entityList)
        {
            if ((getDistanceToEntity(entity) < entDist) && !(entity instanceof EntityHook) && (entity != getThrower()) && !(entity instanceof EntityPlayer))
            {
                retEnt = entity;
                entDist = getDistanceToEntity(entity);
            }
        }

        return retEnt;
    }

    public void moveEntities(final Entity target, final Entity moving, final float speed)
    {
        if ((target == null) || (moving == null))
        {
            setDead();
            return;
        }
        double xDif = target.posX - moving.posX;
        double yDif = (target.posY - moving.posY) + moving.height;
        double zDif = target.posZ - moving.posZ;

        if (Math.abs(xDif) < ((moving.width) * speed))
        {
            xDif = 0;
        }
        if (Math.abs(yDif) < (0.1 * speed))
        {
            yDif = 0;
        }
        if (Math.abs(zDif) < ((moving.width) * speed))
        {
            zDif = 0;
        }

        double xV = Math.signum(xDif) * 0.10 * speed;
        double yV = Math.signum(yDif) * 0.15 * speed;
        double zV = Math.signum(zDif) * 0.10 * speed;

        moving.fallDistance = 0;
        moving.addVelocity(xV, yV, zV);
    }
}