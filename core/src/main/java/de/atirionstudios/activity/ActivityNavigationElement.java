package de.atirionstudios.activity;

import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.gui.navigation.elements.ScreenNavigationElement;

public class ActivityNavigationElement extends ScreenNavigationElement {

  private final NavigationActivity activity;

  public ActivityNavigationElement(NavigationActivity activity) {
    super(activity);
    this.activity = activity;
  }

  @Override
  public Component getDisplayName() {
    return Component.text(activity.getName());
  }

  @Override
  public Icon getIcon() {
    return activity.getIcon();
  }

  @Override
  public String getWidgetId() {
    return activity.getNamespace();
  }
}
