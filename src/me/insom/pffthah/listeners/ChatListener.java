package me.insom.pffthah.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.insom.pffthah.core.PfftHah;

public class ChatListener implements Listener{
	
	PfftHah myPlugin = null;
	
	public ChatListener(PfftHah instance)
	{
		myPlugin = instance;
	}
	
	@EventHandler (priority = EventPriority.LOW)
	public void playerChat(AsyncPlayerChatEvent e)
	{
		if(e.getPlayer().getName().equals("Kherr"))
		{
			String msg = e.getMessage();
			
			if(msg.contains("pf") && msg.contains("ha")) // The start of both 2 words. there is definitely no "pfft hah" without them
			{
				
				
				/*/////////////
				 * I am doing so much damn work here to allow for any number of f's and a's 
				 * in the message "pfft hah!". I am trying to allow for as
				 * much variation in his message as possible. ////////////*/	
				
				/*
				 * Another way of going about this would be to find "pf", 
				 * then send it through a recursion method to constantly check each next letter for "f" and break at first non-f letter,
				 * use the value of the first non-f character to decide if it is "pffft" or not, then do the same for "hah"
				 * 
				 * ... I'm starting to like that idea alot.
				 * */
				
				
				//Trim message down to start of the potential "pfft!!!"
				msg = msg.substring(msg.indexOf("pf"), msg.length());
				int firstSpace = msg.indexOf(" ");
				
				if(firstSpace != -1)
				{
					if(msg.substring(0,firstSpace).endsWith("t") || msg.substring(0,firstSpace).endsWith("t,")) // Contains "pffft" (most likely...)
					{
						msg = msg.substring(firstSpace, msg.length()); // Trim out the "pfft"
						if(msg.startsWith("ha"))
						{
							firstSpace = msg.indexOf(" ");
							if(firstSpace != 1)
							{
								if(msg.substring(0,firstSpace).endsWith("h")) // *Most likely* contains "hah"
								{
									//TODO increment the amount of "pfft hah"'s kherr has said!
								}
							}
						}
					}
				}
			}
		}
	}

}
