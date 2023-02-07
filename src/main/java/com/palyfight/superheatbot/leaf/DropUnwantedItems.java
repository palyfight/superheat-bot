package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.util.Arrays;
import java.util.stream.Stream;

public class DropUnwantedItems extends LeafTask {
    String[] pickaxes = new String[]{"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe"};
    String[] itemsToKeep = Stream.concat(Arrays.stream(pickaxes),
                    Arrays.stream(new String[]{"Nature rune", "Iron ore", "Coal", "Steel bar"})).toArray(String[]::new);
    @Override
    public void execute() {
        for(SpriteItem item : Inventory.getItems()) {
            if(!Arrays.asList(itemsToKeep).contains(item.getDefinition().getName())) {
               item.interact("Drop");
            }
        }
    }
}
