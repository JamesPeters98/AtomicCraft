package mods.atomiccraft.core;

import mods.atomiccraft.core.GameReg;

public class LangNames {

	public static void initNames(){
		GameReg.registerTab("atomicTab", "AtomicCraft");
		GameReg.registerName(AtomicCraft.coinGold, "Gold Coin");
		GameReg.registerName(AtomicCraft.coinIron, "Iron Coin");
		GameReg.registerName(AtomicCraft.coinCopper, "Copper Coin");
		
		GameReg.registerName(AtomicCraft.nuggetIron, "Iron Nugget");
		GameReg.registerName(AtomicCraft.nuggetCopper, "Copper Nugget");
		
		GameReg.registerName(AtomicCraft.foodCheese, "Slice of Cheese");
		
		GameReg.registerName(AtomicCraft.blockAtomicSplitter, "Atomic Splitter");
	}
	
}
