package xpfly3;

import org.bukkit.plugin.java.JavaPlugin;
import xpfly3.commands.XPFlycmd;
        
public class XPFly extends JavaPlugin {

    @Override
    public void onEnable()
    {
        registerCommands();
        System.out.print("Xpfly3 enabled");
    }
    private void registerCommands()
    {
        getCommand("xpfly").setExecutor(new XPFlycmd());
    }
}
