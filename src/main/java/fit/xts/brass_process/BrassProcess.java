package fit.xts.brass_process;

import fit.xts.brass_process.armor_material.RegisterItems;
import fit.xts.brass_process.enchantment.WitherEnchantment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class BrassProcess implements ModInitializer {
    public static final ItemGroup BRASS_PROCESS_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("brass_process", "brass_process"))
            .icon(() -> new ItemStack(RegisterItems.BRASS_INGOT)) // 这里将你创建的新的材料的模型用作图标，但是你也可以随时使用你喜欢的
            .build();
    public static final CustomItem CANDY = new CustomItem(new FabricItemSettings().maxCount(16).group(BRASS_PROCESS_GROUP).food(new FoodComponent.Builder().hunger(7).saturationModifier(5).snack().build()));
    public static final Block ZINC_ORE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(6.0f).resistance(2.0f));
    public static final Item ZINC_INGOT = new Item(new FabricItemSettings().maxCount(64).group(BRASS_PROCESS_GROUP));
    public static final Item RAW_ZINC = new Item(new FabricItemSettings().maxCount(64).group(BRASS_PROCESS_GROUP));
    public static final Item BRASS_INGOT = new Item(new FabricItemSettings().maxCount(64).group(BRASS_PROCESS_GROUP));
    private static ConfiguredFeature<?, ?> OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
        (Feature.ORE, new OreFeatureConfig(
                OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                ZINC_ORE_BLOCK.getDefaultState(),
                10)); // 矿脉大小

    public static PlacedFeature OVERWORLD_WOOL_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // 每个区块的矿脉数量
                    SquarePlacementModifier.of(), // 水平传播
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
            )); // 高度


    @Override
    public void onInitialize() {
        //糖果
        Registry.register(Registry.ITEM,new Identifier("brass_process","candy"),CANDY);
        //锭
        //锌锭
        Registry.register(Registry.ITEM,new Identifier("brass_process","zinc_ingot"),ZINC_INGOT);
        //黄铜锭
        Registry.register(Registry.ITEM,new Identifier("brass_process","brass_ingot"),BRASS_INGOT);
        //粗锌
        Registry.register(Registry.ITEM,new Identifier("brass_process","raw_zinc"),RAW_ZINC);
        //锌制工具
        //锌镐
        Registry.register(Registry.ITEM,new Identifier("brass_process","zinc_pickaxe"),ZincToolMaterial.ZINC_PICKAXE);
        //锌锄
        Registry.register(Registry.ITEM,new Identifier("brass_process","zinc_hoe"),ZincToolMaterial.ZINC_HOE);
        //锌斧
        Registry.register(Registry.ITEM,new Identifier("brass_process","zinc_axe"),ZincToolMaterial.ZINC_AXE);
        //锌铲
        Registry.register(Registry.ITEM,new Identifier("brass_process","zinc_shovel"),ZincToolMaterial.ZINC_SHOVEL);
        //锌剑
        Registry.register(Registry.ITEM,new Identifier("brass_process","zinc_sword"),ZincToolMaterial.ZINC_SWORD);
        //黄铜制工具
        //黄铜镐
        Registry.register(Registry.ITEM,new Identifier("brass_process","brass_pickaxe"),BrassToolMaterial.BRASS_PICKAXE);
        //黄铜锄
        Registry.register(Registry.ITEM,new Identifier("brass_process","brass_hoe"),BrassToolMaterial.BRASS_HOE);
        //黄铜斧
        Registry.register(Registry.ITEM,new Identifier("brass_process","brass_axe"),BrassToolMaterial.BRASS_AXE);
        //黄铜铲
        Registry.register(Registry.ITEM,new Identifier("brass_process","brass_shovel"),BrassToolMaterial.BRASS_SHOVEL);
        //黄铜剑
        Registry.register(Registry.ITEM,new Identifier("brass_process","brass_sword"),BrassToolMaterial.BRASS_SWORD);
        //方块
        //锌矿石
        Registry.register(Registry.BLOCK, new Identifier("brass_process", "zinc_ore_block"), ZINC_ORE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("brass_process", "zinc_ore_block"), new BlockItem(ZINC_ORE_BLOCK, new FabricItemSettings().group(ItemGroup.MISC)));
        //生成
        //锌矿石
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("brass_process", "zinc_ore_block"), OVERWORLD_WOOL_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("brass_process", "zinc_ore_block"),
                OVERWORLD_WOOL_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("brass_process", "zinc_ore_block")));
        RegisterItems.register();
        Registry.register(Registry.ENCHANTMENT, new Identifier("brass_process", "wither"),new WitherEnchantment());

    }
}




