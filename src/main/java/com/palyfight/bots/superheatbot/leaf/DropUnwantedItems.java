package com.palyfight.bots.superheatbot.leaf;

import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.util.Arrays;
import java.util.stream.Stream;

public class DropUnwantedItems extends LeafTask {
    String[] itemsToKeep = Stream.concat(Arrays.stream(Constants.PICKAXES),
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
