package com.Amuadutua.rubyitemsmod.items;

import com.Amuadutua.rubyitemsmod.entities.projectiles.TorchArrowEntity;
import com.Amuadutua.rubyitemsmod.util.RegistryHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class TorchBow extends ModBow {
    public TorchBow(Properties builder) {
        super(builder);
    }


    @Override
    protected AbstractArrowEntity createArrow(World worldIn, ItemStack ammoStack, PlayerEntity playerentity, ArrowItem  arrowItem) {
        return new TorchArrowEntity(worldIn, playerentity);
    }
    @Override
    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, bowStack);

        return (double)powerLevel * 0.5D + 0.5D;
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (ammoStack) -> {
            return ammoStack.getItem() == RegistryHandler.BOMB_ARROW.get();
        };
    }
}