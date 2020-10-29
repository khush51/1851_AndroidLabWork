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

        names.add("1801 Abhishek");
        names.add("1802 Adam");
        names.add("1803 Abigail");
        names.add("1804 Abigail");
        names.add("1805 Adele");
        names.add("1806 Bella");
        names.add("1807 Blair");
        names.add("1808 Briana");
        names.add("1809 Charley");
        names.add("1810 Charley");
        names.add("1811 Dana");
        names.add("1812 Daniella");
        names.add("1813 Elaine");
        names.add("1814 Elisa");
        names.add("1815 Grace");
        names.add("1816 Hanna");
        names.add("1817 Hannah");
        names.add("1818 Isabella");
        names.add("1819 Jasmine");
        names.add("1820 Julius");
        names.add("1821 Keith");
        names.add("1822 Larry");
        names.add("1823 Lee");
        names.add("1824 Marvin");
        names.add("1825 Porter");
        names.add("1826 Richard");
        names.add("1827 Rocky");
        names.add("1828 Stephen");

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
                        String temp = getItem(position);
                        names.remove(position);
                        listView.setAdapter(new MyAdapter(MainActivity.this , R.layout.record , names));

                        Snackbar.make(listView , "Message is being deleted..." , Snackbar.LENGTH_LONG)
                                .setAction("UNDO", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        names.add(position , temp);
                                        listView.setAdapter(new MyAdapter(MainActivity.this , R.layout.record , names));
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