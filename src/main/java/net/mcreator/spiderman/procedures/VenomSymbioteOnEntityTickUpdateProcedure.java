package net.mcreator.spiderman.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.spiderman.potion.RadioActivePotion;
import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;
import java.util.Collection;

public class VenomSymbioteOnEntityTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SpidermanMod.LOGGER.warn("Failed to load dependency entity for procedure VenomSymbioteOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == RadioActivePotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)) || (entity.isBurning())) || (entity.isInLava()))) {
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 5);
		}
	}
}
