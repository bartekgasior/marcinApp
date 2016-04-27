package com.example.bartek.marcin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        Intent intent = getIntent();
        String[] templates = intent.getStringArrayExtra("templates");

        ListView lvTemplates = (ListView) findViewById(R.id.lvTemplates);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, templates);
        lvTemplates.setAdapter(adapter);

        lvTemplates.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String templateName = (String) parent.getItemAtPosition(position);

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            JSONArray jsonArray = jsonResponse.getJSONArray("templateRows");

                            String[] templateRows = new String[jsonArray.length()];
                           // int rows = jsonArray.length();
                            for (int i=0;i<jsonArray.length();i++){
                                try {
                                    templateRows[i]=jsonArray.getString(i);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            Intent intent = new Intent(UserAreaActivity.this, FillDataActivity.class);

                            intent.putExtra("templateRows",templateRows);
                            //intent.putExtra("rows",rows);
                            UserAreaActivity.this.startActivity(intent);

                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                UserAreaRequest userAreaRequest = new UserAreaRequest(templateName, responseListener);
                RequestQueue requestQueue = Volley.newRequestQueue(UserAreaActivity.this);
                requestQueue.add(userAreaRequest);
            }
        });
    };

    public void exit(View v){
        finish();
    }
}
