package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String, List<String>> map;

    public PhoneBook(Map<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {
        map = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> numbers = new ArrayList<>();
        numbers.add(phoneNumber);
        map.put(name, numbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        List list = new ArrayList<String>();
        list.addAll(Arrays.asList(phoneNumbers));
        map.put(name, list);
            }


    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            if (entry.getValue().contains(name)){
                return true;
            }
        }

        return false;
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            if (entry.getValue().contains(phoneNumber)){
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List list = new ArrayList();
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            list.add(entry.getKey());
        }
        return list;
    }

    public Map<String, List<String>> getMap() {
        return map;
    }
}
