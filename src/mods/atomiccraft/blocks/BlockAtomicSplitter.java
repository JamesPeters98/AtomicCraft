package mods.atomiccraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAtomicSplitter extends Block  {

	public BlockAtomicSplitter(int par1, int par2, Material par3) {
		super(par1, par2, par3);
	}
	
	@Override
	public String getTextureFile(){
		return "/atomiccraft/blocks.png";
	}

}
