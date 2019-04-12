package dev.manifest.note.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import dev.manifest.note.database.NoteEntity;
import dev.manifest.note.util.SampleData;

public class MainViewModel extends AndroidViewModel {

    private List<NoteEntity> notes = SampleData.getNotes();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public List<NoteEntity> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteEntity> notes) {
        this.notes = notes;
    }
}
