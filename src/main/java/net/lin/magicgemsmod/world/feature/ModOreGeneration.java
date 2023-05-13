package net.lin.magicgemsmod.world.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.lin.magicgemsmod.block.ModBlocks;
import net.lin.magicgemsmod.world.feature.ore.ModOreFeatures;
import net.minecraft.block.Block;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ModOreGeneration {

    public static void generateOres() {
        generator("citrine_ore", new OreGenerationReference(
                List.of(new Pair<>(ModBlocks.CITRINE_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES)),
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                10, // Vein Size
                16, // Veins Per Chunk
                HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-40), YOffset.aboveBottom(40))
                // HeightRangePlacementModifier 有很多不同種的生成分布方式。像 trapezoid 就是梯形分布，上下最少，中間最多
        ));
        generator("ruby_ore", new OreGenerationReference(
                List.of(new Pair<>(ModBlocks.RUBY_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES)),
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                10, // Vein Size
                16, // Veins Per Chunk
                HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
                // HeightRangePlacementModifier 有很多不同種的生成分布方式。像 trapezoid 就是梯形分布，上下最少，中間最多
        ));
        generator("sapphire_ore", new OreGenerationReference(
                List.of(new Pair<>(ModBlocks.SAPPHIRE_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES)),
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                10, // Vein Size
                16, // Veins Per Chunk
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
                // HeightRangePlacementModifier 有很多不同種的生成分布方式。像 trapezoid 就是梯形分布，上下最少，中間最多
        ));
        generator("silver_ore", new OreGenerationReference(
                List.of(new Pair<>(ModBlocks.SILVER_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES)),
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                20, // Vein Size
                16, // Veins Per Chunk
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
                // HeightRangePlacementModifier 有很多不同種的生成分布方式。像 trapezoid 就是梯形分布，上下最少，中間最多
        ));
        generator("titanium_ore", new OreGenerationReference(
                List.of(new Pair<>(ModBlocks.TITANIUM_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES)),
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                5, // Vein Size
                16, // Veins Per Chunk
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
                // HeightRangePlacementModifier 有很多不同種的生成分布方式。像 trapezoid 就是梯形分布，上下最少，中間最多
        ));
        generator("strengthen_enhancer_ore", new OreGenerationReference(
                List.of(new Pair<>(ModBlocks.STRENGTHEN_ENHANCER_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES)),
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                15, // Vein Size
                16, // Veins Per Chunk
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
                // HeightRangePlacementModifier 有很多不同種的生成分布方式。像 trapezoid 就是梯形分布，上下最少，中間最多
        ));
        generator("middle_level_coal_ore", new OreGenerationReference(
                List.of(new Pair<>(ModBlocks.MIDDLE_LEVEL_COAL_ORE, OreConfiguredFeatures.STONE_ORE_REPLACEABLES)),
                BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                17, // Vein Size
                16, // Veins Per Chunk
                HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
                // HeightRangePlacementModifier 有很多不同種的生成分布方式。像 trapezoid 就是梯形分布，上下最少，中間最多
        ));
    }

    public record OreGenerationReference(List<Pair<Block, RuleTest>> BRP_list, Predicate<BiomeSelectionContext> biomeSelection,
                                         GenerationStep.Feature step, int veinSize, int veinsPerChunk,
                                         HeightRangePlacementModifier modifier) {}

    public static void generator(String name, OreGenerationReference ref) {
        List<OreFeatureConfig.Target> list = new ArrayList<>();
        for (Pair<Block, RuleTest> p : ref.BRP_list)
            list.add(OreFeatureConfig.createTarget(p.getRight(), p.getLeft().getDefaultState()));

        RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORE =
                ConfiguredFeatures.register(name, Feature.ORE, new OreFeatureConfig(list, ref.veinSize));

        RegistryEntry<PlacedFeature> ORE_PLACED = PlacedFeatures.register(name + "_placed", ORE,
                ModOreFeatures.modifiersWithCount(ref.veinsPerChunk, ref.modifier));

        BiomeModifications.addFeature(ref.biomeSelection, ref.step, ORE_PLACED.getKey().get());
    }

    // utilities
    private static List<Pair<Block, RuleTest>> getOverworldList(Block block) {
        return List.of(new Pair<>(block, OreConfiguredFeatures.STONE_ORE_REPLACEABLES));
    }
    private static final HeightRangePlacementModifier huAll = HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.TOP);
}
