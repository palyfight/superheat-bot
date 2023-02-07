package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.util.Arrays;
import java.util.stream.Stream;

public class DepositToBank extends LeafTask {
    String[] pickaxes = new String[]{"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe"};
    String[] itemsToKeep = Stream.concat(Arrays.stream(pickaxes),
            Arrays.stream(new String[]{"Nature rune"})).toArray(String[]::new);
    @Override
    public void execute() {
        Bank.depositAllExcept(itemsToKeep);
    }
}
