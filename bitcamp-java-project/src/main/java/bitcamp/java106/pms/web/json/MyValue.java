package bitcamp.java106.pms.web.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tour")
public class MyValue {

    @RequestMapping("{no}")
    public Object tour(@PathVariable int no) {
        BufferedReader br = null;

        //현재 날짜 받아오기
        SimpleDateFormat day = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
        SimpleDateFormat hr = new SimpleDateFormat("hh", Locale.KOREA);
        SimpleDateFormat min = new SimpleDateFormat("mm", Locale.KOREA);
        Calendar c1 = Calendar.getInstance();
        int today = Integer.parseInt(day.format(c1.getTime()));
        int hours = Integer.parseInt(hr.format(c1.getTime()));
        int minutes = Integer.parseInt(min.format(c1.getTime()));

        
        List<Object> list = new ArrayList<Object>();
        // 기상청 데이터 업데이트 시간 + kkmm 형식으로 변경
        if(minutes < 40) {
            hours = hours -1;
            if(hours < 0) {
                today = today -1;
                hours = 23;
            }
        }

        String base_time;
        if (hours < 10) {
            base_time = "0" + hours + "00";
        } else {
            base_time = hours + "00";
        }
        //System.out.println(base_time);




        try {
            String urlstr = "http://api.visitkorea.or.kr/openapi/"
                    + "service/rest/KorService/areaBasedList"
                    + "?ServiceKey=j2KT0WiQsYIQ1daSvlJI9F2%2Be0F0UW%2BacYymDWHHCX3BTq8ObPmb7WJSFxmIkLzxJDpIG%2BgjCRY1GqbWupOSlQ%3D%3D"
                    + "&pageNo="
                    + "1"
                    + "&startPage="
                    + "1"
                    + "&numOfRows="
                    + "100"
                    + "&pageSize="
                    + "100"
                    + "&MobileApp="
                    + "AppTest"
                    + "&MobileOS="
                    + "ETC"
                    + "&arrange="
                    + "A"
                    + "&contentTypeId="
                    + no
                    + "&areaCode="
                    + "39"
                    + "&listYN="
                    + "Y"
                    + "&_type=json";
            URL url = new URL(urlstr);
            //System.out.println(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

            String result = "";
            String line;
            while((line = br.readLine()) != null) {
                result = result + line + "\n";
            }
            // System.out.println(result);

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(result);

            // Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
            JSONObject parse_response = (JSONObject) obj.get("response");
            // response 로 부터 body 찾아옵니다.
            JSONObject parse_body = (JSONObject) parse_response.get("body");
            // body 로 부터 items 받아옵니다.
            JSONObject parse_items = (JSONObject) parse_body.get("items");

            // items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
            JSONArray parse_item = (JSONArray) parse_items.get("item");
            for(int i=0 ; i<parse_item.size() ; i++){
                HashMap<String, Object> map = new HashMap<>();
                JSONObject tempObj = (JSONObject) parse_item.get(i);
                if( tempObj.get("mapx") instanceof String ) {

                    if( tempObj.get("mapx") instanceof Double ) {
                        break;
                    }
                    else if( ((String)tempObj.get("mapx")).indexOf(".") > 0) {
                        Double.parseDouble((String) tempObj.get("mapx"));
                        continue;
                    }
                }

                if( tempObj.get("mapy") instanceof String ) {

                    if( tempObj.get("mapy") instanceof Double ) {
                        break;
                    }
                    else if( ((String)tempObj.get("mapy")).indexOf(".") > 0) {
                        Double.parseDouble((String) tempObj.get("mapy"));
                        continue;
                    }
                }

                Double mapx = (Double) tempObj.get("mapx");
                Double mapy = (Double) tempObj.get("mapy");
                String addr1 = (String) tempObj.get("addr1");
                String title = (String) tempObj.get("title");
                String firstimage = (String) tempObj.get("firstimage");

                map.put("mapx", mapx);
                map.put("mapy", mapy);
                map.put("addr1", addr1);
                map.put("title", title);
                map.put("firstimage", firstimage);
                list.add(map);
                //                ArrayList<Object> list = new ArrayList<Object>();
                //                for (int s = 0; s <tempObj.size() s++;)
                //                list[s].add(mapx);
                //                list.add(mapy);

                System.out.println(map);
            }


            //long vec = (Long) vec_item.get("obsrValue");
            //System.out.println(vec);
            //System.out.println(vec);
            //String vector;

            /*if(vec < 45) {
                vector = "북";
            } else if(44 < vec && vec < 135) {
                vector = "동";
            } else if(134 < vec && vec < 225) {
                vector = "남";
            } vector = "서";*/

            /*map.put("temp", temp_item.get("obsrValue").toString());
            map.put("vec", vector);
            map.put("wsd", wsd_item.get("obsrValue").toString());*/
            br.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }

}