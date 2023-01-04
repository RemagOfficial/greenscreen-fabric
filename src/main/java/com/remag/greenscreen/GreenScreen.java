package com.remag.greenscreen;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreenScreen implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final Block GREENSCREEN = new Block(FabricBlockSettings.of(Material.WOOL).strength(4.0f));
	public static final Block BLUESCREEN = new Block(FabricBlockSettings.of(Material.WOOL).strength(4.0f));
	public static final ItemGroup GREEN_SCREEN = FabricItemGroup.builder(
					new Identifier("greenscreen", "green_screen"))
			.icon(() -> new ItemStack(GreenScreen.GREENSCREEN))
			.entries(((enabledFeatures, entries, operatorEnabled) -> {
				entries.add(GreenScreen.GREENSCREEN);
				entries.add(GreenScreen.BLUESCREEN);
			}))
			.build();

	@Override
	public void onInitialize() {

		Registry.register(Registries.BLOCK, new Identifier("greenscreen", "green_screen"), GREENSCREEN);
		Registry.register(Registries.BLOCK, new Identifier("greenscreen", "blue_screen"), BLUESCREEN);

		Registry.register(Registries.ITEM, new Identifier("greenscreen", "green_screen"), new BlockItem(GREENSCREEN, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("greenscreen", "blue_screen"), new BlockItem(BLUESCREEN, new FabricItemSettings()));
	}
}