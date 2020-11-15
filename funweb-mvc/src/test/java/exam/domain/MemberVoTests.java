package exam.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.java.Log;

/*
JUnit이 하나의 테스트클래스를 가져와서 테스트를 수행하는 순서

1. 테스트클래스에서 JUnit 관련 애노테이션이 붙은 메소드를 모두 찾는다.
2. BeforeAll static 메소드가 있으면 실행한다.
3. 테스트클래스의 오브젝트를 하나 만든다.
4. @BeforeEach 메소드가 있으면 실행한다.
5. @Test 메소드를 하나 호출하고 테스트 결과를 저장해 둔다.
6. @AfterEach 메소드가 있으면 실행한다.
7. 나머지 @Test 메소드에 대해 앞의 3~6번을 반복한다.
8. @AfterAll 메소드가 있으면 실행한다.
9. 모든 테스트의 결과를 종합해서 돌려준다.
*/

@DisplayName("MemberVo에 대한 테스트케이스 클래스")
@Log
public class MemberVoTests {
	
	private MemberVo member;
	
	@BeforeAll
	static void initAll() {
		log.info("@BeforeAll - initAll() 호출됨");
	}
	
	@BeforeEach
	void init() {
		log.info("@BeforeEach - init() 호출됨");
		
		// 픽스처 준비
		// 픽스처(Fixture): 테스트를 수행하는데 필요한 정보나 오브젝트
		member = new MemberVo("admin", "1234", "관리자", null, "admin@admin.com", null, LocalDateTime.now(), "서울시", "02-1111-1111", "010-1111-1111");
	}
	
	@Disabled
	@DisplayName("테스트 예제 메소드입니다.")
	@Test
	void testExam() {
		log.info("@Test - testExam() 호출됨");
	}
	
	
	@DisplayName("MemberVo 객체 복사 테스트")
	@Test
	void testClone() throws CloneNotSupportedException {
		log.info("@Test - testClone() 호출됨");
		
		MemberVo memberClone = (MemberVo) member.clone();
		
		//memberClone.setName("홍길동");
		
		// assert 류의 검증메소드 사용으로 테스트케이스 작성
		assertNotSame(member, memberClone);
		assertEquals(member.getId(), memberClone.getId());
		assertEquals(member.toString(), memberClone.toString());
	}
	
	@AfterEach
	void tearDown() {
		log.info("@AfterEach - tearDown() 호출됨");
	}
	
	@AfterAll
	static void tearDownAll() {
		log.info("@AfterAll - tearDownAll() 호출됨");
	}

}





