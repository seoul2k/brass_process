package fit.xts.brass_process.armor_material;

import fit.xts.brass_process.BrassProcess;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

    public static final ArmorMaterial BRASS_ARMOR_MATERIAL = new BrassArmorMaterial();
    public static final Item BRASS_INGOT = BrassProcess.BRASS_INGOT;
    public static final Item BRASS_MATERIAL_HELMET = new ArmorItem(BRASS_ARMOR_MATERIAL, EquipmentSlot.HEAD, new FabricItemSettings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static final Item BRASS_MATERIAL_CHESTPLATE = new ArmorItem(BRASS_ARMOR_MATERIAL, EquipmentSlot.CHEST, new FabricItemSettings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static final Item BRASS_MATERIAL_LEGGINGS = new ArmorItem(BRASS_ARMOR_MATERIAL, EquipmentSlot.LEGS, new FabricItemSettings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static final Item BRASS_MATERIAL_BOOTS = new ArmorItem(BRASS_ARMOR_MATERIAL, EquipmentSlot.FEET, new FabricItemSettings().group(BrassProcess.BRASS_PROCESS_GROUP));
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("brass_process", "brass_material_helmet"), BRASS_MATERIAL_HELMET);
        Registry.register(Registry.ITEM, new Identifier("brass_process", "brass_material_chestplate"), BRASS_MATERIAL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("brass_process", "brass_material_leggings"), BRASS_MATERIAL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("brass_process", "brass_material_boots"), BRASS_MATERIAL_BOOTS);
    }
}
