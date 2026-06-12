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

    public static final Color
                chaosMain = Color.valueOf("ff6b6b"),
                chaosDark = Color.valueOf("1a1a1a"),
                chaosLight = Color.valueOf("ff9999"),
                chaosGlow = Color.valueOf("ff4444"),

                orderMain = Color.valueOf("ffffff"),
                orderDark = Color.valueOf("d0d0d0"),
                orderLight = Color.valueOf("ffffff"),
                orderGlow = Color.valueOf("f0f0f0"),

                voidMain = Color.valueOf("d0d4e8"),
                voidDark = Color.valueOf("18182a"),
                voidLight = Color.valueOf("f0f0ff"),
                voidGlow = Color.valueOf("a8b8ff"),

                infoMain = Color.valueOf("77df00"),
                infoDark = Color.valueOf("3a8a00"),
                infoLight = Color.valueOf("b0ff60"),
                infoGlow = Color.valueOf("99ff33"),

                abyssMain = Color.valueOf("9000a4"),
                abyssDark = Color.valueOf("5a0070"),
                abyssLight = Color.valueOf("c040d0"),
                abyssGlow = Color.valueOf("b020c0"),

                timeMain = Color.valueOf("f0e060"),
                timeDark = Color.valueOf("a09020"),
                timeLight = Color.valueOf("ffffb0"),
                timeGlow = Color.valueOf("e0d040");
}
