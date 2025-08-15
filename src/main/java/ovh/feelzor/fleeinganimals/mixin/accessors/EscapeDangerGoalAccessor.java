package ovh.feelzor.fleeinganimals.mixin.accessors;

import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EscapeDangerGoal.class)
public interface EscapeDangerGoalAccessor {
    @Accessor("mob")
    PathAwareEntity getMob();
}
