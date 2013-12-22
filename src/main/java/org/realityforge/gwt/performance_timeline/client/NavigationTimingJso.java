package org.realityforge.gwt.performance_timeline.client;

public class NavigationTimingJso
  extends PerformanceEntryJso
  implements NavigationTiming
{
  protected NavigationTimingJso()
  {
  }

  @Override
  public final Type getType()
  {
    return Type.valueOf( getType0() );
  }

  private native String getType0()/*-{
    return this.type;
  }-*/;

  @Override
  public final native double getRedirectStart() /*-{
    return this.redirectStart;
  }-*/;


  @Override
  public final native double getRedirectEnd() /*-{
    return this.redirectEnd;
  }-*/;

  @Override
  public final native double getFetchStart() /*-{
    return this.fetchStart;
  }-*/;

  @Override
  public final native double getDomainLookupStart() /*-{
    return this.redirectStart;
  }-*/;

  @Override
  public final native double getDomainLookupEnd() /*-{
    return this.domainLookupEnd;
  }-*/;

  @Override
  public final native double getConnectStart() /*-{
    return this.connectStart;
  }-*/;

  @Override
  public final native double getConnectEnd() /*-{
    return this.connectEnd;
  }-*/;

  @Override
  public final native double getSecureConnectStart() /*-{
    return this.secureConnectStart;
  }-*/;

  @Override
  public final native double getRequestStart() /*-{
    return this.requestStart;
  }-*/;

  @Override
  public final native double getResponseStart() /*-{
    return this.responseStart;
  }-*/;

  @Override
  public final native double getResponseEnd() /*-{
    return this.responseEnd;
  }-*/;

  @Override
  public final native double getNavigationStart() /*-{
    return this.navigationStart;
  }-*/;

  @Override
  public final native double getUnloadEventStart() /*-{
    return this.unloadEventStart;
  }-*/;

  @Override
  public final native double getUnloadEventEnd() /*-{
    return this.unloadEventEnd;
  }-*/;

  @Override
  public final native double getLinkNegotiationStart() /*-{
    return this.linkNegotiationStart;
  }-*/;

  @Override
  public final native double getLinkNegotiationEnd() /*-{
    return this.linkNegotiationEnd;
  }-*/;

  @Override
  public final native double getDomLoading() /*-{
    return this.domLoading;
  }-*/;

  @Override
  public final native double getDomInteractive() /*-{
    return this.domInteractive;
  }-*/;

  @Override
  public final native double getDomContentLoadedEventStart() /*-{
    return this.domContentLoadedEventStart;
  }-*/;

  @Override
  public final native double getDomContentLoadedEventEnd() /*-{
    return this.domContentLoadedEventEnd;
  }-*/;

  @Override
  public final native double getDomComplete() /*-{
    return this.domComplete;
  }-*/;

  @Override
  public final native double getLoadEventStart() /*-{
    return this.loadEventStart;
  }-*/;

  @Override
  public final native double getLoadEventEnd() /*-{
    return this.loadEventEnd;
  }-*/;

  @Override
  public final native int getRedirectCount() /*-{
    return this.redirectCount;
  }-*/;
}
