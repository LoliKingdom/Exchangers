package jackyy.exchangers.registry;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.integration.EnderIOIntegration;
import jackyy.exchangers.integration.ImmersiveEngineeringIntegration;
import jackyy.exchangers.integration.MekanismIntegration;
import jackyy.exchangers.integration.ThermalExpansionIntegration;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import javax.annotation.Nonnull;

public class ModRecipes {

    public static void init(RegistryEvent.Register<IRecipe> e) {

        if (ModConfig.modules.enderIOModule) {
            if (Loader.isModLoaded(Exchangers.EIO)) {
                EnderIOIntegration.init();
            }
        }
        if (ModConfig.modules.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                ThermalExpansionIntegration.init();
            }
        }
        if (ModConfig.modules.mekanismModule) {
            if (Loader.isModLoaded(Exchangers.MEK)) {
                MekanismIntegration.init();
            }
        }
        if (ModConfig.modules.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Exchangers.IE)) {
                ImmersiveEngineeringIntegration.init();
            }
        }

        if (ModConfig.modules.vanillaModule) {
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Exchangers.MODID + ":wooden_exchanger"), null, new ItemStack(ModItems.woodenExchanger),
                    "WEW", "WCW", "WEW",
                    'W', "logWood", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT1
            );
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier1"), null, new ItemStack(ModItems.exchangerCoreT1),
                    "WRW", "RPR", "WRW",
                    'R', "dyeRed", 'W', "logWood", 'P', "enderpearl"
            );
            switch (ModConfig.recipeTweaks.vanillaRecipesType) {
                case "easy": {
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":stone_exchanger_easy"), null, new ItemStack(ModItems.stoneExchanger),
                            "SES", "SCS", "SES",
                            'S', "stone", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":golden_exchanger_easy"), null, new ItemStack(ModItems.goldenExchanger),
                            "GEG", "GCG", "GEG",
                            'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT2
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":iron_exchanger_easy"), null, new ItemStack(ModItems.ironExchanger),
                            "IEI", "ICI", "IEI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT2
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":diamond_exchanger_easy"), null, new ItemStack(ModItems.diamondExchanger),
                            "DED", "DCD", "DED",
                            'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":emerald_exchanger_easy"), null, new ItemStack(ModItems.emeraldExchanger),
                            "MEM", "MCM", "MEM",
                            'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":obsidian_exchanger_easy"), null, new ItemStack(ModItems.obsidianExchanger),
                            "OEO", "OCO", "OEO",
                            'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier2_easy"), null, new ItemStack(ModItems.exchangerCoreT2),
                            "ILI", "LEL", "ILI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis"
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier3_easy"), null, new ItemStack(ModItems.exchangerCoreT3),
                            "DED", "EBE", "DED",
                            'D', "gemDiamond", 'E', "gemEmerald", 'B', "blockDiamond"
                    );
                    break;
                }
                case "normal": {
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":stone_exchanger_normal"), new ItemStack(ModItems.stoneExchanger), new ItemStack(ModItems.woodenExchanger),
                            "SCS", "EXE", "SSS",
                            'S', "stone", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT1, 'X', ModItems.woodenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":golden_exchanger_normal"), new ItemStack(ModItems.goldenExchanger), new ItemStack(ModItems.stoneExchanger),
                            "GCG", "EXE", "GGG",
                            'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT2, 'X', ModItems.stoneExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":iron_exchanger_normal"), new ItemStack(ModItems.ironExchanger), new ItemStack(ModItems.goldenExchanger),
                            "ICI", "EXE", "III",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT2, 'X', ModItems.goldenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":diamond_exchanger_normal"), new ItemStack(ModItems.diamondExchanger), new ItemStack(ModItems.ironExchanger),
                            "DCD", "EXE", "DDD",
                            'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3, 'X', ModItems.ironExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":emerald_exchanger_normal"), new ItemStack(ModItems.emeraldExchanger), new ItemStack(ModItems.diamondExchanger),
                            "MCM", "EXE", "MMM",
                            'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3, 'X', ModItems.diamondExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":obsidian_exchanger_normal"), new ItemStack(ModItems.obsidianExchanger), new ItemStack(ModItems.emeraldExchanger),
                            "OCO", "EXE", "OOO",
                            'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3, 'X', ModItems.emeraldExchanger
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier2_normal"), null, new ItemStack(ModItems.exchangerCoreT2),
                            "ILI", "ECE", "ILI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ModItems.exchangerCoreT1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier3_normal"), null, new ItemStack(ModItems.exchangerCoreT3),
                            "DED", "BCB", "DED",
                            'D', "gemDiamond", 'E', "gemEmerald", 'C', ModItems.exchangerCoreT2, 'B', "blockDiamond"
                    );
                    break;
                }
                case "hard": {
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":stone_exchanger_hard"), new ItemStack(ModItems.stoneExchanger), new ItemStack(ModItems.woodenExchanger),
                            "SES", "CXC", "SES",
                            'S', "stone", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT1, 'X', ModItems.woodenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":golden_exchanger_hard"), new ItemStack(ModItems.goldenExchanger), new ItemStack(ModItems.stoneExchanger),
                            "GEG", "CXC", "GEG",
                            'G', "ingotGold", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT2, 'X', ModItems.stoneExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":iron_exchanger_hard"), new ItemStack(ModItems.ironExchanger), new ItemStack(ModItems.goldenExchanger),
                            "IEI", "CXC", "IEI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT2, 'X', ModItems.goldenExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":diamond_exchanger_hard"), new ItemStack(ModItems.diamondExchanger), new ItemStack(ModItems.ironExchanger),
                            "DED", "CXC", "DED",
                            'D', "gemDiamond", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3, 'X', ModItems.ironExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":emerald_exchanger_hard"), new ItemStack(ModItems.emeraldExchanger), new ItemStack(ModItems.diamondExchanger),
                            "MEM", "CXC", "MEM",
                            'M', "gemEmerald", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3, 'X', ModItems.diamondExchanger
                    );
                    new ShapedCopyNBTRecipe(
                            e, new ResourceLocation(Exchangers.MODID + ":obsidian_exchanger_hard"), new ItemStack(ModItems.obsidianExchanger), new ItemStack(ModItems.emeraldExchanger),
                            "OEO", "CXC", "OEO",
                            'O', "obsidian", 'E', Items.ENDER_EYE, 'C', ModItems.exchangerCoreT3, 'X', ModItems.emeraldExchanger
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier2_hard"), null, new ItemStack(ModItems.exchangerCoreT2),
                            "ILI", "CEC", "ILI",
                            'I', "ingotIron", 'E', Items.ENDER_EYE, 'L', "gemLapis", 'C', ModItems.exchangerCoreT1
                    );
                    GameRegistry.addShapedRecipe(
                            new ResourceLocation(Exchangers.MODID + ":vanilla_core_tier3_hard"), null, new ItemStack(ModItems.exchangerCoreT3),
                            "DCE", "CBC", "ECD",
                            'D', "gemDiamond", 'E', "gemEmerald", 'C', ModItems.exchangerCoreT2, 'B', "blockDiamond"
                    );
                    break;
                }
            }
        }

        if (ModConfig.modules.enderIOModule) {
            if (Loader.isModLoaded(Exchangers.EIO)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":conductive_exchanger"), null, new ItemStack(ModItems.conductiveIronExchanger),
                        "IBI", "ICI", "IBI",
                        'I', "ingotConductiveIron", 'B', EnderIOIntegration.basicCapacitor, 'C', ModItems.eioExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":eio_core_tier1"), null, new ItemStack(ModItems.eioExchangerCoreT1),
                        "PCP", "CNC", "PCP",
                        'P', "nuggetPulsatingIron", 'C', "ingotConductiveIron", 'N', EnderIOIntegration.bucketNutrientDistillation
                );
                switch (ModConfig.recipeTweaks.enderIORecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":pulsating_exchanger_easy"), null, new ItemStack(ModItems.pulsatingIronExchanger),
                                "IPI", "ICI", "IBI",
                                'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ModItems.eioExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":electricalsteel_exchanger_easy"), null, new ItemStack(ModItems.electricalSteelExchanger),
                                "SDS", "SCS", "SBS",
                                'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ModItems.eioExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":energetic_exchanger_easy"), null, new ItemStack(ModItems.energeticExchanger),
                                "ADA", "ACA", "ABA",
                                'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ModItems.eioExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":darksteel_exchanger_easy"), null, new ItemStack(ModItems.darkSteelExchanger),
                                "SVS", "SCS", "SOS",
                                'S', "ingotDarkSteel", 'B', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ModItems.eioExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":vibrant_exchanger_easy"), null, new ItemStack(ModItems.vibrantExchanger),
                                "AEA", "ACA", "ABA",
                                'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ModItems.eioExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier2_easy"), null, new ItemStack(ModItems.eioExchangerCoreT2),
                                "PSP", "SDS", "PSP",
                                'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier3_easy"), null, new ItemStack(ModItems.eioExchangerCoreT3),
                                "DBD", "BVB", "DBD",
                                'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":pulsating_exchanger_normal"), new ItemStack(ModItems.pulsatingIronExchanger), new ItemStack(ModItems.conductiveIronExchanger),
                                "ICI", "PXP", "IBI",
                                'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ModItems.eioExchangerCoreT1, 'X', ModItems.conductiveIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":electricalsteel_exchanger_normal"), new ItemStack(ModItems.electricalSteelExchanger), new ItemStack(ModItems.pulsatingIronExchanger),
                                "SCS", "DXD", "SBS",
                                'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ModItems.eioExchangerCoreT2, 'X', ModItems.pulsatingIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":energetic_exchanger_normal"), new ItemStack(ModItems.energeticExchanger), new ItemStack(ModItems.electricalSteelExchanger),
                                "ACA", "DXD", "ABA",
                                'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ModItems.eioExchangerCoreT2, 'X', ModItems.electricalSteelExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":darksteel_exchanger_normal"), new ItemStack(ModItems.darkSteelExchanger), new ItemStack(ModItems.energeticExchanger),
                                "SCS", "VXV", "SOS",
                                'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ModItems.eioExchangerCoreT3, 'X', ModItems.energeticExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":vibrant_exchanger_normal"), new ItemStack(ModItems.vibrantExchanger), new ItemStack(ModItems.darkSteelExchanger),
                                "ACA", "EXE", "ABA",
                                'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ModItems.eioExchangerCoreT3, 'X', ModItems.darkSteelExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier2_normal"), null, new ItemStack(ModItems.eioExchangerCoreT2),
                                "PSP", "DCD", "PSP",
                                'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ModItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier3_normal"), null, new ItemStack(ModItems.eioExchangerCoreT3),
                                "DBD", "VCV", "DBD",
                                'C', ModItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'B', EnderIOIntegration.basicCapacitor, 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":pulsating_exchanger_hard"), new ItemStack(ModItems.pulsatingIronExchanger), new ItemStack(ModItems.conductiveIronExchanger),
                                "IPI", "CXC", "IBI",
                                'I', "ingotPulsatingIron", 'P', EnderIOIntegration.pulsatingCrystal, 'B', EnderIOIntegration.basicCapacitor, 'C', ModItems.eioExchangerCoreT1, 'X', ModItems.conductiveIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":electricalsteel_exchanger_hard"), new ItemStack(ModItems.electricalSteelExchanger), new ItemStack(ModItems.pulsatingIronExchanger),
                                "SDS", "CXC", "SBS",
                                'S', "ingotElectricalSteel", 'B', EnderIOIntegration.capacitorBankBasic, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ModItems.eioExchangerCoreT2, 'X', ModItems.pulsatingIronExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":energetic_exchanger_hard"), new ItemStack(ModItems.energeticExchanger), new ItemStack(ModItems.electricalSteelExchanger),
                                "ADA", "CXC", "ABA",
                                'A', "ingotEnergeticAlloy", 'B', EnderIOIntegration.capacitorBank, 'D', EnderIOIntegration.doubleLayerCapacitor, 'C', ModItems.eioExchangerCoreT2, 'X', ModItems.electricalSteelExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":darksteel_exchanger_hard"), new ItemStack(ModItems.darkSteelExchanger), new ItemStack(ModItems.energeticExchanger),
                                "SVS", "CXC", "SOS",
                                'S', "ingotDarkSteel", 'O', EnderIOIntegration.octadicCapacitor, 'V', EnderIOIntegration.vibrantCrystal, 'C', ModItems.eioExchangerCoreT3, 'X', ModItems.energeticExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":vibrant_exchanger_hard"), new ItemStack(ModItems.vibrantExchanger), new ItemStack(ModItems.darkSteelExchanger),
                                "AEA", "CXC", "ABA",
                                'A', "ingotVibrantAlloy", 'B', EnderIOIntegration.capacitorBankVibrant, 'E', EnderIOIntegration.enderCrystal, 'C', ModItems.eioExchangerCoreT3, 'X', ModItems.darkSteelExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier2_hard"), null, new ItemStack(ModItems.eioExchangerCoreT2),
                                "PSP", "CDC", "PSP",
                                'P', "itemPulsatingPowder", 'S', "ingotElectricalSteel", 'C', ModItems.eioExchangerCoreT1, 'D', EnderIOIntegration.bucketDewOfTheVoid
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":eio_core_tier3_hard"), null, new ItemStack(ModItems.eioExchangerCoreT3),
                                "DCD", "CVC", "DCD",
                                'C', ModItems.eioExchangerCoreT2, 'D', "ingotDarkSteel", 'V', EnderIOIntegration.bucketVaporOfLevity
                        );
                        break;
                    }
                }
            }
        }

        if (ModConfig.modules.thermalExpansionModule) {
            if (Loader.isModLoaded(Exchangers.TE)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":leadstone_exchanger"), null, new ItemStack(ModItems.leadstoneExchanger),
                        "LSL", "LCL", "LFL",
                        'L', "ingotLead", 'S', ThermalExpansionIntegration.redstoneServo, 'F', ThermalExpansionIntegration.fluxCapacitorBasic, 'C', ModItems.teExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":te_core_tier1"), null, new ItemStack(ModItems.teExchangerCoreT1),
                        "CLC", "LRL", "CLC",
                        'C', "gearCopper", 'L', "ingotLead", 'R', ThermalExpansionIntegration.bucketResonantEnder
                );
                switch (ModConfig.recipeTweaks.thermalExpansionRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":hardened_exchanger_easy"), null, new ItemStack(ModItems.hardenedExchanger),
                                "IRI", "ICI", "IFI",
                                'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ModItems.teExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":reinforced_exchanger_easy"), null, new ItemStack(ModItems.reinforcedExchanger),
                                "ERE", "ECE", "EFE",
                                'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ModItems.teExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":signalum_exchanger_easy"), null, new ItemStack(ModItems.signalumExchanger),
                                "SRS", "SCS", "SFS",
                                'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ModItems.teExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":resonant_exchanger_easy"), null, new ItemStack(ModItems.resonantExchanger),
                                "IRI", "ICI", "IFI",
                                'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ModItems.teExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier2_easy"), null, new ItemStack(ModItems.teExchangerCoreT2),
                                "BIB", "IGI", "BIB",
                                'B', "gearBronze", 'I', "gearInvar", 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier3_easy"), null, new ItemStack(ModItems.teExchangerCoreT3),
                                "LSL", "SGS", "LSL",
                                'S', "gearSignalum", 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hardened_exchanger_normal"), new ItemStack(ModItems.hardenedExchanger), new ItemStack(ModItems.leadstoneExchanger),
                                "ICI", "RXR", "IFI",
                                'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ModItems.teExchangerCoreT1, 'X', ModItems.leadstoneExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":reinforced_exchanger_normal"), new ItemStack(ModItems.reinforcedExchanger), new ItemStack(ModItems.hardenedExchanger),
                                "ECE", "RXR", "EFE",
                                'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ModItems.teExchangerCoreT2, 'X', ModItems.hardenedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":signalum_exchanger_normal"), new ItemStack(ModItems.signalumExchanger), new ItemStack(ModItems.reinforcedExchanger),
                                "SCS", "RXR", "SFS",
                                'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ModItems.teExchangerCoreT3, 'X', ModItems.reinforcedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":resonant_exchanger_normal"), new ItemStack(ModItems.resonantExchanger), new ItemStack(ModItems.signalumExchanger),
                                "ICI", "RXR", "IFI",
                                'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ModItems.teExchangerCoreT3, 'X', ModItems.signalumExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier2_normal"), null, new ItemStack(ModItems.teExchangerCoreT2),
                                "BIB", "GCG", "BIB",
                                'B', "gearBronze", 'I', "gearInvar", 'C', ModItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier3_normal"), null, new ItemStack(ModItems.teExchangerCoreT3),
                                "LSL", "GCG", "LSL",
                                'C', ModItems.teExchangerCoreT2, 'L', "gearLumium", 'S', "gearSignalum", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hardened_exchanger_hard"), new ItemStack(ModItems.hardenedExchanger), new ItemStack(ModItems.leadstoneExchanger),
                                "IRI", "CXC", "IFI",
                                'I', "ingotInvar", 'R', ThermalExpansionIntegration.redstoneReceptionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorHardened, 'C', ModItems.teExchangerCoreT1, 'X', ModItems.leadstoneExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":reinforced_exchanger_hard"), new ItemStack(ModItems.reinforcedExchanger), new ItemStack(ModItems.hardenedExchanger),
                                "ERE", "CXC", "EFE",
                                'E', "ingotElectrum", 'R', ThermalExpansionIntegration.redstoneTransmissionCoil, 'F', ThermalExpansionIntegration.fluxCapacitorReinforced, 'C', ModItems.teExchangerCoreT2, 'X', ModItems.hardenedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":signalum_exchanger_hard"), new ItemStack(ModItems.signalumExchanger), new ItemStack(ModItems.reinforcedExchanger),
                                "SRS", "CXC", "SFS",
                                'S', "ingotSignalum", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorSignalum, 'C', ModItems.teExchangerCoreT3, 'X', ModItems.reinforcedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":resonant_exchanger_hard"), new ItemStack(ModItems.resonantExchanger), new ItemStack(ModItems.signalumExchanger),
                                "IRI", "CXC", "IFI",
                                'I', "ingotEnderium", 'R', ThermalExpansionIntegration.redstoneConductanceCoil, 'F', ThermalExpansionIntegration.fluxCapacitorResonant, 'C', ModItems.teExchangerCoreT3, 'X', ModItems.signalumExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier2_hard"), null, new ItemStack(ModItems.teExchangerCoreT2),
                                "BIB", "CGC", "BIB",
                                'B', "gearBronze", 'I', "gearInvar", 'C', ModItems.teExchangerCoreT1, 'G', ThermalExpansionIntegration.bucketEnergizedGlowstone
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":te_core_tier3_hard"), null, new ItemStack(ModItems.teExchangerCoreT3),
                                "LCL", "CGC", "LCL",
                                'C', ModItems.teExchangerCoreT2, 'L', "gearLumium", 'G', ThermalExpansionIntegration.bucketGelidCryotheum
                        );
                        break;
                    }
                }
            }
        }

        if (ModConfig.modules.mekanismModule) {
            if (Loader.isModLoaded(Exchangers.MEK)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":basic_exchanger"), null, new ItemStack(ModItems.basicExchanger),
                        "BTB", "BCB", "BTB",
                        'B', MekanismIntegration.circuitBasic, 'T', MekanismIntegration.energyTablet, 'C', ModItems.mekanismExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":mek_core_tier1"), null, new ItemStack(ModItems.mekanismExchangerCoreT1),
                        "OSO", "SAS", "OSO",
                        'O', "ingotOsmium", 'S', "ingotSteel", 'A', "alloyAdvanced"
                );
                switch (ModConfig.recipeTweaks.mekanismRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":advanced_exchanger_easy"), null, new ItemStack(ModItems.advancedExchanger),
                                "ATA", "ACA", "ATA",
                                'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ModItems.mekanismExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":elite_exchanger_easy"), null, new ItemStack(ModItems.eliteExchanger),
                                "EPE", "ECE", "ETE",
                                'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ModItems.mekanismExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ultimate_exchanger_easy"), null, new ItemStack(ModItems.ultimateExchanger),
                                "UTU", "UCU", "UTU",
                                'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ModItems.mekanismExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier2_easy"), null, new ItemStack(ModItems.mekanismExchangerCoreT2),
                                "DGD", "GAG", "DGD",
                                'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier3_easy"), null, new ItemStack(ModItems.mekanismExchangerCoreT3),
                                "OIO", "IAI", "OIO",
                                'O', "dustRefinedObsidian", 'I', "ingotRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":advanced_exchanger_normal"), new ItemStack(ModItems.advancedExchanger), new ItemStack(ModItems.basicExchanger),
                                "ACA", "TXT", "AAA",
                                'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ModItems.mekanismExchangerCoreT2, 'X', ModItems.basicExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":elite_exchanger_normal"), new ItemStack(ModItems.eliteExchanger), new ItemStack(ModItems.advancedExchanger),
                                "ECE", "TXT", "EPE",
                                'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ModItems.mekanismExchangerCoreT3, 'X', ModItems.advancedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":ultimate_exchanger_normal"), new ItemStack(ModItems.ultimateExchanger), new ItemStack(ModItems.eliteExchanger),
                                "UCU", "TXT", "UUU",
                                'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ModItems.mekanismExchangerCoreT3, 'X', ModItems.eliteExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier2_normal"), null, new ItemStack(ModItems.mekanismExchangerCoreT2),
                                "DGD", "ACA", "DGD",
                                'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', ModItems.mekanismExchangerCoreT1, 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier3_normal"), null, new ItemStack(ModItems.mekanismExchangerCoreT3),
                                "OAO", "ACA", "OAO",
                                'C', ModItems.mekanismExchangerCoreT2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":advanced_exchanger_hard"), new ItemStack(ModItems.advancedExchanger), new ItemStack(ModItems.basicExchanger),
                                "ATA", "CXC", "ATA",
                                'A', MekanismIntegration.circuitAdvanced, 'T', MekanismIntegration.energyTablet, 'C', ModItems.mekanismExchangerCoreT2, 'X', ModItems.basicExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":elite_exchanger_hard"), new ItemStack(ModItems.eliteExchanger), new ItemStack(ModItems.advancedExchanger),
                                "EPE", "CXC", "ETE",
                                'E', MekanismIntegration.circuitElite, 'P', MekanismIntegration.teleportationCore, 'T', MekanismIntegration.energyTablet, 'C', ModItems.mekanismExchangerCoreT3, 'X', ModItems.advancedExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":ultimate_exchanger_hard"), new ItemStack(ModItems.ultimateExchanger), new ItemStack(ModItems.eliteExchanger),
                                "UTU", "CXC", "UTU",
                                'U', MekanismIntegration.circuitUltimate, 'T', MekanismIntegration.portableTeleporter, 'C', ModItems.mekanismExchangerCoreT3, 'X', ModItems.eliteExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier2_hard"), null, new ItemStack(ModItems.mekanismExchangerCoreT2),
                                "DGD", "CAC", "DGD",
                                'D', "dustDiamond", 'G', "ingotRefinedGlowstone", 'C', ModItems.mekanismExchangerCoreT1, 'A', "alloyElite"
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mek_core_tier3_hard"), null, new ItemStack(ModItems.mekanismExchangerCoreT3),
                                "OCO", "CAC", "OCO",
                                'C', ModItems.mekanismExchangerCoreT2, 'O', "dustRefinedObsidian", 'A', "alloyUltimate"
                        );
                        break;
                    }
                }
            }
        }

        if (ModConfig.modules.immersiveEngineeringModule) {
            if (Loader.isModLoaded(Exchangers.IE)) {
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":lv_exchanger"), null, new ItemStack(ModItems.lvExchanger),
                        "SLS", "SCS", "SLS",
                        'S', "blockSheetmetalCopper", 'L', ImmersiveEngineeringIntegration.lvCapacitor, 'C', ModItems.ieExchangerCoreT1
                );
                GameRegistry.addShapedRecipe(
                        new ResourceLocation(Exchangers.MODID + ":ie_core_tier1"), null, new ItemStack(ModItems.ieExchangerCoreT1),
                        "CIC", "IBI", "CIC",
                        'C', ImmersiveEngineeringIntegration.lvWireCoil, 'I', ImmersiveEngineeringIntegration.ironMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketCreosote
                );
                switch (ModConfig.recipeTweaks.immersiveEngineeringRecipesType) {
                    case "easy": {
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":mv_exchanger_easy"), null, new ItemStack(ModItems.mvExchanger),
                                "SMS", "SCS", "SMS",
                                'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ModItems.ieExchangerCoreT2
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":hv_exchanger_easy"), null, new ItemStack(ModItems.hvExchanger),
                                "SHS", "SCS", "SHS",
                                'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ModItems.ieExchangerCoreT3
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier2_easy"), null, new ItemStack(ModItems.ieExchangerCoreT2),
                                "ESE", "SBS", "ESE",
                                'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier3_easy"), null, new ItemStack(ModItems.ieExchangerCoreT3),
                                "SHS", "HBH", "SHS",
                                'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel
                        );
                        break;
                    }
                    case "normal": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":mv_exchanger_normal"), new ItemStack(ModItems.mvExchanger), new ItemStack(ModItems.lvExchanger),
                                "SCS", "MXM", "SSS",
                                'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ModItems.ieExchangerCoreT2, 'X', ModItems.lvExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hv_exchanger_normal"), new ItemStack(ModItems.hvExchanger), new ItemStack(ModItems.mvExchanger),
                                "SCS", "HXH", "SSS",
                                'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ModItems.ieExchangerCoreT3, 'X', ModItems.mvExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier2_normal"), null, new ItemStack(ModItems.ieExchangerCoreT2),
                                "ESE", "BCB", "ESE",
                                'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', ModItems.ieExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier3_normal"), null, new ItemStack(ModItems.ieExchangerCoreT3),
                                "SHS", "BCB", "SHS",
                                'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', ModItems.ieExchangerCoreT2
                        );
                        break;
                    }
                    case "hard": {
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":mv_exchanger_hard"), new ItemStack(ModItems.mvExchanger), new ItemStack(ModItems.lvExchanger),
                                "SMS", "CXC", "SMS",
                                'S', "blockSheetmetalElectrum", 'M', ImmersiveEngineeringIntegration.mvCapacitor, 'C', ModItems.ieExchangerCoreT2, 'X', ModItems.lvExchanger
                        );
                        new ShapedCopyNBTRecipe(
                                e, new ResourceLocation(Exchangers.MODID + ":hv_exchanger_hard"), new ItemStack(ModItems.hvExchanger), new ItemStack(ModItems.mvExchanger),
                                "SHS", "CXC", "SHS",
                                'S', "blockSheetmetalSteel", 'H', ImmersiveEngineeringIntegration.hvCapacitor, 'C', ModItems.ieExchangerCoreT3, 'X', ModItems.mvExchanger
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier2_hard"), null, new ItemStack(ModItems.ieExchangerCoreT2),
                                "ESE", "CBC", "ESE",
                                'E', ImmersiveEngineeringIntegration.mvWireCoil, 'S', ImmersiveEngineeringIntegration.steelMechanicalComponent, 'B', ImmersiveEngineeringIntegration.bucketPlantOil, 'C', ModItems.ieExchangerCoreT1
                        );
                        GameRegistry.addShapedRecipe(
                                new ResourceLocation(Exchangers.MODID + ":ie_core_tier3_hard"), null, new ItemStack(ModItems.ieExchangerCoreT3),
                                "HCS", "CBC", "SCH",
                                'S', ImmersiveEngineeringIntegration.hvWireCoil, 'H', ImmersiveEngineeringIntegration.heavyEngineeringBlock, 'B', ImmersiveEngineeringIntegration.bucketBiodiesel, 'C', ModItems.ieExchangerCoreT2
                        );
                        break;
                    }
                }
            }
        }

        if (ModConfig.modules.specialModule) {
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(Exchangers.MODID + ":tuberous_exchanger"), null, new ItemStack(ModItems.tuberousExchanger),
                    "PGP", "PEP", "PGP",
                    'P', Items.POTATO, 'G', "nuggetGold", 'E', "enderpearl"
            );
        }

    }

    private static class ShapedCopyNBTRecipe extends ShapedOreRecipe {

        private final ItemStack nbtCopyStack;

        private ShapedCopyNBTRecipe(RegistryEvent.Register<IRecipe> e, ResourceLocation group, @Nonnull ItemStack result, ItemStack nbtCopyStack, Object... recipe) {
            super(group, result, recipe);
            this.nbtCopyStack = nbtCopyStack;

            e.getRegistry().register(this.setRegistryName(group));
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventory) {
            ItemStack stack = super.getCraftingResult(inventory);
            if (!stack.isEmpty()) {
                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                    ItemStack input = inventory.getStackInSlot(i);
                    if (this.nbtCopyStack.isItemEqual(input)) {
                        stack.setTagCompound(input.getTagCompound());
                        break;
                    }
                }
            }
            return stack;
        }

    }

}
