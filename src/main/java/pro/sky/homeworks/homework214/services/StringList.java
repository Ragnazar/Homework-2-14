package pro.sky.homeworks.homework214.services;

public interface StringList {
    String add(String item);

    String add(int index, String item);

    String set(int index, String item);

    String remove(String item);

    String remove(int index);

    boolean contains(String item);

    int indexOf(String item);

    int lastIndexOf(String item);

    String get(int index);

    boolean equals(String[] otherList);

    int size();

    boolean isEmpty();

    String[] toArray();


    void clear();
}
