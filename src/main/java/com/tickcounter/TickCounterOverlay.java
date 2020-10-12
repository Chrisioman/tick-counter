package com.tickcounter;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayMenuEntry;
import net.runelite.client.ui.overlay.components.LayoutableRenderableEntity;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

public class TickCounterOverlay extends OverlayPanel
{

	private TickCounterPlugin plugin;
	private TickCounterConfig config;
	private Client client;

	@Inject
	public TickCounterOverlay(TickCounterPlugin plugin,Client client,TickCounterConfig config)
	{
		super(plugin);
		setPosition(OverlayPosition.DYNAMIC);
		setPosition(OverlayPosition.DETACHED);
		setPosition(OverlayPosition.BOTTOM_RIGHT);
		this.plugin = plugin;
		this.client = client;
		this.config = config;
		getMenuEntries().add(new OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY, "Reset", "Tick counter"));
	}

	@Override
	public Dimension render(Graphics2D g)
	{
		List<LayoutableRenderableEntity> elems = panelComponent.getChildren();
		elems.clear();
		List<Entry<String, Integer>> list = new ArrayList<>(plugin.activity.entrySet());
		list.sort(new Comparator<Entry<String, Integer>>()
		{
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
			{
				int value = -Integer.compare(o1.getValue(), o2.getValue());
				if (value == 0)
					value = o1.getKey().compareTo(o2.getKey());
				return value;
			}
		});
		if (list.size() != 0) elems.add(TitleComponent.builder().text("Tick counter").color(config.titleColor()).build());
		int total = 0;
		for (Entry<String, Integer> e : list)
		{
			total += e.getValue();
			if(e.getKey().equals(client.getLocalPlayer().getName()))
			{
				elems.add(LineComponent.builder().leftColor(config.selfColor()).rightColor(config.selfColor()).left(e.getKey()).right(e.getValue().toString()).build());
			}
			else
			{
				elems.add(LineComponent.builder().left(e.getKey()).right(e.getValue().toString()).leftColor(config.otherColor()).rightColor(config.otherColor()).build());

			}
		}
		if (config.totalEnabled())
		{
			if (list.size() != 0) elems.add(LineComponent.builder().left("Total").leftColor(config.totalColor()).rightColor(config.totalColor()).right(String.valueOf(total)).build());
		}
		return super.render(g);
	}
}