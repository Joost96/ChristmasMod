package ChristmasMod.common;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockDTree extends BlockContainer {

	public static int RenderId;
	public BlockDTree(int i) {
		super(i, Material.rock);
		this.setCreativeTab(ChristmasMod.TabChrist);
	}
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileDTree();
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		
		return RenderId;
	}
	public String getTextureFile()
	{
		return "/ChristmasMod/terrain.png";
	}
}