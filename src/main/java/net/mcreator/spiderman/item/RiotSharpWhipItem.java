
package net.mcreator.spiderman.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.spiderman.SpidermanModElements;

@SpidermanModElements.ModElement.Tag
public class RiotSharpWhipItem extends SpidermanModElements.ModElement {
	@ObjectHolder("spiderman:riot_sharp_whip")
	public static final Item block = null;
	public RiotSharpWhipItem(SpidermanModElements instance) {
		super(instance, 225);
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
				return 4f;
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
		}, 3, -3.2f, new Item.Properties().group(null)) {
		}.setRegistryName("riot_sharp_whip"));
	}
}
