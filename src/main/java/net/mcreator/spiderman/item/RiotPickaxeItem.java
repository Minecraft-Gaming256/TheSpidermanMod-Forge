
package net.mcreator.spiderman.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.spiderman.SpidermanModElements;

@SpidermanModElements.ModElement.Tag
public class RiotPickaxeItem extends SpidermanModElements.ModElement {
	@ObjectHolder("spiderman:riot_pickaxe")
	public static final Item block = null;
	public RiotPickaxeItem(SpidermanModElements instance) {
		super(instance, 187);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3.1f, new Item.Properties().group(null)) {
		}.setRegistryName("riot_pickaxe"));
	}
}
