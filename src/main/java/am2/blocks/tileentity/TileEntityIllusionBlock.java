package am2.blocks.tileentity;

import am2.blocks.BlockIllusionBlock;
import am2.defs.BlockDefs;
import am2.defs.PotionEffectsDefs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityIllusionBlock extends TileEntity implements ITickable{
	
	private IBlockState mimicBlock;
	
	public TileEntityIllusionBlock() {
		
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isRevealed(IBlockState state) {
		return BlockIllusionBlock.getIllusionType(state).canBeRevealed() && Minecraft.getMinecraft().thePlayer.isPotionActive(PotionEffectsDefs.trueSight);
	}

	@Override
	public void update() {
		BlockPos pos = this.pos.down();
		IBlockState blockBellow = worldObj.getBlockState(pos);
		while (blockBellow.getBlock() == BlockDefs.illusionBlock) {
			pos = pos.down();
			blockBellow = worldObj.getBlockState(pos);
		}
		if (!blockBellow.isFullBlock() || !blockBellow.isFullCube())
			blockBellow = Blocks.AIR.getDefaultState();
		mimicBlock = blockBellow;
	}
	
	public IBlockState getMimicBlock() {
		return mimicBlock;
	}
}
