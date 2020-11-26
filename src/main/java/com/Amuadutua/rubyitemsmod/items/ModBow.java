package com.Amuadutua.rubyitemsmod.items;

import java.util.function.Predicate;

import com.Amuadutua.rubyitemsmod.entities.projectiles.TorchArrowEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class ModBow extends BowItem {
    public ModBow(Item.Properties builder) {
        super(builder);
        ItemModelsProperties.func_239418_a_(this, new ResourceLocation("pull"), (stack, world, player) -> {
            if (player == null) {
                return 0.0F;
            } else {
                return player.getActiveItemStack() != stack ? 0.0F : (float)(stack.getUseDuration() - player.getItemInUseCount()) / 20.0F;
            }
        });
        ItemModelsProperties.func_239418_a_(this, new ResourceLocation("pulling"), (stack, world, player) -> {
            return player != null && player.isHandActive() && player.getActiveItemStack() == stack ? 1.0F : 0.0F;
        });
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            boolean hasInfinity = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = playerentity.findAmmo(stack);

            int i = this.getUseDuration(stack) - timeLeft;
            i = ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i, !itemstack.isEmpty() || hasInfinity);
            if (i < 0) return;

            if (!itemstack.isEmpty() || hasInfinity) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getArrowVelocity(i);
                if (!((double)f < 0.1D)) {
                    boolean isTippedArrow = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
                    if (!worldIn.isRemote) {
                        ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrowEntity arrowEntity = createArrow(worldIn, itemstack, playerentity, arrowitem);
                        arrowEntity = customArrow(arrowEntity);
                        arrowEntity.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            arrowEntity.setIsCritical(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                        if (j > 0) {
                            arrowEntity.setDamage(arrowEntity.getDamage() + (double)j * 0.5D + 0.5D);
                        }

                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                        if (k > 0) {
                            arrowEntity.setKnockbackStrength(k);
                        }

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                            arrowEntity.setFire(100);
                        }

                        stack.damageItem(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                        });

                        if (hasInfinity && !isTippedArrow) {
                            arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        if (hasInfinity || playerentity.abilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                            arrowEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
                        }

                        worldIn.addEntity(arrowEntity);
                    }

                    worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!hasInfinity && !playerentity.abilities.isCreativeMode) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            playerentity.inventory.deleteStack(itemstack);
                        }
                    }

                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    // override to use a custom arrow entity
    protected AbstractArrowEntity createArrow(World worldIn, ItemStack ammoStack, PlayerEntity playerentity, ArrowItem arrowItem) {
        return new TorchArrowEntity(worldIn, playerentity);
    }

    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, bowStack);

        if (powerLevel > 0) return arrowEntity.getDamage() + (double)powerLevel * 0.5D + 0.5D;
        else return arrowEntity.getDamage();
    }

    protected int getArrowKnockback(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        return EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, bowStack);
    }

    // Override to change what it uses as ammo
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (ammoStack) -> {
            return ammoStack.getItem().isIn(ItemTags.ARROWS);
        };
    }
}
