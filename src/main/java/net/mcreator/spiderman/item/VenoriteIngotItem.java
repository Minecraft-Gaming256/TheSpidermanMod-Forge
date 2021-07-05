
package net.mcreator.spiderman.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.spiderman.itemgroup.ItemsItemGroup;
import net.mcreator.spiderman.SpidermanModElements;

@SpidermanModElements.ModElement.Tag
public class VenoriteIngotItem extends SpidermanModElements.ModElement {
	@ObjectHolder("spiderman:venorite_ingot")
	public static final Item block = null;
	public VenoriteIngotItem(SpidermanModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("venorite_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
