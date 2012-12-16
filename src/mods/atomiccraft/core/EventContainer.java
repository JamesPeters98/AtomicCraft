package mods.atomiccraft.core;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

public class EventContainer {
	
	@ForgeSubscribe
	public void oreEvent(OreRegisterEvent event){
		if(event.Name.contains("ingotCopper")){
			System.out.println("AtomicCraft: Found Copper Ingot.");
			GameReg.addRecipe(event.Ore, new Object[]{
					"XXX", "XXX", "XXX", 'X', AtomicCraft.nuggetCopper
			});
		}
		if(event.Name.contains("ingotTin")){
			System.out.println("AtomicCraft: Found Tin Ingot.");
			GameReg.addRecipe(new ItemStack(AtomicCraft.blockAtomicSplitter, 1), new Object[]{
				"XIX", "I/I", "XIX", 'X', event.Ore, 'I', Block.glass, '/', Block.blockSteel  	
			});
		}
	}

}
