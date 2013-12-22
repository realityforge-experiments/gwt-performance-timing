package org.realityforge.gwt.performance_timeline.client;

/**
 * The interface defined by the first public draft of the Navigation Timing L2 specification.
 *
 * See <a href="http://www.w3.org/TR/navigation-timing-2/">Navigation Timing L2</a> for further details.
 *
 * This is currently supported in IE11.
 */
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
