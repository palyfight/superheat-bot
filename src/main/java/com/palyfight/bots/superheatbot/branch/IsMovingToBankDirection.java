package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.RunToBank;
import com.palyfight.bots.superheatbot.leaf.WalkToCoalRegion;
import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class IsMovingToBankDirection extends BranchTask {
    private final RunToBank runToBank = new RunToBank();
    private final WalkToCoalRegion walkToCoalRegion = new WalkToCoalRegion();
    private final Player player = Players.getLocal();
    @Override
    public boolean validate() {
        boolean movingToBank = true;
        if(player != null) {
            if(player.isMoving() && player.isFacing(Constants.COAL_AREA))
                movingToBank = false;
        }
        return movingToBank;
    }

    @Override
    public TreeTask successTask() {
        return runToBank;
    }

    @Override
    public TreeTask failureTask() {
        return walkToCoalRegion;
    }
}
