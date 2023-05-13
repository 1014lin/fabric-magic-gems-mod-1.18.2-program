package net.lin.magicgemsmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.lin.magicgemsmod.MagicGemsMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup mod = FabricItemGroupBuilder.build(new Identifier(MagicGemsMod.MOD_ID,"mod"),
            () -> new ItemStack(ModItems.CITRINE));
}
