package com.jup.consumablesandcharms.items.foods;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.potion.Effects.SLOWNESS;
import static net.minecraft.util.SoundEvents.BLOCK_GLASS_BREAK;

public class ItemCandycicle extends ItemFoodBase
{
    public ItemCandycicle(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity e) {
        if(e instanceof PlayerEntity)
        {
            List<Entity> entities = e.world.getEntitiesWithinAABBExcludingEntity(e, e.getBoundingBox().expand(10.0D, 10.0D, -10.0D).offset(-5, -5, 5));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof LivingEntity && !listEntity.world.isRemote())
                {
                    ((MonsterEntity) listEntity).addPotionEffect(new EffectInstance(SLOWNESS, 300, nbt.getInt("Tier")));
                    listEntity.playSound(BLOCK_GLASS_BREAK, 100, 1);
                    listEntity.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.ICE.getDefaultState()), listEntity.posX, listEntity.posY, listEntity.posZ, 0.0D, 0.0D, 0.0D);
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, e);
    }
}