package com.palyfight.bots.superheatbot;

import com.palyfight.bots.superheatbot.branch.InDraynorBankRegion;
import com.palyfight.bots.superheatbot.branch.IsInventoryFull;
import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InCoalRegionRoot extends BranchTask {
    private final IsInventoryFull isInventoryFull = new IsInventoryFull();
    private final InDraynorBankRegion inDraynorBankRegion = new InDraynorBankRegion();

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        return player != null && Constants.COAL_AREA.contains(player.getPosition());
    }

    @Override
    public TreeTask successTask() {
        return isInventoryFull;
    }

    @Override
    public TreeTask failureTask() {
        return inDraynorBankRegion;
    }
}
