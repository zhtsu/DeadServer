package cc.zhtsu.dyingserver.item;

import cc.zhtsu.dyingserver.DyingServer;
import cc.zhtsu.dyingserver.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DyingServer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DYING_SERVER_TAB = CREATIVE_MODE_TABS.register("dyingserver_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SNAIL.get()))
                    .title(Component.translatable("creativetab.dyingserver_tab"))
                    .displayItems((parameters, output) -> {
                        Arrays.stream(new ItemLike[]{
                            // Items
                            ModItems.SNAIL.get(),
                            // Blocks
                            ModBlocks.ASPHALT.get(), ModBlocks.COLD_SLATE.get(), ModBlocks.COLD_STONE.get(),
                            ModBlocks.EYED_FLESH_001.get(), ModBlocks.EYED_FLESH_002.get(), ModBlocks.FLESH_001.get(),
                            ModBlocks.FLESH_002.get(), ModBlocks.FLESH_TRAP.get(), ModBlocks.LUMINOUS_STEEL_WOOD.get(),
                            ModBlocks.OCEAN_TILE.get(), ModBlocks.WHITE_TILE.get()
                        }).forEach(output::accept);
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
