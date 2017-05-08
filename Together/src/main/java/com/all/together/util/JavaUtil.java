package com.all.together.util;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JavaUtil {

   private static Gson _gson = new Gson();

   public static HashMap<String, String> dissasambleJson(String json) {
      Type type = new TypeToken<HashMap<String, String>>() {
      }.getType();
      HashMap<String, String> data = _gson.fromJson(json, type);
      return data;
   }
}
