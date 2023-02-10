package com.palyfight.bots.superheatbot;

import com.palyfight.bots.superheatbot.ui.ExampleSettings;
import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.runemate.ui.setting.annotation.open.SettingsProvider;
import lombok.extern.log4j.Log4j2;

@Log4j2(topic = "PalySuperheat")
public class PalySuperheat extends TreeBot {
    @SettingsProvider
    private ExampleSettings settings;

    @Override
    public TreeTask createRootTask() {
        log.info("Starting superheat bot :) ");
        return new InCoalRegionRoot();
    }
}
