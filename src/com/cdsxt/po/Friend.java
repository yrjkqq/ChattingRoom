package com.cdsxt.po;

import javax.persistence.*;

@Entity
@Table(name = "test_friend")
public class Friend {

    @Id
    @SequenceGenerator(name = "friendGen", sequenceName = "seq_test_friend")
    @GeneratedValue(generator = "friendGen")
    private Integer fid;

    @ManyToOne
    @JoinColumn(name = "tid")
    private Talker talker;

    @ManyToOne
    @JoinColumn(name = "talker_friend_id")
    private Talker talkerFriend;


}
