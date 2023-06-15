This code Simulate the Priority Scheduling Algorithm using Java


How the code works :
•	The code begins by prompting the user to enter the number of processes to be scheduled.                                                                             
•	It then initializes arrays and variables to store process information such as process names, arrival times, burst times, priorities, start times, completion times, turnaround times, waiting times, response times, and process IDs.                                                                                                     
•	The code takes input for each process, including the process name, arrival time, burst time, and priority.                                                          
•	The code initializes arrays to keep track of the remaining burst time for each process and whether a process has been completed.                                    
•	The scheduling algorithm starts by iterating until all processes are completed. It finds the process with the highest priority among the arrived processes.         
•	If a process is found, it checks if the process has just started executing and updates the start time accordingly.                                                  
•	It reduces the burst time of the process by 1 and increments the current time.                                                                                      
•	If the burst time of the process becomes 0, it means the process has completed execution. The code calculates completion time, turnaround time, and waiting time for the process.                                                                                                                                                      
•	The code updates the total turnaround time and total waiting time for calculating averages.                                                                         
•	It marks the process as completed and increments the completed count.                                                                                               
•	If no process is found to execute at the current time, the current time is incremented.                                                                             
•	After all processes have been scheduled and completed, the code calculates the minimum arrival time and maximum completion time among all processes.                
•	The code calculates the average turnaround time and average waiting time.                                                                                           
•	It then displays the details of each process, including process ID, arrival time, burst time, priority, start time, turnaround time, and waiting time.              
•	Next, it displays the order of execution based on sorted priorities.                                                                                                
•	Finally, the code displays the average turnaround time and average waiting time.                                                                                    
