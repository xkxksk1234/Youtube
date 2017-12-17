package com.maemong.youtube.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.maemong.youtube.managers.WarpManager;

public class SetWarpCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("�÷��̾ ����� ������ ��ɾ��Դϴ�.");
			
			return false;
		}
		
		Player p = (Player) sender;
		
		if (args.length == 0) {
			p.sendMessage("���� �̸��� �Է����ּ���.");
			
			return false;
		}
		
		String name = args[0];
		Location loc = p.getLocation();
		
		boolean result = WarpManager.getInstance().addWarp(name, loc);
		
		if (result) {
			p.sendMessage(name + " ������ ���������� �߰��Ͽ����ϴ�.");
		} else {
			p.sendMessage(name + " ������ �߰����� ���Ͽ����ϴ�.");
		}
		
		return true;
	}
}
