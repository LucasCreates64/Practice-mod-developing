package com.lucascreates.lucascreatespractice.item;

import com.lucascreates.lucascreatespractice.Practice;
import com.lucascreates.lucascreatespractice.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Practice.MODID);

    public static final Supplier<CreativeModeTab> TEST_ITEM_TAB = CREATIVE_MODE_TAB.register("test_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_TEST_ITEM.get()))
                    .title(Component.translatable("creativetab.lucascreatespractice.test_items_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TEST_ITEM);
                        output.accept(ModItems.RAW_TEST_ITEM);
                    }).build());

    public static final Supplier<CreativeModeTab> TEST_BLOCK_TAB = CREATIVE_MODE_TAB.register("test_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TEST_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Practice.MODID, "test_items_tab"))
                    .title(Component.translatable("creativetab.lucascreatespractice.test_blocks_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.TEST_BLOCK);
                        output.accept(ModBlocks.TEST_ORE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}