package ru.mtplab.notes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    private ListView lvNotes;
    private ArrayAdapter<String> adapter;
    private final Context context = this;

    final String[] catnames = new String[] { "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
            "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };

    private ArrayList<String> list = new ArrayList<String>(Arrays.asList(catnames));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNotes = (ListView) findViewById(R.id.lvNotes);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        lvNotes.setAdapter(adapter);

        lvNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, EditNotes.class);
                context.startActivity(intent);
            }
        });

        lvNotes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final String selectedItem = parent.getItemAtPosition(position).toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Вы хотите удалить " + selectedItem + "?");
                builder.setCancelable(false);
                builder.setPositiveButton("Да",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.remove(selectedItem);
                                adapter.notifyDataSetChanged();

                                Toast.makeText(getApplicationContext(),
                                        selectedItem + " удален."   ,
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                builder.show();
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.menu_add_item) {
            adapter.add("Тестируем добавление");
            adapter.notifyDataSetChanged();
            return true;
        }

        if (id ==R.id.menu_clear_items) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Вы хотите удалить ВСЕ заметки?");
            builder.setCancelable(false);
            builder.setPositiveButton("Да",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            adapter.clear();
                            adapter.notifyDataSetChanged();
                            Toast.makeText(getApplicationContext(),
                                    "Все заметки удалены",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
            builder.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
