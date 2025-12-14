import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// 命名规则：L学号_20_Test.java（需将“2023001”替换为自己的学号）
class L2023001_20_Test {
    private final Solution solution = new Solution();

    // 测试目的：验证单节点场景（n=1，无边）；测试用例：n=1，edges=[], 预期输出[0]
    @Test
    void testSingleNode() {
        int n = 1;
        int[][] edges = {};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = List.of(0);
        assertEquals(expected, result, "单节点树的最小高度根节点应为[0]");
    }

    // 测试目的：验证两节点场景（n=2，一条边）；测试用例：n=2，edges=[[0,1]], 预期输出[0,1]
    @Test
    void testTwoNodes() {
        int n = 2;
        int[][] edges = {{0, 1}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = List.of(0, 1);
        // 忽略顺序（题目允许任意顺序返回）
        assertTrue(result.containsAll(expected) && expected.containsAll(result), "两节点树的最小高度根节点应为[0,1]");
    }

    // 测试目的：验证示例1（星形结构）；测试用例：n=4，edges=[[1,0],[1,2],[1,3]], 预期输出[1]
    @Test
    void testExample1() {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = List.of(1);
        assertEquals(expected, result, "示例1的最小高度根节点应为[1]");
    }

    // 测试目的：验证示例2（分支结构）；测试用例：n=6，edges=[[3,0],[3,1],[3,2],[3,4],[5,4]], 预期输出[3,4]
    @Test
    void testExample2() {
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = List.of(3, 4);
        assertTrue(result.containsAll(expected) && expected.containsAll(result), "示例2的最小高度根节点应为[3,4]");
    }

    // 测试目的：验证链状树（n=5，线性结构）；测试用例：n=5，edges=[[0,1],[1,2],[2,3],[3,4]], 预期输出[2]
    @Test
    void testChainTree() {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = List.of(2);
        assertEquals(expected, result, "链状树（n=5）的最小高度根节点应为[2]");
    }

    // 测试目的：验证三叉树（n=5，中间节点连4个子节点）；测试用例：n=5，edges=[[2,0],[2,1],[2,3],[2,4]], 预期输出[2]
    @Test
    void testThreeBranchTree() {
        int n = 5;
        int[][] edges = {{2, 0}, {2, 1}, {2, 3}, {2, 4}};
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        List<Integer> expected = List.of(2);
        assertEquals(expected, result, "三叉树（n=5）的最小高度根节点应为[2]");
    }
}