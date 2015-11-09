package mr.lmd.personal.sqlitemodule;

import android.app.Application;
import android.database.Cursor;
import android.test.ApplicationTestCase;
import android.util.Log;

import mr.lmd.personal.sqlitemodule.SqliteABC.DBHelper;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    public void testInsert() {
        DBHelper mDBHelp = new DBHelper(getContext());
        mDBHelp.insert("title");
        testSelect();
    }

    public void testDelete() {
        DBHelper mDBHelp = new DBHelper(getContext());
        mDBHelp.delete(1);
        testSelect();
    }

    public void testUpdate() {
        DBHelper mDBHelp = new DBHelper(getContext());
        mDBHelp.update(2, "changedTitle");
        testSelect();
    }

    public void testSelect() {
        DBHelper mDBHelp = new DBHelper(getContext());
        Cursor mCursor = mDBHelp.select();
        while (mCursor.moveToNext()) {
            String id = mCursor.getString(mCursor.getColumnIndex(DBHelper.FIELD_ID));
            String title = mCursor.getString(mCursor.getColumnIndex(DBHelper.FIELD_TITLE));
            Log.d("ELSeed", "id = " + id + " , title = " + title);
        }
    }
}