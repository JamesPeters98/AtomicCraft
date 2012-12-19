package mods.atomiccraft.blocks;

import java.util.Random;

import mods.atomiccraft.core.proxy.BlockRenderingHandler;
import mods.atomiccraft.core.proxy.ClientProxy;
import mods.atomiccraft.tileentities.TileEntitySplitter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockAtomicSplitter extends BlockContainer  {

	public BlockAtomicSplitter(int par1, int par2, Material par3) {
		super(par1, par2, par3);
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
	
	public ForgeDirection getOrientation(World world, int x, int y, int z){
		return ForgeDirection.getOrientation(world.getBlockMetadata(x, y, z));
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override 
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public int getRenderType()
	{
		return BlockRenderingHandler.ID;
	}
	
	@Override
	public String getTextureFile(){
		return "/atomiccraft/splitterindex.png";
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntitySplitter();
	}

	

}
