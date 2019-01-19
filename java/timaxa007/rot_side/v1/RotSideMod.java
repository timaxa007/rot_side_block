package timaxa007.rot_side.v1;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = RotSideMod.MODID, name = RotSideMod.NAME, version = RotSideMod.VERSION)
public class RotSideMod {

	public static final String
	MODID = "rot_side",
	NAME = "Rotate Side Block Mod",
	VERSION = "0.1";

	@Mod.Instance(MODID)
	public static RotSideMod instance;

	public static Block block_rot_side;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		block_rot_side = new BlockRotSide(Material.iron).setBlockName("rot_side.rot_side").setBlockTextureName("rot_side:rot_side").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(block_rot_side, "block_rot_side");

	}

}
