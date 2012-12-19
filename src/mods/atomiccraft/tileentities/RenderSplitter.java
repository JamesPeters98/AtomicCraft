package mods.atomiccraft.tileentities;

import org.lwjgl.opengl.GL11;

import mods.atomiccraft.core.proxy.ModelSplitter;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderSplitter extends TileEntitySpecialRenderer {

	ModelSplitter model = new ModelSplitter();
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		bindTextureByName("/atomiccraft/splitter.png");
		GL11.glPushMatrix();
		GL11.glTranslatef((float) var2 + 0.5F, (float) var4 + 1.5F, (float) var6 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(0f, 0f, 1f, 0f);
		model.render(0.0625F);
		GL11.glPopMatrix();
	}

}
