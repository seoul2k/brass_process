package fit.xts.brass_process.speed_of_progress;

import fit.xts.brass_process.BrassProcess;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class Advancements implements Consumer<Consumer<Advancement>> {

    @Override
    public void accept(Consumer<Advancement> consumer) {
        Advancement ZincIngotAdvancement = Advancement.Builder.create()
                .display(
                        BrassProcess.ZINC_INGOT, // The display icon
                        Text.of("锌锭？锌锭！"), // The title
                        Text.of("获得锌锭"), // The description
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                        AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_zinc_ingot", InventoryChangedCriterion.Conditions.items(BrassProcess.ZINC_INGOT))
                .build(consumer, "brass_process" + "/root");
        Advancement BrassIngotAdvancement = Advancement.Builder.create().parent(ZincIngotAdvancement)
                .display(
                        BrassProcess.BRASS_INGOT, // The display icon
                        Text.of("合金"), // The title
                        Text.of("获得黄铜"), // The description
                        null, // Background image used
                        AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
                        true, // Show toast top right
                        true, // Announce to chat
                        false // Hidden in the advancement tab
                )
                // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                .criterion("got_brass_ingot", InventoryChangedCriterion.Conditions.items(BrassProcess.BRASS_INGOT))
                .build(consumer, "brass_process" + "/brass_ingot");
    }
}