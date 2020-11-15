package exam.xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

public class JsonParserTest {

	@Test
	void testGson() {
		
		String str = "http://kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyList.json?key=430156241533f1d058c603178cc3ca0e";
		
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			URL url = new URL(str);
			con = (HttpURLConnection) url.openConnection();
			
			reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Map<String, Object> map = gson.fromJson(reader, HashMap.class);
		
		System.out.println(map);
		
		Map<String, Object> resultMap = (Map<String, Object>) map.get("companyListResult");
		List<Map<String, String>> companyList = (List<Map<String, String>>) resultMap.get("companyList");
		
		for (Map<String, String> rowMap : companyList) {
			System.out.println(rowMap);
		}
		
	} // testGson()
	
	
	@Test
	void testJsonSimple() {
		
		String str = "http://kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyList.json?key=430156241533f1d058c603178cc3ca0e";
		
		HttpURLConnection con = null;
		BufferedReader reader = null;
		JSONObject jsonObject = null;
		
		try {
			URL url = new URL(str);
			con = (HttpURLConnection) url.openConnection();
			
			reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			
			// JSON 파서 객체 준비
			JSONParser parser = new JSONParser();
			// 파서로 파싱을 수행
			// JSONArray 또는 JSONObject 둘중에 한개로 리턴됨
			jsonObject = (JSONObject) parser.parse(reader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(jsonObject);
		
		JSONObject companyListResult = (JSONObject) jsonObject.get("companyListResult");
		JSONArray companyList = (JSONArray) companyListResult.get("companyList");
		
		System.out.println(companyList);
		
		// JSONArray를 ArrayList로 변환하기
		List<CompanyDto> list = new ArrayList<>();
		
		for (int i=0; i<companyList.size(); i++) {
			CompanyDto dto = new CompanyDto();
			JSONObject company = (JSONObject) companyList.get(i);
			
			dto.setCompanyCd((String) company.get("companyCd"));
			dto.setCompanyNm((String) company.get("companyNm"));
			String strFilmoNames = (String) company.get("filmoNames");
			if (strFilmoNames.length() > 0) {
				String[] strArr = strFilmoNames.split(",");
				// String[] -> List 변환
				List<String> filmoNames = Arrays.asList(strArr);
				dto.setFilmoNames(filmoNames);
			}
			
			list.add(dto);
		} // for
		
		// 변환결과 출력
		for (CompanyDto dto : list) {
			System.out.println(dto);
		}
		
	} // testJsonSimple()
	
}







