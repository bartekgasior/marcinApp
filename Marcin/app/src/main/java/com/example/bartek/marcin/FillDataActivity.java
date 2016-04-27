package com.example.bartek.marcin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bartek.marcin.listViewClasses.DataListAdapter;
import com.example.bartek.marcin.listViewClasses.TemplatesDataListProvider;

public class FillDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_data);

        Intent intent = getIntent();
        String[] templateRows = intent.getStringArrayExtra("templateRows");
        int rows = templateRows.length;

        ListView lvInsertData = (ListView) findViewById(R.id.lvInsertData);

        DataListAdapter adapter = new DataListAdapter(getApplicationContext(),R.layout.row_layout);
        lvInsertData.setAdapter(adapter);

        for(int i=0;i<rows;i++){
            TemplatesDataListProvider listProvider = new TemplatesDataListProvider(templateRows[i]+":","");
            adapter.add(listProvider);
        }

        lvInsertData.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
