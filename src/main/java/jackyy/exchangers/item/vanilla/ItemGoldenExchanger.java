package jackyy.exchangers.item.vanilla;

import jackyy.exchangers.Exchangers;
import jackyy.exchangers.item.ItemExchangerBase;
import jackyy.exchangers.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemGoldenExchanger extends ItemExchangerBase {

    public ItemGoldenExchanger() {
        setRegistryName(Exchangers.MODID + ":golden_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".golden_exchanger");
        setMaxDamage(ModConfig.vanillaTweaks.goldenMaxDmg);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getTier() {
        return 3;
    }

    @Override
    public int getHarvestLevel() {
        return ModConfig.vanillaTweaks.goldenMaxHarvestLevel;
    }

    @Override
    public int getMaxRange() {
        return ModConfig.vanillaTweaks.goldenMaxRange;
    }

    @Override
    public boolean checkLoaded() {
        return ModConfig.modules.vanillaModule;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return OreDictionary.containsMatch(false, OreDictionary.getOres("ingotGold"), repair);
    }

}
