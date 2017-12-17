package com.maemong.youtube;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class Warp implements ConfigurationSerializable {
	private String name;
	private Location loc;
	
	public Warp(String name, Location loc) {
		this.name = name.toLowerCase();
		this.loc = loc;
	}
	
	public Warp(Map<String, Object> map) {
		this.name = (String) map.get("name");
		this.loc = (Location) map.get("location");
	}
	
	public String getName() {
		return name;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	@Override
	public Map<String, Object> serialize() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("name", name);
		map.put("location", loc);
		
		return map;
	}
}
