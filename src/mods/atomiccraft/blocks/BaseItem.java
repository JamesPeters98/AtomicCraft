package mods.atomiccraft.blocks;

import net.minecraft.src.Item;

public class BaseItem extends Item {

	public BaseItem(int par1) {
		super(par1);
	}
	
	@Override
	public String getTextureFile(){
		return "/atomiccraft/items.png";
	}

}
