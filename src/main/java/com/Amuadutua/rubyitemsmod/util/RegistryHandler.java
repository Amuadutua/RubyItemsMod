package com.Amuadutua.rubyitemsmod.util;

import com.Amuadutua.rubyitemsmod.RubyItems;
import com.Amuadutua.rubyitemsmod.armor.ModArmorMaterial;
import com.Amuadutua.rubyitemsmod.blocks.*;
import com.Amuadutua.rubyitemsmod.items.ItemBase;
import com.Amuadutua.rubyitemsmod.items.ModBow;
import com.Amuadutua.rubyitemsmod.items.PoisonApple;
import com.Amuadutua.rubyitemsmod.items.TorchBow;
import com.Amuadutua.rubyitemsmod.tools.ModItemTier;
import com.Amuadutua.rubyitemsmod.tools.ModItemTier2;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.Amuadutua.rubyitemsmod.armor.ModArmorMaterial2;

public class RegistryHandler {

    // This tells the game what the ITEMS and BLOCKS is.
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RubyItems.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RubyItems.MOD_ID);

    // This registers the items and blocks.
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register( "ruby", ItemBase::new);
    public static final RegistryObject<Item> AMETHYST = ITEMS.register( "amethyst", ItemBase::new);
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register( "steel_ingot", ItemBase::new);
    public static final RegistryObject<PoisonApple> POISON_APPLE = ITEMS.register( "poison_apple", PoisonApple::new);

    // Tools
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register( "ruby_sword", () ->
            new SwordItem(ModItemTier.RUBY, 2, -2.4F, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<Item> RUBY_BOW = ITEMS.register( "ruby_bow", () ->
            new TorchBow(new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register( "ruby_pickaxe", () ->
            new PickaxeItem(ModItemTier.RUBY, 0, -2.8F, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register( "ruby_axe", () ->
            new AxeItem(ModItemTier.RUBY, 1, -2.6F, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register( "ruby_shovel", () ->
            new ShovelItem(ModItemTier.RUBY, 0, -2.8F, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<Item> BOMB_ARROW = ITEMS.register( "bomb_arrow", ItemBase::new);

    public static final RegistryObject<SwordItem> AMETHYST_SWORD = ITEMS.register( "amethyst_sword", () ->
            new SwordItem(ModItemTier2.AMETHYST, 2, -2.2F, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<PickaxeItem> AMETHYST_PICKAXE = ITEMS.register( "amethyst_pickaxe", () ->
            new PickaxeItem(ModItemTier2.AMETHYST, 0, -2.8F, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<AxeItem> AMETHYST_AXE = ITEMS.register( "amethyst_axe", () ->
            new AxeItem(ModItemTier2.AMETHYST, 1, -2.6F, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<ShovelItem> AMETHYST_SHOVEL = ITEMS.register( "amethyst_shovel", () ->
            new ShovelItem(ModItemTier2.AMETHYST, 0, -2.8F, new Item.Properties().group(RubyItems.TAB)));
    // Armor
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(RubyItems.TAB)));

   public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(RubyItems.TAB)));

   public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(RubyItems.TAB)));

   public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () ->
            new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(RubyItems.TAB)));

    public static final RegistryObject<ArmorItem> AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () ->
            new ArmorItem(ModArmorMaterial2.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(RubyItems.TAB)));

    public static final RegistryObject<ArmorItem> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate", () ->
            new ArmorItem(ModArmorMaterial2.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(RubyItems.TAB)));

    public static final RegistryObject<ArmorItem> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () ->
            new ArmorItem(ModArmorMaterial2.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(RubyItems.TAB)));

    public static final RegistryObject<ArmorItem> AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () ->
            new ArmorItem(ModArmorMaterial2.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(RubyItems.TAB)));
    public static final RegistryObject<SwordItem> HAMMER = ITEMS.register( "hammer", () ->
            new SwordItem(ModItemTier.RUBY, 4, -2.8F, new Item.Properties().group(RubyItems.TAB)));
    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register( "ruby_block", RubyBlock::new);
    public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register( "amethyst_block", AmethystBlock::new);
    public static final RegistryObject<Block> AMETHYST_ORE = BLOCKS.register( "amethyst_ore", AmethystOre::new);
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register( "ruby_ore", RubyOre::new);
    public static final RegistryObject<Block> STEEL_ORE = BLOCKS.register( "steel_ore", SteelOre::new);
    public static final RegistryObject<Block> OVEN = BLOCKS.register( "oven", Oven::new);
    public static final RegistryObject<Block> EXAMPLE_CHEST = BLOCKS.register( "example_chest", ExampleChest::new);


    // Block Items
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block", () -> new BlockItemBase(AMETHYST_BLOCK.get()));
    public static final RegistryObject<Item> AMETHYST_ORE_ITEM = ITEMS.register("amethyst_ore", () -> new BlockItemBase(AMETHYST_ORE.get()));
    public static final RegistryObject<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> new BlockItemBase(RUBY_ORE.get()));
    public static final RegistryObject<Item> STEEL_ORE_ITEM = ITEMS.register("steel_ore", () -> new BlockItemBase(STEEL_ORE.get()));
    public static final RegistryObject<Item> OVEN_ITEM = ITEMS.register("oven", () -> new BlockItemBase(OVEN.get()));
    public static final RegistryObject<Item> EXAMPLE_CHEST_ITEM = ITEMS.register("example_chest", () -> new BlockItemBase(EXAMPLE_CHEST.get()));
}
