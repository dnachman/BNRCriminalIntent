package com.logicalenigma.bnrcriminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.logicalenigma.bnrcriminalintent.Crime;
import com.logicalenigma.bnrcriminalintent.database.CrimeDbSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

/**
 * Copyright 2015 Logical Enigma
 * Created by dnachman on 9/5/15.
 */
public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));

        Crime c = new Crime(UUID.fromString(uuidString));
        c.setTitle(title);
        c.setDate(new Date(date));
        c.setSolved(isSolved != 0);
        c.setSuspect(suspect);

        return c;
    }
}
