package me.pvpclient.mixin;

import me.pvpclient.Client;
import me.pvpclient.event.impl.ClientTickEvent;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.PixelFormat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Shadow private boolean fullscreen;
    @Shadow @Final private static final Logger logger = LogManager.getLogger();
    @Shadow private void updateDisplayMode() {}
    /**
     * @author Mojang & Developer
     * @reason Change the title
     */
    @Overwrite
    private void createDisplay() throws LWJGLException {
        Display.setResizable(true);
        Client.getInstance().setTitle();
        try {Display.create((new PixelFormat()).withDepthBits(24));}
        catch (LWJGLException lwjglexception) {
        logger.error("Couldn't set pixel format", lwjglexception);
        try {Thread.sleep(1000L);}
        catch (InterruptedException ignored) {}
        if (this.fullscreen) {this.updateDisplayMode();}
        Display.create();}
    }

    @Inject(method = "startGame", at = @At("HEAD"))
    public void startGame(CallbackInfo ci){
        Client.getInstance().onStartup();
    }
    @Inject(method = "shutdownMinecraftApplet", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/stream/IStream;shutdownStream()V"))
    public void shutdownMinecraftApplet(CallbackInfo ci){
        Client.getInstance().onShutdown();
    }
    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/profiler/Profiler;endSection()V"))
    public void runTick(CallbackInfo ci){
        new ClientTickEvent().call();
    }
    /*@Inject(method = "startGame", at = @At(value = "TAIL"))
    public void startGame2(CallbackInfo ci) {
        Client.getInstance().onStart();
    }*/

}