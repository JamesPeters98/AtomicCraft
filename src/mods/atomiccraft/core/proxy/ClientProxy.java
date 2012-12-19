package mods.atomiccraft.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import mods.atomiccraft.core.LangNames;
import mods.atomiccraft.tileentities.RenderSplitter;
import mods.atomiccraft.tileentities.TileEntitySplitter;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	public static int id;
	
	@Override
	public void registerClientTextures(){
		LangNames.initNames();
		RenderingRegistry.registerBlockHandler(new BlockRenderingHandler());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySplitter.class, new RenderSplitter());
	}

}
