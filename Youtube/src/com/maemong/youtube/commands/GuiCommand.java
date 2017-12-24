package com.maemong.youtube.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.maemong.youtube.managers.GuiManager;

public class GuiCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("�� ��ɾ�� �÷��̾ ����� �� �ֽ��ϴ�.");
			
			return true;
		}
		
		Player p = (Player) sender;
		
		GuiManager.getInstance().open(p);
		
		return true;
	}
}
