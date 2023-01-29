package oilgasoverhaul.main.handlers;

import java.io.File;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

@SideOnly(Side.CLIENT)
public class SoundHandler {
	
	@ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try
        {
            event.manager.addSound("machines/OGO_groundwell.ogg", new File("resources/mod/sound/OGO_groundwell.ogg"));
            event.manager.addSound("machines/OGO_lngheater.ogg", new File("resources/mod/sound/OGO_lngheater.ogg"));

        }
        catch (Exception e)
        {
            System.err.println("[OGODEV] Failed to register one or more sounds.");
        }
    }
}