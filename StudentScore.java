import java.util.Scanner;

public class StudentScore {
    public static void main(String[] args) {
        //  TODO  Auto-generated method stub
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生的人数：");
        int number = 0; //学生的人数
        number = input.nextInt();
        System.out.println("请输入课程的数目：");
        int courses = 0; //课程的数目
        courses = input.nextInt();
        String[] coursesname = new String[courses]; //课程的名字
        for (int i = 0; i < coursesname.length; i++) {
            System.out.println("请输入第" + (i + 1) + "门课的名字：");
            coursesname[i] = input.next();
        }
        String[] name = new String[number]; //学生的名字
        int[][] score = new int[number][courses]; //学生的科目成绩，二维数组
        for (int i = 0; i < name.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个学生的名字：");
            name[i] = input.next();
            for (int j = 0; j < coursesname.length; j++) {
                System.out.println("请输入" + name[i] + coursesname[j] + "的成绩：");
                score[i][j] = input.nextInt();
            }
        }

        int sum = 0; //每个学生的成绩总分
        // int   avg =0;//每个学生的平均分
        int[] scoreSum = new int[number];
        int[] ci = new int[number]; //学生的名次
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < courses; j++) {
                sum += score[i][j];
            }
            scoreSum[i] = sum;
            ci[i] = sum;
            sum = 0;
        }
        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j < number; j++) {
                if (ci[i] < ci[j]) {
                    int temp = ci[j];
                    ci[j] = ci[i];
                    ci[i] = temp;
                }

            }
        }
        System.out.print("学生\t");
        for (int i = 0; i < courses; i++) {
            System.out.print(coursesname[i] + "\t");
        }
        System.out.print("总分\t");
        System.out.print("平均分\t");
        System.out.print("排行榜");
        System.out.print("\n");
        int[] temp = new int[number];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < scoreSum.length; j++) {
                if (ci[i] == scoreSum[j]) {
                    temp[i] = j;
                }
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.print(name[temp[i]] + "\t");
            for (int j = 0; j < courses; j++) {
                System.out.print(score[temp[i]][j] + "\t");
            }
            System.out.print(scoreSum[temp[i]] + "\t");
            System.out.print((scoreSum[temp[i]] / courses) + "\t");
            System.out.print("第" + (i + 1) + "名");
            System.out.print("\n");
        }
    }
}