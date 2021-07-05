
package net.mcreator.spiderman.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.spiderman.item.RadioActiveSplatItem;

@Mod.EventBusSubscriber
public class RadioActiveSplatFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(RadioActiveSplatItem.block, (int) (1)).getItem())
			event.setBurnTime(8000);
	}
}
