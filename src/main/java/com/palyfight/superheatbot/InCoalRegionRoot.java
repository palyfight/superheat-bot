package com.palyfight.superheatbot;

import com.palyfight.superheatbot.branch.InDraynorBankRegion;
import com.palyfight.superheatbot.branch.IsInventoryFull;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InCoalRegionRoot extends BranchTask {
    Area coalArea = new Area.Rectangular(new Coordinate(3143, 3154, 0), new Coordinate(3146, 3149, 0));
    private final IsInventoryFull isInventoryFull = new IsInventoryFull();
    private final InDraynorBankRegion inDraynorBankRegion = new InDraynorBankRegion();

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        return player != null && coalArea.contains(player.getPosition());
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
