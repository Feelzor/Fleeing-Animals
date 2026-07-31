[![Requires Fabric API](./src/main/resources/assets/fleeinganimals/requirements/fabric-api.png)](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
[![Requires Cloth Config API](./src/main/resources/assets/fleeinganimals/requirements/cloth-config.png)](https://www.curseforge.com/minecraft/mc-mods/cloth-config)

# Fleeing Animals

Fleeing Animals is a simple mod that changes the behaviour of passive entities. Once hit, they will flee as usual
(except for some entities such as horses), but the nearby entities will also be alerted and will start running too.

![Gif showing mod in action](https://media.giphy.com/media/GdLj7bKyFj4IbIpOGM/giphy.gif)

## Configuration

By default, the mobs will detect any passive mob being hit in their detection range (e.g. the distance where they see you
holding wheat, carrots, ...), 10 blocks higher or lower than them.

If for some reason, you aren't satisfied with the default configuration, you can tweak some settings:

- `radius` is a detection range multiplier. If you set it to 2.0, mobs will flee if you hit another passive entity up 
to twice their follow range.
- `yRadius` is the maximum number of vertical blocks you can be seen by other passive entities. If you set it to 100
for example, animals will detect you if you hit another entity up to 100 blocks over their head.
- `sameSpeciesOnly` decide whether you want all passive entities to flee only when hitting their family (cows will flee 
**only** if you hit another cow), or you want them to flee when you hit any other animal (cows will flee if you hit
chickens).

## Compatibility

The mod should easily work with most other mods, but compatibility issues may arise. If you encounter a problem, do not
hesitate to [leave an issue](https://github.com/FeelZoR/Fleeing-Animals/issues) to let me know, and I'll try to fix it.
