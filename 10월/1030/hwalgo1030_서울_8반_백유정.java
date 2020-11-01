import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo1030_서울_8반_백유정{

   static int  moneys[],days[], min;
   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int TC = Integer.parseInt(in.readLine().trim());
      StringTokenizer st = null;
      moneys = new int[4];
      days = new int[12];
      
      for(int t=1; t<=TC; ++t) {
         st = new StringTokenizer(in.readLine().trim());
         for(int i=0; i<4; ++i) {
            moneys[i] = Integer.parseInt(st.nextToken().trim());
         }// 이용권 가격들 input
         st = new StringTokenizer(in.readLine().trim());
         for(int i=0; i<12; ++i) {
            days[i] = Integer.parseInt(st.nextToken().trim());
         } // 12개월 이용 계획 input
         plan();
         System.out.println("#"+t+" "+min);
      }
   }//main
   
   private static void plan() {
      min = moneys[3];// 1년 이용권을 최소로 놓고 시작.
      calc(0,0);
   }
   private static void calc(int m, int sum) {
      if(m>=12) {
         min = Math.min(min, sum);
         return;
      }
      //1일권 시도
      calc(m+1, sum+days[m]*moneys[0]);
      //1달권 시도
      calc(m+1, sum+(days[m]>0?moneys[1]:0));
      //3달권 시도
      if(days[m]>0) { // 해당 월에 이용계획인 있을 경우는 3달 이용권 구매하고,3달을 건너뜀.
         calc(m+3, sum+moneys[2]);
      }else { // 해당 월에 이용계획이 없을 경우는 3달 이용권 구매하지 않고 다음달로 넘어감.
         calc(m+1, sum);
      }
   }

}