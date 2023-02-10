package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.CloseBank;
import com.palyfight.bots.superheatbot.leaf.WithdrawIronOres;
import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsInventoryNearlyEmpty extends BranchTask {
    private final WithdrawIronOres withdrawIronOres = new WithdrawIronOres();
    private final CloseBank closeBank = new CloseBank();

    @Override
    public boolean validate() {
        return Inventory.getQuantity() <= 2
                && Inventory.containsAnyOf(Constants.PICKAXES);
    }

    @Override
    public TreeTask successTask() {
        return withdrawIronOres;
    }

    @Override
    public TreeTask failureTask() {
        return closeBank;
    }
}
