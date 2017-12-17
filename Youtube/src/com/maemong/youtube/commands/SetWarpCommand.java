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
			sender.sendMessage("플레이어만 사용이 가능한 명령어입니다.");
			
			return false;
		}
		
		Player p = (Player) sender;
		
		if (args.length == 0) {
			p.sendMessage("워프 이름을 입력해주세요.");
			
			return false;
		}
		
		String name = args[0];
		Location loc = p.getLocation();
		
		boolean result = WarpManager.getInstance().addWarp(name, loc);
		
		if (result) {
			p.sendMessage(name + " 워프를 정상적으로 추가하였습니다.");
		} else {
			p.sendMessage(name + " 워프를 추가하지 못하였습니다.");
		}
		
		return true;
	}
}
