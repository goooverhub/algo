class BinaryIndexTree {
    private int[] bit;

    // bit should always start with index 1,
    // otherwise there is no way you can add 0's lowbit
    public BinaryIndexTree(int length) {
        bit = new int[length];
    }

    public void add(int index, int delta) {
        index++;
        while(index < bit.length) {
            bit[index] += delta;
            index += lowbit(index);
        }
    }

    public int sum(int index) {
        index++;
        int result = 0;
        while(index > 0) {
            result += bit[index];
            index -= lowbit(index);
        }
        return result;
    }

    private int lowbit(int index) {
        return (index) & (-index);
    }
}