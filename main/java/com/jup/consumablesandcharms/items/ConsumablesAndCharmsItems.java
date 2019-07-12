package com.jup.consumablesandcharms.items;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.items.foods.ItemCandycicle;
import com.jup.consumablesandcharms.items.foods.ItemHolyCow;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ConsumablesAndCharmsItems
{
    public static Item candycicle;
    public static Item holyCow;
    public static Food carot;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        registry.register(candycicle = new ItemCandycicle(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.candycicle)).setRegistryName(location("candycicle")));
        registry.register(holyCow = new ItemHolyCow(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.holyCow)).setRegistryName(location("holy_cow")));
    }
    
    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(ConsumablesAndCharms.MOD_ID, name);
    }
}
