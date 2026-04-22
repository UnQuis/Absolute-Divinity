package absolutedivinity.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class ADLiquids {
    public static Liquid
        acid,
        livingSteelLiquid,
        neutronFluid,
        steam;

        public static void load(){
            acid = new Liquid("acid", Color.valueOf("cde03a")){{
                localizedName = "Acid";
                description = "A dangerous liquid.";
                coolant = false;
                temperature = 0.2f;
                viscosity = 0.2f;
            }};

            livingSteelLiquid = new Liquid("living-steel-liquid", Color.valueOf("9000a4")){{
                localizedName = "Living Steel Liquid";
                description = "Living Steel that was infused with oil thus making it a liquid. Spreads to nearby oil to 'self-replicate'.";
                coolant = false;
                blockReactive = false;
                viscosity = 0.6f;
                temperature = 0.125f;
                explosiveness = 0.05f;
                heatCapacity = 0.9f;
                capPuddles = true;
                flammability = 1;
                incinerable = true;
                moveThroughBlocks = true;
            }};

            neutronFluid = new Liquid("neutron-fluid", Color.valueOf("e9e9e9")){{
                localizedName = "Neutron Fluid";
                description = "A highly potent coolant created by mixing oil, cryofluid and living steel liquid.";
                coolant = true;
                temperature = 0.1f;
                explosiveness = 2.5f;
                heatCapacity = 1.5f;
                viscosity = 0.5f;
                flammability = 0;
            }};

            steam = new Liquid("steam", Color.valueOf("ececec")){{
                localizedName = "Steam";
                description = "Evaporated water.";
                coolant = false;
                flammability = 0;
                gas = true;
                heatCapacity = 0.1f;
                explosiveness = 0;
                temperature = 0.1f;
                gasColor = Color.valueOf("ececec");
            }};
        }

}
