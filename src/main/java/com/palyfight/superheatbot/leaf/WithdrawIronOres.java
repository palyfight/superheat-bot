package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WithdrawIronOres extends LeafTask {
    @Override
    public void execute() {
        if(Bank.isOpen()) {
            Bank.withdraw("Iron ore", 24);
        }
    }
}
