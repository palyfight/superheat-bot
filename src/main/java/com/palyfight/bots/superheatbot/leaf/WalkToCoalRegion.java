package com.palyfight.bots.superheatbot.leaf;

import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkToCoalRegion extends LeafTask {
    private final Player player = Players.getLocal();
    @Override
    public void execute() {
        WebPath path = Traversal.getDefaultWeb().getPathBuilder().buildTo(Constants.COAL_AREA);

        if (player != null && path != null && path.step(false)){
            Execution.delayUntil(()-> !player.isMoving(), player::isMoving, 1200, 2000);}
    }
}
