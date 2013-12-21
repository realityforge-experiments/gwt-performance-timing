package org.realityforge.gwt.timing.client;

public interface PerformanceEntry
{
  enum EntryType
  {
    resource, navigation, mark, measure
  }

  String getName();

  EntryType getEntryType();

  double getStartTime();

  double getDuration();
}
