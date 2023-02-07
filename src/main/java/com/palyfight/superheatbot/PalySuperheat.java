package com.palyfight.superheatbot;

import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class PalySuperheat extends TreeBot {
    @Override
    public TreeTask createRootTask() {
        return new InCoalRegionRoot();
    }
}
