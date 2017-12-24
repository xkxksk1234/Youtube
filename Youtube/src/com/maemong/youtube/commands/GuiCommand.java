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
			sender.sendMessage("이 명령어는 플레이어만 사용할 수 있습니다.");
			
			return true;
		}
		
		Player p = (Player) sender;
		
		GuiManager.getInstance().open(p);
		
		return true;
	}
}
