package fit.xts.brass_process;

import fit.xts.brass_process.speed_of_progress.AdvancementsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MyModDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        generator.addProvider(AdvancementsProvider::new);
        // ...
    }
}