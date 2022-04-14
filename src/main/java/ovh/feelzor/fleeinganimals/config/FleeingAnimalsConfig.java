package ovh.feelzor.fleeinganimals.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import static ovh.feelzor.fleeinganimals.FleeingAnimals.MODID;

@Config(name = MODID)
public class FleeingAnimalsConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip(count = 2) // On some screens, the tooltip is too long - Break it down into two tooltips
    @Comment(value = "The detection radius multiplier (for x and z axes). It will be multiplied by the entity's detection range. Default: 1.0")
    public double radius = 1.0;

    @Comment(value = "The detection radius on the vertical (y) axis. Default: 10.0")
    public double yRadius = 10;

    @ConfigEntry.Gui.Tooltip(count = 2)
    @Comment(value = "Whether all the animals shall flee regardless of their type. If set to true, only the same animals will flee. Default: false")
    public boolean sameSpeciesOnly = false;
}
