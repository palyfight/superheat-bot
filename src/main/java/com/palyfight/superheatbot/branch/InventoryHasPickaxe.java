package com.palyfight.superheatbot.branch;

import com.palyfight.superheatbot.leaf.StopBot;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InventoryHasPickaxe extends BranchTask {
    String[] pickaxes = new String[]{"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe"};
    private final StopBot stopBot = new StopBot();
    private final InventoryHasFreeSlots inventoryHasFreeSlots = new InventoryHasFreeSlots();

    @Override
    public boolean validate() {
        return Inventory.containsAnyOf(pickaxes);
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
