function solution(nums) {

    const max = nums.length/2;
    const arr = [...new Set(nums)];
    
    const arrSize = arr.length;
    
    return max > arrSize ? arrSize : max;
}