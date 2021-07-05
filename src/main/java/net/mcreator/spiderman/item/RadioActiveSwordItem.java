
package net.mcreator.spiderman.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.Minecraft;

import net.mcreator.spiderman.procedures.RadioactiveToolsGlowProcedureProcedure;
import net.mcreator.spiderman.procedures.RadioActiveToolLivingEntityIsHitProcedure;
import net.mcreator.spiderman.itemgroup.ItemsItemGroup;
import net.mcreator.spiderman.block.RadioActiveOreBlock;
import net.mcreator.spiderman.SpidermanModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

@SpidermanModElements.ModElement.Tag
public class RadioActiveSwordItem extends SpidermanModElements.ModElement {
	@ObjectHolder("spiderman:radio_active_sword")
	public static final Item block = null;
	public RadioActiveSwordItem(SpidermanModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1661;
			}

			public float getEfficiency() {
				return 8.5f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 35;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(RadioActiveOreBlock.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(ItemsItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("-A Tool That Has A Unknown Energy"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					RadioActiveToolLivingEntityIsHitProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				PlayerEntity entity = Minecraft.getInstance().player;
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (!(RadioactiveToolsGlowProcedureProcedure.executeProcedure(ImmutableMap.of("world", world)))) {
					return false;
				}
				return true;
			}
		}.setRegistryName("radio_active_sword"));
	}
}
