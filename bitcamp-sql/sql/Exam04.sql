# FK(Foreign Key)
- 다른 테이블의 PK를 참조하는 컬럼이다.


create table test1(
  no int not null primary key auto_increment,
  title varchar(255) not null,
  content text,
  rdt datetime not null
);

create table test2(
  fno int not null primary key auto_increment,
  filepath varchar(255) not null,
  bno int not null
);


insert into test1(title,rdt) values('aaa',now());
insert into test1(title,rdt) values('bbb',now());
insert into test1(title,rdt) values('ccc',now());
insert into test1(title,rdt) values('ddd',now());
insert into test1(title,rdt) values('eee',now());
insert into test1(title,rdt) values('fff',now());
insert into test1(title,rdt) values('ggg',now());
insert into test1(title,rdt) values('hhh',now());
insert into test1(title,rdt) values('iii',now());
insert into test1(title,rdt) values('jjj',now());



## FK 제약 조건이 없을 때
- 첨부파일 데이터를 입력할 때 존재하지 않는 게시물 번호가 들어 갈 수 있다.

insert into test2(filepath, bno) values('c:/download/x.gif', 100);

- 첨부 파일이 있는 게시물이 삭제될 수 잇다.

delete from test1 where no=1;

## FK(foreign key) 제약 조건 설정

alter table 테이블명
    add constraint 제약조건이름 foreign key (컬럼명) references 테이블명(컬럼명);
    
delete from test2;

alter table test2
    add constraint test2_bno_fk foreign key (bno) references test1(no);

    
    
    
    


