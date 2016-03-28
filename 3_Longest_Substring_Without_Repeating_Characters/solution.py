class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        current_best = 0

        char_dict = dict()
        current_length = 0;
        for char_idx, character in enumerate(s):
            previous_idx = char_dict.get(character)

            # if we never seen this character before OR
            # if this character does not belongs to the current non repeating substring
            # i.e in between it's previous and current instances there are repeating chars
            # current_length = current length of substring without repeating characters
            if previous_idx is None or char_idx - current_length > previous_idx:
                ++current_length
            # When we need to conclude the current scan
            else:
                # update the longest substring length based on length
                # calculated before seening this repeating character
                if current_length > current_best:
                    current_best = current_length

                # new current length
                current_length = char_idx - previous_idx

            # update the latest index of the character
            char_dict[character] = char_idx

        if current_length > current_best:
            current_best = current_length

        return current_best


if __name__ == "__main__":
    the_string = 'abcabcbbabcdefg'
    print Solution().lengthOfLongestSubstring(the_string)
