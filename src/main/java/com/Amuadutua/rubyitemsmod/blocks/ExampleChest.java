package com.Amuadutua.rubyitemsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class ExampleChest extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 8, 0, 9, 12, 1),
            Block.makeCuboidShape(1, 1, 1, 15, 10, 15),
            Block.makeCuboidShape(1, 10, 1, 15, 15, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(15, 8, 7, 16, 12, 9),
            Block.makeCuboidShape(1, 1, 1, 15, 10, 15),
            Block.makeCuboidShape(1, 10, 1, 15, 15, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 8, 15, 9, 12, 16),
            Block.makeCuboidShape(1, 1, 1, 15, 10, 15),
            Block.makeCuboidShape(1, 10, 1, 15, 15, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 8, 7, 1, 12, 9),
            Block.makeCuboidShape(1, 1, 1, 15, 10, 15),
            Block.makeCuboidShape(1, 10, 1, 15, 15, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public ExampleChest() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(4.0f, 6.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .setRequiresTool()
                .harvestTool(ToolType.AXE));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }
}
