package com.reactnativecommunity.webview.events

import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

/**
 * Event emitted when onLoadResource is called
 */
class TopLoadingResourceEvent(viewId: Int, private val mData: WritableMap) : Event<TopLoadingResourceEvent>(viewId) {
  companion object {
    // TODO: Change EVENT_NAME (will likely need to tweak React-Native/TypeScript code to do this
    // const val EVENT_NAME = "topShouldStartLoadWithRequest"
    const val EVENT_NAME = "topLoadingResource"
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