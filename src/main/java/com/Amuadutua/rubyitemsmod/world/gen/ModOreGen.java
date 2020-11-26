package com.Amuadutua.rubyitemsmod.world.gen;

import com.Amuadutua.rubyitemsmod.RubyItems;
import com.Amuadutua.rubyitemsmod.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = RubyItems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            genOre(biome, 5, 0, 5, 30, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(), 7);
            genOre(biome, 3, 0, 5, 25, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.STEEL_ORE.get().getDefaultState(), 7);
            genOre(biome, 10, 0, 5, 55, OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.AMETHYST_ORE.get().getDefaultState(), 10);
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockstate, int size) {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockstate, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
