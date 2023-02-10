package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.OpenBank;
import com.palyfight.bots.superheatbot.leaf.WalkToCoalRegion;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InventoryHasFreeSlots extends BranchTask {
    private final OpenBank openBank = new OpenBank();
    private final WalkToCoalRegion walkToCoalRegion = new WalkToCoalRegion();
    @Override
    public boolean validate() {
        return Inventory.getEmptySlots() >= 2;
    }

    @Override
    public TreeTask successTask() {
        return walkToCoalRegion;
    }

    @Override
    public TreeTask failureTask() {
        return openBank;
    }
}
