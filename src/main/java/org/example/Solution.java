package org.example;

import java.util.*;

public class Solution {
    // 解决最小高度树问题（核心方法）
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 边界条件：n=1时直接返回[0]
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // 1. 构建邻接表 + 统计每个节点的度
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        // 2. 初始化队列：所有度为1的叶子节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        // 3. 剥洋葱：逐层移除叶子节点，直到剩余1/2个节点（核心）
        int remaining = n;
        while (remaining > 2) {
            int size = queue.size();
            remaining -= size;
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                // 遍历叶子节点的邻居，减少度并判断是否成为新叶子
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // 4. 剩余节点即为最小高度树的根
        return new ArrayList<>(queue);
    }
}