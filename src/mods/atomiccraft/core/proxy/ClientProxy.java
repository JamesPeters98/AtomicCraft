package mods.mikecraft.core.proxy;

import mods.mikecraft.core.LangNames;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerClientTextures(){
		MinecraftForgeClient.preloadTexture("/mikecraft/items.png");
		MinecraftForgeClient.preloadTexture("/mikecraft/blocks.png");
		LangNames.initNames();
	}

}
