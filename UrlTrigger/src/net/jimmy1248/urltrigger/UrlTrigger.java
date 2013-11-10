package net.jimmy1248.urltrigger;

import org.bukkit.plugin.java.JavaPlugin;

public class UrlTrigger extends JavaPlugin{

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		new  EventListener(this);
	}
}
