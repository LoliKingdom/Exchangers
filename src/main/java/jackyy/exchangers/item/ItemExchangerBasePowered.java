package jackyy.exchangers.item;

import cofh.core.item.IEnchantableItem;
import cofh.redstoneflux.api.IEnergyContainerItem;
import cofh.redstoneflux.util.EnergyContainerItemWrapper;
import jackyy.exchangers.handler.ExchangerHandler;
import jackyy.exchangers.registry.ModConfig;
import jackyy.exchangers.util.Reference;
import jackyy.gunpowderlib.helper.EnergyHelper;
import jackyy.gunpowderlib.helper.KeyHelper;
import jackyy.gunpowderlib.helper.NBTHelper;
import jackyy.gunpowderlib.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@Optional.InterfaceList(value = {
        @Optional.Interface(iface = "cofh.redstoneflux.api.IEnergyContainerItem", modid = "redstoneflux"),
        @Optional.Interface(iface = "cofh.core.item.IEnchantableItem", modid = "cofhcore")
})
public class ItemExchangerBasePowered extends ItemExchangerBase implements IEnergyContainerItem, IEnchantableItem {

    public ItemExchangerBasePowered() {
        setMaxDamage(1);
    }

    @GameRegistry.ObjectHolder("cofhcore:holding")
    public static final Enchantment holding = null;

	@Override
	public int receiveEnergy(ItemStack container, int energy, boolean simulate) {
		return NBTHelper.receiveEnergy(container, energy, getMaxEnergyStored(container), simulate);
	}

	@Override
	public int extractEnergy(ItemStack container, int energy, boolean simulate) {
		return NBTHelper.extractEnergy(container, energy, simulate);
	}

	@Override
	public int getEnergyStored(ItemStack container) {
		return NBTHelper.getEnergyStored(container);
	}

    @Override
    public int getMaxEnergyStored(ItemStack container) {
	    if (ModConfig.misc.holdingEnchantment && Loader.isModLoaded("cofhcore")) {
            int enchant = EnchantmentHelper.getEnchantmentLevel(holding, container);
            return getMaxEnergy() + getMaxEnergy() * enchant / 2;
        }
        return getMaxEnergy();
    }

    @Override
	public boolean showDurabilityBar(ItemStack stack) {
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		if (stack.getTagCompound() == null) {
			EnergyHelper.setDefaultEnergyTag(stack, 0);
		}
		return 1D - ((double) stack.getTagCompound().getInteger("Energy") / (double) getMaxEnergyStored(stack));
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		super.addInformation(stack, world, tooltip, flag);
		if (!Loader.isModLoaded("redstoneflux")) {
            tooltip.add(StringHelper.localize(Reference.MODID, "tooltip.redstone_flux_warning"));
        }
        if (KeyHelper.isShiftKeyDown()) {
            tooltip.add(StringHelper.formatNumber(getEnergyStored(stack)) + " / " + StringHelper.formatNumber(getMaxEnergyStored(stack)) + " RF");
        }
	}

	@Override @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
	    if (isInCreativeTab(tab)) {
            if (checkLoaded()) {
                ItemStack empty = new ItemStack(this);
                ExchangerHandler.setDefaultTagCompound(empty);
                list.add(empty);
                ItemStack full = new ItemStack(this);
                ExchangerHandler.setDefaultTagCompound(full);
                EnergyHelper.setDefaultEnergyTag(full, getMaxEnergyStored(full));
                list.add(full);
            }
        }
    }

	@Override
	public boolean isPowered() {
		return true;
	}

    /* CAPABILITIES */
    @Override @Optional.Method(modid = "redstoneflux")
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new EnergyContainerItemWrapper(stack, this);
    }

    /* HOLDING ENCHANT */
    @Override
    public boolean canEnchant(ItemStack stack, Enchantment enchantment) {
        return ModConfig.misc.holdingEnchantment && Loader.isModLoaded("cofhcore") && enchantment == holding;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.FORTUNE
                || enchantment == Enchantments.SILK_TOUCH
                || enchantment == Enchantments.UNBREAKING;
    }

}
