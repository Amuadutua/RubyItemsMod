package com.Amuadutua.rubyitemsmod.init;


import com.Amuadutua.rubyitemsmod.RubyItems;
import com.Amuadutua.rubyitemsmod.tileentity.QuarryTileEntity;

import com.Amuadutua.rubyitemsmod.util.RegistryHandler;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RubyItems.MOD_ID);

    public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry",
            () -> TileEntityType.Builder.create(QuarryTileEntity::new, RegistryHandler.QUARRY.get()).build(null));

}