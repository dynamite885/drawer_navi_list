package com.songjh.drawernavilist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    listAdapter adapter;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.navigation);
        drawerLayout.closeDrawers();

        ArrayList<ListViewItem> list = new ArrayList<>();

        list.add(new ListViewItem(R.mipmap.ic_launcher_round, "1번", "설명설명"));
        list.add(new ListViewItem(R.mipmap.ic_launcher_round, "2번", "ㅁㄴㅇㄹ"));
        list.add(new ListViewItem(R.mipmap.ic_launcher_round, "3번", "3번항목"));
        list.add(new ListViewItem(R.mipmap.ic_launcher_round, "4번", "가나다라"));
        list.add(new ListViewItem(R.mipmap.ic_launcher_round, "5번", "asdf"));

        listView = findViewById(R.id.listview1);
        adapter = new listAdapter(list);

        listView.setAdapter(adapter);
    }

    class listAdapter extends BaseAdapter {
        List<ListViewItem> lists;

        public listAdapter(List<ListViewItem> lists) {
            this.lists = lists;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View v = view;
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.listview_item, null);
            }

            TextView tvTitle = v.findViewById(R.id.tv1);
            TextView tvDesc = v.findViewById(R.id.tv2);

            ListViewItem listViewItem = lists.get(position);
            tvTitle.setText(listViewItem.getTitle());
            tvDesc.setText(listViewItem.getDesc());

            return v;
        }
    }

    public void onclick(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}