package com.music.android.sensilence.features.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;

import com.music.android.sensilence.features.senseofsilence.SenseOfSilenceFragment;
import com.music.android.sensilence.features.zigmundafraid.ZigmundAfraidFragment;

import java.util.Arrays;

import io.github.turskyi.domain.entities.enums.Band;

/**
 * {@link MusicBandPageAdapter} is a {@link androidx.viewpager2.adapter.FragmentStateAdapter} that can provide the layout for
 * each list item based on a data source which is a list of { Song} objects.
 */
public class MusicBandPageAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {

    /**
     * Create a new {@link MusicBandPageAdapter} object.
     *
     * @param fragmentManager is the fragment manager that will keep each fragment's state in the adapter
     *                        across swipes.
     */
    public MusicBandPageAdapter(
            @NonNull FragmentManager fragmentManager,
            @NonNull Lifecycle lifecycle
    ) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == Arrays.asList(Band.values()).indexOf(Band.SENSE_OF_SILENCE)) {
            return new SenseOfSilenceFragment();
        } else {
            return new ZigmundAfraidFragment();
        }
    }

    /**
     * Returns the total number of pages.
     */
    @Override
    public int getItemCount() {
        return Band.values().length;
    }
}

