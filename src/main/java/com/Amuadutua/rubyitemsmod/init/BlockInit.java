package com.Amuadutua.rubyitemsmod.init;

import com.Amuadutua.rubyitemsmod.RubyItems;
import com.Amuadutua.rubyitemsmod.blocks.ExampleChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RubyItems.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Block> DEF_BLOCK = BLOCKS.register("def_block",
            () -> new Block(Block.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> EXAMPLE_CHEST = BLOCKS.register("example_chest",
            () -> new ExampleChestBlock(Block.Properties.from(BlockInit.DEF_BLOCK.get())));

}