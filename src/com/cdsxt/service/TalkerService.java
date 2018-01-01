package com.cdsxt.service;

import com.cdsxt.po.Talker;

public interface TalkerService {

    Talker queryByName(String name);

    void add(Talker talker);
}
