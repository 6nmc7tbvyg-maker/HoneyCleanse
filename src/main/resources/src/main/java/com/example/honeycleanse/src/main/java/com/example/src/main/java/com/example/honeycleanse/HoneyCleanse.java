package com.example.honeycleanse;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public final class HoneyCleanse extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("HoneyCleanse enabled!");
    }

    @EventHandler
    public void onHoneyDrink(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() != Material.HONEY_BOTTLE) {
            return;
        }

        var player = event.getPlayer();

        PotionEffectType[] badEffects = {
            PotionEffectType.BLINDNESS,
            PotionEffectType.DARKNESS,
            PotionEffectType.HUNGER,
            PotionEffectType.MINING_FATIGUE,
            PotionEffectType.NAUSEA,
            PotionEffectType.POISON,
            PotionEffectType.SLOWNESS,
            PotionEffectType.WEAKNESS,
            PotionEffectType.WITHER,
            PotionEffectType.UNLUCK
        };

        for (PotionEffectType effect : badEffects) {
            player.removePotionEffect(effect);
        }
    }
}
