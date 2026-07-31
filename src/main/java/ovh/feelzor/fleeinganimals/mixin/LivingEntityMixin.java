package ovh.feelzor.fleeinganimals.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ovh.feelzor.fleeinganimals.FleeingAnimals;
import ovh.feelzor.fleeinganimals.mixin.accessors.LivingEntityAccessor;

import static ovh.feelzor.fleeinganimals.FleeingAnimals.getConfig;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.AABB;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;actuallyHurt(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)V"), method = "hurtServer(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)Z")
	private void propagateAttacker(ServerLevel world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> ci) {
		// The method invokes setAttacker when attacker is known to be a LivingEntity.
		if (!((Object) this instanceof AgeableMob thisPassiveMob)) return;

		Class<? extends AgeableMob> afraidClass = (!getConfig().sameSpeciesOnly) ? AgeableMob.class : thisPassiveMob.getClass();

		double d = thisPassiveMob.getAttributeValue(Attributes.FOLLOW_RANGE) * getConfig().radius;

		AABB box = AABB.unitCubeFromLowerCorner(thisPassiveMob.position()).inflate(d, getConfig().yRadius, d);
		world.getEntitiesOfClass(afraidClass, box, EntitySelector.NO_SPECTATORS).stream()
				.filter(mob -> mob != thisPassiveMob) // Other mobs only
				.filter(mob -> mob.getLastHurtByMob() == null) // Not already attacked
				.forEach(mob -> {
					// From 1.21, the EscapeDangerGoal uses the last damage source and time to determine if the mob is fleeing.
					((LivingEntityAccessor) mob).setLastDamageSource(source);
					((LivingEntityAccessor) mob).setLastDamageTime(world.getGameTime());
				});
	}
}
