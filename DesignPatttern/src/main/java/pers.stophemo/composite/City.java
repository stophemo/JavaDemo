package pers.stophemo.composite;

/**
 * 叶子节点
 */
class City implements Counter {
    private int sum = 0;

    public City(int sum) {
        this.sum = sum;
    }

    @Override
    public int count() {
        return sum;
    }
}

