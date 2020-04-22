import java.util.Random;

public class Eu2 {

	public static void sort(int[] nums) {
		int i = 0;
		
		while (i < nums.length) {
			int j = i + 1;
			while (j < nums.length) {
				if (nums[j] < nums[i]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
				assert nums[i] <= nums[j];
				j++;
			}
			i++;
		}
		
		boolean boo = false;
		for (int k = 1; k < nums.length; k++) {
			if (nums[0] < nums[k]) {
				boo = true;
			} else
				boo = false;
		}
		assert boo;
	}


	public static final Random rand = new Random();

	public static void main(String[] args) {
		int[] nums = new int[20];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(21);
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		sort(nums);
		System.out.println();

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}
