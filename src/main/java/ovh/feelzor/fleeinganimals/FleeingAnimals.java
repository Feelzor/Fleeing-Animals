package ovh.feelzor.fleeinganimals;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ovh.feelzor.fleeinganimals.config.FleeingAnimalsConfig;

public class FleeingAnimals implements ModInitializer {
	public static final String MODID = "fleeinganimals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static final FleeingAnimalsConfig CONFIG = new FleeingAnimalsConfig();

	@Override
	public void onInitialize() {
		LOGGER.info("Reading config");

		CONFIG.readConfigFromFile();
		CONFIG.saveConfigToFile();
	}
}
