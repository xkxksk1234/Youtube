package com.maemong.youtube.managers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.maemong.youtube.Main;

public class GuiManager {
	private static GuiManager instance;
	private File folder = Main.getInstance().getDataFolder();
	private File file;
	private YamlConfiguration yaml;
	private List<ItemStack> items = new ArrayList<>();
	private Inventory gui;
	
	public GuiManager() {
		instance = this;
		
		initFile();
		loadData();
		createGui();
	}
	
	public static GuiManager getInstance() {
		return instance;
	}
	
	public void open(Player p) {
		p.openInventory(gui);
	}
	
	private void initFile() {
		file = new File(folder, "Gui.yml");
		
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
		
		yaml = YamlConfiguration.loadConfiguration(file);
	}
	
	@SuppressWarnings("unchecked")
	private void loadData() {
		items = (List<ItemStack>) yaml.getList("gui.items");

		if (items == null) {
			items = new ArrayList<>();
		}
		
		Bukkit.getConsoleSender().sendMessage("GUI 파일을 불러왔습니다.");
	}
	
	public void saveData() {
		yaml.set("gui.items", items);
		
		try {
			yaml.save(file);
			
			Bukkit.getConsoleSender().sendMessage("GUI 파일을 저장하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void addItem(ItemStack item) {
		items.add(item);
		gui.addItem(item);
		Bukkit.getConsoleSender().sendMessage("GUI에 새로운 아이템이 추가되었습니다.");
	}
	
	private void createGui() {
		gui = Bukkit.createInventory(null, 9, "This is GUI");
		
		for (ItemStack item : items) {
			gui.addItem(item);
		}
	}
}
