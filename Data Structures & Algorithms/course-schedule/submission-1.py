class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = {i: [] for i in range(numCourses)} # initializes course code and list of prereqs
        for course, prereq in prerequisites:
            preMap[course].append(prereq)

        path = set()

        def dfs(crs):
            if crs in path:
                return False
            
            path.add(crs)
            for prereq in preMap[crs]:
                if not dfs(prereq):
                    return False
            path.remove(crs)
            preMap[crs] = []

            return True
        
        for c in range(numCourses):
            if not dfs(c):
                return False
            
        return True