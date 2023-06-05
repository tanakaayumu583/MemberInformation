//テーブル作成
CREATE TABLE k_users
(member_id     VARCHAR(13) NOT NULL comment '会員番号',
 last_name    VARCHAR(32) NOT NULL comment '名前_姓',
 first_name VARCHAR(32) NOT NULL comment '名前_名',
 sex  CHAR(1) NOT NULL comment '性別',
 birth_year  INT(4) NOT NULL comment '生年月日_年',
 birth_month   INT(2) NOT NULL comment '生年月日_月',
  birth_day  INT(2) NOT NULL comment '生年月日_日',
 job      VARCHAR(32) NOT NULL comment '職業',
  phone_number VARCHAR(32) NOT NULL comment '電話番号',
 mail_address     VARCHAR(128) NOT NULL comment 'メールアドレス',
  PRIMARY KEY (member_id));
  
  //確認用
  SHOW FULL COLUMNS  FROM k_users;
  
 alter table k_users modify column sex INT(1) NOT NULL;
 alter table k_users modify column job INT(3) NOT NULL;
  









