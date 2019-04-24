package com.example.unidirectionalstateflow.di;

import com.example.unidirectionalstateflow.ui.modules.clans.ClanListFragment;
import com.example.unidirectionalstateflow.ui.modules.dashboard.DashboardFragment;
import com.example.unidirectionalstateflow.ui.modules.settings.SettingsFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ClanListFragment contributeClanListFragment();

    @ContributesAndroidInjector
    abstract DashboardFragment contributeDashboardFragment();

    @ContributesAndroidInjector
    abstract SettingsFragment contributeSettingsFragment();
}
