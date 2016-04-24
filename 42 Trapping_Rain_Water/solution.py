class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_height = 0;
        max_height_idx = 0;
        # find out maximum height of all bars
        for idx, h_val in enumerate(height):
            if h_val > max_height:
                max_height = h_val
                max_height_idx = idx
                
        trapped_water = 0;
        
        current_max_height = 0;
        # calculate trapped water
        for h_idx in xrange(0, max_height_idx):
            h = height[h_idx]
            if h > current_max_height:
                current_max_height = h
            trapped_water += current_max_height - h
        
        current_max_height = 0;
        # post max height
        for h_idx in xrange(len(height) - 1, max_height_idx, -1):
            h = height[h_idx]
            if h > current_max_height:
                current_max_height = h
            trapped_water += current_max_height - h
            
        return trapped_water
        