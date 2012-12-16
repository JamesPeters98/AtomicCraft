package mods.atomiccraft.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class AtomicCraftTab extends CreativeTabs {

	public String tabName = null;
	
	public AtomicCraftTab(String label) {
		super(label);
		tabName = label;
	}
	
	@Override
	public ItemStack getIconItemStack(){
		ItemStack icon = new ItemStack(AtomicCraft.blockAtomicSplitter);
		return icon;
	}

}
