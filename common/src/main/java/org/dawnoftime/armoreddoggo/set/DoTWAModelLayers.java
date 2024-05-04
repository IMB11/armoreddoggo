package org.dawnoftime.armoreddoggo.set;

import java.util.Set;
import java.util.stream.Stream;
import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;

import static org.dawnoftime.armoreddoggo.Constants.MOD_ID;

public class DoTWAModelLayers {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation JAPANESE_LIGHT_HELMET = register("JAPANESE_LIGHT_NAME", EquipmentSlot.HEAD);

    private static ModelLayerLocation register(String armorSet, EquipmentSlot type) {
        ModelLayerLocation modellayerlocation = new ModelLayerLocation(new ResourceLocation(MOD_ID, armorSet + "/" + type.getName()), "main");
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    //private static ModelLayerLocation createLocation(String pPath) {
    //    return
    //}
    public static Stream<ModelLayerLocation> getKnownLocations() {
        return ALL_MODELS.stream();
    }
}