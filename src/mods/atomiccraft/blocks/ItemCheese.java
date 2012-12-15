package mods.atomiccraft.blocks;

import net.minecraft.src.ItemFood;

public class ItemCheese extends ItemFood {

	public ItemCheese(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
	}
	
	@Override
	public String getTextureFile(){
		return "/atomiccraft/items.png";
	}

}
