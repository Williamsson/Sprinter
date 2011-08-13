package swe.kbk.williamsson.sprinter;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class MoveListener extends PlayerListener {
	public static Sprinter plugin;
	public MoveListener(Sprinter instance) {
		plugin = instance;
	}
		
	public MoveListener setSprint(PlayerMoveEvent Event){
		Player player = Event.getPlayer();
		if ((Sprinter.permissionHandler.has(player, "Sprinter.sprint")));{
			Vector v = player.getLocation().getDirection().multiply(20).setY(0);
			player.setVelocity(v);
			player.sendMessage("Hurrdurrderpaderp");
		}
		return null;
		
	}
}