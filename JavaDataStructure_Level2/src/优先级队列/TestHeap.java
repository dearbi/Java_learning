package 优先级队列;

public class TestHeap {
    public int[] array;
    public int uesdSize;

    public TestHeap() {
        this.array = new int[4];
    }

    public void intitArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
            this.uesdSize++;
        }
    }

    public static void createHeap(int[] array) {
// 找倒数第⼀个⾮叶⼦节点，从该节点位置开始往前⼀直到根节点，遇到⼀个节点，应⽤向下调整
        int root = ((array.length - 2) >> 1);
        for (; root >= 0; root--) {
            shiftDown(array, root);
        }
    }


    private static void shiftDown(int[] array, int parent) {
        // child先标记parent的左孩⼦，因为parent可能右左没有右
        int child = 2 * parent + 1;
        int size = array.length;
        while (child < size) {
            // 如果右孩⼦存在，找到左右孩⼦中较⼩的孩⼦,⽤child进⾏标记
            if (child + 1 < size && array[child + 1] < array[child]) {
                child += 1;
            }
            // 如果双亲⽐其最⼩的孩⼦还⼩，说明该结构已经满⾜堆的特性了
            if (array[parent] <= array[child]) {
                break;
            } else {
                // 将双亲与较⼩的孩⼦交换
                int t = array[parent];
                array[parent] = array[child];
                array[child] = t;
                // parent中⼤的元素往下移动，可能会造成⼦树不满⾜堆的性质，因此需要继续向下调整
                parent = child;
                child = parent * 2 + 1;
            }
        }
    }

    public void shiftUp(int child) {
        // 找到child的双亲
        int parent = (child - 1) / 2;
        while (child > 0) {
// 如果双亲⽐孩⼦⼤，parent满⾜堆的性质，调整结束
            if (array[parent] > array[child]) {
                break;
            } else {
// 将双亲与孩⼦节点进⾏交换
                int t = array[parent];
                array[parent] = array[child];
                array[child] = t;
// ⼩的元素向下移动，可能到值⼦树不满⾜对的性质，因此需要继续向上调增
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }
}
