# Project Description

**This project involves the development of a process scheduling and execution simulation system. Key components include a ready queue, memory for variable storage, and Process Control Blocks (PCBs) containing Process ID, Program Counter, and Memory Boundaries. The system supports two scheduling algorithms: Round Robin and Shortest Job First.**

**Input:**

- **Three text files with program instructions encompassing variable assignments, arithmetic operations, file I/O, and print commands. Each program file follows a consistent format and syntax.**

**Implementation Steps:**

1. **Initialize Queues and Memory:**
    - Create a data structure for the Ready queue.
    - Implement memory allocation to store variables and program data.
2. **Parsing Programs:**
    - Read each input text file containing programs.
    - Parse instructions and organize them for execution.
    - Categorize instructions: variable assignments, arithmetic operations, file I/O, print commands.
3. **Implement Operations:**
    - **Variable Assignment:**
        - Implement 'assign' operation, handling direct value assignment and user input.
    - **Arithmetic Operations:**
        - Implement add, subtract, multiply, divide operations.
    - **File I/O:**
        - Implement writeFile and readFile operations for data storage and retrieval from files.
4. **Scheduling Algorithms:**
    - Implement Round Robin (quantum=2) and Shortest Job First algorithms for process execution management.
    - Define time-slice for Round Robin and criteria for Shortest Job First.
5. **Execution Control:**
    - Iterate through parsed instructions, execute them based on scheduling algorithms.
    - Print the current process executing at each cycle.
    - Track and print when each process finishes execution.
6. **Testing and Debugging:**
    - Test the implementation with various input programs to ensure correct execution.
    - Debug any encountered issues during testing.

**Expected Outputs at Each Clock Cycle:**

1. **Ready Queues:**
    - Display contents of the Ready queue.
2. **Processor Status:**
    - Indicate which process is currently on the processor (CPU).
3. **Memory State:**
    - Showcase memory state after each operation:
        - Variables and their assigned values.
        - Any changes in memory due to file I/O or program execution.
4. **Gantt Chart:**
    - Display the Gantt chart for each scheduling algorithm.

**This simulation aims to provide insights into process scheduling, execution, and memory management, offering visual representations of system state and scheduling decisions.**
