package net.mcreator.spiderman.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.spiderman.SpidermanModElements;

import java.lang.reflect.Method;

@SpidermanModElements.ModElement.Tag
public class RadioactiveToolsGlowGameRule extends SpidermanModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("radioactiveToolsGlow", GameRules.Category.PLAYER,
			create(true));
	public RadioactiveToolsGlowGameRule(SpidermanModElements instance) {
		super(instance, 168);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
