package me.pvpclient.mixin;

import me.pvpclient.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(GuiIngame.class)
public class MixinGuiIngame {
    @Final
    @Shadow private Minecraft mc = Minecraft.getMinecraft();
    @Inject(method = "renderGameOverlay", at = @At(value = "RETURN"))
    public void renderGameOverlay(CallbackInfo ci){
        mc.fontRendererObj.drawStringWithShadow(Client.NAME + " " + Client.VERSION, 2, 2, new Color(255, 255, 255).getRGB());
        mc.fontRendererObj.drawStringWithShadow("FPS: " + Minecraft.getDebugFPS(), 2, 4 + mc.fontRendererObj.FONT_HEIGHT, new Color(255, 255, 255).getRGB());



    }

}
