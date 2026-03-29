class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if not n:
            return True
        
        adj_list = { i:[] for i in range(n)}

        for n1, n2 in edges:
            adj_list[n1].append(n2)
            adj_list[n2].append(n1)

        visit = set()
        def dfs(i, prev):
            if i in visit: # detected a loop
                return False
            
            visit.add(i)

            for j in adj_list[i]:
                if j == prev:
                    continue
                if not dfs(j, i):
                    return False
            return True
        
        return dfs(0, -1) and n == len(visit)