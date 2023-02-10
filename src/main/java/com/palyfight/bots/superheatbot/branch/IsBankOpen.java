package com.palyfight.bots.superheatbot.branch;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsBankOpen extends BranchTask {
    private final InventoryHasCoalOrSteel inventoryHasCoalOrSteel = new InventoryHasCoalOrSteel();
    private final InventoryHasPickaxe inventoryHasPickaxe = new InventoryHasPickaxe();
    @Override
    public boolean validate() {
        return Bank.isOpen();
    }

    @Override
    public TreeTask successTask() {
        return inventoryHasCoalOrSteel;
    }

    @Override
    public TreeTask failureTask() {
        return inventoryHasPickaxe;
    }
}
