package com.reactnativecommunity.webview.events

import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

/*
class TopLoadingResourceEvent(viewId: Int, private val mEventData: WritableMap) :
  Event<TopLoadingResourceEvent>(viewId) {
  companion object {
    const val EVENT_NAME = "topLoadingResource"
  }

  override fun getEventName(): String = EVENT_NAME

  override fun canCoalesce(): Boolean = false

  override fun getCoalescingKey(): Short = 0

  override fun dispatch(rctEventEmitter: RCTEventEmitter) =
    rctEventEmitter.receiveEvent(viewTag, eventName, mEventData)
}
*/


// NOTE: Above code does not work, let's try using some code that does work and just change the name...

/**
 * Event emitted when shouldOverrideUrlLoading is called
 */
class TopLoadingResourceEvent(viewId: Int, private val mData: WritableMap) : Event<TopShouldStartLoadWithRequestEvent>(viewId) {
  companion object {
    const val EVENT_NAME = "topShouldStartLoadWithRequest"
  }

  init {
    mData.putString("navigationType", "other")
    // Android does not raise shouldOverrideUrlLoading for inner frames
    mData.putBoolean("isTopFrame", true)
  }

  override fun getEventName(): String = EVENT_NAME

  override fun canCoalesce(): Boolean = false

  override fun getCoalescingKey(): Short = 0

  override fun dispatch(rctEventEmitter: RCTEventEmitter) =
    rctEventEmitter.receiveEvent(viewTag, EVENT_NAME, mData)
}