package com.example.giftter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListActivity extends AppCompatActivity {
    String[] sp;
    String[] li;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        sp=getIntent().getStringArrayExtra("Sp");
        li=getIntent().getStringArrayExtra("Li");
        listView=(ListView)findViewById(R.id.listview);
        ListAdapter adapter=new ListAdapter();

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos=position;
                Uri uri=Uri.parse(li[pos]);
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

    }
    public class ListAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return sp.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }
        public View getView(int position, View view, ViewGroup parent) {
            // TODO Auto-generated method stub
            LayoutInflater inflater = getLayoutInflater();
            view = inflater.inflate(R.layout.list_adapter, parent, false);
            TextView itemName=(TextView)view.findViewById(R.id.itemName);
            itemName.setText(sp[position]);
            Animation animation = null;
            animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wave);
            animation.setDuration(200);
            view.startAnimation(animation);
            animation = null;
            return view;
        }
    }

}