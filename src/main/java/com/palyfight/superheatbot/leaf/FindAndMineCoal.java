package com.palyfight.superheatbot.leaf;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.awt.*;

public class FindAndMineCoal extends LeafTask {
    private final Color coalRock = new Color(56,56,37);
    private final Area coalArea = new Area.Rectangular(new Coordinate(3143, 3154, 0), new Coordinate(3146, 3149, 0));
    @Override
    public void execute() {
        GameObject mineableCoal = GameObjects.newQuery().within(coalArea).names("Rocks").defaultColors(coalRock).results().nearest();
        if(mineableCoal != null) {
            var miningXpBefore = Skill.MINING.getExperience();
            if(mineableCoal.isVisible()) {
                mineableCoal.interact("Mine");
                Execution.delayUntil(() -> !mineableCoal.isValid() || Skill.MINING.getExperience() > miningXpBefore, 200, 15000);
            } else {
                Camera.turnTo(mineableCoal);
            }
        }
    }
}
