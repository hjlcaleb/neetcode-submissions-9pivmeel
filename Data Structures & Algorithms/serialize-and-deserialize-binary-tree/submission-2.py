# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return 'N'
        res = []
        queue = deque([root])
        while queue:
            node = queue.popleft()
            if not node:
                res.append('N')
            else:
                res.append(str(node.val))
                queue.append(node.left)
                queue.append(node.right)
            
        return ','.join(res)

        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        nodeList = data.split(',')
        if nodeList[0] == 'N':
            return None
        root = TreeNode(int(nodeList[0]))

        queue = deque([root])
        index = 1
        while queue:
            node = queue.popleft()
            if nodeList[index] != 'N':
                node.left = TreeNode(int(nodeList[index]))
                queue.append(node.left)
            index += 1
            if nodeList[index] != 'N':
                node.right = TreeNode(int(nodeList[index]))
                queue.append(node.right)
            index += 1
        return root


