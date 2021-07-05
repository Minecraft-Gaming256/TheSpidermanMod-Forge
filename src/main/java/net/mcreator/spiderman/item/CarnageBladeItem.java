
package net.mcreator.spiderman.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.spiderman.SpidermanModElements;

@SpidermanModElements.ModElement.Tag
public class CarnageBladeItem extends SpidermanModElements.ModElement {
	@ObjectHolder("spiderman:carnage_blade")
	public static final Item block = null;
	public CarnageBladeItem(SpidermanModElements instance) {
		super(instance, 226);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 10f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.2f, new Item.Properties().group(null).isImmuneToFire()) {
		}.setRegistryName("carnage_blade"));
	}
}
