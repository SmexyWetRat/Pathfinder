package com.smexywetrat.pathfinder.init;

import com.smexywetrat.pathfinder.Pathfinder;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PFFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Pathfinder.MODID);
	
	public static Feature<NoFeatureConfig> ROAD_FEATURES = new RoadFeature(NoFeatureConfig.field_236558_a_);
}
