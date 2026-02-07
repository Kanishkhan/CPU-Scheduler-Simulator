# CPU Scheduler Simulator 🚀

A comprehensive, interactive web-based **CPU Scheduling Simulator** comparing First-Come, First-Served (FCFS), Round Robin (RR), and Hill Climbing algorithms. This tool visualizes scheduling logic and calculates performance metrics, serving as a practical educational resource for operating system concepts.

**🔗 Live Demo:** [cpu-optimizer.netlify.app](https://cpu-optimizer.netlify.app/)

## Key Features

- **Dynamic Process Management**: User-friendly interface to add processes with custom Arrival and Burst times.
- **Algorithm Comparison**:
  - **FCFS (First-Come, First-Served)**: Basic non-preemptive scheduling.
  - **Round Robin**: Preemptive scheduling with a fixed time quantum (Default: 5ms).
  - **Hill Climbing Optimization**: Advanced heuristic approach to discover optimized execution sequences for minimized waiting times.
- **Performance Analytics**: Real-time calculation and tabular display of Average Waiting Times for all algorithms.
- **Responsive Design**: Modern, glassmorphism-styled UI ensuring a consistent experience across devices.

## Technology Stack

- **Frontend Structure**: HTML5
- **Styling**: CSS3 with modern layout techniques and animations
- **Logic**: JavaScript (ES6+)

## Quick Start

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/Kanishkhan/CPU-Scheduler-Simulator.git
    ```
2.  **Launch the application**:
    Open the `index.html` file in any modern web browser. No server setup is required.

## Usage Guide

1.  **Input Data**: Enter specific *Arrival Time* and *Burst Time* values.
2.  **Add Processes**: Click "Add Process" to populate the simulation table.
3.  **Execute**: Click "Run Scheduling" to trigger the algorithms.
4.  **Analyze**: Review the comparative results table to observe how different algorithms perform on the given dataset.

## Contributions

Contributions to improve the simulator or add new algorithms (e.g., SJF, Priority Scheduling) are welcome. Please follow standard fork-and-pull-request workflows.

## Author

**Kanishk Khan**
- [GitHub Profile](https://github.com/Kanishkhan)
