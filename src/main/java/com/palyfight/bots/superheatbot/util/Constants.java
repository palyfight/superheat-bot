package com.palyfight.bots.superheatbot.util;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;

import java.awt.*;

public class Constants {
    public static final Area COAL_AREA = new Area.Rectangular(new Coordinate(3143, 3154, 0), new Coordinate(3146, 3149, 0));
    public static final Area BANK_AREA = new Area.Rectangular(new Coordinate(3092, 3245, 0), new Coordinate(3094, 3241, 0));
    public static final Area[] GENERAL_BOT_AREA = {
            new Area.Rectangular(new Coordinate(3086, 3249, 0), new Coordinate(3108, 3214, 0)),
            new Area.Rectangular(new Coordinate(3109, 3231, 0), new Coordinate(3144, 3205, 0)),
            new Area.Rectangular(new Coordinate(3130, 3204, 0), new Coordinate(3158, 3156, 0)),
            new Area.Rectangular(new Coordinate(3108, 3213, 0), new Coordinate(3091, 3206, 0)),
            new Area.Rectangular(new Coordinate(3165, 3146, 0), new Coordinate(3138, 3155, 0)),
            new Area.Rectangular(new Coordinate(3140, 3145, 0), new Coordinate(3160, 3142, 0))
    };
    public static final String[] PICKAXES = new String[]{"Bronze pickaxe", "Iron pickaxe", "Steel pickaxe", "Black pickaxe", "Mithril pickaxe", "Adamant pickaxe", "Rune pickaxe"};
    public static final Color COAL_ROCK_COLOR = new Color(56,56,37);
}
