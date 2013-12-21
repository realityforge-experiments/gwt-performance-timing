package org.realityforge.gwt.performance_timeline.client;

import com.google.gwt.core.client.JsArray;
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
}
