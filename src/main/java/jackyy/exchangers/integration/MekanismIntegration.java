package jackyy.exchangers.integration;

import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.ObjectHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MekanismIntegration {

    public static Object circuitBasic;
    public static Object circuitAdvanced;
    public static Object circuitElite;
    public static Object circuitUltimate;
    public static ItemStack teleportationCore;
    public static ItemStack energyTablet;
    public static ItemStack portableTeleporter;

    public static void init() {
        Reference.LOGGER.info("Fetching items for Mekanism integration...");

        if (ModConfig.misc.useOreDictCircuits) {
            circuitBasic = "circuitBasic";
            circuitAdvanced = "circuitAdvanced";
            circuitElite = "circuitElite";
            circuitUltimate = "circuitUltimate";
        } else {
            Item circuitsItem = ObjectHelper.getItemByName(Reference.MEK, "controlcircuit");
            if (circuitsItem != null) {
                circuitBasic = new ItemStack(circuitsItem, 1, 0);
                circuitAdvanced = new ItemStack(circuitsItem, 1, 1);
                circuitElite = new ItemStack(circuitsItem, 1, 2);
                circuitUltimate = new ItemStack(circuitsItem, 1, 3);
            }
        }

        Item energyTabletItem = ObjectHelper.getItemByName(Reference.MEK, "energytablet");
        if (energyTabletItem != null) {
            energyTablet = new ItemStack(energyTabletItem, 1, 0);
        }

        Item teleportationCoreItem = ObjectHelper.getItemByName(Reference.MEK, "teleportationcore");
        if (teleportationCoreItem != null) {
            teleportationCore = new ItemStack(teleportationCoreItem, 1, 0);
        }

        Item portableTeleporterItem = ObjectHelper.getItemByName(Reference.MEK, "portableteleporter");
        if (portableTeleporterItem != null) {
            portableTeleporter = new ItemStack(portableTeleporterItem, 1, 0);
        }
    }

}
