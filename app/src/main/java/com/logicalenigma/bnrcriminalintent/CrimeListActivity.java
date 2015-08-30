package com.logicalenigma.bnrcriminalintent;

import android.support.v4.app.Fragment;

/**
 * Activity to control the crime listing
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
