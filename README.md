<<<<<<< HEAD
# CPU Scheduler Simulator 🚀

A powerful and interactive web-based **CPU Scheduling Simulator** designed to visualize and compare different process scheduling algorithms. Ideally built for students and developers to understand the core concepts of operating system scheduling.

## 🌟 Features

- **Interactive Interface**: Add processes dynamically with Arrival Time and Burst Time.
- **Multiple Algorithms**:
  - **First-Come, First-Served (FCFS)**: The simplest scheduling algorithm.
  - **Round Robin (RR)**: Processes are dispatched in a FIFO manner but are given a limited amount of CPU time (Quantum = 5).
  - **Hill Climbing Optimization**: A heuristic approach to find an optimized schedule sequence for better average waiting time.
- **Visual Results**: View the process table and compare Average Waiting Times across algorithms in a clear, tabular format.
- **Modern UI**: Built with a sleek **Glassmorphism** design using CSS3.

## 🛠️ Technologies Used

- **HTML5**: For structure and layout.
- **CSS3**: for styling, animations, and the glassmorphism effect.
- **JavaScript (ES6+)**: For implementation of scheduling logic and DOM manipulation.

## 🚀 Getting Started

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/Kanishkhan/CPU-Scheduler-Simulator.git
    ```
2.  **Open the project**:
    Navigate to the project directory and open `index.html` in your preferred web browser.

## 📖 How to Use

1.  **Add Processes**:
    - Enter the **Arrival Time** and **Burst Time** in the input fields.
    - Click **"Add Process"**.
2.  **Run Simulation**:
    - Once you have added all desired processes, click **"Run Scheduling"**.
3.  **Analyze Results**:
    - The breakdown of average waiting times for FCFS, Round Robin, and Hill Climbing will be displayed in the **Results** section.

## 📸 Screenshots

*(Add screenshots of your application here to show off the UI!)*

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

## 👤 Author

**Kanishk Khan**

- GitHub: [@Kanishkhan](https://github.com/Kanishkhan)
- LinkedIn: (Add your LinkedIn Profile URL)

---

*Built with ❤️ by Kanishk Khan*
=======
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
>>>>>>> 7217e034530daad30e711db379a22d62c4ffdda2
