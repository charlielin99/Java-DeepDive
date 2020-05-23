class Solution {
    /*
    "1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group."
    So for any two workers in the paid group,
    we have wage[i] : wage[j] = quality[i] : quality[j]
    So we have wage[i] : quality[i] = wage[j] : quality[j]
    We pay wage to every worker in the group with the same ratio compared to his own quality.

    "2. Every worker in the paid group must be paid at least their minimum wage expectation."
    For every worker, he has an expected ratio of wage compared to his quality.

    So to minimize the total wage, we want a small ratio.
    So we sort all workers with their expected ratio, and pick up K first worker.
    Now we have a minimum possible ratio for K worker and we their total quality.

    As we pick up next worker with bigger ratio, we increase the ratio for whole group.
    Meanwhile we remove a worker with highest quality so that we keep K workers in the group.
    We calculate the current ratio * total quality = total wage for this group.

    We redo the process and we can find the minimum total wage.
    Because workers are sorted by ratio of wage/quality.
    For every ratio, we find the minimum possible total quality of K workers.
    
    Time Complexity O(NlogN) for sort. O(NlogK) for priority queue.
    */
    
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
}