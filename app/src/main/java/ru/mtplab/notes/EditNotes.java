package ru.mtplab.notes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditNotes extends ActionBarActivity {

    private EditText editNoteTitle;
    private Button noteSaveButton;
    private Intent intent;
    private int noteId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);

        editNoteTitle = (EditText) findViewById(R.id.editNoteTitle);
        String nodeTitle;
        intent = this.getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        if ( ( nodeTitle = intent.getStringExtra("noteTitle")) != null ) {
            editNoteTitle.setText(nodeTitle);
        }
        noteSaveButton = (Button) findViewById(R.id.noteSaveButton);

        noteSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("noteTitle", editNoteTitle.getText().toString());
                if (noteId != -1) {
                    intent.putExtra("noteId", noteId);
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
