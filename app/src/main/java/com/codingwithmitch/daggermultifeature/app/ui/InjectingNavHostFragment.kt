package com.codingwithmitch.daggermultifeature.app.ui

import android.content.Context
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.BaseApplication
import javax.inject.Inject

/**
 * From: https://github.com/zawadz88/NavigationComponentPlayground/blob/master/app/src/main/java/com/github/zawadz88/navigationcomponentplayground/di/factory/InjectingFragmentFactory.kt
 */
class InjectingNavHostFragment
@Inject
constructor() : NavHostFragment() {

    @Inject
    protected lateinit var daggerFragmentInjectionFactory: InjectingFragmentFactory

    override fun onAttach(context: Context) {
        ((activity?.application) as BaseApplication)
            .getAppComponent()
            .homeComponent()
            .create()
            .inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        childFragmentManager.fragmentFactory = daggerFragmentInjectionFactory
        super.onCreate(savedInstanceState)
    }
}