package net.lin.magicgemsmod.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.lin.magicgemsmod.MagicGemsMod;
import net.lin.magicgemsmod.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs(){
        registerFuels();
    }
    public static void registerFuels(){
        MagicGemsMod.LOGGER.info("Registering Mod Items for"+ MagicGemsMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;
        registry.add(ModItems.MIDDLE_LEVEL_COAL,2000);
        registry.add(ModItems.HIGH_LEVEL_COAL,3000);

    }
}
