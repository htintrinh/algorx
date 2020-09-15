package jp.co.hungtin.algorx.removeElement;

public class SlowFastPointerRemoveElement {
    public int removeElement(int[] elements, int removeVal) {
        int slowIdx = 0;
        for(int fastIdx = 0; fastIdx < elements.length; fastIdx++) {
            if (elements[fastIdx] != removeVal) {
                elements[slowIdx] = elements[fastIdx];
                slowIdx++;
            }
        }

        return slowIdx;
    }
}
