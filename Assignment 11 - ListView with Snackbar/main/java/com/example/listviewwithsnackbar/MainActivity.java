package com.example.listviewwithsnackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    //String[] names = {"Jungkook", "J-Hope", "Jimin", "RM", "Suga", "Jin", "V", "Rap Monster" , "BTS"};

    ArrayList<String> names = new ArrayList<>();

    //ImageButton delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names.add("BTS");
        names.add("Jimin");
        names.add("J-Hope");
        names.add("Jungkook");
        names.add("Jin");
        names.add("Suga");
        names.add("V");
        names.add("Rap Monster");
        names.add("Kookie");
        names.add("BTS");
        names.add("Jimin");
        names.add("J-Hope");
        names.add("Jungkook");
        names.add("Jin");
        names.add("Suga");
        names.add("V");
        names.add("Rap Monster");
        names.add("Kookie");

        listView = (ListView) findViewById(R.id.listArea);

        MyAdapter listViewAdapter = new MyAdapter(this , R.layout.record , names);

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), names.get(position) , Toast.LENGTH_SHORT).show();

            }
        });




    }

    private class MyAdapter extends ArrayAdapter<String>{

        private int resource1;

        public MyAdapter(@NonNull Context context, int resource , List<String> names) {
            super(context, resource , names);
            resource1 = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder tempViewHolder = null;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.record , parent , false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.nm = (TextView) convertView.findViewById(R.id.nm);
                viewHolder.delete = (ImageButton) convertView.findViewById(R.id.delete);
                viewHolder.nm.setText(getItem(position));
                viewHolder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext() , getItem(position) + " " + position , Toast.LENGTH_SHORT).show();

                        Snackbar.make(listView , "Message is being deleted..." , Snackbar.LENGTH_LONG)
                                .setAction("UNDO", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Snackbar.make(listView , "Restored!" , Snackbar.LENGTH_SHORT).show();
                                    }
                                })
                                .show();

                    }
                });
                convertView.setTag(viewHolder);
            }
            else {
                tempViewHolder = (ViewHolder) convertView.getTag();
                //tempViewHolder.nm.setText(getItem(position));
            }

            return convertView;
        }

    }

    public class ViewHolder{

        TextView nm;
        ImageButton delete;

    }

}