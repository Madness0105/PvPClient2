package me.pvpclient.mods;

import me.pvpclient.Client;
import me.pvpclient.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod {

    private boolean isEnabled = true;
    protected final FontRenderer font;
    protected final Minecraft mc;
    protected final Client client;
    public Mod() {
        this.mc = Minecraft.getMinecraft();
        this.font = this.mc.fontRendererObj;
        this.client = Client.getInstance();

        setEnabled(isEnabled);
    }
    public boolean isEnabled() {
        return isEnabled;
    }
    public void setEnabled(boolean isEnabled){
        this.isEnabled = isEnabled;

        if(isEnabled) {
            EventManager.register(this);
        } else {
            EventManager.unregister(this);
        }
    }

}
