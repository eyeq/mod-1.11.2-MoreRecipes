package eyeq.morerecipes;

import java.util.Arrays;

import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static eyeq.morerecipes.MoreRecipes.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class MoreRecipes {
    public static final String MOD_ID = "eyeq_morerecipes";

    @Mod.Instance(MOD_ID)
    public static MoreRecipes instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        addRecipes();
    }

    public static void addRecipes() {
        // dye
        for(int i = 0; i < EnumDyeColor.values().length; ++i) {
            GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, i), new ItemStack(Blocks.WOOL, 1, EnumDyeColor.byDyeDamage(i).getMetadata()));
        }
        GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()), Items.WHEAT_SEEDS, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 3, EnumDyeColor.BLACK.getDyeDamage()), Items.WATER_BUCKET, Items.COAL);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 3, EnumDyeColor.BLACK.getDyeDamage()), Items.WATER_BUCKET, new ItemStack(Items.COAL, 1, 1));
        // bucket
        GameRegistry.addShapelessRecipe(new ItemStack(Items.WATER_BUCKET), Items.BUCKET, Blocks.CACTUS, Blocks.CACTUS, Blocks.CACTUS);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.WATER_BUCKET), Items.BUCKET, Blocks.ICE);
        GameRegistry.addRecipe(new ItemStack(Blocks.OBSIDIAN), "XY",
                'X', Items.LAVA_BUCKET, 'Y', Items.WATER_BUCKET);
        GameRegistry.addRecipe(new ItemStack(Blocks.OBSIDIAN, 2), "XRY",
                'X', Items.LAVA_BUCKET, 'Y', Items.WATER_BUCKET, 'R', Items.REDSTONE);
        GameRegistry.addRecipe(new ItemStack(Items.REDSTONE), "Y ", " X",
                'X', Items.LAVA_BUCKET, 'Y', Items.WATER_BUCKET);
        GameRegistry.addRecipe(new ItemStack(Blocks.STONE, 32), "X", "Y",
                'X', Items.LAVA_BUCKET, 'Y', Items.WATER_BUCKET);
        GameRegistry.addRecipe(new ItemStack(Blocks.COBBLESTONE, 64), "Y", "X",
                'X', Items.LAVA_BUCKET, 'Y', Items.WATER_BUCKET);
        // wood
        GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK), Blocks.SAPLING);
        for(int i = 0; i < BlockPlanks.EnumType.values().length; ++i) {
            GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, i), "X", "X",
                    'X', new ItemStack(Blocks.WOODEN_SLAB, 1, i));
        }
        GameRegistry.addRecipe(new ItemStack(Items.NAME_TAG), "X ", "YZ", "YZ",
                'X', Items.STRING, 'Y', Items.LEATHER, 'Z', Items.PAPER);
        //coal
        Object[] coals = new Object[9];
        Arrays.fill(coals, new ItemStack(Items.COAL));
        ItemStack charcoal = new ItemStack(Items.COAL, 1, 1);
        for(int i = 0; i < 8; ++i) {
            coals[i] = charcoal;
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COAL_BLOCK), coals);
        }
        // armor
        GameRegistry.addRecipe(new ItemStack(Items.SADDLE), "XXX", "YYY", " Z ",
                'X', Items.STRING, 'Y', Items.LEATHER, 'Z', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), "X  ", "XXX", "X X",
                'X', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR), "X  ", "XXX", "X X",
                'X', Items.GOLD_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR), "X  ", "XXX", "X X",
                'X', Items.DIAMOND);
        // extra
        GameRegistry.addShapelessRecipe(new ItemStack(Items.FLINT), Blocks.GRAVEL);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.CLAY_BALL, 4), Blocks.CLAY);
        GameRegistry.addShapelessRecipe(new ItemStack(Items.SPAWN_EGG, 1, 55), Items.WATER_BUCKET, Blocks.SLIME_BLOCK);
        // smelt
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER), 0);
        GameRegistry.addSmelting(Items.CHORUS_FRUIT, new ItemStack(Items.ENDER_PEARL), 0);
    }
}
