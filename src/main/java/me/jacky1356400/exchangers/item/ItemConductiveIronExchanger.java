package me.jacky1356400.exchangers.item;

import me.jacky1356400.exchangers.Config;
import me.jacky1356400.exchangers.Exchangers;
import me.jacky1356400.exchangers.helper.EnergyHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemConductiveIronExchanger extends ItemExchangerBaseRF {

    public ItemConductiveIronExchanger(){
        setRegistryName(Exchangers.MODID + ":conductive_iron_exchanger");
        setUnlocalizedName(Exchangers.MODID + ".conductive_iron_exchanger");
        setMaxStackSize(1);
        setCreativeTab(Exchangers.exchangersCreativeTab);
        setNoRepair();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {
        return Config.conductiveIronExchangerMaxRF;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        ItemStack empty = new ItemStack(this);
        list.add(empty);
        ItemStack full = new ItemStack(this);
        EnergyHelper.setDefaultEnergyTag(full, Config.conductiveIronExchangerMaxRF);
        list.add(full);
    }

}
