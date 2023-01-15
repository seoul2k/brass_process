package fit.xts.brass_process;

import fit.xts.brass_process.tools.AxeItem;
import fit.xts.brass_process.tools.HoeItem;
import fit.xts.brass_process.tools.PickaxeItem;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class BrassToolMaterial implements ToolMaterial {
    public static final BrassToolMaterial INSTANCE = new BrassToolMaterial();
    public static ToolItem BRASS_SHOVEL = new ShovelItem(BrassToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem BRASS_SWORD = new SwordItem(BrassToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem BRASS_PICKAXE = new PickaxeItem(BrassToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem BRASS_AXE = new AxeItem(BrassToolMaterial.INSTANCE, 7.0F, -3.2F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static ToolItem BRASS_HOE = new HoeItem(BrassToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings().group(BrassProcess.BRASS_PROCESS_GROUP));
    @Override
    public int getDurability() {
        return 800;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.75F;
    }

    @Override
    public float getAttackDamage() {
        return 12.0F;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(BrassProcess.BRASS_INGOT);
    }
}
