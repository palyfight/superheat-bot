package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class OpenBank extends LeafTask {
    private final Player player = Players.getLocal();
    @Override
    public void execute() {
        GameObject bank = GameObjects.newQuery().actions("Bank").results().nearest();
        if(player != null && bank != null) {
            if(!bank.isVisible())
                Camera.turnTo(bank);
            else {
                if (bank.interact("Bank")) {
                    Execution.delayUntil(Bank::isOpen, player::isMoving, 100, 1000 );
                }
            }
        }
    }
}
