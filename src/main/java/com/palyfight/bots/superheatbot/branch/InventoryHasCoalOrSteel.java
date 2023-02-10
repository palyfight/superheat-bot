package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.DepositToBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InventoryHasCoalOrSteel extends BranchTask {
    private final DepositToBank depositToBank = new DepositToBank();
    private final IsInventoryNearlyEmpty isInventoryNearlyEmpty = new IsInventoryNearlyEmpty();
    @Override
    public boolean validate() {
        return Inventory.containsAnyOf("Coal", "Steel bar");
    }

    @Override
    public TreeTask successTask() {
        return depositToBank;
    }

    @Override
    public TreeTask failureTask() {
        return isInventoryNearlyEmpty;
    }
}
