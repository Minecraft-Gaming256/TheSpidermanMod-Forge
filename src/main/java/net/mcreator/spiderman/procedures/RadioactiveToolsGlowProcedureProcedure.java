package net.mcreator.spiderman.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.spiderman.world.RadioactiveToolsGlowGameRule;
import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;

public class RadioactiveToolsGlowProcedureProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SpidermanMod.LOGGER.warn("Failed to load dependency world for procedure RadioactiveToolsGlowProcedure!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return ((world.getWorldInfo().getGameRulesInstance().getBoolean(RadioactiveToolsGlowGameRule.gamerule)) == (true));
	}
}
