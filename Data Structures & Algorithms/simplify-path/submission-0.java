class Solution {
    public String simplifyPath(String path) {
        Stack<String> fileNames = new Stack<>(); 
        StringBuilder result = new StringBuilder();
        String[] pathComponents = path.split("/+");
        for (int i = 0; i < pathComponents.length; i++) {
            String component = pathComponents[i];
            if (component.equals("..")) {
                if (!fileNames.isEmpty()) {
                    fileNames.pop();
                }
            } else if (!component.equals("") && !component.equals(".")) {
                fileNames.push(component);
            }
        }
        
        if (fileNames.isEmpty()) return "/";
        for (String dir : fileNames) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}