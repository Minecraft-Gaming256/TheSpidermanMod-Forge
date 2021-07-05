package net.mcreator.spiderman.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.spiderman.potion.RadioActivePotion;
import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;

public class RadioActiveSpiderOnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SpidermanMod.LOGGER.warn("Failed to load dependency entity for procedure RadioActiveSpiderOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(RadioActivePotion.potion);
		}
	}
}
