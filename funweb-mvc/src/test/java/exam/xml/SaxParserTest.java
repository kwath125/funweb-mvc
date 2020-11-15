package exam.xml;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.jupiter.api.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import lombok.extern.java.Log;


class PersonHandler extends DefaultHandler {
	
	private List<PersonDto> list;
	private PersonDto dto;
	private StringBuilder sb;
	
	public PersonHandler() {
		list = new ArrayList<>();
		sb = new StringBuilder();
	}

	public List<PersonDto> getList() {
		return list;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("person")) {
			dto = new PersonDto();
			
			String strId = attributes.getValue("id");
			dto.setId(Integer.parseInt(strId));
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		sb.append(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("name")) {
			dto.setName(sb.toString().trim());
		} else if (qName.equals("company")) {
			dto.setCompany(sb.toString().trim());
		} else if (qName.equals("person")) {
			list.add(dto);
		}
		sb.setLength(0);
	}
} // class PersonHandler


@Log
public class SaxParserTest {

	@Test
	void testParseFile() {
		String path = SaxParserTest.class.getResource(".").getPath();
		log.info("path: " + path);
		
		// 읽어들일 XML파일 객체 준비
		File file = new File(path, "personList.xml");
		log.info(file.getPath());
		assertTrue(file.exists());
		
		// SAX 파서 객체 준비하기
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		
		PersonHandler handler = new PersonHandler();
		
		try {
			parser = factory.newSAXParser();
			// 파싱 수행하기
			parser.parse(file, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파싱결과를 핸들러로부터 가져오기
		List<PersonDto> list = handler.getList();
		
		// 파싱결과 출력하기
		for (PersonDto dto : list) {
			System.out.println(dto);
		}
	} // testParseFile()
	
	
	@Test
	void testParseMovieCompany() {
		
		String str = "http://kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyList.xml?key=430156241533f1d058c603178cc3ca0e";
		
		HttpURLConnection con = null;
		try {
			URL url = new URL(str);
			con = (HttpURLConnection) url.openConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// SAX 파서 객체 준비하기
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		
		CompanyHandler handler = new CompanyHandler();
		
		try {
			parser = factory.newSAXParser();
			// 파싱 수행하기
			parser.parse(con.getInputStream(), handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 핸들러로부터 파싱결과 가져오기
		List<CompanyDto> list = handler.getList();
		
		// 파싱결과 출력하기
		for (CompanyDto dto : list) {
			System.out.println(dto);
		}
	} // testParseMovieCompany()
}


