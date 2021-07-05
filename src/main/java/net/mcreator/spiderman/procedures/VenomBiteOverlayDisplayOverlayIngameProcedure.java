package net.mcreator.spiderman.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.spiderman.potion.VenomsBitePotion;
import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;
import java.util.Collection;

public class VenomBiteOverlayDisplayOverlayIngameProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SpidermanMod.LOGGER.warn("Failed to load dependency entity for procedure VenomBiteOverlayDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == VenomsBitePotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity));
	}
}
