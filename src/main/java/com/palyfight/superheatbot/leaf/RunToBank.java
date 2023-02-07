package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class RunToBank extends LeafTask {
    private final Area bankArea = new Area.Rectangular(new Coordinate(3092, 3245, 0), new Coordinate(3094, 3241, 0));
    private final Player player = Players.getLocal();

    @Override
    public void execute() {
        WebPath path = Traversal.getDefaultWeb().getPathBuilder().buildTo(bankArea);

        if (player != null && path != null && path.step()){
            Execution.delayUntil(()-> !player.isMoving(), player::isMoving, 1200, 2000);}
    }
}
