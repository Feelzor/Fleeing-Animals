package ovh.feelzor.fleeinganimals;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import ovh.feelzor.fleeinganimals.config.FleeingAnimalsConfig;
import static ovh.feelzor.fleeinganimals.FleeingAnimals.LOGGER;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        LOGGER.info("Registering config screen for ModMenu");
        return parent -> AutoConfig.getConfigScreen(FleeingAnimalsConfig.class, parent).get();
    }
}
