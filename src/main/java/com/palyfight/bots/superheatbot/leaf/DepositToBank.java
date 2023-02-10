package com.palyfight.bots.superheatbot.leaf;

import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.util.Arrays;
import java.util.stream.Stream;

public class DepositToBank extends LeafTask {
    String[] itemsToKeep = Stream.concat(Arrays.stream(Constants.PICKAXES),
            Arrays.stream(new String[]{"Nature rune"})).toArray(String[]::new);
    @Override
    public void execute() {
        Bank.depositAllExcept(itemsToKeep);
    }
}
