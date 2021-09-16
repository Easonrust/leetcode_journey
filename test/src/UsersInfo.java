import java.util.ArrayList;

import java.util.*;

class UsersInfo {
 private class User {
  String name;
  String viewsCnt;
  String category;
 }

 public UsersInfo() {

 }

 private List<User> users;

 public UsersInfo(String[] infoStr) {
  users = new ArrayList<>();
  for (int i = 2; i < infoStr.length; i = i + 3) {
   User user = new User();
   user.name = infoStr[i - 2];
   user.viewsCnt = infoStr[i - 1];
   user.category = infoStr[i];
   users.add(user);
  }
 }

 private int getIdxofNameCategory(String name, String category) {
  for (User user : users) {
   if (user.name == name && user.category == category) {
    return users.indexOf(user);
   }
  }
  return -1;
 }

 private int getViewsInCategory(String category) {
  int cnt = 0;
  for (User user : users) {
   if (user.category == category) {
    cnt += Integer.parseInt(user.viewsCnt);
   }
  }
  return cnt;
 }

 private String getTopStreamersInCategory(String category) {
  int max = -1;
  String res = null;
  for (User user : users) {
   if (user.category == category) {
    if (Integer.parseInt(user.viewsCnt) > max) {
     res = user.name;
     max = Integer.parseInt(user.viewsCnt);
    }
   }
  }
  return res;
 }

 private String getTopStreamer() {
  int max = -1;
  String res = null;
  for (User user : users) {
   if (Integer.parseInt(user.viewsCnt) > max) {
    res = user.name;
    max = Integer.parseInt(user.viewsCnt);
   }
  }
  return res;
 }

 private String[] command(String[] commandStr) {
  List<String> resStrList = new ArrayList<>();
  String[] resStr;
  int i = 0;
  while (i < commandStr.length) {
   if (commandStr[i] == "StreamerOnline") {
    User user = new User();
    user.name = commandStr[i + 1];
    user.viewsCnt = commandStr[i + 2];
    user.category = commandStr[i + 3];
    users.add(user);
    i = i + 4;
   } else if (commandStr[i] == "UpdateViews") {
    User user = new User();
    user.name = commandStr[i + 1];
    user.viewsCnt = commandStr[i + 2];
    user.category = commandStr[i + 3];
    int idx = getIdxofNameCategory(user.name, user.category);
    if (idx != -1) {
     users.set(idx, user);
    }
    i = i + 4;
   } else if (commandStr[i] == "UpdateCategory") {
    String name = commandStr[i + 1];
    String categoryA = commandStr[i + 2];
    String categoryB = commandStr[i + 3];
    int idx = getIdxofNameCategory(name, categoryA);
    if (idx != -1) {
     User user = users.get(idx);
     user.category = categoryB;
     users.set(idx, user);
    }
    i = i + 4;
   } else if (commandStr[i] == "StreamerOffline") {
    String name = commandStr[i + 1];
    String category = commandStr[i + 2];
    int idx = getIdxofNameCategory(name, category);
    if (idx != -1) {
     users.remove(idx);
    }
    i = i + 3;
   } else if (commandStr[i] == " ViewsInCategory") {
    String category = commandStr[i + 1];
    int cnt = getViewsInCategory(category);
    resStrList.add(Integer.toString(cnt));
    i = i + 2;
   } else if (commandStr[i] == "TopStreamerInCategory") {
    String category = commandStr[i + 1];
    resStrList.add(getTopStreamersInCategory(category));
    i = i + 2;
   } else if (commandStr[i] == "TopStreamer") {
    i = i + 1;
    resStrList.add(getTopStreamer());
   }
  }

  int size = resStrList.size();
  resStr = (String[]) resStrList.toArray(new String[size]);

  return resStr;
 }
}
