package com.Amuadutua.rubyitemsmod.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonApple extends Item {

    public PoisonApple() {
        super(new Item.Properties()
            .group(ItemGroup.BREWING)
                .food(new Food.Builder()
                    .hunger(4)
                    .saturation(1.0F)
                    .effect(new EffectInstance(Effects.NAUSEA, 300, 3), 2.0F)
                    .effect(new EffectInstance(Effects.POISON, 500, 1), 2.0F)
                    .build()
                )



        );
    }
}
