### **(V.3.4.7 Changes) (1.16.5 Minecraft)**

##### Misc:
Hotfix to try and reduced locate radius for RS structures based on how common the structure is set.
  Should help reduce some lag with some structure locating stuff within worlds created by certain world overhaul mods 
  that make some biomes super rare or non-existent while saying the biome will spawn when it doesnt.


### **(V.3.4.6 Changes) (1.16.5 Minecraft)**

##### Mod Compat:
Updated mods.toml so if Waystones is on, RS will require a newer version of Waystones if it is too out of date to prevent a crash.

Added piece limiting amount for RS - Simply Cats compat datapack.


### **(V.3.4.5 Changes) (1.16.5 Minecraft)**

##### Mod Compat:
Vanilla Mineshafts will not be removed by Repurposed Structures if Caves And Cliffs Backport mod is on.
 This is because CCB added their own Mineshafts that replaces vanilla's so RS will try to not interfere with that now.

##### Configs:
Fixed a typo in a config comment.

Added thebeginning:.+ to the disallowed dimension config entry's default values to keep RS structures from that mod's dimensions by default.


### **(V.3.4.4 Changes) (1.16.5 Minecraft)**

##### Mod Compat:
Auto added vampirism:vampire_forest entries to RS's disallowedBiomes config entry to make oak village, oak witch hut, oak well, and oak outposts no longer spawn in that Vampirism biome.

##### Configs:
Adjusted wording of some config comments to be a bit more clear.

##### Igloos:
Adjusted code to make sure Grassy Igloos won't put falling blocks like sand as part of the structure's roof.

##### Villages:
Trying something new by increasing the bounding box of all RS Overworld Village's roads from 2 to 32. 
 This should make villages look better on mountains and hills and help reduce village roads or farms eating away the ground under houses. (In theory)

##### Misc:
Fixed a swallowed crash with the log spam filter if another mod causes missing structure piece type log spam with their own structures.


### **(V.3.4.3 Changes) (1.16.5 Minecraft)**

##### Configs:
Cleaned up RS configs to not be bloated with redundant comments and fixed a lot of incorrect/typos in some comments.


### **(V.3.4.2 Changes) (1.16.5 Minecraft)**

##### Configs:
Significantly cleaned up the config system backend code for my mod. Let me know if any config no longer works but it should be ok!

##### Mod Compat:
Blay's Waystone and Bountiful now cannot spawn more than 1 of their injected structure piece in RS villages. I did the restricting on my end. 
 (Note, Bountiful boards does not spawn in RS villages right now. They will fix it next update of their mod)

Blay Waystone's spawnInVillages and forceSpawnInVillages config are now read directly by Repurposed Structures and will control the waystones in RS villages.


### **(V.3.4.1 Changes) (1.16.5 Minecraft)**

##### Mineshafts:
Fixed a broken End Mineshaft check so it now properly space itself from End Strongholds and doesn't deadlock /locate command rarely.

##### Dungeons:
Fixed Mushroom Dungeons basically never spawning. Oops.

Fixed a missing block from corner of one Snow Dungeon nbt file. (no user would notice any change so idk why I am listing this fix here lol)

##### Outposts:
Changed all RS Outposts to better match Vanilla Outpost that can spawn a ton of tents and cages and stuff in 1.17.
 Yeah, Mojang made a change to outposts and no one noticed lol. I don't think it was reported anywhere.
 As for why this change was backported to 1.16.5 RS, I did it because it looks so much better having more tents and stuff lol.


### **(V.3.4.0 Changes) (1.16.5 Minecraft)**

##### Woodland Mansions:
All RS Mansions now spawns pieces by using template pools. This means you can edit the pool files by datapack to
 remove rooms you do not want to spawn. Or datapack the pools to make structure processors run for mansion pieces to randomize blocks.
 Or even datapack using RS's pool_addition folder to inject new rooms into mansions!
 Just make sure your new mansion pieces matches the size of the other pieces in the same pool. 
 No Jigsaw Block needed since Mansions are not Jigsaw Structures.

1x1_b5 room now spawns in RS mansions unlike vanilla which is bugged lol. https://bugs.mojang.com/browse/MC-240121

Adjusted looks of Savanna mansion to make it look nicer.

Fixed vanilla bug in RS mansions where terrain can be found floating on second and third floor hallways of the mansions. https://bugs.mojang.com/browse/MC-107594

Fixed vanilla mansion bug for RS mansions where there can be a hole in the second floor's wall to the outside if there's a 3rd floor above. https://bugs.mojang.com/browse/MC-240221

Fixed vanilla mansion bug for RS mansions where there can be a 3 block high hole on outside wall right side where 2nd floor meets the 3rd floor. https://bugs.mojang.com/browse/MC-110098

##### Outposts:
Crimson, Warped, and Nether Brick Outposts now can have target pieces with either Wither Skeleton Skulls or regular Skeleton Skulls.
 The Wither Skeleton Skull piece only has a 23% chance of appearing for a single Outpost. Before, Nether Brick Outpost had a 50% chance of spawning one.

##### Misc:
Adjusted several loot table files.

##### Compat:
Added a mixin to undo a Charm's structure processor for non-charm buildings so that Charm does not break several RS structures that uses Data Mode Structure Blocks.


### **(V.3.3.4 Changes) (1.16.5 Minecraft)**

##### Mod Compat:
Adjusted piece spawn limiting for Tidbits compat datapack.


### **(V.3.3.3 Changes) (1.16.5 Minecraft)**

##### Mod Compat:
Modded loot will be imported into Better Stronghold Compat datapack's loot tables now.

##### Misc:
Fixed the structure offsetting to actually work for and only for RS strongholds so they do not get cutoff by world bottom.


### **(V.3.3.2 Changes) (1.16.5 Minecraft)**

##### Dungeons:
Added shulkerBoxInEndDungeons config option to let users make End Dungeons spawn chests instead of Shulker Boxes if set to false.
 Configuredfeatures are unable to be overridden by datapack due to a bad Forge hook placement. Hence this config option as a workaround.

##### Villages:
Slightly adjusted look of Church (temple) piece in Mushroom Villages.

##### Misc:
RS structures that would've been cut off by world bottom will be offset upward so that they are now longer cut off. 
 (Helps prevents End-themed Better Stronghold from being cut off when using Better Stronghold Compat datapack)


### **(V.3.3.1 Changes) (1.16.5 Minecraft)**

##### Villages:
Adjusted some zombie terminator pool files so that they are used now for many zombie variant RS Villages.

Adjusted many RS Village's terminator pieces to make absolutely sure they cannot spawn the wrong village's street to prevent other village's buildings from spawning in extremely rare edge cases.

Fixed Zombie Warped Village spawning non-zombified Piglins.

##### Mod Compat:
Added limit on piece spawning for future mod compat datapacks with Tidbits, Reosurceful Bees, and PneumaticCraft: Repressurized.
 I'm just future proofing a bit. 


### **(V.3.3.0 Changes) (1.16.5 Minecraft)**

##### Villages:
Added Mushroom Villages for Mushroom category biomes!

Fixed Mountains Villages very very rarely spawn Savanna Village pieces.

Fixed Swamp and Giant Tree Taiga Villages very very rarely spawn Plains Village pieces.

Removed a lot of the randomly placed Red Sand blocks from Badlands Villages to make them look a lot cleaner.

##### Mod Compat:
Houses added to RS's villages from the official mod compat datapacks will now only spawn more more than once for a single village.
 This will greatly help prevent RS's villages from becoming overloaded with multiple modded houses from the datapacks.