/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    private HtmlParser htmlParser;
    private String startHostname;
    private HashSet<String> visited;

    private String getHostname(String url) {
        return url.split("/")[2];
    }

    private void dfs(String url) {
        if (visited.contains(url)) return;
        visited.add(url);

        for (String link : htmlParser.getUrls(url)) {
            if (getHostname(link).equals(startHostname)) {
                dfs(link);
            }
        }
    }
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        this.htmlParser = htmlParser;
        startHostname = getHostname(startUrl);
        visited = new HashSet<>();
        dfs(startUrl);
        List<String> result = new ArrayList<>(visited);
        return result;
    }
}
