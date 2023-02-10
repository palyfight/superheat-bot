package com.palyfight.bots.superheatbot.branch;

import com.palyfight.bots.superheatbot.leaf.RunToBank;
import com.palyfight.bots.superheatbot.leaf.DropUnwantedItems;
import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanDropItems extends BranchTask {
    private final DropUnwantedItems dropUnwantedItems = new DropUnwantedItems();
    private final RunToBank runToBank = new RunToBank();
    String[] itemsToKeep = Stream.concat(Arrays.stream(Constants.PICKAXES),
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
