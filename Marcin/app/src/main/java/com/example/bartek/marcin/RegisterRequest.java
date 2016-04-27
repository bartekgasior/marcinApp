package com.example.bartek.marcin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://szzefu.webd.pl/app/Register.php";
    private Map<String, String> params;

    public RegisterRequest (String name, String surname, String username, String email, int phone, String password, String repassword, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("surname", surname);
        params.put("username", username);
        params.put("email", email);
        params.put("phone", phone + "");
        params.put("password", password);
        params.put("rePassword", repassword);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
