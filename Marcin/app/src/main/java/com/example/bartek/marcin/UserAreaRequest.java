package com.example.bartek.marcin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserAreaRequest extends StringRequest {
    private static final String USER_AREA_REQUEST_URL = "http://szzefu.webd.pl/app/templateData.php";
    private Map<String, String> params;

    public UserAreaRequest (String templateName, Response.Listener<String> listener){
        super(Method.POST, USER_AREA_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("templateName", templateName);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
