package com.palyfight.superheatbot.branch;

import com.palyfight.superheatbot.leaf.MakeSteelBar;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class CanSuperheat extends BranchTask {
    private final CanDropItems canDropItems = new CanDropItems();
    private final MakeSteelBar makeSteelBar = new MakeSteelBar();
    @Override
    public boolean validate() {
        return Equipment.contains("Staff of fire")
                && Skill.MAGIC.getCurrentLevel() >= 43
                && Inventory.contains("Nature Rune")
                && Inventory.getItems("Coal").size() >= 2
                && Inventory.contains("Iron ore");
    }

    @Override
    public TreeTask successTask() {
        return makeSteelBar;
    }

    @Override
    public TreeTask failureTask() {
        return canDropItems;
    }
}
