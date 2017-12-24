package com.maemong.youtube;

import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.maemong.youtube.commands.AddGuiCommand;
import com.maemong.youtube.commands.GuiCommand;
import com.maemong.youtube.commands.RemoveWarpCommand;
import com.maemong.youtube.commands.SetWarpCommand;
import com.maemong.youtube.commands.WarpCommand;
import com.maemong.youtube.listeners.GuiClickListener;
import com.maemong.youtube.managers.GuiManager;
import com.maemong.youtube.managers.WarpManager;

public class Main extends JavaPlugin {
	private static Main instance;
	
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;

		getCommand("warp").setExecutor(new WarpCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
		getCommand("delwarp").setExecutor(new RemoveWarpCommand());
		getCommand("gui").setExecutor(new GuiCommand());
		getCommand("addgui").setExecutor(new AddGuiCommand());
		
		Bukkit.getPluginManager().registerEvents(new GuiClickListener(), this);
		
		ConfigurationSerialization.registerClass(Warp.class);
        
		new WarpManager();
		new GuiManager();
	}
	
	@Override
	public void onDisable() {
		WarpManager.getInstance().saveData();
		GuiManager.getInstance().saveData();
	}
}
