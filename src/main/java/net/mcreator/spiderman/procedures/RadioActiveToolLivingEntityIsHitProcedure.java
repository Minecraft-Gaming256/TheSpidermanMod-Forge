package net.mcreator.spiderman.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.spiderman.potion.RadioActivePotion;
import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;

public class RadioActiveToolLivingEntityIsHitProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SpidermanMod.LOGGER.warn("Failed to load dependency entity for procedure RadioActiveToolLivingEntityIsHit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.7)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(RadioActivePotion.potion, (int) 6000, (int) 1, (false), (false)));
		}
	}
}
