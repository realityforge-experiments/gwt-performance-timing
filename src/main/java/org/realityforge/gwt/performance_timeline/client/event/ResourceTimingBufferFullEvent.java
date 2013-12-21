package org.realityforge.gwt.performance_timeline.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import javax.annotation.Nonnull;
import org.realityforge.gwt.performance_timeline.client.event.ResourceTimingBufferFullEvent.Handler;

public class ResourceTimingBufferFullEvent
  extends GwtEvent<Handler>
{
  public interface Handler
    extends EventHandler
  {
    void onResourceTimingBufferFullEvent( @Nonnull ResourceTimingBufferFullEvent event );
  }

  private static final GwtEvent.Type<Handler> TYPE = new Type<Handler>();

  public static GwtEvent.Type<Handler> getType()
  {
    return TYPE;
  }

  @Override
  public GwtEvent.Type<Handler> getAssociatedType()
  {
    return ResourceTimingBufferFullEvent.getType();
  }

  @Override
  protected void dispatch( @Nonnull final Handler handler )
  {
    handler.onResourceTimingBufferFullEvent( this );
  }
}
