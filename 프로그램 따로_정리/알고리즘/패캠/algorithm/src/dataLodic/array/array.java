package array;

import java.util.ArrayList;
import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        { //배열 기본사용
        /*
            // 직접 배열 데이터 선언시 넣을 수도 있음
        Integer data_list[] = {5, 4, 3, 2, 1};
        Integer[] data_list2 = {1, 2, 3, 4, 5};

        System.out.println(data_list);

        //배열을 한번에 출력
        System.out.println( Arrays.toString(data_list2) );
         */
        }

        { //어레이 기본
        /*
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            list1.add(1); // 배열에 아이템 추가 시 add(아이템) 메서드 사용
            list1.add(2);
            System.out.println(list1.get(0)); // 배열에 특정 아이템을 읽을 시 get(인덱스번호) 메서드 사용 (굳이 System.out.println() 을 사용하지 않아도 됨)
            System.out.println(list1);

            list1.set(0, 5);
            System.out.println(list1.get(0)); // 특정 인덱스에 해당하는 아이템 변경 시, set(인덱스번호, 변경할값) 메서드 사용
            System.out.println(list1);

            System.out.println(list1.get(0));
            System.out.println(list1);

            list1.remove(0); // 특정 인덱스에 해당하는 아이템 삭제 시, remove(인덱스번호) 메서드 사용
            System.out.println(list1.get(0));

            System.out.println(list1.size()); // 배열 길이
         */
        }

        { // 2차배열
            /*
            Integer data_list[][] = {{1, 2, 3}, {4, 5, 6}};

            // 데이터 2 인덱스로 지정해서 출력해보기
            System.out.println(data_list[0][1]);
            // 데이터 5 인덱스로 지정해서 출력해보기
            System.out.println(data_list[1][1]);
             */
        }

        { // 3차원 배열
            /*
            Integer[][][] data_list = {
                    {
                            {1, 2, 3},
                            {4, 5, 6}
                    },
                    {
                            {7, 8, 9},
                            {10, 11, 12}
                    }
            };

            // 데이터 5 인덱스로 지정해서 출력해보기
            System.out.println(data_list[0][1][1]);
            // 데이터 12 인덱스로 지정해서 출력해보기
            System.out.println(data_list[1][1][2]);
             */
        }

        { // 문자열
            String dataset[] = {
                    "Braund, Mr. Owen Harris",
                    "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
                    "Heikkinen, Miss. Laina",
                    "Futrelle, Mrs. Jacques Heath (Lily May Peel)",
                    "Allen, Mr. William Henry",
                    "Moran, Mr. James",
                    "McCarthy, Mr. Timothy J",
                    "Palsson, Master. Gosta Leonard",
                    "Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)",
                    "Nasser, Mrs. Nicholas (Adele Achem)",
                    "Sandstrom, Miss. Marguerite Rut",
                    "Bonnell, Miss. Elizabeth",
                    "Saundercock, Mr. William Henry",
                    "Andersson, Mr. Anders Johan",
                    "Vestrom, Miss. Hulda Amanda Adolfina",
                    "Hewlett, Mrs. (Mary D Kingcome) ",
                    "Rice, Master. Eugene",
                    "Williams, Mr. Charles Eugene",
                    "Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)",
                    "Masselmani, Mrs. Fatima",
                    "Fynney, Mr. Joseph J",
                    "Beesley, Mr. Lawrence",
                    "McGowan, Miss. Anna",
                    "Sloper, Mr. William Thompson",
                    "Palsson, Miss. Torborg Danira",
                    "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
                    "Emir, Mr. Farred Chehab",
                    "Fortune, Mr. Charles Alexander",
                    "Dwyer, Miss. Ellen",
                    "Todoroff, Mr. Lalio"
            };

            Integer count = 0;

            for (int i = 0; i < dataset.length; i++) {
                if (dataset[i].contains("M")){
                    count ++;
                }
            }

            System.out.println(count);
        }
    }
}
