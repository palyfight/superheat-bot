package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InDraynorBankRegion extends BranchTask {
    private final IsBankOpen isBankOpen = new IsBankOpen();
    private final InGeneralBotRegion inGeneralBotRegion = new InGeneralBotRegion();

    @Override
    public boolean validate() {
        Player player = Players.getLocal();
        return player != null && Constants.BANK_AREA.contains(player.getPosition());
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
