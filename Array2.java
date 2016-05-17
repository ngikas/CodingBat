public class Array2 {

    /*
     *  FIZZ BUZZ
     */
    static String[] fizzBuzz(int start, int end) {
        String[] array = new String[end - start];
        for (int i = 0; i < array.length; i++) {
            if (start % 3 == 0 && start % 5 == 0) {
                array[i] = "FizzBuzz";
            } else if (start % 5 == 0) {
                array[i] = "Buzz";
            } else if (start % 3 == 0) {
                array[i] = "Fizz";
            } else {
                array[i] = String.valueOf(start);
            }
            start++;
        }
        return array;

    }


    /*
     *  WITHOUT TEN
     */
    static int[] withoutTen(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 10) {
                count++;
            }
        }

        int index = 0;
        int numsIndex = 0;
        int[] array = new int[nums.length];
        while (numsIndex < array.length) {
            if (nums[numsIndex] != 10) {
                array[index] = nums[numsIndex];
                index++;
            }
            numsIndex++;
        }
        

        return array;
    }

    /*  
     *  ZERO FRONT
     */
    static int[] zeroFront(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }

        //get count, then swap zeroes with non-zero values till count is reached
        int index = 0;
        int[] array = new int[nums.length];
        while (index < count) {
            array[index] = 0;
            index++;
        }

        int numsIndex = 0;
        while (numsIndex < array.length) {
            if (nums[numsIndex] != 0) {
                array[index] = nums[numsIndex];
                index++;
            }
            numsIndex++;
        }

        return nums;

    }

    /*
     *  NOT ALONE
     */
    static int[] notAlone(int[] nums, int val) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == val && nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                nums[i] = Math.max(nums[i-1], nums[i+1]);
            }
        }
        return nums;
    }

    /*
     *  POST4
     */
    static int[] post4(int[] nums) {
        int count = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                start = i; //finds the last 4
            }
        }

        start++;
        int arrayLength = nums.length-start;
        int[] array = new int[arrayLength];
        int index = 0;

        while (start < nums.length) {
            array[index] = nums[start];
            start++;
            index++;
        }
        return array;
    }

    /*
     *  PRE4
     */
    static int[] pre4(int[] nums) {
        int arrayLength = 0;
        for (int i = 0; i < nums.length; i++) {
            //find first 4
            if (nums[i] == 4) {
                arrayLength = i;
                break;
            }
        }
        int[] array = new int[arrayLength];
        for (int j = 0; j < arrayLength; j++) {
            array[j] = nums[j];
        }
        
        return array;
    }

    /*
     *  TEN RUN
     */
    static int[] tenRun(int[] nums) {
        boolean isMultipleOf10 = false;
        int multiple = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) {
                isMultipleOf10 = true;
                multiple = nums[i];
            }

            if (isMultipleOf10) {
                nums[i] = multiple;
            }

        }
        return nums;
    }

    /*
     *  SHIFT LEFT
     */
    static int[] shiftLeft(int[] nums) {
        if (nums.length < 2) return nums;
        //get first value to insert at the end
        int first = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = first;
        
        return nums;
    }

    /*
     *  FIZZ ARRAY 3
     */
    static int[] fizzArray3(int start, int end) {
        int[] array = new int[end-start];
        for (int i = 0; i < array.length; i++) {
            array[i] = start;
            start++;
        }
        return array;
    }

    /*
     *  TRIPLE UP
     */
    static boolean tripleUp(int[] nums) {
        boolean isTriple = false;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i+2] - nums[i+1] == 1 && nums[i+1] - nums[i] == 1) {
                isTriple = true;
            }
        }
        return isTriple;
    }

    /*
     *  SAME ENDS 
     */
    static boolean sameEnds(int[] nums, int len) {
        if (len == 0) return true;
        if (len > nums.length) return false;
        int count = 0;
        int index = 0;
        //depending on len go to those indices less than the len
        while (index < len && count < len) {
            if (nums[index] == nums[nums.length-len+index]) {
                count++;
                System.out.println(count);   
            }
            index++;
        }
        return count == len;
    }
}
