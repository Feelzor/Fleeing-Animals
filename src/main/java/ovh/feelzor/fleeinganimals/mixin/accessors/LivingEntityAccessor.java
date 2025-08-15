package ovh.feelzor.fleeinganimals.mixin.accessors;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LivingEntity.class)
public interface LivingEntityAccessor {
    @Accessor("lastDamageSource")
    void setLastDamageSource(DamageSource source);

    @Accessor("lastDamageTime")
    void setLastDamageTime(long time);
}