package ovh.feelzor.fleeinganimals.mixin;

import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ovh.feelzor.fleeinganimals.mixin.accessors.EscapeDangerGoalAccessor;


@Mixin(EscapeDangerGoal.class)
public class EscapeDangerGoalMixin {
    @Inject(at = @At(value = "TAIL"), method = "isInDanger()Z", cancellable = true)
    private void isInDanger(CallbackInfoReturnable<Boolean> cir) {
        /* To avoid bugs such as:
         *  - Nearby villagers being upset at the player
         *  - Nearby bees being angry at the player when the player attacks another species
         *
         * which all use mob.getAttacker() to determine angriness,
         *
         * The escape danger goal is modified to use the recent damage source.
         * This is consistent with the behavior of the escape danger goal in 1.21.0+.
         */
        DamageSource recentDamageSource = ((EscapeDangerGoalAccessor) this).getMob().getRecentDamageSource();
        if (recentDamageSource == null) return;

        boolean attackedByPlayer = recentDamageSource.getAttacker() instanceof PlayerEntity;
        cir.setReturnValue(cir.getReturnValue() || attackedByPlayer);
    }
}
