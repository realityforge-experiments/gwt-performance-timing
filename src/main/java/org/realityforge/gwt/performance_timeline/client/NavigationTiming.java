package org.realityforge.gwt.performance_timeline.client;

public interface NavigationTiming
  extends PerformanceEntry
{
  enum Type
  {
    navigate, reload, back_forward
  }

  Type getType();

  double getNavigationStart();

  double getUnloadEventStart();

  double getUnloadEventEnd();

  double getLinkNegotiationStart();

  double getLinkNegotiationEnd();

  double getRedirectStart();

  double getRedirectEnd();

  double getFetchStart();

  double getDomainLookupStart();

  double getDomainLookupEnd();

  double getConnectStart();

  double getSecureConnectStart();

  double getConnectEnd();

  double getRequestStart();

  double getResponseStart();

  double getResponseEnd();

  double getDomLoading();

  double getDomInteractive();

  double getDomContentLoadedEventStart();

  double getDomContentLoadedEventEnd();

  double getDomComplete();

  double getLoadEventStart();

  double getLoadEventEnd();

  int getRedirectCount();
}
