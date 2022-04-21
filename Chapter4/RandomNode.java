package Chapter4;

import java.util.*;

public class RandomNode {
    int data;
    int size;
    RandomNode left;
    RandomNode right;

    public RandomNode(int data) {
        this.data = data;
        this.size = 1;
    }

    public void insertNode(int d) {
        if (d <= data) {
            if (left == null)
                left = new RandomNode(d);
            else
                left.insertNode(d);
        } else {
            if (right == null)
                right = new RandomNode(d);
            else
                right.insertNode(d);
        }
        size++;
    }

    public RandomNode getRandomNode() {
        int randomValue = new Random().nextInt(size);
        int leftSize = left == null ? 0 : left.size;
        if (randomValue < leftSize) {
            return left.getRandomNode();
        } else if (randomValue == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public RandomNode find(int d) {
        if (d == this.data)
            return this;
        else if (d < this.data) {
            if (this.left == null)
                return null;
            else
                return this.left.find(d);
        } else {
            if (this.right == null)
                return null;
            else
                return this.right.find(d);
        }
    }

    public RandomNode remove(int d) {
        if (d == this.data)
            return this;
        else if (d < this.data) {
            if (this.left == null)
                return null;
            else
                return this.left.find(d);
        } else {
            if (this.right == null)
                return null;
            else
                return this.right.find(d);
        }
    }

}
