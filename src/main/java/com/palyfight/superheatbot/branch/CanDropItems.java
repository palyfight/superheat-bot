package com.palyfight.superheatbot.branch;

import com.palyfight.superheatbot.leaf.DropUnwantedItems;
import com.palyfight.superheatbot.leaf.RunToBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanDropItems extends BranchTask {
    private final DropUnwantedItems dropUnwantedItems = new DropUnwantedItems();
    private final RunToBank runToBank = new RunToBank();
    String[] pickaxes = new String[]{"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe"};
    String[] itemsToKeep = Stream.concat(Arrays.stream(pickaxes),
            Arrays.stream(new String[]{"Nature rune", "Iron ore", "Coal", "Steel bar"})).toArray(String[]::new);
    @Override
    public boolean validate() {
        var itemsToDrop = Inventory.getItems().stream()
                .filter(item -> !Arrays.asList(itemsToKeep).contains(item.getDefinition().getName()))
                .collect(Collectors.toList());

        return !itemsToDrop.isEmpty();
    }

    @Override
    public TreeTask successTask() {
        return dropUnwantedItems;
    }

    @Override
    public TreeTask failureTask() {
        return runToBank;
    }
}
