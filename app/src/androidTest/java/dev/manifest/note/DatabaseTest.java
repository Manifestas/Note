package dev.manifest.note;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import dev.manifest.note.database.AppDatabase;
import dev.manifest.note.database.NoteDao;
import dev.manifest.note.database.NoteEntity;
import dev.manifest.note.util.SampleData;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private static final String TAG = "Junit";

    private AppDatabase db;
    private NoteDao noteDao;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        noteDao = db.noteDao();
        Log.i(TAG, "createDb");
    }

    @After
    public void closeDb() {
        db.close();
        Log.i(TAG, "closeDb");
    }

    @Test
    public void createAndRetrieveNotes() {
        noteDao.insertAll(SampleData.getNotes());
        int count = noteDao.getCount();
        Log.i(TAG, "createAndRetrieveNotes: count = " + count);
        assertEquals(SampleData.getNotes().size(), count);
    }

    @Test
    public void compareStrings() {
        noteDao.insertAll(SampleData.getNotes());
        NoteEntity original = SampleData.getNotes().get(0);
        NoteEntity noteFromDb = noteDao.getNoteById(1);
        assertEquals(original.getText(), noteFromDb.getText());
        assertEquals(1, noteFromDb.getId());
    }
}
