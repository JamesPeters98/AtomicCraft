package mods.atomiccraft.core.proxy;

import org.lwjgl.opengl.GL11;

import mods.atomiccraft.blocks.BlockAtomicSplitter;
import mods.atomiccraft.core.AtomicCraft;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class BlockRenderingHandler implements ISimpleBlockRenderingHandler {

	ModelSplitter model = new ModelSplitter();
	public static int ID = RenderingRegistry.getNextAvailableRenderId();
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		if(block == AtomicCraft.blockAtomicSplitter){
		 	GL11.glPushMatrix();
			GL11.glTranslatef((float) 0.0F, (float)1F, (float)0.0F);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture("/atomiccraft/splitter.png"));				
			model.render(0.0625F);
			GL11.glPopMatrix();
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ID;
	}

}
