package com.palyfight.superheatbot.branch;

import com.palyfight.superheatbot.leaf.RunToBank;
import com.palyfight.superheatbot.leaf.WalkToCoalRegion;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsMovingToBankDirection extends BranchTask {
    private final RunToBank runToBank = new RunToBank();
    private final WalkToCoalRegion walkToCoalRegion = new WalkToCoalRegion();
    private final Player player = Players.getLocal();
    @Override
    public boolean validate() {
        boolean movingToBank = true;
        if(player != null) {
            if(player.isMoving()) {
                player.getOrientationAsAngle();
            } else {
                // default to moving to bank
            }
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
