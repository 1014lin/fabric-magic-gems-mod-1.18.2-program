package net.lin.magicgemsmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lin.magicgemsmod.MagicGemsMod;
import net.lin.magicgemsmod.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {


    public static final Block TITANIUM_ORE =registerBlock("titanium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()),ModItemGroup.mod);
    public static final Block SILVER_ORE =registerBlock("silver_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()),ModItemGroup.mod);
    public static final Block RUBY_ORE =registerBlock("ruby_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),ModItemGroup.mod);
    public static final Block CITRINE_ORE =registerBlock("citrine_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),ModItemGroup.mod);
    public static final Block SAPPHIRE_ORE =registerBlock("sapphire_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),ModItemGroup.mod);
    public static final Block MIDDLE_LEVEL_COAL_ORE =registerBlock("middle_level_coal_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool()),ModItemGroup.mod);
    public static final Block STRENGTHEN_ENHANCER_ORE =registerBlock("strengthen_enhancer_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),ModItemGroup.mod);
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MagicGemsMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MagicGemsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks(){
        MagicGemsMod.LOGGER.info("Registering ModBlocks For"+ MagicGemsMod.MOD_ID);
    }
}
