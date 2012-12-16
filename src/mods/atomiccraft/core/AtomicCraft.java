package mods.atomiccraft.core;

import java.util.List;

import mods.atomiccraft.blocks.BaseItem;
import mods.atomiccraft.blocks.BlockAtomicSplitter;
import mods.atomiccraft.blocks.ItemCheese;
import mods.atomiccraft.core.GameReg;
import mods.atomiccraft.core.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "AtomicCraft", name = "AtomicCraft", version = "0.1")
public class AtomicCraft {
	
	public static int coinGoldID;
	public static int coinIronID;
	public static int coinCopperID;
	public static int nuggetIronID;
	public static int nuggetCopperID;
	public static int foodCheeseID;
	public static int blockSplitterID;
	
	public final static CreativeTabs tab = new AtomicCraftTab("atomicTab");
	
	public static Item coinGold;
	public static Item coinIron;
	public static Item coinCopper;
	public static Item nuggetIron;
	public static Item nuggetCopper;
	public static Item foodCheese;
	public static Block blockAtomicSplitter;
	
	@SidedProxy(clientSide = "mods.atomiccraft.core.proxy.ClientProxy", serverSide = "mods.atomiccraft.core.proxy.CommonProxy", bukkitSide ="mods.mikecraft.core.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInitMod(FMLPreInitializationEvent event){
			Configuration config = new Configuration(event.getSuggestedConfigurationFile());
			
			config.load();
			coinGoldID = config.getItem("GoldCoin", 9001).getInt(9001);
			coinIronID = config.getItem("IronCoin", 9002).getInt(9002);
			coinCopperID = config.getItem("CopperCoin", 9003).getInt(9003);
			nuggetIronID = config.getItem("IronNugget", 9004).getInt(9004);
			nuggetCopperID = config.getItem("CopperNugget", 9005).getInt(9005);
			foodCheeseID = config.getItem("SliceofCheese", 9006).getInt(9006);
			blockSplitterID = config.getBlock("AtomicSplitter", 2000).getInt(2000);
			config.save();
			
			MinecraftForge.EVENT_BUS.register(new EventContainer());
	}
	
	@Init
	public void initMod(FMLInitializationEvent event) {
		
		addItems();
		GameReg.registerBlock(blockAtomicSplitter);
		proxy.registerClientTextures();
		GameReg.addSmelting(coinGold.shiftedIndex, new ItemStack(Item.goldNugget, 1));
		GameReg.addSmelting(coinIron.shiftedIndex, new ItemStack(nuggetIron, 1));
		GameReg.addSmelting(coinCopper.shiftedIndex, new ItemStack(nuggetCopper, 1));
		GameReg.addSmelting(ItemBucketMilk.bucketMilk.shiftedIndex, new ItemStack(this.foodCheese, 1));
		GameReg.addRecipe(new ItemStack(Item.ingotIron, 1), new Object[]{
				"XXX", "XXX", "XXX", 'X', AtomicCraft.nuggetIron
		});
		
	}
	
	public void addItems(){
		
		coinGold = new BaseItem(coinGoldID).setItemName("coinGold").setCreativeTab(tab);
		coinIron = new BaseItem(coinIronID).setItemName("coinIron").setCreativeTab(tab).setIconIndex(1);
		coinCopper = new BaseItem(coinCopperID).setItemName("coinCopper").setCreativeTab(tab).setIconIndex(2);
		
		nuggetIron = new BaseItem(nuggetIronID).setItemName("nuggetIron").setCreativeTab(tab).setIconIndex(3);
		nuggetCopper = new BaseItem(nuggetCopperID).setItemName("nuggetCopper").setCreativeTab(tab).setIconIndex(4);
		
		foodCheese = new ItemCheese(foodCheeseID, 4, 2.0F ,false).setItemName("foodCheese").setCreativeTab(tab).setIconIndex(5);
		
		blockAtomicSplitter = new BlockAtomicSplitter(blockSplitterID, 1, Material.iron).setCreativeTab(tab).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setBlockName("blockAtomicSplitter");
		
	}

	
}
