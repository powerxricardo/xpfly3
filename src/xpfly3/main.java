package xpfly3;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

/*
het command is nu /refil.
dit werkt half.
het werkt alleen als je er achter ook nog de naam zet. ik wil dat je ook gewoon /refil kan gebruiken en dan op de zender van het command word gebruikt.
WORK IN PROGRESS!!!


*/
        
public class main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.print("Xpfly3 enabled");        
    }
    
    @Override
    public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("refil")) {
            /*
             Player p = (Player) sender; werkt nog niet. waarom weet ik niet.
            dit komt waarschijnlijk omdat ik in dat ifstatement die er boven zit "if(sender instanceof Player) {" de zelfde variable gebruikt...
            HEEEEELLLLPPPP!!!!!
            */ 
           Player p = (Player) sender;
           String playerName = args[0];
           Player selected = Bukkit.getServer().getPlayer(playerName);  

           
           if(args.length == 0) {
                if(sender instanceof Player) {
                    if(p.isFlying() == false) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                    }
                    else if(p.isFlying() == true) {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                    } 
                                       
                    return true;
                } 
                else {
                    sender.sendMessage("You need to put a name after the command to use it.");
                    return true;
                }
                
                
                
                
                
                
                
            }
           /*
           dit hieronder is voor mensen in het consol. of voor staf/mensen met permissie.
           consol moet er een 2e variable bij zetten anders doet hij het niet. dit klopt.
           */
           
            else if(args.length == 1){
             
                if(selected == null) {
                
                    sender.sendMessage(ChatColor.RED + "The player" + playerName + "is offline");
                } 
                else {
                    if(selected.isFlying() == false) {
                    selected.setAllowFlight(true);
                    selected.setFlying(true);
                    }
                    else if(selected.isFlying() == true) {
                    selected.setAllowFlight(false);
                    selected.setFlying(false);
                    }
                   /*
                    selected.setAllowFlight(true);
                    selected.setFlying(true);
                    */
                    selected.sendMessage("You have been refilled!");
                    sender.sendMessage("You have refilled" + selected.getName());
                    
                }
            }
        }
        
        
        
        
        return true;
    }

    
}
