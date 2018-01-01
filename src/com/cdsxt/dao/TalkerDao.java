package com.cdsxt.dao;

import com.cdsxt.po.Talker;

public interface TalkerDao {

    Talker queryByName(String name);

    void add(Talker talker);

}
