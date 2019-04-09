package dev.manifest.note.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.manifest.note.R;
import dev.manifest.note.database.NoteEntity;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private final List<NoteEntity> notes;
    private final Context context;

    public NotesAdapter(List<NoteEntity> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.note_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final NoteEntity note = notes.get(i);
        viewHolder.textView.setText(note.getText());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.note_text)
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
