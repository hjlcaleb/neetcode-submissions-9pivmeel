# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def valid(node: TreeNode, lower_bound: float, upper_bound: float):
            if not node:
                return True
            elif not (lower_bound < node.val < upper_bound):
                return False
            return valid(node.left, lower_bound, node.val) and valid(node.right, node.val, upper_bound)
        return valid(root, float('-infinity'), float('infinity'))
