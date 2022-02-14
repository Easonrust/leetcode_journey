class SnapshotArray {
    TreeMap<Integer, Integer>[] mapArr;
    int id;

    public SnapshotArray(int length) {
        id = 0;
        mapArr = new TreeMap[length];
        for (int i = 0; i < length; ++i) {
            mapArr[i] = new TreeMap<>();
            mapArr[i].put(id, 0);
        }
    }

    public void set(int index, int val) {
        mapArr[index].put(id, val);
    }

    public int snap() {
        return id++;
    }

    public int get(int index, int snap_id) {
        return mapArr[index].get(mapArr[index].floorKey(snap_id));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

// 使用treeMap的floorKey(id), 返回小于等于id的最大id
