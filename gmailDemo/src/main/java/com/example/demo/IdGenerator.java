package com.example.demo;
import java.util.HashSet;
import java.util.Set;

public class IdGenerator {

    private static int nextId = 1;
    private static Set<Integer> deletedIds = new HashSet<>();

    public static int generateId() {
        if (!deletedIds.isEmpty()) {
            int reusedId = deletedIds.iterator().next();
            deletedIds.remove(reusedId);
            return reusedId;
        } else {
            return nextId++;
        }
    }

    public static void deleteId(int id) {
        deletedIds.add(id);
    }
}

