package com.maemong.youtube.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class GuiClickListener implements Listener {
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Inventory inv =  e.getClickedInventory();
		
		if (inv == null || inv.getTitle() == null) {
			return;
		}
		
		if (inv.getTitle().equals("This is GUI")) {
			e.setCancelled(true);
		}
	}
}
