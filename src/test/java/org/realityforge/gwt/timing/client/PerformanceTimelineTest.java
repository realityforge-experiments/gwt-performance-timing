package org.realityforge.gwt.timing.client;

import java.util.ArrayList;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PerformanceTimelineTest
{
  @Test
  public void registryTest()
  {
    assertNull( PerformanceTimeline.get() );
    PerformanceTimeline.register( new TestPerformanceTimeline( new ArrayList<PerformanceEntry>() ) );
    assertNotNull( PerformanceTimeline.get() );
    final PerformanceTimeline timeline = PerformanceTimeline.get();
    assertTrue( PerformanceTimeline.deregister( timeline ) );
    assertNull( PerformanceTimeline.get() );
    assertFalse( PerformanceTimeline.deregister( timeline ) );
  }
}
