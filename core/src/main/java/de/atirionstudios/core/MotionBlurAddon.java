package de.atirionstudios.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class MotionBlurAddon extends LabyAddon<MotionBlurConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<MotionBlurConfiguration> configurationClass() {
    return MotionBlurConfiguration.class;
  }
}
