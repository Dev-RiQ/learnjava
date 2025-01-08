package 콜랙션리스트;

class MyArrayList {
	int[] arr;
	int size;
	int capacity = 10;
	final int DEFUALT_CAPACITY = 10;

	MyArrayList() {
		arr = new int[capacity];
	}

	int size() {
		return size;
	}

	void add(int value) {
		arr[size++] = value;
		if (size == capacity) {
			capacity += DEFUALT_CAPACITY;
			int[] temp = arr;
			arr = new int[capacity];
			for(int i = 0 ; i < temp.length;i++)
				arr[i] = temp[i];
		}
	}

	void add(int idx, int value) {
		size++;
		if (size == capacity) {
			capacity += DEFUALT_CAPACITY;
			int[] temp = arr;
			arr = new int[capacity];
			for(int i = 0 ; i < temp.length;i++)
				arr[i] = temp[i];
		}
		int[] temp = arr;
		arr = new int[capacity];
		int k = 0;
		for (int i = 0; i < size; i++)
			if (i != idx)
				arr[i] = temp[k++];
		arr[idx] = value;
	}

	Integer get(int idx) {
		return arr[idx];
	}

	int remove(int idx) {
		int value = arr[idx];
		size--;
		for (int i = idx; i < size + 1; i++)
			arr[i] = arr[i+1];
		if (size % 10 == 0 && size != 0)
			capacity -= DEFUALT_CAPACITY;
		return value;
	}

	boolean remove(Integer value) {
		int idx = -1;
		for (int i = 0; i < size; i++)
			if (arr[i] == value)
				idx = i;
		if (idx == -1)
			return false;
		size--;
		for (int i = idx; i < size + 1; i++)
			arr[i] = arr[i+1];
		if (size % 10 == 0 && size != 0)
			capacity -= DEFUALT_CAPACITY;
		return true;
	}

	void set(int idx, int value) {
		arr[idx] = value;
	}

	String getToString() {
		String str = "[";
		if (size != 0) {
			for (int i = 0; i < size; i++)
				str += arr[i] + ", ";
			str = str.substring(0, str.length() - 2) + "]";
		} else
			str += "]";
		return str;
	}

	@Override
	public String toString() {
		return getToString();
	}
}

public class _03arrayList구현 {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50 };

		MyArrayList list = new MyArrayList();
		System.out.println(list);
		System.out.println(list.size());
		System.out.println();
		for (int value : arr)
			list.add(value);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
		System.out.println();
		System.out.println("=====");
		System.out.println(list.remove(0));
		System.out.println(list.remove(Integer.valueOf(20)));
		System.out.println("=====");
		list.add(0, 100);
//		list.add(10,100);
		System.out.println(list);
		list.set(1, 1000);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.capacity);
		for (int i = 0; i < 7; i++)
			list.add(i + 1);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.capacity);
		for (int i = 4; i > 0; i--)
			list.remove(i + 1);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.capacity);
	}

}
