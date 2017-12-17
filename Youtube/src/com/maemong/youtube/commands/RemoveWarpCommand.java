package com.maemong.youtube.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.maemong.youtube.managers.WarpManager;

public class RemoveWarpCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("플레이어만 사용이 가능한 명령어입니다.");
			
			return false;
		}
		
		Player p = (Player) sender;
		
		if (args.length == 0) {
			p.sendMessage("이름을 입력해주세요.");
			
			return false;
		}
		
		WarpManager manager = WarpManager.getInstance();
		String name = args[0];
		
		if (manager.containWarp(name)) {
			manager.removeWarp(name);
			
			p.sendMessage(name + " 워프를 성공적으로 삭제하였습니다.");
		} else {
			p.sendMessage(name + " 워프는 존재하지 않습니다.");
		}
		
		return true;
	}

}
