package com.codingwithmitch.daggermultifeature.app.di

import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import com.codingwithmitch.daggermultifeature.app.di.keys.FragmentKey
import com.codingwithmitch.daggermultifeature.app.ui.InjectingFragmentFactory
import com.codingwithmitch.daggermultifeature.app.ui.InjectingNavHostFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentFactoryModule{

    @Binds
    abstract fun bindFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(NavHostFragment::class)
    abstract fun bindInjectingNavHostFragment(navHost: InjectingNavHostFragment): NavHostFragment

}