package me.tyranzx.teaching;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private ConfigManager() { }
    static ConfigManager instance = new ConfigManager();

    public static ConfigManager getInstance() {
        return instance;
    }
    public Server server = Bukkit.getServer();
    public FileConfiguration config;
    public File cfile;

    public void setupConfiguration(YourCore core) {
        if (!core.getDataFolder().exists()){
            core.getDataFolder().mkdir();
            server.broadcastMessage(ChatColor.GREEN+"La carpeta de configuracion ha sido creada.");
        }
        cfile = new File(core.getDataFolder(), "config.yml");
        config = core.getConfig();
        config.options().copyDefaults(true);
        this.saveConfig();
    }
    public FileConfiguration getConfig() {
        return config;
    }
    public void saveConfig() {
        try {
            config.save(cfile);
        } 
        catch (IOException e) {
            e.printStackTrace();
            server.broadcastMessage("Hubo un error al guardar el archivo config.yml");
        }
        finally {
        	 server.broadcastMessage("Metodo de guardado completado!");
        }
    }
}
