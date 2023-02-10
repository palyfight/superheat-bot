package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.FindAndMineCoal;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsInventoryFull extends BranchTask {
    private final FindAndMineCoal findAndMineCoal = new FindAndMineCoal();
    private final CanSuperheat canSuperheat = new CanSuperheat();

    @Override
    public boolean validate() {
       return Inventory.isFull();
    }

    @Override
    public TreeTask successTask() {
        return canSuperheat;
    }

    @Override
    public TreeTask failureTask() {
        return findAndMineCoal;
    }
}
