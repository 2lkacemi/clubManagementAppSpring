package com.club_HR.business;

import com.club_HR.persistence.IMemberDao;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.persistence.mapper.MemberMapper;
import com.club_HR.persistence.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MemberServiceImpl implements IMemberService {

    final private IMemberDao iMemberDao;
    final private MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(IMemberDao iMemberDao, MemberMapper memberMapper) {
        this.iMemberDao = iMemberDao;
        this.memberMapper = memberMapper;
    }

    /**
     * add member
     * @param memberDto parameter
     * @return member added
     */
    @Override
    public MemberDto addMember(MemberDto memberDto) {
        this.iMemberDao.save(memberMapper.mapToMemberEntity(memberDto));
        return memberDto;
    }

    /**
     * update a member
     * @param member parameter
     */
    @Override
    public void updateMember(MemberDto member){
        iMemberDao.save(memberMapper.mapToMemberEntity(member));
    }

    /**
     * list all members
     * @return list of all members
     */
    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberEntity> memberEntitiesList = iMemberDao.findAll();

        return memberEntitiesList
                .stream()
                .map(memberMapper::mapToMemberDto)
                .collect(Collectors.toList());
    }

    /**
     * get member using email
     * @param email parameter
     * @return a member if it exists
     */
    @Override
    public MemberDto getMemberByEmail(String email) {
       return iMemberDao.findMemberEntityByEmail(email)
               .map(memberMapper::mapToMemberDto)
               .orElse(null);
    }

    /**
     * remove member using email
     * @param email parameter
     */
    @Transactional(readOnly = false)
    @Override
    public void removeMemberByEmail(String email) {
            iMemberDao.deleteByEmail(email);
    }

}
