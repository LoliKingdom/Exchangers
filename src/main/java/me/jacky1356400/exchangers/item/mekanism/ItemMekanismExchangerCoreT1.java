package me.jacky1356400.exchangers.item.mekanism;

import me.jacky1356400.exchangers.Exchangers;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMekanismExchangerCoreT1 extends Item {

	public ItemMekanismExchangerCoreT1() {
		setRegistryName(Exchangers.MODID + ":mekanism_exchanger_core_tier1");
		setUnlocalizedName(Exchangers.MODID + ".mekanism_exchanger_core_tier1");
		setMaxStackSize(16);
		setCreativeTab(Exchangers.exchangersCreativeTab);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
