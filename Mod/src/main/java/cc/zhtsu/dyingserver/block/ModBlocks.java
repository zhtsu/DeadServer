package cc.zhtsu.dyingserver.block;

import cc.zhtsu.dyingserver.DyingServer;
import cc.zhtsu.dyingserver.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.http.config.Registry;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DyingServer.MOD_ID);

    public static final RegistryObject<Block> FLESH_001 = registerBlock("flesh_001",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> FLESH_002 = registerBlock("flesh_002",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> FLESH_WITH_EYES_001 = registerBlock("flesh_with_eyes_001",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> FLESH_WITH_EYES_002 = registerBlock("flesh_with_eyes_002",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> FLESH_TRAP = registerBlock("flesh_trap",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> SEA_TILE = registerBlock("sea_tile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj);
        return blockObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
