package com.palyfight.bots.superheatbot.ui;

import com.runemate.ui.setting.annotation.open.Setting;
import com.runemate.ui.setting.annotation.open.SettingsGroup;
import com.runemate.ui.setting.open.Settings;

@SettingsGroup
public interface ExampleSettings extends Settings {
    @Setting(key = "logsToChop", title = "Logs to Chop", description = "How many logs the bot should chop")
    default int logToChop() {
        return 1000;
    }
}
