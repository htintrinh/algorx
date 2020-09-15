package jp.co.hungtin.algorx.removeElement;

public class RemoveElement {
    public int removeElement(int[] elements, int removeVal) {
        if (elements == null || elements.length == 0) {
            return 0;
        }

        int firstMetRemoveIdx = 0;
        int lastNotRemoveIdx = elements.length - 1;

        while (firstMetRemoveIdx <= elements.length - 1 && elements[firstMetRemoveIdx] != removeVal) firstMetRemoveIdx++;
        while (lastNotRemoveIdx >= 0 && elements[lastNotRemoveIdx] == removeVal) lastNotRemoveIdx--;

        while (firstMetRemoveIdx < lastNotRemoveIdx) {
            swapArray(elements, lastNotRemoveIdx, firstMetRemoveIdx);
            while (firstMetRemoveIdx <= elements.length - 1 && elements[firstMetRemoveIdx] != removeVal) firstMetRemoveIdx++;
            while (lastNotRemoveIdx >= 0 && elements[lastNotRemoveIdx] == removeVal) lastNotRemoveIdx--;
        }

        return firstMetRemoveIdx;
    }

    public void swapArray(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }
}
