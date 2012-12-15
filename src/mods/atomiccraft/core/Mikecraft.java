package mods.mikecraft.core;

import java.util.List;

import mods.mikecraft.blocks.BaseItem;
import mods.mikecraft.blocks.BlockLantern;
import mods.mikecraft.blocks.ItemCheese;
import mods.mikecraft.core.MikecraftCore;
import mods.mikecraft.core.proxy.CommonProxy;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.InventoryMerchant;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MerchantRecipe;
import net.minecraft.src.MerchantRecipeList;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "Mikecraft", name = "Mikecraft", version = "0.1")
public class Mikecraft {
	
	public final static Item coinGold = new BaseItem(9001).setItemName("coinGold").setCreativeTab(CreativeTabs.tabMisc);
	public final static Item coinIron = new BaseItem(9002).setItemName("coinIron").setCreativeTab(CreativeTabs.tabMisc).setIconIndex(1);
	public final static Item coinCopper = new BaseItem(9003).setItemName("coinCopper").setCreativeTab(CreativeTabs.tabMisc).setIconIndex(2);
	
	public final static Item nuggetIron = new BaseItem(9004).setItemName("nuggetIron").setCreativeTab(CreativeTabs.tabMaterials).setIconIndex(3);
	public final static Item nuggetCopper = new BaseItem(9005).setItemName("nuggetCopper").setCreativeTab(CreativeTabs.tabMaterials).setIconIndex(4);
	
	public final static Item foodCheese = new ItemCheese(9006, 4, 2.0F ,false).setItemName("foodCheese").setIconIndex(5);
	
	public final static Block blockLantern = new BlockLantern(2000, 0, Material.glass).setCreativeTab(CreativeTabs.tabDecorations).setHardness(2.0F).setStepSound(Block.soundGlassFootstep).setLightValue(1.0F).setBlockName("blockGlowLantern");
	
	@SidedProxy(clientSide = "mods.mikecraft.core.proxy.ClientProxy", serverSide = "mods.mikecraft.core.proxy.CommonProxy", bukkitSide ="mods.mikecraft.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInitMod(FMLPreInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new EventContainer());
	}
	
	@Init
	public void initMod(FMLInitializationEvent event) {
		
		MikecraftCore.registerBlock(blockLantern);
		proxy.registerClientTextures();
		MikecraftCore.addSmelting(coinGold.shiftedIndex, new ItemStack(Item.goldNugget, 1));
		MikecraftCore.addSmelting(coinIron.shiftedIndex, new ItemStack(nuggetIron, 1));
		MikecraftCore.addSmelting(coinCopper.shiftedIndex, new ItemStack(nuggetCopper, 1));
		MikecraftCore.addSmelting(Item.bucketMilk.shiftedIndex, new ItemStack(foodCheese, 1));
		MikecraftCore.addRecipe(new ItemStack(blockLantern, 2), new Object[] {
			"XX", "XX", 'X', Block.glowStone
		});
		MikecraftCore.addRecipe(new ItemStack(Item.ingotIron, 1), new Object[]{
				"XXX", "XXX", "XXX", 'X', Mikecraft.nuggetIron
		});
		
	}

	
}
