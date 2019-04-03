package com.sqisland.android.espresso.idling

import android.support.test.espresso.IdlingResource

class DialogFragmentIdlingResource(private val manager: android.support.v4.app.FragmentManager, private val tag: String): IdlingResource {
    override fun getName(): String {
        return DialogFragmentIdlingResource::class.java.name + ":" + tag
    }

    override fun isIdleNow(): Boolean {
        val idle = (manager.findFragmentByTag(tag) == null)
        if (idle)
            callback?.onTransitionToIdle()
        return idle
    }

    private var callback: IdlingResource.ResourceCallback? = null

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.callback = callback

    }

}