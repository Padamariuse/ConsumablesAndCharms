package com.jup.consumablesandcharms.items.foods;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class ItemHolyCow extends ItemFoodBase
{
    public ItemHolyCow(Properties properties) {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity)
        {
            List<Entity> entities = entityLiving.world.getEntitiesWithinAABBExcludingEntity(entityLiving, entityLiving.getBoundingBox().expand(20.0D, 20.0D, -20.0D).offset(-10, -10, 10));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof LivingEntity)
                {
                    if(((LivingEntity) listEntity).isEntityUndead() && !listEntity.world.isRemote())
                    {
                        listEntity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 50.0F);
                    }
                    else if(nbt.getInt("Tier") > 1 && !listEntity.world.isRemote())
                    {
                        listEntity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 5.0F * nbt.getInt("Tier"));
                    }
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
