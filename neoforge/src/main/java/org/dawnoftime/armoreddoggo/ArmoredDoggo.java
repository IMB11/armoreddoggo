package org.dawnoftime.armoreddoggo;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.dawnoftime.armoreddoggo.registry.ItemModRegistry.ITEMS;
import static org.dawnoftime.armoreddoggo.registry.ItemModRegistry.RAIJIN_DOG_ARMOR;

@Mod(Constants.MOD_ID)
public class ArmoredDoggo {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public ArmoredDoggo(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);

        CREATIVE_MODE_TAB.register(modEventBus);
        CREATIVE_MODE_TAB.register(Constants.MOD_ID, () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + Constants.MOD_ID))
                .icon(RAIJIN_DOG_ARMOR::toStack)
                .displayItems((params, output) -> output.acceptAll(ITEMS.getEntries().stream().map((itemDeferredHolder) -> itemDeferredHolder.get().asItem().getDefaultInstance()).toList()))
                .build());

        if (FMLEnvironment.dist == Dist.CLIENT) {
            //modEventBus.addListener(DoTAWArmorSetsRegistry::onLayerRegister);
        }
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();
    }
}