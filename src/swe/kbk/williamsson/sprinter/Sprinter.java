package swe.kbk.williamsson.sprinter;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

/** Making plugin for KBK server. Like a bauss!
 * 
 * @author Williamsson
 *
 */

public class Sprinter extends JavaPlugin {
		public static Sprinter plugin;
	
	public final Logger logger = Logger.getLogger ("Minecraft");
	public static PermissionHandler permissionHandler;
	public final MoveListener MoveListener = new MoveListener(this);
		
	@Override
	public void onDisable() {
		this.logger.info("Sprinter disabled!");
		
		
	}
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_MOVE, this.MoveListener, Event.Priority.Normal, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
		setupPermissions();
	}
	
	private void setupPermissions() {
	    if (permissionHandler != null) {
	        return;
	    }
	    Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
	    
	    if (permissionsPlugin == null) {
	        logger.info("Permission system not detected, defaulting to OP");
	        return;
	    }
	    
	    permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	    logger.info("Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}
	
}


