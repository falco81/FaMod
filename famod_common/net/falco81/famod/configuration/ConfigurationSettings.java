package net.falco81.famod.configuration;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.Itemids;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.lib.Strings;
import net.falco81.famod.lib.Worldgen;
import net.minecraftforge.common.Configuration;

public class ConfigurationSettings {

    public static Configuration configuration;
    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* Block configs */
            Blockids.FAMODMANGANORE = configuration.getBlock(Strings.FAMODMANGANORE_NAME, Blockids.FAMODMANGANORE_DEFAULT).getInt(Blockids.FAMODMANGANORE_DEFAULT);
            Blockids.FAMODMANGANBLOCK = configuration.getBlock(Strings.FAMODMANGANBLOCK_NAME, Blockids.FAMODMANGANBLOCK_DEFAULT).getInt(Blockids.FAMODMANGANBLOCK_DEFAULT);
            Blockids.FAMODSHOCKFURNACE = configuration.getBlock(Strings.FAMODSHOCKFURNACE_NAME, Blockids.FAMODSHOCKFURNACE_DEFAULT).getInt(Blockids.FAMODSHOCKFURNACE_DEFAULT);
            Blockids.FAMODSHOCKCOALORE = configuration.getBlock(Strings.FAMODSHOCKCOALORE_NAME, Blockids.FAMODSHOCKCOALORE_DEFAULT).getInt(Blockids.FAMODSHOCKCOALORE_DEFAULT);
            Blockids.FAMODSHOCKCOALBLOCK = configuration.getBlock(Strings.FAMODSHOCKCOALBLOCK_NAME, Blockids.FAMODSHOCKCOALBLOCK_DEFAULT).getInt(Blockids.FAMODSHOCKCOALBLOCK_DEFAULT);
            /* Item configs */
            Itemids.FAMODSICKLEDIAMOND = configuration.getItem(Strings.FAMODSICKLEDIAMOND_NAME, Itemids.FAMODSICKLEDIAMOND_DEFAULT).getInt(Itemids.FAMODSICKLEDIAMOND_DEFAULT);
            Itemids.FAMODSICKLEGOLDEN = configuration.getItem(Strings.FAMODSICKLEGOLDEN_NAME, Itemids.FAMODSICKLEGOLDEN_DEFAULT).getInt(Itemids.FAMODSICKLEGOLDEN_DEFAULT);
            Itemids.FAMODSICKLEIRON = configuration.getItem(Strings.FAMODSICKLEIRON_NAME, Itemids.FAMODSICKLEIRON_DEFAULT).getInt(Itemids.FAMODSICKLEIRON_DEFAULT);
            Itemids.FAMODSICKLESTONE = configuration.getItem(Strings.FAMODSICKLESTONE_NAME, Itemids.FAMODSICKLESTONE_DEFAULT).getInt(Itemids.FAMODSICKLESTONE_DEFAULT);
            Itemids.FAMODSICKLEWOODEN = configuration.getItem(Strings.FAMODSICKLEWOODEN_NAME, Itemids.FAMODSICKLEWOODEN_DEFAULT).getInt(Itemids.FAMODSICKLEWOODEN_DEFAULT);
            Itemids.FAMODTREEAXE = configuration.getItem(Strings.FAMODTREEAXE_NAME, Itemids.FAMODTREEAXE_DEFAULT).getInt(Itemids.FAMODTREEAXE_DEFAULT);
            Itemids.FAMODMANGANINGOT = configuration.getItem(Strings.FAMODMANGANINGOT_NAME, Itemids.FAMODMANGANINGOT_DEFAULT).getInt(Itemids.FAMODMANGANINGOT_DEFAULT);
            Itemids.FAMODMANGANPICKAXE = configuration.getItem(Strings.FAMODMANGANPICKAXE_NAME, Itemids.FAMODMANGANPICKAXE_DEFAULT).getInt(Itemids.FAMODMANGANPICKAXE_DEFAULT);
            Itemids.FAMODMANGANAXE = configuration.getItem(Strings.FAMODMANGANAXE_NAME, Itemids.FAMODMANGANAXE_DEFAULT).getInt(Itemids.FAMODMANGANAXE_DEFAULT);
            Itemids.FAMODMANGANSWORD = configuration.getItem(Strings.FAMODMANGANSWORD_NAME, Itemids.FAMODMANGANSWORD_DEFAULT).getInt(Itemids.FAMODMANGANSWORD_DEFAULT);
            Itemids.FAMODSHOCKCOAL = configuration.getItem(Strings.FAMODSHOCKCOAL_NAME, Itemids.FAMODSHOCKCOAL_DEFAULT).getInt(Itemids.FAMODSHOCKCOAL_DEFAULT);
            /* Worldgen configs */
            Worldgen.WORLDGENMANGAN = configuration.get("World Generation", Strings.FAMODWORLDGENMANGAN_NAME, Worldgen.WORLDGENMANGAN_DEFAULT).getBoolean(Worldgen.WORLDGENMANGAN_DEFAULT);
            Worldgen.WORLDGENSHOCKORE = configuration.get("World Generation", Strings.FAMODWORLDGENSHOCKORE_NAME, Worldgen.WORLDGENSHOCKORE_DEFAULT).getBoolean(Worldgen.WORLDGENSHOCKORE_DEFAULT);

        }
        catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
    }

    public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }

}
