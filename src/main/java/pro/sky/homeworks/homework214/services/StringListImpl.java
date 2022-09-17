package pro.sky.homeworks.homework214.services;

import org.springframework.stereotype.Service;
import pro.sky.homeworks.homework214.excaptions.ElementAlreadyExistsException;
import pro.sky.homeworks.homework214.excaptions.ElementNotFoundException;
import pro.sky.homeworks.homework214.excaptions.NullParameterException;
import pro.sky.homeworks.homework214.excaptions.OutOfBoundsExceptions;

import java.util.Arrays;
import java.util.Objects;

@Service
public class StringListImpl implements StringList {

    private String[] list = new String[1];

    @Override
    public String add(String item) {
        int length = list.length;
        String[] result;
        if (list[0] == null) {
            result = new String[length];
            result[length - 1] = item;
        } else {
            result = new String[length + 1];
            System.arraycopy(list, 0, result, 0, length);
            result[length] = item;
        }
        list = result;
        return list[length - 1];
    }

    @Override
    public String add(int index, String item) {
        int length = list.length;
        if (index >= length || index < 0) {
            throw new OutOfBoundsExceptions("Индекс выходит за пределы фактического количества элементов массива");
        } else if (list[index] != null) {
            throw new ElementAlreadyExistsException("Элемент уже существует");
        }
        list[index] = item;
        return list[index];
    }

    @Override
    public String set(int index, String item) {
        int length = list.length;
        if (index >= length || index < 0) {
            throw new OutOfBoundsExceptions("Индекс выходит за пределы фактического количества элементов массива");
        }
        list[index] = item;
        return list[index];
    }

    @Override
    public String remove(String item) {
        int length = list.length;
        String[] result = new String[length - 1];
        for (int i = 0; i < length; i++) {
            if (Objects.equals(list[i], item)) {
                list[i] = null;
            } else if (i == list.length - 1) {
                throw new ElementNotFoundException("Элемент отсутсвует");
            }
            if (list[i] != null) {
                result[i] = list[i];
            }
        }
        list = result;
        return item;
    }

    @Override
    public String remove(int index) {
        int length = list.length;
        String[] result = new String[length - 1];
        if (index > length || list[0] == null) {
            throw new ElementNotFoundException("Элемент отсутсвует");
        }
        String out = null;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                out = list[i];
                list[i] = null;
            }
            if (list[i] != null) {
                result[i] = list[i];
            }
        }
        list = result;
        return out;
    }

    @Override
    public boolean contains(String item) {
        for (String s : list) {
            if (Objects.equals(item, s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < list.length; i++) {
            if (Objects.equals(item, list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (Objects.equals(item, list[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (list.length <= index) {
            throw new OutOfBoundsExceptions("Индекс выходит за пределы фактического количества элементов массива");
        }
        return list[index];
    }

    @Override
    public boolean equals(String[] otherList) {
        boolean isEqual = false;
        if (otherList == null) {
            throw new NullParameterException("Параметр не определен");
        }
        for (int i = 0; i < list.length; i++) {
            if (Objects.equals(list[i], otherList[i])) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isEmpty() {
        return list[0] == null;
    }

    @Override
    public String[] toArray() {
        return (String[]) Arrays.stream(list).toArray();

    }

    @Override
    public void clear() {
        Arrays.fill(list, null);
    }
}

