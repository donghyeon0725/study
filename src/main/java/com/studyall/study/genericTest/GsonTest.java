package com.studyall.study.genericTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GsonTest {

    public static <T> T typeToken(T value, Class<T> clazz) {
        return clazz.cast(value);
    }

    public static void main(String[] args) {
        System.out.println(typeToken(10, Integer.class));
        System.out.println(typeToken("string", String.class));

        String json = "{\"username\" : \"wonwoo\", \"password\" : \"test\"}";
        Gson gson = new Gson();
        Account account = gson.fromJson(json, Account.class);
        System.out.println(account);


        String jsons = "[{\"username\" : \"wonwoo\", \"password\" : \"test\"},{\"username\" : \"seungwoo\", \"password\" : \"test1\"}]";
//        List<Account> accountList = gson.fromJson(jsons, List.class); // 에러
        List<Account> accountList = gson.fromJson(jsons, new AccountTypeToken().getType());
        System.out.println(accountList);
        System.out.println(accountList.get(0).getPassword());

        List<Account> newAccountList = gson.fromJson(jsons, new TypeToken<List<Account>>(){}.getType());
        System.out.println(newAccountList.get(0).getPassword());
    }
}
