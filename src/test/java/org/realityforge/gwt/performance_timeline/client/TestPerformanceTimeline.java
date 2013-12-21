package org.realityforge.gwt.performance_timeline.client;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.gwt.performance_timeline.client.PerformanceEntry.EntryType;

@SuppressWarnings( "unchecked" )
final class TestPerformanceTimeline
  extends PerformanceTimeline
{
  private final List<PerformanceEntry> _entries;

  TestPerformanceTimeline( final List<PerformanceEntry> entries )
  {
    _entries = entries;
  }

  @Nonnull
  @Override
  public List<PerformanceEntry> getEntries()
  {
    return _entries;
  }

  @Nonnull
  @Override
  public <T extends PerformanceEntry> List<T> getEntriesByType( @Nonnull final EntryType entryType )
  {
    return (List<T>) _entries;
  }

  @Nonnull
  @Override
  public <T extends PerformanceEntry> List<T> getEntriesByName( @Nonnull final String name,
                                                                @Nullable final EntryType entryType )
  {
    return (List<T>) _entries;
  }
}
