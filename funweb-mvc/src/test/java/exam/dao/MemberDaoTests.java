package exam.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import exam.domain.MemberVo;
import lombok.extern.java.Log;

@Log
public class MemberDaoTests {
	// 픽스처
	private MemberDao dao;
	private MemberVo member1, member2, member3;
	
	@BeforeEach
	void init() {
		dao = MemberDao.getInstance();
		
		member1 = new MemberVo("admin", "1234", "관리자", null, "admin@admin.com", null, LocalDateTime.now().withNano(0), "서울시", "02-1111-1111", "010-1111-1111");
		member2 = new MemberVo("aaa", "1234", "성춘향", null, "aaa@a.com", null, LocalDateTime.now().withNano(0), "부산시", "051-2222-2222", "010-2222-2222");
		member3 = new MemberVo("bbb", "1234", "이몽룡", null, "bbb@b.com", null, LocalDateTime.now().withNano(0), "울산시", "052-3333-3333", "010-3333-3333");
	}
	
	@DisplayName("insert문과 select문 수행 메소드 테스트")
	@Test
	void addAndGet() throws SQLException {
		log.info("@Test - addAndGet()");
		
		// 조건
		dao.deleteAll();
		assertEquals(0, dao.getCount());
		
		// 행위
		dao.insert(member1);
		dao.insert(member2);
		
		// 결과
		assertEquals(2, dao.getCount());
		
		
		// 행위
		MemberVo memberGet1 = dao.getMemberById(member1.getId());
		
		// 결과 (assert 메소드로 결과 검증)
		assertNotNull(memberGet1);
		assertEquals(member1.getName(), memberGet1.getName());
		assertEquals(member1.getPasswd(), memberGet1.getPasswd());
		
		// 긍정테스트(positive test) - 존재하는 아이디로 레코드 가져오기
		MemberVo memberGet2 = dao.getMemberById(member2.getId());
		assertNotNull(memberGet2);
		assertEquals(member2.toString(), memberGet2.toString());
		
		// 부정테스트(negative test) - 존재하지 않는 아이디로 레코드 가져올때는 null 리턴
//		MemberVo memberGet3 = dao.getMemberById("unknown_id");
//		assertNull(memberGet3);
	}
	
	
	@Test
	void getMemberFailure() {
		log.info("@Test - getMemberFailure()");
		
		// 조건
		dao.deleteAll();
		assertEquals(0, dao.getCount());
		
		// 부정테스트(negative test)
		// 존재하지 않는 id로 레코드 가져오기 하면
		// 예외가 발생해야 테스트 성공해야함
		
		// 예외객체의 타입 검사
		Throwable exception = assertThrows(SQLException.class, new Executable() {
			
			@Override
			public void execute() throws Throwable {
				dao.getMemberById("unknown_id");
			}
		});
		
		// 예외객체의 메시지 검사
		assertEquals("id에 해당하는 MemberVo가 없습니다.", exception.getMessage());
	}
	
	@Test
	void testIsIdDuplicated() {
		log.info("@Test - testIsIdDuplicated()");
		
		// 조건
		dao.deleteAll();
		assertEquals(0, dao.getCount());
		
		assertFalse(dao.isIdDuplicated(member1.getId()));
		
		dao.insert(member1);
		assertEquals(1, dao.getCount());
		
		assertTrue(dao.isIdDuplicated(member1.getId()));
	}
	
	
	@Test
	void testUpdate() throws SQLException {
		log.info("@Test - testUpdate()");
		
		// 조건
		dao.deleteAll();
		assertEquals(0, dao.getCount());
		
		dao.insert(member1);
		assertEquals(1, dao.getCount());
		
		// 행위 - 이름을 "홍길동"으로 수정하기
		member1.setName("홍길동");
		dao.update(member1);
		
		// 결과 - 이름이 "홍길동"으로 수정됐는지 확인하기
		MemberVo memberGet1 = dao.getMemberById(member1.getId());
		assertNotNull(memberGet1);
		assertEquals(member1.getName(), memberGet1.getName());
	}


	@Test
	void testDeleteById() {
		log.info("@Test - testDeleteById()");
		
		// 조건
		dao.deleteAll();
		assertEquals(0, dao.getCount());
		
		dao.insert(member1);
		assertEquals(1, dao.getCount());
		
		dao.insert(member2);
		assertEquals(2, dao.getCount());
		
		dao.deleteById(member1.getId());
		assertEquals(1, dao.getCount());
		
		dao.deleteById(member2.getId());
		assertEquals(0, dao.getCount());
	}
	
	
	// 테스트 일관성을 유지하는 작업이 필요함
	// DB 테이블 테스트라면  deleteAll()  getCount() 메소드 필요
	@DisplayName("count 수행 메소드 테스트")
	@Test
	void count() {
		log.info("@Test - count()");
		
		dao.deleteAll();
		assertEquals(0, dao.getCount());
		
		dao.insert(member1);
		assertEquals(1, dao.getCount());
		
		dao.insert(member2);
		assertEquals(2, dao.getCount());
		
		dao.insert(member3);
		assertEquals(3, dao.getCount());
	}
	
	
}






