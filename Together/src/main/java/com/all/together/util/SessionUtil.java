package com.all.together.util;

import java.util.HashSet;
import java.util.Set;

public class SessionUtil {
   private static Set<String> _loggedUsers = new HashSet<String>();

   public static boolean loginUser(String username) {
      return _loggedUsers.add(username);
   }
   
   public static boolean logoutUser(String username) {
      return _loggedUsers.remove(username);
   }
}
