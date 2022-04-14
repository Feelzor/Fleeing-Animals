package ovh.feelzor.fleeinganimals.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static ovh.feelzor.fleeinganimals.FleeingAnimals.getConfig;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setAttacker(Lnet/minecraft/entity/LivingEntity;)V"), method = "damage(Lnet/minecraft/entity/damage/DamageSource;F)Z")
	private void propagateAttacker(DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
		// The method invokes setAttacker when attacker is known to be a LivingEntity.
		LivingEntity attacker = (LivingEntity) source.getAttacker();

		if (!((Object) this instanceof PassiveEntity thisPassiveMob)) return;

		Class<? extends PassiveEntity> afraidClass = (!getConfig().sameSpeciesOnly) ? PassiveEntity.class : thisPassiveMob.getClass();

		double d = thisPassiveMob.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE) * getConfig().radius;
		Box box = Box.from(thisPassiveMob.getPos()).expand(d, getConfig().yRadius, d);
		thisPassiveMob.world.getEntitiesByClass(afraidClass, box, EntityPredicates.EXCEPT_SPECTATOR).stream()
				.filter(mob -> mob != thisPassiveMob) // Other mobs only
				.filter(mob -> mob.getAttacker() == null) // Not already attacked
				.forEach(mob -> mob.setAttacker(attacker));
	}
}
