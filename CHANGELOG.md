## **(V.5.1.12 Changes) (1.18.2 Minecraft)**

#### Mod Compat:
Added Betterend and Betternether biomes to the biome tags that my mod uses so my structures spawns in their biomes. 
 (Just in case they port to Forge 1.18.2)

Added Magical Forest's biome to the forest biome tags that my mod uses so my structures spawns in their biomes.

Added ProjectVibrantJourney's biomes to the biome tags that my mod uses so my structures spawns in their biomes.

#### Mineshafts:
Lowered Crimson, Warped, and Nether Mineshaft's max y value their center room can spawn at. (Lowers entire mineshaft by 4 blocks)
 Config datapack is updated with this change now.


### **(V.5.1.11 Changes) (1.18.2 Minecraft)**

#### Mineshafts:
Fixed Desert and Swamp Mineshafts not having pillars/chains support.
 (Config datapack now updated to include the small changes for this fix)

#### Misc:
Slightly improved the error message that shows when a RS structure fails to generate with certain required pieces.


### **(V.5.1.10 Changes) (1.18.2 Minecraft)**

#### Config:
Autoupdate the dimension blacklist config entry for RS's dungeons and wells so that it uses `twilightforest:twilight_forest` instead of `twilightforest:twilightforest`
 This will make RS dungeons and wells no longer spawn in Twilight Forest's dimension.


### **(V.5.1.9 Changes) (1.18.2 Minecraft)**

#### Locate:
/locate command mixin that RS does now only increase the search radius for structures under the
 `repurposed_structures:larger_locate_search` configured structure feature tag.
 Has RS's Mineshafts by default and will make the command's search radius go from 100 structure region radius to 2000 radius.
 With this tag, the command should not time out as often when locating other mod's/datapack's structures that are having issues spawning.
 Config datapack updated to include this new tag.


### **(V.5.1.8 Changes) (1.18.2 Minecraft)**

#### End Structures:
End Pyramid, End Shipwreck, End Mineshaft, End Outpost, and End Ruined Portal all now generate only past 1000 blocks from the world center in the End.

#### Dungeons:
Set the default value for Ocean Dungeon's spawnrate from 3 to 2 in config/repurposed_structures-forge/dungeons.toml


### **(V.5.1.7 Changes) (1.18.2 Minecraft)**

#### Outposts:
Fixed Warped Outposts being very rare.

#### Shipwrecks:
Fixed Crimson Shipwreck being very rare.

#### Nether Structures:
Slightly decreased the spawnrates of all Nether Outposts, Nether Pyramid, Nether Ruins,
 Nether Shipwrecks, Nether Temples, Nether Strongholds, Nether Mineshafts, and Nether Villages.
 Hopefully this helps make the Nether a little less crowded.

#### Villages:
Fixed Badland Village's trapdoor plant pots to have grass block/podzol inside instead of air.

Added stable_1 building to spawn in non-zombied Badlands Villages rarely.

Dark Forest Village Churches and Stable buildings has some Granite Stairs/Slabs replaced with Dark Oak Stairs/Slabs

Swamp Villages overall has their Moss Blocks on ground replaced with various terracotta blocks. 
 Moss Block and Moss Carpet has been removed from the outside of the Swamp Village's mud igloo houses and instead, has Moss Carpet on floor inside.

Fixed Swamp Villages spawning Structure Void blocks sometimes.

#### Lang:
it_it.json lang file added by Zano1999! Thank you!


### **(V.5.1.6 Changes) (1.18.2 Minecraft)**

#### Misc:
Fixed crash when certain features are spawned outside of worldgen.
 (Made some mixins safer and only apply their changes when during worldgen)

Fixed mixins that reduces amount of jungle bushes in some RS structures.

Fixed mixins that removes lava lakes and lavafalls from spawning in some RS structures.


### **(V.5.1.5 Changes) (1.18.2 Minecraft)**

#### Biome Tags:
Fixed "#byg:is_icy" entry in repurposed_structures:collections/icy biome tag so it includes icy byg biomes properly.


### **(V.5.1.4 Changes) (1.18.2 Minecraft)**

#### Biome Tags:
Fixed the biome tags that RS uses so it now spawns structures in modded/datapack biomes that are using forge's or c's namespaced tags.
 If you're using an RS config datapack, the new v5 of the config datapack should have the updated data/repurposed_structures/tags/worldgen/biome/collections tags that should work now.


### **(V.5.1.3 Changes) (1.18.2 Minecraft)**

#### Loot:
Fixed all structure maps in RS loot tables (chests and shulker boxes) so that the structure maps actually locates structures now.
 Issue was the way explorer maps gets what structure to track was changed in 1.18.2 and I did not realize it. 
 If you downloaded a config datapack already, replace the loot table folder in it with v4 config datapack's loot table folder.
 (Note: structures at the edge of the map's area may not show the icon for the structure's location. This is vanilla behavior. Don't ask why)

#### Shipwrecks:
Fixed End Shipwrecks not spawning.


### **(V.5.1.2 Changes) (1.18.2 Minecraft)**

#### Misc:
Fixed crash at startup due to missing mixin refmap. Don't know why it keeps disappearing on Forge builds... (I can't catch a break lol)


### **(V.5.1.1 Changes) (1.18.2 Minecraft)**

#### Mod Compat:
Fixed issue where Blay's Waystone may not be able to inject into RS Villages.
 Issue was that I was creating the conditions registry at mod init and Waystones was registering their conditions in mod init as well.
 Meaning there was a rare chance that Blay may run their registry code before I make the registry which causes the RS json files in Waystones to fail later.
 Solution, RS now makes the conditions registry at game startup way before any mod init is ran.


### **(V.5.1.0 Changes) (1.18.2 Minecraft)**

#### Monuments:
Added Jungle, Icy, Desert, and Nether Monuments! Can be found from Cartographer's map trades too!

#### Tags:
Updated several biome tags so some RS structures can spawn in the correct modded/datapack biomes better.

#### Mod Compat:
The rs_spawner json file's entries now can have `"optional": true` to make the entry no longer error if the mob is not present in the registry.
  Good for marking modded mobs as optional when overriding the rs_spawner json files so that you can later remove that mod and not cause the json file to explode.

#### Lang:
Fixed typo in zh_cn.json file that prevented it from loading properly.
