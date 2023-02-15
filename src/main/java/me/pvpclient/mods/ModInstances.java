package me.pvpclient.mods;

import me.pvpclient.gui.hud.HudManager;
import me.pvpclient.mods.impl.ModHelloWorld;

public class ModInstances {
    private static ModHelloWorld modHelloWorld;
    public static void register(HudManager api){
        modHelloWorld = new ModHelloWorld();
        api.register(modHelloWorld);
    }
    public static ModHelloWorld getModHelloWorld(){
        return modHelloWorld;
    }
}
