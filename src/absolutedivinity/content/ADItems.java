package absolutedivinity.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class ADItems {

    public static Item
        ammoLevel1,
        ammoLevel2,
        ammoLevel3,
        healAmmo,
        homingAmmo,
        nanoAmmo,
        funnyMetal,
        mythril,
        blackMythril;

    public static Item
        livingSteel,
        livingSteelHard;

    public static Item
        cryogenicGel,
        cryogenicAlloy;

    public static Item
        fuelRod,
        steelAmalgam;

    public static void load() {

        ammoLevel1 = new Item("ammo-level-1", Color.valueOf("9d7600")) {{
            localizedName = "Copper Ammo";
            description = "Simple, boring ammo with absolutly no effects whatsoever.";
            cost = 2.5f;
            hardness = 4;
            flammability = 0.1f;
            explosiveness = 0.1f;
        }};

        ammoLevel2 = new Item("ammo-level-2", Color.valueOf("002b92")) {{
            localizedName = "Titanium Ammo";
            description = "Ammo made from titanium. Decent damage and has pierce.";
            cost = 2.5f;
            hardness = 6;
            flammability = 0.1f;
            explosiveness = 0.3f;
        }};

        ammoLevel3 = new Item("ammo-level-3", Color.valueOf("df0505")) {{
            localizedName = "Explosive Ammo";
            description = "Ammo made from blast compound. Decent damage and has a frag effect in some turrets.";
            cost = 2.5f;
            hardness = 3;
            flammability = 0.3f;
            explosiveness = 0.6f;
        }};

        healAmmo = new Item("heal-ammo", Color.valueOf("77df05")) {{
            localizedName = "Healing Ammo";
            description = "Ammo made from spore pods. No damage but heals hit allied blocks.";
            cost = 2.5f;
            hardness = 1;
            flammability = 0.2f;
            explosiveness = 0.05f;
        }};

        homingAmmo = new Item("homing-ammo", Color.valueOf("df21fa")) {{
            localizedName = "Homing Ammo";
            description = "Ammo made from thorium. Good damage and has a homing effect.";
            cost = 2.5f;
            hardness = 1;
            flammability = 0.2f;
            explosiveness = 1.2f;
            radioactivity = 0.3f;
        }};

        nanoAmmo = new Item("nano-ammo", Color.valueOf("6e0268")) {{
            localizedName = "Nano Ammo";
            description = "Ammo made from living steel that infects enemies with nano bots which burn them from the inside.";
            cost = 2.5f;
            hardness = 1;
            flammability = 0.6f;
            explosiveness = 0.1f;
        }};

        livingSteel = new Item("living-steel", Color.valueOf("88299f")) {{
            localizedName = "Living Steel";
            description = "A living piece of metal. Titanium infused with spores.";
            details = "In a small sector on Cerbero, a virus was contained by the ministry of defense. " +
                "The virus consisted of intelligent spores. " +
                "Scientists had done experiments and found that the spores had the ability to alter parts of electrical circuits to change the behaviour of maschines to their likings. " +
                "After the invention of the 'main core', these spores were infused into steel, hoping that their power could be used while annihilating their risks. " +
                "It was later found that the infused steel could multiply itself. " +
                "But is this really the case or does the infusion give the spores more power? Only time will tell...";
            cost = 2.5f;
            hardness = 3;
            flammability = 0.5f;
            explosiveness = 0f;
            frames = 24;
            frameTime = 5f;
        }};

        livingSteelHard = new Item("living-steel-hard", Color.valueOf("6d59c6")) {{
            localizedName = "Hardened Living Steel";
            description = "Living steel that was infused with thorium to make it more durable.";
            cost = 2.5f;
            hardness = 4;
            flammability = 0.3f;
            explosiveness = 0f;
            radioactivity = 0.2f;
        }};

        cryogenicGel = new Item("cryogenic-gel", Color.valueOf("4fa4c0")) {{
            localizedName = "Cryogenic Gel";
            description = "A very cold material made from mixing cryofluid and silicon. Used as one of the components to create [cyan]Cryogenic Alloy.";
            hardness = 1;
            flammability = 0f;
            explosiveness = 0f;
            radioactivity = 0f;
            charge = 0f;
        }};

        cryogenicAlloy = new Item("cryogenic-alloy", Color.valueOf("2cbcc9")) {{
            localizedName = "Cryogenic Alloy";
            description = "A shock-cooled, highly durable metal made from Igneous Alloy, Cryogenic Gel and Neutron Fluid. Useful in advanced electronic components.";
            hardness = 5;
            charge = 0.45f;
            explosiveness = 0f;
            flammability = 0f;
            radioactivity = 0f;
            cost = 1.4f;
        }};

        steelAmalgam = new Item("steel-alloy", Color.valueOf("ba6a83")) {{
            localizedName = "Steel Amalgam";
            description = "A compound material made from Copper, Living Steel and Surge Alloy.";
            flammability = 0.6f;
            explosiveness = 0.2f;
            charge = 0.9f;
            radioactivity = 0f;
        }};

        funnyMetal = new Item("funny-metal", Color.valueOf("7c00e6")){{
            localizedName = "Funny Metal";
            description = "It's funny metal. Not for campaign.";
            hardness = 5;
            cost = 3;
            flammability = Float.MAX_VALUE;
            explosiveness = Float.MAX_VALUE;
            radioactivity = Float.MAX_VALUE;
            charge = Float.MAX_VALUE;
            alwaysUnlocked = false;
        }};

        mythril = new Item("mythril", Color.valueOf("59b4c0")){{
            localizedName = "Mythril";
            description = "Light, extremely durable metal, perfect for high-rate projectiles.";
            hardness = 3;
            cost = 1.5f;
            flammability = 0.1f;
            explosiveness = 0f;
            radioactivity = 0.3f;
            charge = 0f;
        }};
    }
}
