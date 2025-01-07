package 콜랙션리스트;

class MyArrayList {
	int[] arr;
	int size;
	int capacity = 10;

	int size() {
		if (arr != null)
			size = arr.length;
		return size;
	}

	void add(int value) {
		if (arr == null)
			arr = new int[1];
		else {
			int[] temp = arr;
			arr = new int[size + 1];
			for (int i = 0; i < size; i++)
				arr[i] = temp[i];
		}
		arr[size++] = value;
		if (size % 10 == 1 && size != 1)
			capacity += 10;
	}

	void add(int idx, int value) {
		if (arr == null)
			arr = new int[1];
		else {
			int[] temp = arr;
			arr = new int[size + 1];
			int k = 0;
			for (int i = 0; i < size + 1; i++)
				if (i != idx)
					arr[i] = temp[k++];
		}
		arr[idx] = value;
		size++;
		if (size % 10 == 1 && size != 1)
			capacity += 10;
	}

	Integer get(int idx) {
		return arr[idx];
	}

	int remove(int idx) {
		int value = arr[idx];
		int[] temp = arr;
		arr = new int[--size];
		for (int i = idx; i < size; i++)
			temp[i] = temp[i + 1];
		for (int i = 0; i < size; i++)
			arr[i] = temp[i];
		if (size % 10 == 0 && size != 0)
			capacity -= 10;
		return value;
	}

	boolean remove(Integer value) {
		int[] temp = arr;
		int idx = -1;
		for (int i = 0; i < size; i++)
			if (temp[i] == value)
				idx = i;
		if (idx == -1)
			return false;
		arr = new int[--size];
		for (int i = idx; i < size; i++)
			temp[i] = temp[i + 1];
		for (int i = 0; i < size; i++)
			arr[i] = temp[i];
		if (size % 10 == 0 && size != 0)
			capacity -= 10;
		return true;
	}

	void set(int idx, int value) {
		arr[idx] = value;
	}

	String getToString() {
		String str = "[";
		if (arr != null) {
			for (int i = 0; i < arr.length; i++)
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
