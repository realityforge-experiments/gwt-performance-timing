package org.realityforge.gwt.performance_timeline.client;

import com.google.gwt.core.client.JsArray;
import com.google.web.bindery.event.shared.EventBus;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.gwt.performance_timeline.client.PerformanceEntry.EntryType;

@SuppressWarnings( "unchecked" )
public class Html5PerformanceTimeline
  extends PerformanceTimeline
{
  public static native boolean isSupported()/*-{
    return typeof ($wnd.performance) == "object";
  }-*/;

  public Html5PerformanceTimeline( @Nonnull final EventBus eventBus )
  {
    super( eventBus );
    registerListeners0();
  }

  @Override
  public boolean isSupported( @Nonnull final EntryType entryType )
  {
    if( !isSupported() )
    {
      return false;
    }
    switch ( entryType )
    {
      case resource:
        return isResourceEntryTypeSupported0();
      case navigation:
        return false;
      case measure:
      case mark:
        return false;
    }
    return false;
  }

  @Nonnull
  public List<PerformanceEntry> getEntries()
  {
    return (List<PerformanceEntry>) (List) new JsoReadOnlyList<PerformanceEntryJso>( getEntries0() );
  }

  private native JsArray<PerformanceEntryJso> getEntries0()/*-{
    return $wnd.performance.getEntries();
  }-*/;

  @Nonnull
  public final <T extends PerformanceEntry> List<T> getEntriesByType( @Nonnull final EntryType entryType )
  {
    return (List<T>) (List) new JsoReadOnlyList<PerformanceEntryJso>( getEntriesByType0( entryType.name() ) );
  }

  private native JsArray<PerformanceEntryJso> getEntriesByType0( String entryType )/*-{
    return $wnd.performance.getEntriesByType( entryType );
  }-*/;

  @Nonnull
  public final <T extends PerformanceEntry> List<T> getEntriesByName( @Nonnull final String name,
                                                                      @Nullable final EntryType entryType )
  {
    final String typeKey = null != entryType ? entryType.name() : null;
    return (List<T>) (List) new JsoReadOnlyList<PerformanceEntryJso>( getEntriesByName0( name, typeKey ) );
  }

  private native JsArray<PerformanceEntryJso> getEntriesByName0( String name, String entryType )/*-{
    return $wnd.performance.getEntriesByName( name, entryType );
  }-*/;

  @Override
  public native void clearResourceTimings()/*-{
    if (typeof ($wnd.performance.webkitClearResourceTimings) == "function") {
      $wnd.performance.webkitClearResourceTimings();
    } else if (typeof ($wnd.performance.clearResourceTimings) == "function") {
      $wnd.performance.clearResourceTimings();
    }
  }-*/;

  @Override
  public native void setResourceTimingBufferSize( final int maxSize )/*-{
    if (typeof ($wnd.performance.webkitSetResourceTimingBufferSize) == "function") {
      $wnd.performance.webkitSetResourceTimingBufferSize(maxSize);
    } else if (typeof ($wnd.performance.setResourceTimingBufferSize) == "function") {
      $wnd.performance.setResourceTimingBufferSize(maxSize);
    }
  }-*/;

  private native void registerListeners0() /*-{
    var that = this;

    var onResourceTimingBufferFullEvent = $entry( function () {
      that.@org.realityforge.gwt.performance_timeline.client.PerformanceTimeline::onResourceTimingBufferFullEvent()()();
    } );
    if (typeof ($wnd.performance.onwebkitresourcetimingbufferfull) != "undefined") {
      $wnd.performance.onwebkitresourcetimingbufferfull = onResourceTimingBufferFullEvent;
    } else if (typeof ($wnd.performance.onresourcetimingbufferfull) != "undefined") {
      $wnd.performance.onresourcetimingbufferfull = onResourceTimingBufferFullEvent;
    }
  }-*/;

  private native boolean isResourceEntryTypeSupported0() /*-{
    if (typeof ($wnd.performance.webkitClearResourceTimings) == "function") {
      return true;
    } else if (typeof ($wnd.performance.clearResourceTimings) == "function") {
      return true;
    } else {
      return false;
    }
  }-*/;
}
