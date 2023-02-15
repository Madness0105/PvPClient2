package me.pvpclient;

import me.pvpclient.event.EventManager;
import me.pvpclient.gui.hud.HudManager;
import me.pvpclient.mods.ModInstances;
import org.lwjgl.opengl.Display;

public class Client {
    public static String NAME = "PvP Client", VERSION = "0.1";
    private static final Client INSTANCE = new Client();

    public static Client getInstance() {
        return INSTANCE;
    }
    private HudManager hudManager;
    public void onStartup() {
        hudManager = HudManager.getInstance();
        ModInstances.register(hudManager);
    }

    public void onStart() {

        ModInstances.register(HudManager.getInstance());
    }

    public void onShutdown() {

    }

    public void setTitle() {
        Display.setTitle(NAME + " " + VERSION);
    }
}
