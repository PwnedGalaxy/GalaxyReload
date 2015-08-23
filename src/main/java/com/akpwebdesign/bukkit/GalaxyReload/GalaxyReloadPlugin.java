package com.akpwebdesign.bukkit.GalaxyReload;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class GalaxyReloadPlugin extends JavaPlugin implements Listener {
	
	private String[] responses = {"Are you daft?", "Reported; assisting enemy team.", "What the fuck did you just fucking say about me, you little bitch?",
									"Little bitches don't get shit.", "Gorbfer stop gorbfing! Gorbfer stop gorbfing! Gorbfer stop gorbfing!", "no ward ching chong",
									"Once a nigger, always a nigger.", "Is that an ass cavern?", "You dun goofed.", "Well, shit.", "Bloody Hell!",
									"I DON'T KNOW ABOUT YOU, BUT I'M FEELING TWENTY TWOOOOOOOO!", ":I", "LOL", "ぽんぽんぽん", "So kawaii~", "wwwwwwwwwwwwww",
									"yozorajp wuz heer.w", "WUBWUBWUB", "Cluck!", "Fuck bitches, get money.", "Chad Warden.", "PSTriple", "When are we getting pizza?",
									"I agree, nerf Irelia.", "Cazif likes men.", "Holy batshit, Batman!", "desudesudesu", "What the fuck, bird?", "MAH BARON, BITCH!",
									"Oh, really?", "YAAAAAAAAY!", "GAAAAAAAAY!", "IF U STEAL THIS I'LL CHOP UR NOB OFF YA CUNT YA", "SUK MY FLIPPY KNACKLES", 
									"how u no my passwerd", "^mad", "The average person has roughly one ovary and one testicle.", "Uh... I got nothing."};
	
	private Random rand = new Random();
	
	@Override
	public void onDisable() {
		getLogger().info(String.format("[%s] Disabled v%s", getDescription().getName(), getDescription().getVersion()));
	}

	@Override
	public void onEnable() {
		getLogger().info(String.format("[%s] Enabled v%s", getDescription().getName(), getDescription().getVersion()));
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		String cmd = e.getMessage().split(" ")[0].replace("/", "").toLowerCase();
		if(cmd.equals("reload") || cmd.equals("rl"))
		{
			if(e.getPlayer().hasPermission("bukkit.command.reload"))
			{
				e.getPlayer().sendMessage(ChatColor.RED + responses[rand.nextInt(responses.length+1)]);
				e.setCancelled(true);
			}
		}
	}
}
