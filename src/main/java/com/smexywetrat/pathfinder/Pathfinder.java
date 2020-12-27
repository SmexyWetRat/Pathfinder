package com.smexywetrat.pathfinder;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod(Pathfinder.MODID)
public class Pathfinder {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "undergroundvillages";
//	public static final RoadMap roadmap = new RoadMap();
	
	public Pathfinder() {
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		forgeBus.addListener(this::biomeModification);
//		forgeBus.addListener(this::registerDatapackListener);
		forgeBus.addListener(this::addDimensionalSpacing);
		
		modEventBus.addListener(this::setup);
//		PathfinderFeatures.FEATURES.register(modEventBus);
//		PathfinderStructures.STRUCTURE_FEATURES.register(modEventBus);
//		PathfinderPlacements.DECORATORS.register(modEventBus);
	}
	
	public void setup(final FMLCommonSetupEvent event) {
//		event.enqueueWork(() -> {
//			PFConfiguredFeatures.registerConfiguredFeatures();
//			PFStructures.registerStructures();
//			PFConfiguredStructures.registerConfiguredStructureFeatures();
//			PFStructureTagMap.setupTags();
//		}
	}
	
	public void biomeModification(final BiomeLoadingEvent event) {
		//event.getGeneration().getStructures().add(() -> ConfiguredStructures.oIJoijoerjg);
		//event.getGeneration.getFeatures(GenerationStage.Decoration.SOIJOIJ).add(() -> Oijoijr.FEATURE);
	}
	
	public void addDimensionalSpacing(final WorldEvent.Load event) {
		if(event.getWorld() instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld)event.getWorld();
			
			if(serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator &&
					serverWorld.getDimensionKey().equals(World.OVERWORLD)) 
				return;
			
			Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
//			tempMap.put(Structure);
			
//			serverWorld.getChunkProvider().generator.func_235957_b_().
		}
	}
	
	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) {
		entry.setRegistryName(new ResourceLocation(Pathfinder.MODID, registryKey));
		registry.register(entry);
		return entry;
	}
}