package za.ac.cput.repository.impl;
import za.ac.cput.entity.Member;
import za.ac.cput.repository.MemberRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Author: Lisakhanya Tshokolo
 * (220239215)
 * 26 March 2026
 */

public class MemberRepositoryImpl implements MemberRepository {

    private static MemberRepositoryImpl repository;
    private Map<String, Member> membersMap;

    private MemberRepositoryImpl() {
        membersMap = new HashMap<>();
    }

    public static MemberRepositoryImpl getRepository() {
        if (repository == null) {
            repository = new MemberRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Member create(Member member) {
        if (!membersMap.containsKey(member.getMemberId())) {
            membersMap.put(member.getMemberId(), member);
        }
        return membersMap.get(member.getMemberId());
    }

    @Override
    public Member read(String memberId) {
        return membersMap.get(memberId);
    }

    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Member findById(String s) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public Member update(Member member) {
        if (membersMap.containsKey(member.getMemberId())) {
            membersMap.put(member.getMemberId(), member);
            return member;
        }
        return null;
    }

    @Override
    public boolean delete(String memberId) {
        return membersMap.remove(memberId) != null;
    }

    @Override
    public List<Member> getAll() {
        return new ArrayList<>(membersMap.values());
    }
}