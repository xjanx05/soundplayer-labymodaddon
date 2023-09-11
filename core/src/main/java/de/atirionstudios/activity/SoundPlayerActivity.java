package de.atirionstudios.activity;


import net.labymod.api.client.component.Component;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.gui.screen.Parent;
import net.labymod.api.client.gui.screen.activity.AutoActivity;
import net.labymod.api.client.gui.screen.widget.attributes.WidgetAlignment;
import net.labymod.api.client.gui.screen.widget.size.SizeType;
import net.labymod.api.client.gui.screen.widget.size.WidgetSide;
import net.labymod.api.client.gui.screen.widget.size.WidgetSize;
import net.labymod.api.client.gui.screen.widget.widgets.input.ButtonWidget;
import net.labymod.api.client.gui.screen.widget.widgets.layout.ScrollWidget;
import net.labymod.api.client.gui.screen.widget.widgets.layout.list.VerticalListWidget;
import net.labymod.api.client.resources.ResourceLocation;

@AutoActivity
public class SoundPlayerActivity extends NavigationActivity {

  @Override
  public String getName() {
    return "Sound Player";
  }

  private VerticalListWidget<ButtonWidget> buttonList;
  private ScrollWidget scrollWidget;

  @Override
  public void initialize(Parent parent) {
    super.initialize(parent);
    buttonList = new VerticalListWidget<>();
    buttonList.setSize(SizeType.ACTUAL, WidgetSide.WIDTH, WidgetSize.fitContent());
    buttonList.setSize(SizeType.ACTUAL, WidgetSide.HEIGHT, WidgetSize.fitContent());
    for (int i = 1; i <= 25; i++) {
      ButtonWidget buttonWidget = new ButtonWidget();
      buttonWidget.alignmentX().set(WidgetAlignment.CENTER);
      buttonWidget.alignmentY().set(WidgetAlignment.CENTER);
      buttonWidget.updateIcon(
          Icon.texture(ResourceLocation.create("minecraft", "textures/item/music_disc_chirp.png")));
      buttonWidget.text().set(Component.text(i));
      buttonList.addChild(buttonWidget);
    }

    buttonList.alignmentX().set(WidgetAlignment.CENTER);
    buttonList.alignmentY().set(WidgetAlignment.TOP);

    System.out.println(buttonList.getChildren().size());
    scrollWidget = new ScrollWidget(buttonList);
    scrollWidget.setDragging(true);
    scrollWidget.alignmentX().set(WidgetAlignment.CENTER);
    scrollWidget.alignmentY().set(WidgetAlignment.TOP);
    scrollWidget.setSize(SizeType.ACTUAL, WidgetSide.WIDTH, WidgetSize.fitContent());
    scrollWidget.setSize(SizeType.ACTUAL, WidgetSide.HEIGHT, WidgetSize.fitContent());
    this.document().addChild(scrollWidget);

    scrollWidget.scrollbar().setSize(SizeType.MIN, WidgetSide.WIDTH, WidgetSize.fixed(10));
    scrollWidget.scrollbar().setActive(true);
    scrollWidget.updateScrollbarBounds();

    System.out.println(scrollWidget.scrollbar().isActive());
    System.out.println(scrollWidget.isScrollbarRequired());

  }

  @Override
  protected void postStyleSheetLoad() {
    super.postStyleSheetLoad();
    buttonList.alignmentY().set(WidgetAlignment.TOP);
    buttonList.alignmentX().set(WidgetAlignment.CENTER);

    scrollWidget.alignmentY().set(WidgetAlignment.TOP);
    scrollWidget.alignmentX().set(WidgetAlignment.CENTER);

    scrollWidget.updateScrollbarBounds();

    System.out.println("Active: " + scrollWidget.scrollbar().isActive());
    System.out.println("Required: " + scrollWidget.isScrollbarRequired());
  }

  @Override
  public Icon getIcon() {
    return Icon.texture(ResourceLocation.create("minecraft", "textures/item/music_disc_chirp.png"));
  }
}
