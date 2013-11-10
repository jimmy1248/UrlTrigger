package net.jimmy1248.urltrigger;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener{
	UrlTrigger plugin;
	String url;
	public EventListener(UrlTrigger plugin) {
		this.plugin = plugin;
		url = plugin.getConfig().getString("url");
	}
	

	@EventHandler
	public void EnderDragonDeath(EntityDeathEvent event){
		if(event.getEntity().equals(EntityType.ENDER_DRAGON)){
			new SendUrlTrigger(url+"?dragondeath="+event.getEntity().getKiller().getDisplayName());
			plugin.getLogger().info(event.getEntity().getKiller()+" killed the ender dragon");
		}
		
	}
	
	@EventHandler
	public void PlayerJoinEvent(PlayerLoginEvent event){
		new SendUrlTrigger(url+"?join="+event.getPlayer().getDisplayName());
		plugin.getLogger().info(event.getPlayer().getPlayer().getDisplayName()+" joined");
	}
	
	@EventHandler
	public void PlayerLeaveEvent(PlayerQuitEvent event){
		new SendUrlTrigger(url+"?quit="+event.getPlayer().getDisplayName());
		plugin.getLogger().info(event.getPlayer().getPlayer().getDisplayName()+" quit");
	}
}
