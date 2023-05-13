package net.lin.magicgemsmod;

import net.fabricmc.api.ModInitializer;
import net.lin.magicgemsmod.block.ModBlocks;
import net.lin.magicgemsmod.item.ModItems;
import net.lin.magicgemsmod.potion.ModPotions;
import net.lin.magicgemsmod.util.ModLootTableModifiers;
import net.lin.magicgemsmod.util.ModRegistries;
import net.lin.magicgemsmod.world.dimension.ModDimensions;
import net.lin.magicgemsmod.world.feature.ModOreGeneration;
import net.lin.magicgemsmod.world.feature.ore.ModOreFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicGemsMod implements ModInitializer {
	public static final String MOD_ID = "magicgemsmod";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModStuffs();
		ModDimensions.register();
		ModPotions.registerPotions();
		ModLootTableModifiers.modifyLootTables();
		ModOreGeneration.generateOres();
		LOGGER.info("Hello Fabric world!");
	}
}
