package com.maemong.youtube.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.maemong.youtube.Warp;
import com.maemong.youtube.managers.WarpManager;

public class WarpCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("�÷��̾ ����� ������ ��ɾ��Դϴ�.");
			
			return false;
		}
		
		Player p = (Player) sender;
		
		if (args.length == 0) {
			p.sendMessage("�̸��� �Է����ּ���.");
			
			return false;
		}
		
		WarpManager manager = WarpManager.getInstance();
		String name = args[0];
		
		if (manager.containWarp(name)) {
			Warp warp = manager.getWarp(name);
			Location loc = warp.getLocation();
			
			p.teleport(loc);
			p.sendMessage(name + " ������ �̵��Ͽ����ϴ�.");
		} else {
			p.sendMessage(name + " ������ �������� �ʽ��ϴ�.");
		}
		
		return true;
	}
}
