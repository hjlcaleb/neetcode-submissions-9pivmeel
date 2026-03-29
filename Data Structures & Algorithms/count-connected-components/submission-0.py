class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        if not n:
            return 0

        adj_map = { i:[] for i in range(n)}
        for n1, n2 in edges:
            adj_map[n1].append(n2)
            adj_map[n2].append(n1)
        
        visit = [False] * n

        def dfs(i):
            for nei in adj_map[i]:
                if not visit[nei]:
                    visit[nei] = True
                    dfs(nei)
        res = 0
        for node in range(n):
            if not visit[node]:
                res += 1
                visit[node] = True
                dfs(node)
                
        return res

        
