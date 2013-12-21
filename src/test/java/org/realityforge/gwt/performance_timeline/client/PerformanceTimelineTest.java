package org.realityforge.gwt.performance_timeline.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import java.util.ArrayList;
import org.mockito.Mockito;
import org.realityforge.gwt.performance_timeline.client.event.ResourceTimingBufferFullEvent;
import org.testng.annotations.Test;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

public class PerformanceTimelineTest
{
  @Test
  public void registryTest()
  {
    assertNull( PerformanceTimeline.get() );
    PerformanceTimeline.register( new TestPerformanceTimeline( new SimpleEventBus(),
                                                               new ArrayList<PerformanceEntry>() ) );
    assertNotNull( PerformanceTimeline.get() );
    final PerformanceTimeline timeline = PerformanceTimeline.get();
    assertTrue( PerformanceTimeline.deregister( timeline ) );
    assertNull( PerformanceTimeline.get() );
    assertFalse( PerformanceTimeline.deregister( timeline ) );
  }

  @Test
  public void handlerInteractions()
  {
    final TestPerformanceTimeline performanceTimeline =
      new TestPerformanceTimeline( new SimpleEventBus(), new ArrayList<PerformanceEntry>() );

    final ResourceTimingBufferFullEvent.Handler handler = mock( ResourceTimingBufferFullEvent.Handler.class );
    final HandlerRegistration registration = performanceTimeline.addResourceTimingBufferFull( handler );
    performanceTimeline.onResourceTimingBufferFullEvent();
    verify( handler, only() ).onResourceTimingBufferFullEvent( Mockito.<ResourceTimingBufferFullEvent>anyObject() );
    registration.removeHandler();
    performanceTimeline.onResourceTimingBufferFullEvent();
    verify( handler, atMost( 1 ) ).
      onResourceTimingBufferFullEvent( Mockito.<ResourceTimingBufferFullEvent>anyObject() );
  }
}
