package jp.co.hungtin.algorx.removeElement;

public class ArrayShrinkRemoveElement {
    public int removeElement(int[] elements, int removeVal) {
        int idx = 0;
        int length = elements.length;

        while(idx < length) {
            if (elements[idx] == removeVal) {
                elements[idx] = elements[length - 1];
                length--;
            } else {
                idx++;
            }
        }

        return length;
    }
}
