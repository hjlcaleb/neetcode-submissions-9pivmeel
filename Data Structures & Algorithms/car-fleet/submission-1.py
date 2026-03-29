class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        
        # e.g., 5 cars -> 5 fleets
        # start with car closest to target - sorting
        # see how fast all the preceding cars are going

        # if the preceding cars could get to the target
        # before the car closes to the target - i.e., faster time
        # then they form a fleet

        pair = [[p, s] for p, s in zip(position, speed)]
        stack = []

        for p, s in sorted(pair)[::-1]: #Reverse Sorted Order
            stack.append((target - p) / s)

            if len(stack) >= 2:
                if stack[-1] <= stack[-2]:
                    stack.pop()

        return len(stack)
