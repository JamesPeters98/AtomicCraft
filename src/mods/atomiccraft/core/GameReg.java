package mods.atomiccraft.core;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class GameReg extends GameRegistry {
	
	/**
	 * Adds an in-game item name to the Item specified.
	 */
	public static void registerName(Item item, String name){
		LanguageRegistry.instance().addStringLocalization(item.getItemName() + ".name", "en_US", name);
	}
	
	/**
	 * Adds an in-game block name to the Block specified.
	 */
	public static void registerName(Block block, String name){
		LanguageRegistry.instance().addStringLocalization(block.getBlockName() + ".name", "en_US", name);
	}
	
	/**
	 * Adds an in-game name to a CreativeTab extending the class AtomicCraftTab.
	 * @param tab
	 * @param name
	 */
	public static void registerTab(String tabname, String name){
		LanguageRegistry.instance().addStringLocalization("itemGroup." + tabname, "en_US", name);
	}
	
	/**
	 * Adds an in-game translation to the field specified in the language specified.
	 * registerName() should be used for block and item names.
	 * Primary use is for adding names to GUIs where registerName()  or registerTab() will not work.
	 */
	public static void registerTranslation(String name, String language, String translation){
		LanguageRegistry.instance().addStringLocalization(name, language, translation);
	}

	/**
	 * Allows the item specified in shiftedIndex to be smelted into the item defined in itemStack.
	 * @param shiftedIndex
	 * @param itemStack
	 */
	public static void addSmelting(int shiftedIndex, ItemStack itemStack) {
		addSmelting(shiftedIndex, itemStack, 1.0F);
	}

}
