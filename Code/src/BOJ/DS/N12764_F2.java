package BOJ.DS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class N12764_F2 {
    static class person implements Comparable<person> {
        int start;
        int end;

        public person(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(person o) {
            if (this.start < o.start) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static class computer implements Comparable<computer> {
        int end;
        int index;
        int count;

        public computer(int end, int index, int count) {
            this.end = end;
            this.index = index;
            this.count = count;
        }

        @Override
        public int compareTo(computer o) {
            if (this.end < o.end) {
                return -1;
            } else {
                return 1;
            }
        }

        public seat GetValues() {
            return new seat(this.end, this.index, this.count);
        }
    }

    static class seat implements Comparable<seat> {
        int end;
        int index;
        int count;

        public seat(int end, int index, int count) {
            this.end = end;
            this.index = index;
            this.count = count;
        }

        @Override
        public int compareTo(seat o) {
            if (this.index < o.index) {
                return -1;
            } else {
                return 1;
            }
        }

        public computer GetValues() {
            return new computer(this.end, this.index, this.count);
        }

        public computer GetPlus(int nextEnd) {
            return new computer(nextEnd, this.index, this.count + 1);
        }
    }

    static PriorityQueue<computer> CyRoom;
    static PriorityQueue<person> people;

    static int N;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        CyRoom = new PriorityQueue<>();
        people = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people.add(new person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        num = 1;

        //시작
        person A = people.poll();
        //System.out.println(A.start + " " + A.end);
        CyRoom.add(new computer(A.end, num++, 1));
        for (int i = 1; i < N; i++) {
            FindSeat();
        }
        ShowAll();
    }

    static void FindSeat() {
        PriorityQueue<seat> seats = new PriorityQueue<>();
        person A = people.poll();
        //System.out.println(A.start + " " + A.end);
        if (CyRoom.peek().end < A.start) {
            while (!CyRoom.isEmpty() && CyRoom.peek().end < A.start) {
                seats.add(CyRoom.poll().GetValues());
            }
            CyRoom.add(seats.poll().GetPlus(A.end));
            while (!seats.isEmpty()) {
                CyRoom.add(seats.poll().GetValues());
            }
        } else {
            CyRoom.add(new computer(A.end, num++, 1));
        }


    }

    static void ShowAll() {
        PriorityQueue<seat> seats = new PriorityQueue<>();
        while (!CyRoom.isEmpty()) {
            seats.add(CyRoom.poll().GetValues());
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(seats.size());
        while(!seats.isEmpty()){
            sb.append(seats.poll().count + " ");
        }
        System.out.println(sb.toString());
    }
}