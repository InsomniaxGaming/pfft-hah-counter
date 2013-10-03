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
		if(e.getPlayer().getName().equals("Kherr")) // we only want to stalk kherr.
		{
			String msg = e.getMessage().toLowerCase();
			
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
				
				
				//////////////////////OLD CODE/////////////////////////////////
				/*Trim message down to start of the potential "pfft!!!"
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
				}*/
				
				if(msg.indexOf("pf") < msg.indexOf("ha")) // Very quick check that pfft and hah are in the right order. This still means words can be in between the two
				{
					msg = msg.substring(msg.indexOf("pf") + 1); // Trim down to the start of Kherr's F rampage
					
					if(this.getCharAfterLastInstanceOf(msg, 'f', 0) == 't') // contains "pfft"!!!!
					{
						msg = msg.substring(msg.indexOf("ha") +1); // Trim down to the start of Kherr's terrifying bombardment of H's
						
						if(this.getCharAfterLastInstanceOf(msg, 'a', 0) == 'h') // Contains "Hah"!!
						{
							myPlugin.incrementKherrCount();
						}
					}
				}					
			}
		}
	}
	
	public char getCharAfterLastInstanceOf(String message, char instance, int index)
	{
		if(message.charAt(index) == instance)
		{
			return getCharAfterLastInstanceOf(message,instance,index+1); // We must go deeper!
		} else
		{
			return message.charAt(index);
		}		
	}
	

}
