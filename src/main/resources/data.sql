INSERT INTO Member
VALUES
  (5400001,'1998-02-01', '2017-08-12' ,'Fred', 'Flintstone'),
  (5400002,'1979-02-08' ,'2017-09-15','Wilma',  'Flintstone'),
  (5400003,'1985-05-05', '2017-09-16','Barney', 'Rubble' ),
  (5400004,'1966-01-07', '2018-11-20','Betty',  'Rubble' ),
  (5400005,'1969-01-07', '2019-11-20','kkk',  'anu' );

INSERT INTO Member_Transaction
VALUES
  ('1',5000,'Salary','Credit',5400001),
  ('2', 200,'Bill Thai restaurant','Debit',5400001),
  ('3',8000,'Salary','Credit',5400002 ),
  ('4',10000, 'Salary','Credit',5400003),
  ('5', 5000,'Salary','Credit',5400004),
  ('6', 100,'bill energy','Debit',5400001),
  ('7',80, 'bill gas','Debit',5400001);