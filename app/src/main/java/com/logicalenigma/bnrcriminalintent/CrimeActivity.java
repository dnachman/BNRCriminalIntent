package com.logicalenigma.bnrcriminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.logicalenigma.bnrcriminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID crime_id) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crime_id);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }


}
