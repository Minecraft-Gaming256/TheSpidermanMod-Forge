package net.mcreator.spiderman.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;

public class VenomsBiteOnPotionActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SpidermanMod.LOGGER.warn("Failed to load dependency entity for procedure VenomsBiteOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.isBurning()) || (entity.isInLava())) || (entity.isSprinting()))) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("venombite").setDamageBypassesArmor(), (float) 1);
			}
		}
	}
}
