package com.jup.consumablesandcharms.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class ConsumablesAndCharmsItemGroup extends ItemGroup
{
    public static final ItemGroup MAIN = new ConsumablesAndCharmsItemGroup("consumablesandcharms", () -> new ItemStack(ConsumablesAndCharmsItems.candycicle));
    
    private final Supplier<ItemStack> icon;
    
    public ConsumablesAndCharmsItemGroup(String label, Supplier<ItemStack> icon)
    {
        super(label);
        this.icon = icon;
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack createIcon()
    {
        return icon.get();
    }
}
