package me.insom.pffthah.core;

import me.insom.pffthah.listeners.ChatListener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PfftHah extends JavaPlugin{
	
	FileConfiguration config = null;
	
	public void onEnable()
	{
		config = this.getConfig();	
		this.getServer().getPluginManager().registerEvents(new ChatListener(this), this);
	
	}
	
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
				sender.sendMessage("Kherr has said \"Pfffft, hah!\" " + this.getKherrCount() + " times on " + this.getServer().getServerName());
				//sender.sendMessage("Kherr's record for longest \"pfft\": " + this.getKherrLongestPfft()); I /may/ do this some day.
				
				return true;
			}
		}
		return false;
	}
	
	public int getKherrCount()
	{
		return config.getInt("kherrCount");
	}
	
	public void incrementKherrCount()
	{
		config.set("kherrCount", getKherrCount()+1);
		this.saveConfig();
	}
	
	public String getKherrLongestPfft()
	{
		return config.getString("longestPfft");
	}
	
	public void setKherrLongestPfft(String longestPfft)
	{
		config.set("longestPfft", longestPfft);
	}

}
