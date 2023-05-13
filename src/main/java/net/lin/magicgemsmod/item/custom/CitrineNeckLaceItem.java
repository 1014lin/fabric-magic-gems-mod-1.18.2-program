package net.lin.magicgemsmod.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CitrineNeckLaceItem extends Item {
    public CitrineNeckLaceItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
       user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE,10000,5));
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,10000,5));
        return super.use(world, user, hand);
    }
}
