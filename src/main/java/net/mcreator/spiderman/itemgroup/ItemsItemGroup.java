
package net.mcreator.spiderman.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.spiderman.item.MetalJarItem;
import net.mcreator.spiderman.SpidermanModElements;

@SpidermanModElements.ModElement.Tag
public class ItemsItemGroup extends SpidermanModElements.ModElement {
	public ItemsItemGroup(SpidermanModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MetalJarItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
