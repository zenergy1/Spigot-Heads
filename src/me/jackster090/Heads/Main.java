package me.jackster090.Heads;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@SuppressWarnings("deprecation")
	public void getHead(Player player, String playerhead) {
		ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
		SkullMeta headmeta = (SkullMeta) head.getItemMeta();
		headmeta.setOwner(playerhead);
		head.setItemMeta(headmeta);
		player.getInventory().addItem(head);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("head")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("heads.head")) {
					if (args.length == 0) {
						player.sendMessage(ChatColor.RED + "Not Enough Arguments! Usage: /head <playername>");
					} else if (args.length == 1) {
						getHead(player, args[0]);
					}
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You Must Be A Player To Use This Command.");
			}
		}
		return true;
	}
}