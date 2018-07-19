// 서비스 컴포넌트 - 게시물 관련 업무를 처리할 객체
package bitcamp.java106.pms;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
 
public class PharmParser {
 
    public final static String PHARM_URL = "http://openapi.jejutour.go.kr:8080/openapi/service/TourSpotInfoService/getTourSpotCategory";
    public final static String KEY = "kuQLts2epFkXcRYSn4ewIw4AWjBuCDkLZI1rz8m86Ije%2B3j%2BkZslvFlLjg695tkJKLlOAVE94OIqEnncw0QmUQ%3D%3D";
    public PharmParser() {
        try {
            apiParserSearch();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    
    /**
     * 
     * @throws Exception
     */
    public void apiParserSearch() throws Exception {
        URL url = new URL(getURLParam(null));
 
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        xpp.setInput(bis, "utf-8");
        
        String tag = null;
        int event_type = xpp.getEventType();
        
        HashMap<String, String> list = new HashMap<>();
        
        String addr = null;
        String no = null;
        while (event_type != XmlPullParser.END_DOCUMENT) {
            if (event_type == XmlPullParser.START_TAG) {
                tag = xpp.getName();
            } else if (event_type == XmlPullParser.TEXT) {
                /**
                 * 약국의 주소만 가져와본다.
                 */
                if(tag.equals("caName")){
                    addr = xpp.getText();
                } else if(tag.equals("caId")) {
                    no = xpp.getText();
                }
            } else if (event_type == XmlPullParser.END_TAG) {
                tag = xpp.getName();
                if (tag.equals("item")) {
                    list.put(no, addr);
                }
            }
 
            event_type = xpp.next();
        }
        printList(list);
    }
    
    /**
     * 결과 값을 출력해본다.
     * @param list
     */
    private void printList(HashMap<String, String> list){
                
        for(Entry<String, String> entity : list.entrySet()){
            entity.getKey();
            entity.getValue();
            System.out.println(entity.getKey() + ", " + entity.getValue());
        }
        
        
    }
    
    
    
    private String getURLParam(String search){
        String url = PHARM_URL+"?ServiceKey="+KEY+"&numOfRows=100";
        if(search != null){
        url = url+"&yadmNm"+search;
        }
        return url;
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new PharmParser();
    }
 
}
 
 