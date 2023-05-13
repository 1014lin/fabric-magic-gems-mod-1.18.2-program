package net.lin.magicgemsmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lin.magicgemsmod.MagicGemsMod;
import net.lin.magicgemsmod.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item RUBY_NECKLACE = registerItem("ruby_necklace",
            new RubyNeckLaceItem(new Item.Settings().group(ModItemGroup.mod)));
    public static final Item SAPPHIRE_NECKLACE = registerItem("sapphire_necklace",
            new SapphireNeckLaceItem(new Item.Settings().group(ModItemGroup.mod)));
    public static final Item CITRINE_NECKLACE = registerItem("citrine_necklace",
            new CitrineNeckLaceItem(new Item.Settings().group(ModItemGroup.mod)));
    public static final Item RUBY_STAFF = registerItem("ruby_staff",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item CITRINE_SWORD = registerItem("citrine_sword",
            new SwordItem(ModToolMaterials.SAPPHIRE,3,2.5f,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item ZIRCON_SWORD = registerItem("zircon_sword",
            new ModKillnessSwordItem(ModToolMaterials.ZIRCON,6,4f,new FabricItemSettings().group(ModItemGroup.mod)));

    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe",
            new ModAxeItem(ModToolMaterials.SAPPHIRE,4,1.0f,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe",
            new ModHoeItem(ModToolMaterials.SAPPHIRE,1,1.0f,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe",
            new ModPickaxeItem(ModToolMaterials.SAPPHIRE,1,1.0f,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel",
            new ShovelItem(ModToolMaterials.SAPPHIRE,1,1.2f,new FabricItemSettings().group(ModItemGroup.mod)));

    public static final Item CITRINE = registerItem("citrine",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item RUBY = registerItem("ruby",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SAPPHIRE = registerItem("sapphire",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item ZIRCON = registerItem("zircon",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item MIDDLE_LEVEL_COAL = registerItem("middle_level_coal",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item HIGH_LEVEL_COAL = registerItem("high_level_coal",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item STRENGTHEN_ENHANCER = registerItem("strengthen_enhancer",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SILVER_INGOT = registerItem("silver_ingot",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item RAW_SILVER = registerItem("raw_silver",new Item(new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium",new Item(new FabricItemSettings().group(ModItemGroup.mod)));

    public static final Item SILVER_HELMET = registerItem("silver_helmet",
            new ArmorItem(ModArmorMaterials.SILVER, EquipmentSlot.HEAD,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
            new ArmorItem(ModArmorMaterials.SILVER,EquipmentSlot.CHEST,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SILVER_LEGGINGS = registerItem("silver_leggings",
            new ArmorItem(ModArmorMaterials.SILVER,EquipmentSlot.LEGS,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item SILVER_BOOTS = registerItem("silver_boots",
            new ArmorItem(ModArmorMaterials.SILVER,EquipmentSlot.FEET,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item TITANIUM_HELMET = registerItem("titanium_helmet",
            new ModArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.HEAD,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item TITANIUM_CHESTPLATE = registerItem("titanium_chestplate",
            new ArmorItem(ModArmorMaterials.TITANIUM,EquipmentSlot.CHEST,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item TITANIUM_LEGGINGS = registerItem("titanium_leggings",
            new ArmorItem(ModArmorMaterials.TITANIUM,EquipmentSlot.LEGS,new FabricItemSettings().group(ModItemGroup.mod)));
    public static final Item TITANIUM_BOOTS = registerItem("titanium_boots",
            new ArmorItem(ModArmorMaterials.TITANIUM,EquipmentSlot.FEET,new FabricItemSettings().group(ModItemGroup.mod)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MagicGemsMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        MagicGemsMod.LOGGER.info("Registering Mod Items for "+ MagicGemsMod.MOD_ID);
    }
}
