package com.spring_movie.Dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring.memberDto.memberDto;


public interface MemberDao {

	
	
	@Insert("INSERT INTO MEMBERS(MID, MPW , MNAME, MBIRTH, MEMAIL , MADDRESS , MPROFILE , MSTATE) "
			+ " VALUES(#{mid} ,#{mpw},#{mname},TO_DATE(#{mbirth},'YYYY/MM/DD'),#{memail},#{maddress},#{mprofile},0 )" )
	int insertMember(memberDto member);

	
	//아이디 중복확인
	//여러개의 매개변수를 가져올떄는 (@Param("inputId")String inputId ) 방식으로 파라메터 값을 새로 저장해줘서 사용해야한다 
	@Select("SELECT MID FROM MEMBERS WHERE MID = #{inputId}")
	String selectId(String inputId);
	
	
	//로그인 확인
	@Select("SELECT * FROM MEMBERS WHERE MID = #{inputId} AND MPW = #{inputPw}")
	memberDto SelectMemberLogin(@Param("inputId")String mid, @Param("inputPw")String mpw);


	//내정보 출력
	@Select("SELECT MID, MPW , MNAME,TO_CHAR(MBIRTH , 'yyyy/mm/dd') as MBIRTH, MEMAIL , MADDRESS , MPROFILE , MSTATE"
			+ " FROM MEMBERS WHERE MID = #{loginId}")
	memberDto myInfo(String loginId);

	@Select("SELECT MID,MPROFILE FROM MEMBERS WHERE MID = #{mid}")
	memberDto selectMemberKaKao(String mid);

	@Insert("INSERT INTO MEMBERS(MID, MPW , MNAME, MEMAIL , MPROFILE , MSTATE) "
			+ " VALUES(#{mid} ,#{mpw},#{mname},#{memail},#{mprofile}, 2 )" )
	void insertMemberKaKao(memberDto member);

	
	
	
}
