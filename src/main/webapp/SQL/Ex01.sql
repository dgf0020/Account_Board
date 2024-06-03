create sequence reply_seq
    increment by 1
    start with 1000
    minvalue 1000
    maxvalue 9999999999999999999999999
    nocache;
    
create table reply (
    idx         number          default reply_seq.nextval,
    b_idx	    number		    not null,
    nick        varchar2(60)    not null,
    contents    clob,
    w_date      timestamp       default sysdate,

    constraint reply_idx primary key(idx),
    constraint reply_bidx foreign key(b_idx) references board(idx) on delete cascade,
    constraint reply_nick foreign key(nick) references account(nick) on delete cascade
);