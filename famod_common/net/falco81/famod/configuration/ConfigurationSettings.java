package net.falco81.famod.configuration;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import net.falco81.famod.lib.Blockids;
import net.falco81.famod.lib.Reference;
import net.falco81.famod.lib.Strings;
import net.minecraftforge.common.Configuration;

public class ConfigurationSettings {

    public static Configuration configuration;
    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* Block configs */
            Blockids.FAMODSAND = configuration.getBlock(Strings.FAMODSAND_NAME, Blockids.FAMODSAND_DEFAULT).getInt(Blockids.FAMODSAND_DEFAULT);
            Blockids.FAMODBEDROCK = configuration.getBlock(Strings.FAMODBEDROCK_NAME, Blockids.FAMODBEDROCK_DEFAULT).getInt(Blockids.FAMODBEDROCK_DEFAULT);

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
