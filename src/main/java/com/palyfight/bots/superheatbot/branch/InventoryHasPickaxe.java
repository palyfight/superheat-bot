package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.StopBot;
import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InventoryHasPickaxe extends BranchTask {
    private final StopBot stopBot = new StopBot();
    private final InventoryHasFreeSlots inventoryHasFreeSlots = new InventoryHasFreeSlots();

    @Override
    public boolean validate() {
        return Inventory.containsAnyOf(Constants.PICKAXES);
    }

    @Override
    public TreeTask successTask() {
        return inventoryHasFreeSlots;
    }

    @Override
    public TreeTask failureTask() {
        return stopBot;
    }
}
