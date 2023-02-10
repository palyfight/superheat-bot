package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.StopBot;
import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InGeneralBotRegion extends BranchTask {
    private final StopBot stopBot = new StopBot();
    private final IsMovingToBankDirection isMovingToBankDirection = new IsMovingToBankDirection();
    private final Player player = Players.getLocal();

    @Override
    public boolean validate() {
        boolean playerInBotRegion = false;
        for(Area region : Constants.GENERAL_BOT_AREA)
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
