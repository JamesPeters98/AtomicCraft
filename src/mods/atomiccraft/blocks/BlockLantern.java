package mods.atomiccraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlowStone;
import net.minecraft.block.material.Material;

public class BlockLantern extends BlockGlowStone  {

	public BlockLantern(int par1, int par2, Material par3) {
		super(par1, par2, par3);
	}
	
	@Override
	public String getTextureFile(){
		return "/atomiccraft/blocks.png";
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3){
		return Block.glowStone.blockID;
	}
	
	@Override
	public int quantityDropped(Random par1Random){
		return 2 + par1Random.nextInt(1);
	}

}
