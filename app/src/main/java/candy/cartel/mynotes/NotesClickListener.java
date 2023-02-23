package candy.cartel.mynotes;

import androidx.cardview.widget.CardView;

import candy.cartel.mynotes.Models.Notes;

public interface NotesClickListener {
    void onClick (Notes notes);
    void onLongClick (Notes notes, CardView cardView);
}