package me.lowynzx.lowcx.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Examples {

    private Examples() {
    }

    static Examples instance = new Examples();

    public static Examples getInstance() {
        return instance;
    }

    public Plugin p;
    public FileConfiguration config;
    public File cfile;

    public void setupConfiguration(Plugin core) {
        if (!core.getDataFolder().exists()){
            core.getDataFolder().mkdir();
            core.getServer().broadcastMessage(ChatColor.GREEN+"La carpeta de configuracion ha sido creada.");
        }
        cfile = new File(core.getDataFolder(), "config.yml");
        config = core.getConfig();
        config.options().copyDefaults(true);
        core.saveConfig();
    }
    public FileConfiguration getConfig() {
        return config;
    }
    public void saveConfig() {
        try {
            config.save(cfile);
        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getServer().broadcastMessage("Hubo un error al guardar el archivo config.yml");
        }
    }
}
