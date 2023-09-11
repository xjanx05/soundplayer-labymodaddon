package de.atirionstudios.core;

import de.atirionstudios.activity.ActivityNavigationElement;
import de.atirionstudios.activity.SoundPlayerActivity;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class SoundPlayerAddon extends LabyAddon<SoundPlayerConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.logger().info("Enabled the Addon");

    labyAPI().navigationService()
        .register("soundplayeraddon", new ActivityNavigationElement(new SoundPlayerActivity()));

  }


  @Override
  protected Class<SoundPlayerConfiguration> configurationClass() {
    return SoundPlayerConfiguration.class;
  }
}
