package eval3;

import java.util.*;

class Process {
    int pid, arrivalTime, burstTime, completionTime, turnaroundTime, waitingTime;

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    public void calculateTimes(int currentTime) {
        completionTime = currentTime + burstTime;
        turnaroundTime = completionTime - arrivalTime;
        waitingTime = turnaroundTime - burstTime;
    }
}

public class q1 {

    // FCFS Scheduling - Computes Average Waiting Time
    public static double fcfsScheduling(List<Process> processes) {
        int currentTime = 0, totalWT = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            p.calculateTimes(currentTime);
            currentTime = p.completionTime;
            totalWT += p.waitingTime;
        }
        return (double) totalWT / processes.size(); // Average Waiting Time
    }

    // Round Robin Scheduling - Computes Average Waiting Time
    public static double roundRobinScheduling(List<Process> processes, int quantum) {
        int currentTime = 0, totalWT = 0, completed = 0;
        Queue<Process> queue = new LinkedList<>(processes);
        Map<Integer, Integer> remainingTime = new HashMap<>();
        Map<Integer, Integer> firstExecution = new HashMap<>();
        Map<Integer, Integer> waitingTimeMap = new HashMap<>();

        for (Process p : processes) {
            remainingTime.put(p.pid, p.burstTime);
            firstExecution.put(p.pid, -1);
            waitingTimeMap.put(p.pid, 0);
        }

        while (!queue.isEmpty()) {
            Process p = queue.poll();
            int executionTime = Math.min(quantum, remainingTime.get(p.pid));

            if (firstExecution.get(p.pid) == -1) {
                firstExecution.put(p.pid, currentTime);
            }

            currentTime += executionTime;
            remainingTime.put(p.pid, remainingTime.get(p.pid) - executionTime);

            // Update waiting time for other processes in queue
            for (Process other : queue) {
                waitingTimeMap.put(other.pid, waitingTimeMap.get(other.pid) + executionTime);
            }

            if (remainingTime.get(p.pid) > 0) {
                queue.add(p);
            } else {
                p.calculateTimes(currentTime);
                p.waitingTime = waitingTimeMap.get(p.pid);
                totalWT += p.waitingTime;
                completed++;
            }
        }
        return (double) totalWT / processes.size(); // Average Waiting Time
    }

    // Hill Climbing Optimization - Computes Average Waiting Time
    public static double hillClimbingScheduling(List<Process> processes, int iterations) {
        double bestWT = fcfsScheduling(processes); // Start with FCFS as baseline
        List<Process> bestSchedule = new ArrayList<>(processes);

        for (int i = 0; i < iterations; i++) {
            List<Process> newSchedule = new ArrayList<>(bestSchedule);
            int idx1 = (int) (Math.random() * processes.size());
            int idx2 = (int) (Math.random() * processes.size());

            // Swap two jobs randomly
            Collections.swap(newSchedule, idx1, idx2);

            double newWT = fcfsScheduling(newSchedule);
            if (newWT < bestWT) {
                bestWT = newWT;
                bestSchedule = new ArrayList<>(newSchedule);
            }
        }
        return bestWT;
    }

    public static void main(String[] args) {
        List<Process> processes = Arrays.asList(
                new Process(1, 0, 6),
                new Process(2, 1, 8),
                new Process(3, 2, 7),
                new Process(4, 3, 3)
        );

        double fcfsWT = fcfsScheduling(new ArrayList<>(processes));
        double roundRobinWT = roundRobinScheduling(new ArrayList<>(processes), 5);
        double hillClimbingWT = hillClimbingScheduling(new ArrayList<>(processes), 1000);

        System.out.println("Test Case Results:");
        System.out.println("FCFS Scheduling Average Waiting Time: " + fcfsWT + " ms");
        System.out.println("Round Robin Scheduling Average Waiting Time: " + roundRobinWT + " ms");
        System.out.println("Hill Climbing Optimized Average Waiting Time: " + hillClimbingWT + " ms");
    }
}