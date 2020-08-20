package relt.ewethratemod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import relt.ewethratemod.lists.ArmourMaterialList;
import relt.ewethratemod.lists.BlockList;
import relt.ewethratemod.lists.ItemList;
import relt.ewethratemod.lists.ToolMaterialList;

@Mod("ewethratemod")
public class EwethrateMod
{
    public static EwethrateMod instance;
    public static final String MODID = "ewethratemod";
    private static final Logger logger = LogManager.getLogger(MODID);

    public static final ItemGroup EWETHRATE = new EwethrateItemGroup();

    public EwethrateMod()
    {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        logger.info("Setup registered.");
    }

    private void clientRegistries(final  FMLCommonSetupEvent event)
    {
        logger.info("Client Registries registered.");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll(
                    ItemList.ewethrate_shard = new Item(new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_shard")),

                    ItemList.ewethrate_axe = new AxeItem(ToolMaterialList.ewethrate,6.0f, -3.0f, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_axe")),

                    ItemList.ewethrate_hoe = new HoeItem(ToolMaterialList.ewethrate, 0, 1.0f, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_hoe")),

                    ItemList.ewethrate_pickaxe = new PickaxeItem(ToolMaterialList.ewethrate, -7, -2.8f, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_pickaxe")),

                    ItemList.ewethrate_sword = new SwordItem(ToolMaterialList.ewethrate, 3, -2.4f, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_sword")),

                    ItemList.ewethrate_shovel = new ShovelItem(ToolMaterialList.ewethrate, 1.5f, -3.0F, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_shovel")),

                    ItemList.ewethrate_helmet = new ArmorItem(ArmourMaterialList.ewethrate, EquipmentSlotType.HEAD, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_helmet")),
                    ItemList.ewethrate_chestplate = new ArmorItem(ArmourMaterialList.ewethrate, EquipmentSlotType.CHEST, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_chestplate")),
                    ItemList.ewethrate_leggings = new ArmorItem(ArmourMaterialList.ewethrate, EquipmentSlotType.LEGS, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_leggings")),
                    ItemList.ewethrate_boots = new ArmorItem(ArmourMaterialList.ewethrate, EquipmentSlotType.FEET, new Item.Properties().group(EWETHRATE)).setRegistryName(location("ewethrate_boots")),

                    ItemList.ewethrate_block = new BlockItem(BlockList.ewethrate_block, new Item.Properties().group(EWETHRATE)).setRegistryName(BlockList.ewethrate_block.getRegistryName()),

                    ItemList.ewethrate_ore = new BlockItem(BlockList.ewethrate_ore, new Item.Properties().group(EWETHRATE)).setRegistryName(BlockList.ewethrate_ore.getRegistryName()),
                    ItemList.ewethrate_ore_nether = new BlockItem(BlockList.ewethrate_ore_nether, new Item.Properties().group(EWETHRATE)).setRegistryName(BlockList.ewethrate_ore_nether.getRegistryName()),
                    ItemList.ewethrate_ore_end = new BlockItem(BlockList.ewethrate_ore_end, new Item.Properties().group(EWETHRATE)).setRegistryName(BlockList.ewethrate_ore_end.getRegistryName())

            );

            logger.info("Items registered.");
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll(
                    BlockList.ewethrate_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("ewethrate_block")),

                    BlockList.ewethrate_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("ewethrate_ore")),
                    BlockList.ewethrate_ore_nether = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("ewethrate_ore_nether")),
                    BlockList.ewethrate_ore_end = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("ewethrate_ore_end"))
            );

            logger.info("Blocks registered.");
        }

        private static ResourceLocation location(String name)
        {
            return new ResourceLocation(MODID, name);
        }
    }
}
