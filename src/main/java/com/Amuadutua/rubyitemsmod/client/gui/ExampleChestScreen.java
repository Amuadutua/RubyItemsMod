package com.Amuadutua.rubyitemsmod.client.gui;

import com.Amuadutua.rubyitemsmod.RubyItems;
import com.Amuadutua.rubyitemsmod.container.ExampleChestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ExampleChestScreen extends ContainerScreen<ExampleChestContainer> implements IHasContainer<ExampleChestContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(RubyItems.MOD_ID, "textures/gui/example_chest.png");

    private final int inventoryRows;

    public ExampleChestScreen(ExampleChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn, int inventoryRows) {
        super(screenContainer, inv, titleIn);
        this.inventoryRows = inventoryRows;
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 175;
        this.ySize = 183;
    }


    @Override
    public void render(MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        this.renderBackground(p_230430_1_);
        super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
        this.func_230459_a_(p_230430_1_, p_230430_2_, p_230430_3_);
    }

    

    //@Override
    //protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

    //}

    @Override
    protected void func_230450_a_(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.blit(p_230450_1_, i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.blit(p_230450_1_, i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }

}

