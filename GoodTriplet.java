import java.util.HashMap;
import java.util.HashSet;

class GoodTriplet {
    private static HashMap<Integer, Integer> getNumberPositionMap(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
        }
        return map;
    }

    public static long goodTriplets(int[] nums1, int[] nums2) {
        // Initialize variables
        HashMap<Integer, Integer> map = getNumberPositionMap(nums2);
        int n = nums1.length;
        long ans = 0;

        // Loop through the arrays
        for (int i = 1; i < n - 1; i++) {
            int nums1_mid_ele_pos = i;
            int nums2_mid_ele_pos = map.get(nums1[i]);
            HashSet<Integer> hashset_left = new HashSet<>();
            HashSet<Integer> hashset_right = new HashSet<>();

            // Check if the middle element is within bounds
            if (0 < nums2_mid_ele_pos && nums2_mid_ele_pos < n - 1) {
                int indx = nums1_mid_ele_pos - 1;
                while (indx >= 0) {
                    hashset_left.add(nums1[indx]);
                    indx--;
                }
                indx = nums1_mid_ele_pos + 1;
                while (indx < n) {
                    hashset_right.add(nums1[indx]);
                    indx++;
                }

                // Traverse through nums2 and count common elements from mid
                int common_count_left = 0;
                int common_count_right = 0;
                indx = nums2_mid_ele_pos - 1;
                while (indx >= 0) {
                    if (hashset_left.contains(nums2[indx])) {
                        common_count_left++;
                    }
                    indx--;
                }
                indx = nums2_mid_ele_pos + 1;
                while (indx < n) {
                    if (hashset_right.contains(nums2[indx])) {
                        common_count_right++;
                    }
                    indx++;
                }

                ans += (common_count_right * common_count_left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 0, 1, 3, 2 };
        int[] nums2 = { 4, 1, 0, 2, 3 };
        System.out.println(GoodTriplet.goodTriplets(nums1, nums2));
    }
}
