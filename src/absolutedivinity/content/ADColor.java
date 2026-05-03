package absolutedivinity.content;

import arc.graphics.Color;

public class ADColor {

    public static Color
                ichor = Color.valueOf("ffd700").cpy().lerp(Color.white, 0.15f),
                divineBlood = Color.valueOf("ffd700").cpy().lerp(Color.white, 0.25f),
                deepRed = Color.valueOf("8a0f1a").cpy().lerp(Color.black, 0.2f),
                crimsonRed = Color.valueOf("b11226").cpy().mul(1.1f),
                richBlue = Color.valueOf("1f4fff").cpy().lerp(Color.white, 0.1f),
                energyBlue = Color.valueOf("3aa0ff").cpy().lerp(Color.white, 0.2f);
}
