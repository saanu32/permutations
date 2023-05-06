import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            for (int num : nums) {
                if (!current.contains(num)) {
                    current.add(num);
                    backtrack(nums, current, result);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(nums);

        System.out.println("Permutations:");
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
//        Time complexity: O(n * n!)
//        Space complexity: O(n * n!)