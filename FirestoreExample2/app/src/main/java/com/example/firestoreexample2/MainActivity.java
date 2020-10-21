package com.example.firestoreexample2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaDrm;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_TITLE = "Title";
    private static final String KEY_DESCRIPTION = "Description";


    private EditText editTextTitle;
    private EditText editTextDescription;
    private TextView textViewData;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference noteRef = db.document("Notebook/My first note");
    CollectionReference notebookRef = db.collection("Notebook");
    private ListenerRegistration listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        textViewData = findViewById(R.id.text_view_data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        notebookRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null)
                    return;
                String data = " ";

                for(QueryDocumentSnapshot documentSnapshots:queryDocumentSnapshots){
                    Note note = documentSnapshots.toObject(Note.class);

                    String title = note.getTitle();
                    String description = note.getDescription();

                    data += "Title : "+title+"\n"+"Description : "+description+"\n\n";
                }
                textViewData.setText(data);
            }
        });
    }



    public void addNote(View v){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();


        Note note = new Note(title,description);

        notebookRef.add(note);
    }

    public void loadNotes(View v){
        notebookRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = " ";

                        for(QueryDocumentSnapshot documentSnapshots:queryDocumentSnapshots){
                            Note note = documentSnapshots.toObject(Note.class);

                            String title = note.getTitle();
                            String description = note.getDescription();

                            data += "Title : "+title+"\n"+"Description : "+description+"\n\n";
                        }
                        textViewData.setText(data);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, e.toString());
                    }
                });
    }




}
