package org.realityforge.gwt.performance_timeline.client;

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.SimpleEventBus;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.gwt.performance_timeline.client.PerformanceEntry.EntryType;
import org.realityforge.gwt.performance_timeline.client.event.ResourceTimingBufferFullEvent;

public abstract class PerformanceTimeline
{
  private static PerformanceTimeline g_cache;

  private final EventBus _eventBus;

  public static PerformanceTimeline get()
  {
    if ( null == g_cache )
    {
      if ( GWT.isClient() && Html5PerformanceTimeline.isSupported() )
      {
        register( new Html5PerformanceTimeline( new SimpleEventBus() ) );
      }
    }
    return g_cache;
  }

  public static void register( @Nonnull final PerformanceTimeline performanceTimeline )
  {
    g_cache = performanceTimeline;
  }

  public static boolean deregister( @Nonnull final PerformanceTimeline performanceTimeline )
  {
    if ( g_cache != performanceTimeline )
    {
      return false;
    }
    else
    {
      g_cache = null;
      return true;
    }
  }

  protected PerformanceTimeline( @Nonnull final EventBus eventBus )
  {
    _eventBus = eventBus;
  }

  @Nonnull
  public abstract List<PerformanceEntry> getEntries();

  @Nonnull
  public abstract <T extends PerformanceEntry> List<T> getEntriesByType( @Nonnull EntryType entryType );

  @Nonnull
  public abstract <T extends PerformanceEntry> List<T> getEntriesByName( @Nonnull String name,
                                                                         @Nullable EntryType entryType );

  public abstract boolean isSupported( @Nonnull EntryType entryType );

  public abstract void clearResourceTimings();

  public abstract void setResourceTimingBufferSize( int maxSize );

  @Nonnull
  public final HandlerRegistration addResourceTimingBufferFull( @Nonnull ResourceTimingBufferFullEvent.Handler handler )
  {
    return _eventBus.addHandler( ResourceTimingBufferFullEvent.getType(), handler );
  }

  protected final void onResourceTimingBufferFullEvent()
  {
    _eventBus.fireEventFromSource( new ResourceTimingBufferFullEvent(), this );
  }
}
