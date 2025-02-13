package com.telepathicgrunt.repurposedstructures.configs;

import com.telepathicgrunt.repurposedstructures.configs.omegaconfig.api.Comment;
import com.telepathicgrunt.repurposedstructures.configs.omegaconfig.api.Config;

import java.util.HashMap;
import java.util.Map;

public class RSBiomeDimConfig implements Config {

    @Override
    public String getName() {
        return "repurposed_structures-forge/biome_dimension_allow_disallow_configs";
    }

    @Override
    public String getExtension() {
        return "json5";
    }

    @Override
    public void save() {

        if(configVersion == 1){
            // Simplify abyss config entries
            addEntries(disallowedFeatureDimensions, "all", "theabyss:.+");
            addEntries(disallowedFeatureDimensions, "all", "the_bumblezone:the_bumblezone");
            addEntries(disallowedFeatureDimensions, "all", "twilightforest:twilightforest");
            addEntries(disallowedFeatureDimensions, "all", "undergarden:undergarden");
            addEntries(disallowedFeatureDimensions, "all", "the_midnight:the_midnight");
            addEntries(disallowedFeatureDimensions, "all", "advancedrocketry:space");
            addEntries(disallowedFeatureDimensions, "all", "pokecube:secret_base");
            addEntries(disallowedFeatureDimensions, "all", "pokecube_legends:distorted_world");
            addEntries(disallowedFeatureDimensions, "all", "pokecube_legends:ultraspace");
            addEntries(disallowedFeatureDimensions, "all", "dystopia:dystopia");
            addEntries(disallowedFeatureDimensions, "all", "elvenation:elvenia_dimension");
            addEntries(disallowedFeatureDimensions, "all", "futurepack:.+");
            addEntries(disallowedFeatureDimensions, "all", "the_afterlight:.+");
            addEntries(disallowedFeatureDimensions, "all", "lotr:middle_earth");
            addEntries(disallowedFeatureDimensions, "all", "thebeginning:.+");

            // Add new config entries if they don't exist as we update the config version
            addEntries(disallowedFeatureDimensions, "repurposed_structures:well_badlands", "aoa3:barathos");
            addEntries(disallowedFeatureDimensions, "repurposed_structures:dungeons_desert", "lotr:middle_earth");

            addEntries(allowedFeatureDimensions, "repurposed_structures:dungeons_jungle", "futurepack:tyros");
            addEntries(allowedFeatureDimensions, "repurposed_structures:well_mossy_stone", "futurepack:tyros");
            configVersion = 2;
        }

        if(configVersion == 2){
            removeEntries(disallowedFeatureDimensions, "repurposed_structures:dungeons_desert", "lotr:middle_earth");
            addEntries(disallowedFeatureDimensions, "all", "lotr:middle_earth");
            addEntries(allowedFeatureDimensions, "repurposed_structures:well_forest", "lotr:middle_earth");
            addEntries(allowedFeatureDimensions, "repurposed_structures:well_snow", "lotr:middle_earth");
            addEntries(allowedFeatureDimensions, "repurposed_structures:well_mossy_stone", "lotr:middle_earth");
            configVersion = 3;
        }

        if(configVersion == 3){
            configVersion = 4;
        }

        if(configVersion == 4){
            configVersion = 5;
        }

        if(configVersion == 5){
            addEntries(disallowedFeatureDimensions, "all", "thebeginning:.+");
            configVersion = 6;
        }

        // Oops. have to skip this number
        if(configVersion == 6){
            configVersion = 7;
        }

        if(configVersion == 7) {
            addEntries(disallowedFeatureBiomes, "repurposed_structures:dungeons_badlands", "terralith:snowy_badlands");
            addEntries(disallowedFeatureBiomes, "repurposed_structures:dungeons_snow", "terralith:gravel_desert");
            addEntries(disallowedFeatureBiomes, "repurposed_structures:dungeons_desert", "terralith:red_oasis");
            addEntries(disallowedFeatureBiomes, "repurposed_structures:dungeons_neutral_ocean", "terralith:skylands");

            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_badlands", "terralith:savanna_badlands");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_badlands", "terralith:red_oasis");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_dark_forest", "terralith:mirage_isles");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_desert", "terralith:cave/desert_caves");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_snow", "terralith:alpine_grove");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_snow", "terralith:alpine_highlands");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_snow", "terralith:cold_shrubland");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_icy", "terralith:cave/frostfire_caves");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_icy", "terralith:cave/ice_caves");
            addEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_icy", "terralith:cave/fungal_caves");
            configVersion = 8;
        }

        if(configVersion == 8) {
            removeEntries(allowedFeatureBiomes, "repurposed_structures:dungeons_snow", "terralith:alpine_highlands");
            configVersion = 9;
        }

        if(configVersion == 9) {
            configVersion = 10;
        }

        if(configVersion == 10) {
            removeEntries(disallowedFeatureDimensions, "all", "twilightforest:twilightforest");
            addEntries(disallowedFeatureDimensions, "all", "twilightforest:twilight_forest");
            configVersion = 11;
        }

        configVersion = 11;
        Config.super.save();
    }

    private void fixKeyEntry(Map<String, String> map, String oldKey, String newKey){
        for(String entry : map.get(oldKey).split(",")){
            addEntries(map, newKey, entry.trim());
        }
        map.remove(oldKey);
    }

    private void addEntries(Map<String, String> map, String key, String entry){
        // assign entry
        if(map.putIfAbsent(key, entry) != null && !map.get(key).contains(entry)){
            map.put(key, map.get(key) + ", " + entry); // append entry
        }
    }

    private void removeEntries(Map<String, String> map, String key, String entry){
        if(map.containsKey(key) && map.get(key).contains(entry)){
            String newEntry = map.get(key)
                    .replace(entry+", ", "")
                    .replace(entry+",", "")
                    .replace(entry, "");

            if(newEntry.isEmpty()){
                map.remove(key);
            }
            else{
                map.put(key, newEntry);
            }
        }
    }


    @Comment("""
            -------------------------------------------------------------------------------------------------------------------------------------------------
            //
            // In the key part, specify the name of the features from
            // Repurposed Structures that you want to affect. Then in the value part, add the identifiers
            // or regex for the dimension that you want Repurposed Structures features to NOT spawn in.
            // DOES NOT WORK FOR STRUCTURES! Only for features which are dungeons and wells.
            //
            // Separate multiple entries with a comma.
            // Example usage (the actual config entry to edit are the lines not starting with // further down):
            //  "disallowedDimensions": {
            //    "repurposed_structures:dungeons_badlands": "minecraft:overworld, awesome_mod:.+"
            //  }
            //
            // In this example, no Badlands Dungeon will spawn in the overworld because we specified that dimension's identifier.
            // Then the dungeon will not spawn in any of awesome_mod's dimension because "awesome_mod:.+" is regex that will
            // match all dimensions that starts with "awesome_mod:" in their identifier. Powerful stuff!
            //
            // Use "all" as the key to affect all of RS's structures and configuredfeatures.
            // You can find dimension identifiers by doing "/execute in" command in game.
            // All of RS's structure identifiers can be found by doing "/locate" command in game.
            // RS's dungeons and wells identifiers can be found here on GitHub:
            //  https://github.com/TelepathicGrunt/RepurposedStructures/blob/27c8c23d5b6ee1ba1f894df874d62e5982d39fd5/src/main/java/com/telepathicgrunt/repurposedstructures/modinit/RSConfiguredFeatures.java#L251-L273
            //
            
            """
    )
    public final Map<String, String> disallowedFeatureDimensions = new HashMap<>();

    @Comment("""
            -------------------------------------------------------------------------------------------------------------------------------------------------
            //
            // RS's features has default settings of what dimensions they are added to.
            // This allowedDimensions config is for adding them to more dimension or for overriding disallowedDimensions config.
            // NOTE: A feature must be added to both the dimension and to the biomes in the dimension to spawn.
            // DOES NOT WORK FOR STRUCTURES! Only for features which are dungeons and wells.
            //
            // In the key part, specify the name of the features from
            // Repurposed Structures that you want to affect. Then in the value part, add the identifiers
            // or regex for the dimension that you want Repurposed Structures stuff to ALWAYS spawn in.
            //
            // Separate multiple entries with a comma.
            // Example usage (the actual config entry to edit are the lines not starting with // further down):
            //  "allowedDimensions": {
            //    "repurposed_structures:dungeons_badlands": "minecraft:overworld, firey_realms:.+"
            //  },
            //
            // In this example, Badlands Dungeons will spawn in the overworld because we specified that dimension's identifier.
            // Then the Badlands Dungeons will also spawn in any of awesome_mod's dimension because "firey_realms:.+" is regex that will
            // match all dimensions that starts with "firey_realms:" in their identifier. Powerful stuff!
            //
            // Use "all" as the key to affect all of RS's features.
            // You can find dimension identifiers by doing "/execute in" command in game.
            // RS's dungeons and wells identifiers can be found here on GitHub:
            //  https://github.com/TelepathicGrunt/RepurposedStructures/blob/1ffe99074dcdecee9e2d5e8cc90520644a7ee1cd/src/main/java/com/telepathicgrunt/repurposedstructures/modinit/RSConfiguredFeatures.java#L293-L315
            //
            
            """
    )
    public final Map<String, String> allowedFeatureDimensions = new HashMap<>();

    @Comment("""
            -------------------------------------------------------------------------------------------------------------------------------------------------
            //
            // RS's features has default settings of what biomes they are added to.
            // This disallowedBiomes config is for overriding that internal default setting.
            // DOES NOT WORK FOR STRUCTURES! Only for features which are dungeons and wells.
            //
            // In the key part, specify the name of the features from
            // Repurposed Structures that you want to affect. Then in the value part, add the identifiers
            // or regex for the biomes that you want Repurposed Structures stuff to NOT spawn in.
            //
            // Separate multiple entries with a comma.
            // Example usage (the actual config entry to edit are the lines not starting with // further down):
            //  "disallowedBiomes": {
            //    "repurposed_structures:dungeons_badlands": "minecraft:eroded_badlands, peaceful_lands:.+"
            //  }
            //
            // In this example, Badlands Dungeons are removed from Flower Forest biome because we specified that biomes's identifier.
            // Then the Badlands Dungeons will also be removed from all of peaceful_lands's biomes because "peaceful_lands:.+" is regex
            // that will match all biomes that starts with "peaceful_lands:" in their identifier. Powerful stuff!
            // Use "all" as the key to affect all of RS's features.
            // You can find biome identifiers by doing "/locatebiome" command in game.
            // RS's dungeons and wells identifiers can be found here on GitHub:
            //  https://github.com/TelepathicGrunt/RepurposedStructures/blob/1ffe99074dcdecee9e2d5e8cc90520644a7ee1cd/src/main/java/com/telepathicgrunt/repurposedstructures/modinit/RSConfiguredFeatures.java#L293-L315
            //
            
            """
    )
    public final Map<String, String> disallowedFeatureBiomes = new HashMap<>();

    @Comment("""
            -------------------------------------------------------------------------------------------------------------------------------------------------
            //
            // RS's features has default settings of what biomes they are added to.
            // This allowedBiomes config is for adding them to more biomes or for overriding disallowedBiomes config.
            // NOTE: A feature must be added to both the dimension and to the biomes in the dimension to spawn.
            // DOES NOT WORK FOR STRUCTURES! Only for features which are dungeons and wells.
            //
            // In the key part, specify the name of the features from
            // Repurposed Structures that you want to affect. Then in the value part, add the identifiers
            // or regex for the biomes that you want Repurposed Structures stuff to ALWAYS spawn in.
            //
            // Separate multiple entries with a comma.
            // Example usage (the actual config entry to edit are the lines not starting with // further down):
            //  "allowedBiomes": {
            //    "repurposed_structures:mansion_taiga": "minecraft:desert, fantasy_overworld:.+"
            //  }
            //
            // In this example, Badlands Dungeons will spawn in the one Desert biome because we specified that biomes's identifier.
            // Then the Badlands Dungeons will also spawn in all of fantasy_overworld's biomes because "fantasy_overworld:.+" is regex
            // that will match all biomes that starts with "fantasy_overworld:" in their identifier. Powerful stuff!
            //
            // Use "all" as the key to affect all of RS's features.
            // You can find biome identifiers by doing "/locatebiome" command in game.
            // RS's dungeons and wells identifiers can be found here on GitHub:
            //  https://github.com/TelepathicGrunt/RepurposedStructures/blob/1ffe99074dcdecee9e2d5e8cc90520644a7ee1cd/src/main/java/com/telepathicgrunt/repurposedstructures/modinit/RSConfiguredFeatures.java#L293-L315
            //
            
            """
    )
    public final Map<String, String> allowedFeatureBiomes = new HashMap<>();


    @Comment("""
            -------------------------------------------------------------------------------------------------------------------------------------------------
            //
            // for internal use only. Do not change this."""
    )
    public int configVersion = 1; // DO NOT TOUCH ANYMORE
}
