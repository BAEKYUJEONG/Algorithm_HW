import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
//import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTitle {
   DocumentBuilderFactory factory; //공장	
   DocumentBuilder builder;//일꾼
   //--------------------------> 프로그램마다 상이
   
   
   //--------------- XML프로그램 시작 ------------------
   Document doc;
   
   public DOMTitle() throws Exception{
	   factory = DocumentBuilderFactory.newInstance();
	   builder = factory.newDocumentBuilder();
	   
	   doc = builder.parse("http://rss.etnews.com/Section902.xml");
	   //System.out.println("DOM파싱성공~!!");
	   
	   //Element root = doc.getDocumentElement();
	   //System.out.println("루트태그명>>"+root.getTagName());
	   System.out.println("<<속보 타이틀 목록>>");
	   NodeList list = doc.getElementsByTagName("title");
	   //list.getLength() : 데이터 크기
	   //list.item(int index) : 데이터 얻어오기
	   for(int i=2; i<list.getLength(); i++) {
		   Node n =list.item(i);//n= <title>JavaProgramming</title>
		   String str = n.getTextContent();//str=JavaProgramming
		   System.out.println(str);
	   }
	   
   }//생성자
   
	
   public static void main(String[] args) throws Exception {
	 //DOM파서를 사용해서 xml문서의 데이터를 화면에 출력
	 //==> 도서제목을 출력하시오.
	   
//	   DOMTest dt = new DOMTest();
	   new DOMTitle();
   }
}




