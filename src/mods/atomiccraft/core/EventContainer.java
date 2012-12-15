package mods.atomiccraft.core;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

public class EventContainer {
	
	@ForgeSubscribe
	public void oreEvent(OreRegisterEvent event){
		if(event.Name.contains("ingotCopper")){
			System.out.println("Found Copper Ingot...");
			MikecraftCore.addRecipe(event.Ore, new Object[]{
					"XXX", "XXX", "XXX", 'X', Mikecraft.nuggetCopper
			});
		}
	}

}
