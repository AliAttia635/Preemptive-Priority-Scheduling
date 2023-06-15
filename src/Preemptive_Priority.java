import java.util.*;

public class Preemptive_Priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        System.out.println("Please Enter number of processes: ");
        n = sc.nextInt();

        String Processes[];
        int ArrivalTime[],BurstTime[], priority[] , start_time[],completion_time[];
        int turnaround_time [] , waiting_time[] , response_time[] , pid[];

        Processes = new String[n];
        ArrivalTime = new int[n];
        BurstTime = new int[n];
        priority = new int[n];
        pid = new int[n];

        start_time = new int[n];
        completion_time = new int[n];
        turnaround_time=new int[n];
        waiting_time=new int[n];

        float avg_turnaround_time;
        float avg_waiting_time;

        int total_turnaround_time = 0;
        int total_waiting_time = 0;

        int burst_remaining[];
        burst_remaining=new int[100];
        int is_completed[];
        is_completed=new int[100];

        for(int i = 0; i < n; i++) {
            System.out.println("Please Enter Process " + (i + 1) + " Name");
            Processes[i] = sc.next();

            System.out.println("Please Enter Process " + Processes[i] + " Arrival time:");
            ArrivalTime[i] = sc.nextInt();

            System.out.println("Please Enter Process " +  Processes[i] + " Burst time:");
            BurstTime[i] = sc.nextInt();

            System.out.println("Please Enter Process " +  Processes[i] + " priority :");
            priority[i] = sc.nextInt();

            pid[i] = i+1;

            burst_remaining[i] = BurstTime[i];
            System.out.println("\n");
        }

        int current_time = 0;
        int completed = 0;
        int prev = 0;

        while (completed!=n){
            int idx = -1;
            int mx = 1000000;

            for(int i = 0; i < n; i++) {

                if(ArrivalTime[i] <= current_time && is_completed[i] == 0) {
                    if(priority[i] < mx) {
                        mx = priority[i];
                        idx = i;
                    }
                    if(priority[i] == mx) {
                        if(ArrivalTime[i] < ArrivalTime[idx]) {
                            mx = priority[i];
                            idx = i;
                        }
                    }
                }
            }

            if(idx != -1) {
                if (burst_remaining[idx] == BurstTime[idx]) {
                    start_time[idx] = current_time;
                }
                burst_remaining[idx] -= 1;
                current_time++;
                prev = current_time;

                if (burst_remaining[idx] == 0) {
                    completion_time[idx] = current_time;
                    turnaround_time[idx] = completion_time[idx] - ArrivalTime[idx];
                    waiting_time[idx] = turnaround_time[idx] - BurstTime[idx];

                    total_turnaround_time += turnaround_time[idx];
                    total_waiting_time += waiting_time[idx];

                    is_completed[idx] = 1;
                    completed++;
                }
            }
            else {
                current_time++;
            }

        }

        int min_arrival_time = 10000000;
        int max_completion_time = -1;
        for(int i = 0; i < n; i++) {
            min_arrival_time = Math.min(min_arrival_time,ArrivalTime[i]);
            max_completion_time = Math.max(max_completion_time,completion_time[i]);
        }


        avg_turnaround_time = (float) total_turnaround_time / n;
        avg_waiting_time = (float) total_waiting_time / n;

        System.out.println("#P\t" + "AT\t" + "BT\t" + "PRI\t"  + "ST\t"+ "TAT\t" + "WT\t" + "\n");

        for(int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + ArrivalTime[i] + "\t"
                    + BurstTime[i] + "\t"
                    +priority[i]+"\t"+
                    start_time[i]
                    +"\t"+turnaround_time[i]
                    +"\t"+waiting_time[i]
                    +"\t");
        }

        System.out.println(" ");
        System.out.println("Order of execution is : ");

        Arrays.sort(priority);

        for(int i=0;i<n;i++){
            System.out.println("Process with priority : " + priority[i]);
            if(i==n-1){
                break;
            }
            System.out.println("then");
        }
        System.out.println(" ");
        System.out.println("Average Turnaround Time = " + avg_turnaround_time);
        System.out.println("Average Waiting Time = " + avg_waiting_time);

    }
}