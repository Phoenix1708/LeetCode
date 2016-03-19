def solution(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """

    num_dict = dict()
    answer = []

    for idx, num in enumerate(nums):
        expect_num_two = target - num
        print 'expect_num_two: ' + str (expect_num_two)
        actual_num_two_idx = num_dict.get(expect_num_two)
        print 'actual_num_two_idx: ' + str (actual_num_two_idx)

        if actual_num_two_idx is None:
            num_dict[num] = idx
        else:
            answer.append(actual_num_two_idx)
            answer.append(idx)

    return answer

if __name__ == "__main__":
    print solution([2, 7, 11, 15], 9);
