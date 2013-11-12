package net.jimmy1248.urltrigger;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener{
	UrlTrigger plugin;
	String joinurl ,quiturl, dragonurl;
	public EventListener(UrlTrigger plugin) {
		this.plugin = plugin;
		joinurl = plugin.getConfig().getString("joinurl");
		quiturl = plugin.getConfig().getString("quiturl");
		dragonurl = plugin.getConfig().getString("dragonurl");
		plugin.getServer().getPluginManager().registerEvents(this,plugin);
	}
	

	@EventHandler
	public void EnderDragonDeath(EntityDeathEvent event){
		
		if(event.getEntityType().equals(EntityType.ENDER_DRAGON)){
			plugin.getLogger().info(new SendUrlTrigger(dragonurl+"?dragondeath="+
					event.getEntity().getKiller().getDisplayName()).getResponse());
			plugin.getLogger().info(event.getEntity().getKiller().getDisplayName()+" killed the ender dragon");
		}
		
	}
	
	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent event){
		plugin.getLogger().info(new SendUrlTrigger(joinurl+"?join="+
				event.getPlayer().getDisplayName()).getResponse());
		plugin.getLogger().info(event.getPlayer().getPlayer().getDisplayName()+" joined");
	}
	
	@EventHandler
	public void PlayerLeaveEvent(PlayerQuitEvent event){
		plugin.getLogger().info(new SendUrlTrigger(quiturl+"?quit="+
				event.getPlayer().getDisplayName()).getResponse());
		plugin.getLogger().info(event.getPlayer().getPlayer().getDisplayName()+" quit");
	}
}
