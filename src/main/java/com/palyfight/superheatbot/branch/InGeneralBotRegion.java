package com.palyfight.superheatbot.branch;

import com.palyfight.superheatbot.leaf.StopBot;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InGeneralBotRegion extends BranchTask {
    private final Area[] generalBotAreas = {
            new Area.Rectangular(new Coordinate(3086, 3249, 0), new Coordinate(3108, 3214, 0)),
            new Area.Rectangular(new Coordinate(3109, 3231, 0), new Coordinate(3144, 3205, 0)),
            new Area.Rectangular(new Coordinate(3130, 3204, 0), new Coordinate(3158, 3156, 0)),
            new Area.Rectangular(new Coordinate(3108, 3213, 0), new Coordinate(3091, 3206, 0)),
            new Area.Rectangular(new Coordinate(3165, 3146, 0), new Coordinate(3138, 3155, 0)),
            new Area.Rectangular(new Coordinate(3140, 3145, 0), new Coordinate(3160, 3142, 0))
    };
    private final StopBot stopBot = new StopBot();
    private final IsMovingToBankDirection isMovingToBankDirection = new IsMovingToBankDirection();
    private final Player player = Players.getLocal();

    @Override
    public boolean validate() {
        boolean playerInBotRegion = false;
        for(Area region : generalBotAreas)
            if(region.contains(player)) {
                playerInBotRegion = true;
                break;
            }

        return player != null && playerInBotRegion;
    }

    @Override
    public TreeTask successTask() {
        return isMovingToBankDirection;
    }

    @Override
    public TreeTask failureTask() {
        return stopBot;
    }
}
