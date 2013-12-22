package org.realityforge.gwt.performance_timeline.client;

public interface ResourceTiming
  extends PerformanceEntry
{
  enum InitiatorType
  {
    css, embed, img, link, object, script, subdocument, svg, xmlhttprequest, other
  }

  InitiatorType getInitiatorType();

  double getRedirectStart();

  double getRedirectEnd();

  double getFetchStart();

  double getDomainLookupStart();

  double getDomainLookupEnd();

  double getConnectStart();

  double getConnectEnd();

  double getSecureConnectStart();

  double getRequestStart();

  double getResponseStart();

  double getResponseEnd();
}
