package com.maemong.youtube.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.maemong.youtube.managers.GuiManager;

public class AddGuiCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("�� ��ɾ�� �÷��̾ ����� �� �ֽ��ϴ�.");
			
			return true;
		}
		
		Player p = (Player) sender;
		ItemStack item = p.getInventory().getItemInMainHand();
		
		if (item.getType() == Material.AIR) {
			p.sendMessage("�������� ����ּ���.");
			return false;
		}
		
		GuiManager.getInstance().addItem(item);
		p.sendMessage("�������� �߰��Ͽ����ϴ�.");
		
		return true;
	}

}
