package net.lin.magicgemsmod.potion;

import net.lin.magicgemsmod.MagicGemsMod;
import net.lin.magicgemsmod.item.ModItems;
import net.lin.magicgemsmod.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion KILL_POTION;

    public static Potion registerPotion(String name){
        return Registry.register(Registry.POTION,new Identifier(MagicGemsMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,200,10)));
    }

    public static void registerPotions(){
        KILL_POTION = registerPotion("kill_potion");
        registerPotionRecipes();
    }
    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.ZIRCON,
                ModPotions.KILL_POTION);
    }
}
