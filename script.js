let processes = [];
let pid = 1;

// Add process to table
function addProcess() {
    let arrival = parseInt(document.getElementById("arrival").value);
    let burst = parseInt(document.getElementById("burst").value);

    if (isNaN(arrival) || isNaN(burst)) return;

    processes.push({ pid: pid, arrivalTime: arrival, burstTime: burst });
    document.getElementById("processTable").innerHTML +=
        `<tr><td>${pid}</td><td>${arrival}</td><td>${burst}</td></tr>`;
    pid++;
}

// FCFS (sorted)
function fcfs(list) {
    let current = 0, totalWT = 0;
    list.sort((a, b) => a.arrivalTime - b.arrivalTime);

    for (let p of list) {
        if (current < p.arrivalTime) current = p.arrivalTime;
        let completion = current + p.burstTime;
        let turnaround = completion - p.arrivalTime;
        let waiting = turnaround - p.burstTime;
        totalWT += waiting;
        current = completion;
    }
    return totalWT / list.length;
}

// FCFS (NO SORT) — used only for Hill Climbing
function fcfsNoSort(list) {
    let current = 0, totalWT = 0;
    for (let p of list) {
        if (current < p.arrivalTime) current = p.arrivalTime;
        let completion = current + p.burstTime;
        let turnaround = completion - p.arrivalTime;
        let waiting = turnaround - p.burstTime;
        totalWT += waiting;
        current = completion;
    }
    return totalWT / list.length;
}

// Round Robin
function roundRobin(list, quantum = 5) {
    let time = 0, totalWT = 0, queue = [...list];
    let remaining = {}, waiting = {};

    list.forEach(p => {
        remaining[p.pid] = p.burstTime;
        waiting[p.pid] = 0;
    });

    while (queue.length) {
        let p = queue.shift();
        let exec = Math.min(quantum, remaining[p.pid]);
        remaining[p.pid] -= exec;

        queue.forEach(q => waiting[q.pid] += exec);
        time += exec;

        if (remaining[p.pid] > 0) queue.push(p);
        else totalWT += waiting[p.pid];
    }
    return totalWT / list.length;
}

// Hill Climbing Optimization
function hillClimbing(list, iterations = 1000) {
    let best = fcfsNoSort([...list]);
    let bestSchedule = [...list];

    for (let i = 0; i < iterations; i++) {
        let newSchedule = [...bestSchedule];
        let a = Math.floor(Math.random() * newSchedule.length);
        let b = Math.floor(Math.random() * newSchedule.length);
        [newSchedule[a], newSchedule[b]] = [newSchedule[b], newSchedule[a]];

        let newWT = fcfsNoSort(newSchedule);
        if (newWT < best) {
            best = newWT;
            bestSchedule = [...newSchedule];
        }
    }
    return best;
}

// Run Scheduling + Display Results
function runScheduler() {
    if (processes.length === 0) {
        alert("Please add processes first!");
        return;
    }

    let fcfsWT = fcfs([...processes]).toFixed(2);
    let rrWT = roundRobin([...processes], 5).toFixed(2);
    let hillWT = hillClimbing([...processes]).toFixed(2);

    let table = document.getElementById("resultTable");
    table.innerHTML = `<tr><th>Algorithm</th><th>Average Waiting Time (ms)</th></tr>`;
    table.innerHTML += `<tr><td>FCFS</td><td>${fcfsWT}</td></tr>`;
    table.innerHTML += `<tr><td>Round Robin</td><td>${rrWT}</td></tr>`;
    table.innerHTML += `<tr><td>Hill Climbing</td><td>${hillWT}</td></tr>`;
}
