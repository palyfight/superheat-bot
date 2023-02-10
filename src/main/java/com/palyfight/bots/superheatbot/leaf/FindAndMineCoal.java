package com.palyfight.bots.superheatbot.leaf;

import com.palyfight.bots.superheatbot.util.Constants;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class FindAndMineCoal extends LeafTask {
    @Override
    public void execute() {
        GameObject mineableCoal = GameObjects.newQuery().within(Constants.COAL_AREA).names("Rocks").defaultColors(Constants.COAL_ROCK_COLOR).results().nearest();
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
