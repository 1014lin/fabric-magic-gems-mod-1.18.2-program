package net.lin.magicgemsmod.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.lin.magicgemsmod.MagicGemsMod;
import net.lin.magicgemsmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.awt.*;

public class ModDimensions {
    public static final RegistryKey<World> LIN_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(MagicGemsMod.MOD_ID,"lin"));
    public static final RegistryKey<DimensionType> LIN_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, LIN_DIMENSION_KEY.getValue());

    public static void register(){
        MagicGemsMod.LOGGER.debug("Registering ModDimension for"+ MagicGemsMod.MOD_ID);

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.END_STONE)
                .destDimID(LIN_DIMENSION_KEY.getValue())
                .tintColor(50 ,145 ,30)
                .lightWithItem(ModItems.RUBY_STAFF)
                .flatPortal()
                .registerPortal();
    }
}
