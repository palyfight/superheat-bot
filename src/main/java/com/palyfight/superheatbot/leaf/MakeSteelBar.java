package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.entities.definitions.ItemDefinition;
import com.runemate.game.api.hybrid.local.hud.interfaces.InterfaceWindows;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.osrs.local.hud.interfaces.Magic;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class MakeSteelBar extends LeafTask {
    @Override
    public void execute() {
        SpriteItem ironOre = Inventory.getItems("Iron ore").first();

        if (ironOre != null) {
            ItemDefinition ironOreDef = ironOre.getDefinition();

            if (!InterfaceWindows.getMagic().isOpen()) {
                openSpellBook();
            }

            if (Magic.SUPERHEAT_ITEM.activate())
                Execution.delay(100, 200);

            if (Magic.SUPERHEAT_ITEM.isSelected() &&
                    ironOreDef != null &&
                    ironOre.interact("Cast", Magic.getSelected().getComponent().getName() + " -> " + ironOreDef.getName())) { //Try to interact with the item and if successful
                Execution.delayUntil(() -> InterfaceWindows.getMagic().isOpen(), 2000); //Wait until the magic window has opened again or until 2000 ms (2 seconds) has passed
            }

            // Make sure we ALWAYS end up in the inventory panel after each superheat cast
            if (!InterfaceWindows.getInventory().isOpen()) {
                openInventory();
            }
        }
    }

    private void openSpellBook() {
        if (InterfaceWindows.getMagic().open()) { //Attempt to open the magic book and is successful
            Execution.delayUntil(() -> InterfaceWindows.getMagic().isOpen(), 1000);
        }
    }

    private void openInventory() {
        Execution.delayUntil(() -> InterfaceWindows.getInventory().open(), 1000);
    }
}
