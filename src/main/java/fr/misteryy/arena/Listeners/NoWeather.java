package fr.misteryy.arena.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class NoWeather implements Listener {
    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        e.setCancelled(e.toWeatherState());
    }
}
