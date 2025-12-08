Check out the live website for this project here 👉 https://cpu-optimizer.netlify.app/

Project Overview
This project implements a CPU Scheduling Simulator in Java that evaluates the efficiency of different scheduling algorithms using Average Waiting Time as the main metric. Each process contains arrival time, burst time, completion time, turnaround time, and waiting time.

FCFS Scheduling (First-Come First-Serve)
FCFS is a non-preemptive scheduling approach where processes are executed in the same order as they arrive.
The program calculates completion time, turnaround time, waiting time, and average waiting time for all processes under this method.

Round Robin Scheduling
Round Robin is a preemptive scheduling algorithm that distributes CPU time fairly among processes using a fixed quantum.
The algorithm tracks remaining burst time, executes processes in time slices, and accumulates waiting time across multiple cycles to compute the average waiting time.

Hill Climbing Optimization
This module applies an optimization technique to improve scheduling efficiency.
The order of processes is randomly shuffled for many iterations to search for a sequence that results in minimum average waiting time. The improved schedule replaces the previous one only if it produces a lower waiting time.

Output Summary
After running all three approaches, the program prints the Average Waiting Time for:
• FCFS Scheduling
• Round Robin Scheduling
• Hill Climbing Optimized Scheduling
This allows comparison of how each algorithm performs and how optimization improves scheduling efficiency.

Key Learning & Concepts Demonstrated
• Operating System scheduling algorithms in Java
• Difference between preemptive and non-preemptive scheduling
• Calculation of burst, completion, turnaround, and waiting times
• Use of heuristic (Hill Climbing) for performance improvement

Future Scope
• Support for SJF, Priority Scheduling, and Multi-Level Queue
• Visualization using Gantt Charts
• GUI-based interactive scheduling simulator
