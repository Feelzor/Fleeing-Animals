package ovh.feelzor.fleeinganimals.config;

import com.oroarmor.config.*;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.util.List;

import static java.util.List.of;
import static ovh.feelzor.fleeinganimals.FleeingAnimals.MODID;

public class FleeingAnimalsConfig extends Config {

    private static final String CONFIG_FILENAME = "fleeinganimals.json";

    public static final ConfigItemGroup mainGroup = new GlobalConfigGroup();
    private static final List<ConfigItemGroup> configs = of(mainGroup);

    public FleeingAnimalsConfig() {
        super(configs, new File(FabricLoader.getInstance().getConfigDir().toFile(), CONFIG_FILENAME), MODID);
    }

    public static class GlobalConfigGroup extends ConfigItemGroup {

        public static final DoubleConfigItem fearRadius = new DoubleConfigItem("fear_radius", 1.0, "fleeinganimals.fear_radius");
        public static final BooleanConfigItem allAnimalsFlee = new BooleanConfigItem("all_animals_flee", true, "fleeinganimals.all_animals_flee");

        public GlobalConfigGroup() {
            super(of(fearRadius, allAnimalsFlee), "flee_behaviour");
        }
    }
}
