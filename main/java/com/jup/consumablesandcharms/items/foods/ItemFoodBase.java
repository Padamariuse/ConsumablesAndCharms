package com.jup.consumablesandcharms.items.foods;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFoodBase extends Item {
    CompoundNBT nbt;
    public ItemFoodBase(Properties properties) {
        super(properties);
    }
    
    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if(stack.hasTag())
        {
            nbt = stack.getTag();
        }
        else
        {
            nbt = new CompoundNBT();
        }
        
        if(nbt.contains("Tier"))
        {
            nbt.putInt("Tier", nbt.getInt("Tier") + 1);
        }
        else
        {
            nbt.putInt("Tier", 1);
        }
        
        super.onCreated(stack, worldIn, playerIn);
    }
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (stack.hasTag() && stack.getTag().contains("Tier"))
        {
            tooltip.add(item.tier + String.valueOf(stack.getTag().getInt("Tier")));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
