package net.mcreator.spiderman.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.spiderman.entity.VenomSymbioteEntity;
import net.mcreator.spiderman.entity.RiotVenomSymbioteEntity;
import net.mcreator.spiderman.block.CrashedMeteorBlock;
import net.mcreator.spiderman.SpidermanMod;

import java.util.Map;

public class MeteorEntityFallsProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SpidermanMod.LOGGER.warn("Failed to load dependency x for procedure MeteorEntityFalls!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SpidermanMod.LOGGER.warn("Failed to load dependency y for procedure MeteorEntityFalls!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SpidermanMod.LOGGER.warn("Failed to load dependency z for procedure MeteorEntityFalls!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SpidermanMod.LOGGER.warn("Failed to load dependency world for procedure MeteorEntityFalls!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 5, Explosion.Mode.DESTROY);
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), CrashedMeteorBlock.block.getDefaultState(), 3);
		if ((Math.random() < 0.6)) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new VenomSymbioteEntity.CustomEntity(VenomSymbioteEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		} else if ((Math.random() < 0.4)) {
			if (world instanceof ServerWorld) {
				Entity entityToSpawn = new RiotVenomSymbioteEntity.CustomEntity(RiotVenomSymbioteEntity.entity, (World) world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
