package cc.zhtsu.dyingserver.item;

import cc.zhtsu.dyingserver.DyingServer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DyingServer.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DYING_SERVER_TAB = CREATIVE_MODE_TABS.register("dyingserver_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SNAIL.get()))
                    .title(Component.translatable("creativetab.dyingserver_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SNAIL.get());
                        output.accept(Items.DIAMOND);
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
