package org.koreait.repositories;

import org.koreait.entities.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> { // 구현체가 만들어짐 (DAO를 대신함)

    Member findByUserId(String userId); // 쿼리메서드

    List<Member> findByRegDtBetween(LocalDateTime sdate, LocalDateTime edate, Pageable pageable);

    List<Member> findByUserNmContainingOrderByRegDtDesc(String userNm);

    @Query("SELECT SEQ_MEMBER.nextVal FROM DUAL")
    long getSequence();

    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE :word ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("word") String keyword);
}
