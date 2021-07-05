package net.mcreator.spiderman.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;

public class CrashedMeteorEntityWalksOnTheBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SpidermanMod.LOGGER.warn("Failed to load dependency entity for procedure CrashedMeteorEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 5);
	}
}
