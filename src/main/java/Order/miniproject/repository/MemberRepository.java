package Order.miniproject.repository;

import Order.miniproject.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

  private final EntityManager em;

  public void save(Member member){
    em.persist(member);
  }

  public Member findById(Long id){
    return em.find(Member.class, id);
  }

  public List<Member> findByName(String name){
    return em.createQuery("select m from Member m where m.name =:name", Member.class)
        .setParameter("name", name)
        .getResultList();
  }

  public Optional<Member> findByLoginId(String loginId){
    Optional<Member> member = em.createQuery("select m from Member m where m.loginId =:loginId", Member.class)
                                .setParameter("loginId", loginId)
                                .getResultList()
                                .stream()
                                .filter(m -> m.getLoginId().equals(loginId))
                                .findAny();
    return member;
  }

  public List<Member> findAll(){
    return em.createQuery("select m from Member m", Member.class)
        .getResultList();
  }
}
