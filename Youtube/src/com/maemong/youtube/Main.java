package com.maemong.youtube;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.maemong.youtube.commands.RemoveWarpCommand;
import com.maemong.youtube.commands.SetWarpCommand;
import com.maemong.youtube.commands.WarpCommand;
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
		
		ConfigurationSerialization.registerClass(Warp.class);
        
		new WarpManager();
	}
	
	@Override
	public void onDisable() {
		WarpManager.getInstance().saveData();
	}
}
