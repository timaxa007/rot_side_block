package timaxa007.rot_side.v1;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockRotSide extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public final String[] name = new String[] {
			"bottom",
			"top",
			"back",
			"front",
			"left",
			"right"
	};

	public BlockRotSide(Material material) {
		super(material);
	}

	/**Called when the block is placed in the world.**/
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	/**Gets the block's texture. Args: side, meta**/
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		switch(side) {
		case 0:return icons[0];
		case 1:return icons[1];
		/*
		case 2:return icons[2];
		case 3:return icons[3];
		case 4:return icons[4];
		case 5:return icons[5];
		 */

		case 2:
			switch(meta) {
			case 0:return icons[3];
			case 1:return icons[5];
			case 2:return icons[2];
			case 3:return icons[4];
			}
			break;

		case 3:
			switch(meta) {
			case 0:return icons[2];
			case 1:return icons[4];
			case 2:return icons[3];
			case 3:return icons[5];
			}
			break;

		case 4:
			switch(meta) {
			case 0:return icons[5];
			case 1:return icons[2];
			case 2:return icons[4];
			case 3:return icons[3];
			}
			break;

		case 5:
			switch(meta) {
			case 0:return icons[4];
			case 1:return icons[3];
			case 2:return icons[5];
			case 3:return icons[2];
			}
			break;

		}
		return super.getIcon(side, meta);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icons = new IIcon[6];
		for (int i = 0; i < icons.length; ++i)
			icons[i] = ir.registerIcon(this.getTextureName() + "_" + name[i]);
	}

}
