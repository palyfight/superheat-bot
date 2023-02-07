package com.palyfight.superheatbot.branch;

import com.palyfight.superheatbot.leaf.CloseBank;
import com.palyfight.superheatbot.leaf.WithdrawIronOres;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsInventoryNearlyEmpty extends BranchTask {
    private final WithdrawIronOres withdrawIronOres = new WithdrawIronOres();
    private final CloseBank closeBank = new CloseBank();
    String[] pickaxes = new String[]{"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe"};

    @Override
    public boolean validate() {
        return Inventory.getQuantity() <= 2
                && Inventory.containsAnyOf(pickaxes);
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
