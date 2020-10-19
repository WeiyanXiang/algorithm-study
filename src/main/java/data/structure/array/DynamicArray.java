package data.structure.array;

import java.util.Arrays;

/**
 * @author Weiyan Xiang on 2020/10/18
 * <p>
 * aka array list
 */
public class DynamicArray {

    private Object[] data;
    private int size;
    private int iniitalCapacity;

    public DynamicArray(int iniitalCapacity) {
        this.iniitalCapacity = iniitalCapacity;
        data = new Object[iniitalCapacity];
    }

    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException("out of bound");

        if (size == iniitalCapacity) {
            resize();
        }
        for (int j = size; j > index; j--) {
            data[j] = data[j - 1];
        }
        data[index] = value;
        size++;
    }

    public void delete(int index) {
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String value) {
        return Arrays.stream(data).filter(value::equals).findAny().isPresent();
    }

    private void resize() {
        Object[] resizedArray = new Object[iniitalCapacity * 2];
        for (int i = 0; i < iniitalCapacity; i++) {
            resizedArray[i] = data[i];
        }
        data = resizedArray;
        iniitalCapacity *= 2;
    }

    public int size() {
        return size;
    }

    public void add(String value) {
        if (size == iniitalCapacity) {
            resize();
        }
        data[size++] = value;
    }


}
