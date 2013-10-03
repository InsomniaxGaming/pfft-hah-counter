package me.insom.pffthah.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PfftHah extends JavaPlugin{
	
	public void onEnable(){}
	
	public void onDisable()
	{
		this.saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			if(cmd.getName().equalsIgnoreCase("kherrcounter"))
			{
				sender.sendMessage("Kherr has said \"Pfffft, hah!\" " + this.getKherrCount() + " times");
			}
		}
		return false;
	}

}
