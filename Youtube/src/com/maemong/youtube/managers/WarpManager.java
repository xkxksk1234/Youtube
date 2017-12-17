package com.maemong.youtube.managers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.maemong.youtube.Main;
import com.maemong.youtube.Warp;

public class WarpManager {
	private static WarpManager instance;
	private File file;
	private FileConfiguration yaml;
	private List<Warp> warpList = new ArrayList<>();
	
	public WarpManager() {
		instance = this;
		
		file = new File(Main.getInstance().getDataFolder(), "warps.yml");
		yaml = YamlConfiguration.loadConfiguration(file);
		
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		loadData();
	}
	
	public static WarpManager getInstance() {
		return instance;
	}
	
	public boolean addWarp(String name, Location loc) {
		Warp warp = new Warp(name, loc);
		
		if (containWarp(name)) {
			return false;
		}
		
		return warpList.add(warp);
	}
	
	public void removeWarp(String name) {
		if (containWarp(name)) {
			Warp warp = getWarp(name);
			
			warpList.remove(warp);
		}
	}
	
	public Warp getWarp(String name) {
		for (Warp warp : warpList) {
			if (warp.getName().equals(name)) {
				return warp;
			}
		}
		
		return null;
	}
	
	public boolean containWarp(String name) {
		return getWarp(name) != null;
	}
	
	public void saveData() {
		yaml.set("warps", warpList);
		
		try {
			yaml.save(file);
			Bukkit.getConsoleSender().sendMessage("워프 파일을 저장했습니다.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			Bukkit.getConsoleSender().sendMessage("워프 파일을 저장하지 못하였습니다.");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadData() {
		List<?> warpList = yaml.getList("warps");
		
		if (warpList == null) {
			warpList = new ArrayList<>();
		}
		
		this.warpList = (List<Warp>) warpList;
		Bukkit.getConsoleSender().sendMessage("워프 파일을 불러왔습니다.");
	}
}
