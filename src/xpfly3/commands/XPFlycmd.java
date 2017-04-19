/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpfly3.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author myron
 */

/*
het command is nu /refil.
dit werkt half.
het werkt alleen als je er achter ook nog de naam zet. ik wil dat je ook gewoon /refil kan gebruiken en dan op de zender van het command word gebruikt.
WORK IN PROGRESS!!!
*/

public class XPFlycmd implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender,Command cmd, String label, String[] args)
    {
        if (!sender.hasPermission("xpfly.use"))
        {
            //foutmelding naar speler
            return false;
        }
        /*
         Player p = (Player) sender; werkt nog niet. waarom weet ik niet.
        dit komt waarschijnlijk omdat ik in dat ifstatement die er boven zit "if(sender instanceof Player) {" de zelfde variable gebruikt...
        HEEEEELLLLPPPP!!!!!
        */ 
        Player p = (Player) sender;        
        if(args.length == 0)
        {
            if(sender instanceof Player)
            {
                if(p.isFlying() == false)
                {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                }
                else if(p.isFlying() == true)
                {
                    p.setAllowFlight(false);
                    p.setFlying(false);
                }
                return true;
            }
            else
            {
                sender.sendMessage("You need to put a name after the command to use it.");
                return true;
            }
        }
        /*
        dit hieronder is voor mensen in het consol. of voor staf/mensen met permissie.
        consol moet er een 2e variable bij zetten anders doet hij het niet. dit klopt.
        */

        else if(args.length == 1)
        {
            if (!sender.hasPermission("xpfly.other"))
            {
                //foutmelding naar speler geen permissie
                return false;
            }
            String playerName = args[0];
            Player selected = Bukkit.getServer().getPlayer(playerName);
            if(selected == null)
            {
                sender.sendMessage(ChatColor.RED + "The player" + playerName + "is offline");
            }
            else
            {
                if(selected.isFlying() == false)
                {
                    selected.setAllowFlight(true);
                    selected.setFlying(true);
                }
                else if(selected.isFlying() == true)
                {
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
        return true;
    }
}
