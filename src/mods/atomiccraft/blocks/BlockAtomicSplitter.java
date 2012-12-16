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
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving placer){
		float pitch = placer.rotationPitch;
		float yaw = placer.rotationYaw;
		
		int side;
		
		if (pitch > 45.0f)
		{
			side = ForgeDirection.UP.ordinal();
		}
		else if (pitch < -45.0f)
		{
			side = ForgeDirection.DOWN.ordinal();
		}	
		else
		{
			side = MathHelper.floor_float(0.5f+yaw/90.0f) & 3;
				
			switch (side)
			{
			case 0:
				side = ForgeDirection.NORTH.ordinal();
				break;
			case 1:
				side = ForgeDirection.EAST.ordinal();
				break;
			case 2:
				side = ForgeDirection.SOUTH.ordinal();
				break;
			case 3:
				side = ForgeDirection.WEST.ordinal();
				break;
			}
		}
				
		world.setBlockMetadata(x, y, z, side);
	}
	
	@Override
	public ForgeDirection getOrientation(World world, int x, int y, int z){
		return ForgeDirection.getOrientation(world.getBlockMetadata(x, y, z));
	}

}
