package me.pvpclient.mods.impl;

import me.pvpclient.gui.hud.ScreenPosition;
import me.pvpclient.mods.ModDraggable;

public class ModHelloWorld extends ModDraggable {
    private ScreenPosition pos;
    @Override
    public void save(ScreenPosition pos) {
        this.pos = pos;
    }

    @Override
    public ScreenPosition load() {
        return pos;
    }

    @Override
    public int getWidth() {
        return font.getStringWidth("Hello World");
    }

    @Override
    public int getHeight() {
        return font.FONT_HEIGHT;
    }

    @Override
    public void render(ScreenPosition pos) {
        font.drawString("Hello World", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
    }

    @Override
    public void renderDummy(ScreenPosition pos) {
        font.drawString("Hello World", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0xFF00FF00);
    }
}
