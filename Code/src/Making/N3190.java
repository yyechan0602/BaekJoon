package Making;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3190 {
    static class tile {
        boolean apple;
        int[] nextTile;

        public tile() {
            this.apple = false;
            this.nextTile = new int[]{0, 0};
        }
    }

    static class rotate {
        int time;
        boolean dir;

        public rotate(int time, boolean dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class pos {
        int[] pos;
        int[] dir;

        public pos() {
            this.pos = new int[]{0, 0};
            this.dir = new int[]{0, 1};
        }
    }

    static int N;
    static tile[][] board;
    static rotate[] rotations;
    static pos head;
    static pos tail;
    static int time;
    static int timeIndex;
    static boolean isColide;
    static boolean tailFlag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 보드 생성
        board = new tile[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new tile();
            }
        }

        // 타일에 사과 넣기
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1].apple = true;
        }

        int L = Integer.parseInt(br.readLine());
        rotations = new rotate[L + 1];
        int timeX;
        timeIndex = 0;

        // 방향 저장
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            timeX = Integer.parseInt(st.nextToken());
            if (st.nextToken().equals("L")) {
                rotations[i] = new rotate(timeX, true);
            } else {
                rotations[i] = new rotate(timeX, false);
            }
        }
        rotations[L] = new rotate(-1, false);

        tailFlag = false;
        head = new pos();
        tail = new pos();
        TotalMove();
    }


    public static void TotalMove() {
        time = 0;
        isColide = false;
        while (!isColide) {
            time += 1;
            HeadMove();
        }
        System.out.println(time);
    }

    public static void HeadMove() {
        int[] nextpos = new int[]{head.pos[0] + head.dir[0], head.pos[1] + head.dir[1]};

        // 현재위치가 벽을 통과했는지 확인/ 그자리에 뱀이 없는지 확인
        if ((0 <= nextpos[0]) && (nextpos[0] < N) && (0 <= nextpos[1]) && (nextpos[1] < N)) {
            if (board[nextpos[0]][nextpos[1]].nextTile[0] == 0 && board[nextpos[0]][nextpos[1]].nextTile[1] == 0) {
                // 벽이 없으면 머리를 이동시킨다.
                board[head.pos[0]][head.pos[1]].nextTile = nextpos;
                head.pos[0] = nextpos[0];
                head.pos[1] = nextpos[1];
                showAll();

                // 다음 위치에 사과가 있는지 확인
                // 사과가 있으면 꼬리는 움직이지 않는다.
                if (board[head.pos[0]][head.pos[1]].apple) {
                    board[nextpos[0]][nextpos[1]].apple = false;
                } else { // 사과가 없으면 꼬리가 움직인다.
                    if(tailFlag) {
                        TailMove();
                    }
                    tailFlag = true;
                }
            }
            // 벽에 부딪히면
        } else {
            isColide = true;
        }
        // 방향을 전환한다.
        if (rotations[timeIndex].time == time) {
            int x = head.dir[0];
            int y = head.dir[1];
            // true = "L"
            if (rotations[timeIndex].dir) {
                if (x == 0) {
                    if (y == 1) {
                        head.dir[0] = -1;
                        head.dir[1] = 0;
                    } else {
                        head.dir[0] = 1;
                        head.dir[1] = 0;
                    }
                } else if (x == -1) {
                    head.dir[0] = 0;
                    head.dir[1] = -1;
                } else {
                    head.dir[0] = 0;
                    head.dir[1] = 1;
                }
            }// false = "R"
            else {
                if (x == 0) {
                    if (y == 1) {
                        head.dir[0] = 1;
                        head.dir[1] = 0;
                    } else {
                        head.dir[0] = -1;
                        head.dir[1] = 0;
                    }
                } else if (x == -1) {
                    head.dir[0] = 0;
                    head.dir[1] = 1;
                } else {
                    head.dir[0] = 0;
                    head.dir[1] = -1;
                }
            }
            timeIndex += 1;
        }
    }

    public static void TailMove() {
        int[] nextpos = board[tail.pos[0]][tail.pos[1]].nextTile;
        board[tail.pos[0]][tail.pos[1]].nextTile = new int[]{0, 0};
        tail.pos = nextpos;
    }

    public static void showAll() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!board[i][j].apple) {
                    if (board[i][j].nextTile[0] == 0 && board[i][j].nextTile[1] == 0) {
                        System.out.print(" * ");
                    } else {
                        System.out.print(" O ");
                    }
                } else {
                    System.out.print(" @ ");
                }
            }
            System.out.println();
        }
        System.out.println("===================================");
    }
}
