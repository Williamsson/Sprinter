package swe.kbk.williamsson.sprinter;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class MoveListener extends PlayerListener {
	public static Sprinter plugin;
	public MoveListener(Sprinter instance) {
		System.out.println("Ja vi kan instansiera movelistener");
		plugin = instance;
	}
	
	public void onPlayerMove(PlayerMoveEvent event){
		Player player = event.getPlayer();
		System.out.println("Ja, vi har kört metodanropet");
		if ((Sprinter.permissionHandler.has(player, "Sprinter.sprint")));{
			Vector v = player.getLocation().getDirection().multiply(1.2).setY(0);
			player.setVelocity(v);
			System.out.println("Ja, vi tog oss igenom if-satsen!");
		}
	}
}