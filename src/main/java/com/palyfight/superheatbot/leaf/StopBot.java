package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class StopBot extends LeafTask {
    @Override
    public void execute() {
        if(Environment.getBot() != null)
            Environment.getBot().stop("Stopping bot!");
    }
}
