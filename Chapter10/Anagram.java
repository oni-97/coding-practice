package Chapter10;

import java.util.*;

public class Anagram {
    void sortAnagram(String[] strs) {
        HashMapList<String, String> hml = new HashMapList<String, String>();
        for (String s : strs) {
            String sort = sort(s);
            hml.put(sort, s);
        }

        int i = 0;
        for (String key : hml.keySet()) {
            ArrayList<String> list = hml.get(key);
            for (String s : list) {
                strs[i] = s;
                i++;
            }
        }
    }

    String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public class HashMapList<T, E> {
        private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

        /* Insert item into list at key. */
        public void put(T key, E item) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<E>());
            }
            map.get(key).add(item);
        }

        /* Insert list of items at key. */
        public void put(T key, ArrayList<E> items) {
            map.put(key, items);
        }

        /* Get list of items at key. */
        public ArrayList<E> get(T key) {
            return map.get(key);
        }

        /* Check if hashmaplist contains key. */
        public boolean containsKey(T key) {
            return map.containsKey(key);
        }

        /* Check if list at key contains value. */
        public boolean containsKeyValue(T key, E value) {
            ArrayList<E> list = get(key);
            if (list == null)
                return false;
            return list.contains(value);
        }

        /* Get the list of keys. */
        public Set<T> keySet() {
            return map.keySet();
        }

        @Override
        public String toString() {
            return map.toString();
        }
    }
}
