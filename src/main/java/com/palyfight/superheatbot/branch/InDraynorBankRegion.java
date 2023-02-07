package com.palyfight.superheatbot.branch;

import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InDraynorBankRegion extends BranchTask {
    Area draynorBankArea = new Area.Rectangular(new Coordinate(3092, 3245, 0), new Coordinate(3094, 3241, 0));
    private final IsBankOpen isBankOpen = new IsBankOpen();
    private final InGeneralBotRegion inGeneralBotRegion = new InGeneralBotRegion();

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        return player != null && draynorBankArea.contains(player.getPosition());
    }

    @Override
    public TreeTask successTask() {
        return isBankOpen;
    }

    @Override
    public TreeTask failureTask() {
        return inGeneralBotRegion;
    }
}
