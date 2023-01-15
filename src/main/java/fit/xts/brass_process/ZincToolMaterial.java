package fit.xts.brass_process;

import fit.xts.brass_process.tools.AxeItem;
import fit.xts.brass_process.tools.HoeItem;
import fit.xts.brass_process.tools.PickaxeItem;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class ZincToolMaterial implements ToolMaterial {
    public static final ZincToolMaterial INSTANCE = new ZincToolMaterial();
    public static ToolItem ZINC_PICKAXE = new PickaxeItem(ZincToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem ZINC_SHOVEL = new ShovelItem(ZincToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem ZINC_SWORD = new SwordItem(ZincToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem ZINC_AXE = new AxeItem(ZincToolMaterial.INSTANCE, 7.0F, -3.2F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem ZINC_HOE = new HoeItem(ZincToolMaterial.INSTANCE, 2, -3.2F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    @Override
    public int getDurability() {
        return 400;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.5F;
    }

    @Override
    public float getAttackDamage() {
        return 4F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 32;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(BrassProcess.ZINC_INGOT);
    }
}
