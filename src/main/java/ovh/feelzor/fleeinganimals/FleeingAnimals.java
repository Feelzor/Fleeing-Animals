package ovh.feelzor.fleeinganimals;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ovh.feelzor.fleeinganimals.config.FleeingAnimalsConfig;

public class FleeingAnimals implements ModInitializer {
	public static final String MODID = "fleeinganimals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	private static FleeingAnimalsConfig config;

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Fleeing Animals and its config");
		AutoConfig.register(FleeingAnimalsConfig.class, JanksonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(FleeingAnimalsConfig.class).getConfig();
	}

	public static FleeingAnimalsConfig getConfig() {
		return config;
	}
}
