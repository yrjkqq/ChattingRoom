package com.cdsxt.service.impl;

import com.cdsxt.dao.TalkerDao;
import com.cdsxt.po.Talker;
import com.cdsxt.service.TalkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TalkerServiceImpl implements TalkerService {

    @Autowired
    private TalkerDao talkerDao;

    @Override
    public Talker queryByName(String name) {
        return talkerDao.queryByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void add(Talker talker) {
        this.talkerDao.add(talker);
    }

}
