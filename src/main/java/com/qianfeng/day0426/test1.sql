CREATE TABLE Student
(
    SNO       VARCHAR(3) NOT NULL PRIMARY KEY,
    SNAME     VARCHAR(4) NOT NULL,
    SSEX      VARCHAR(2) NOT NULL,
    SBIRTHDAY DATETIME,
    CLASS     VARCHAR(5)
);

CREATE TABLE Course
(
    CNO   VARCHAR(5)  NOT NULL primary key,
    CNAME VARCHAR(10) NOT NULL,
    TNO   VARCHAR(10) NOT NULL
);

CREATE TABLE Score
(
    SNO    VARCHAR(3)     NOT NULL,
    CNO    VARCHAR(5)     NOT NULL,
    DEGREE NUMERIC(10, 1) NOT NULL,
    primary key (SNO, CNO)
);

CREATE TABLE Teacher
(
    TNO       VARCHAR(3)  NOT NULL primary key,
    TNAME     VARCHAR(4)  NOT NULL,
    TSEX      VARCHAR(2)  NOT NULL,
    TBIRTHDAY DATETIME    NOT NULL,
    PROF      VARCHAR(6),
    DEPART    VARCHAR(10) NOT NULL
);

INSERT INTO STUDENT (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (108, '曾华', '男', '1977-09-01', '95033');
INSERT INTO STUDENT (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (105, '匡明', '男', '1975-10-02', '95031');
INSERT INTO STUDENT (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (107, '王丽', '女', '1976-01-23', '95033');
INSERT INTO STUDENT (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (101, '李军', '男', '1976-02-20', '95033');
INSERT INTO STUDENT (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (109, '王芳', '女', '1975-02-10', '95031');
INSERT INTO STUDENT (SNO, SNAME, SSEX, SBIRTHDAY, CLASS)
VALUES (103, '陆君', '男', '1974-06-03', '95031');

INSERT INTO COURSE(CNO, CNAME, TNO)
VALUES ('3-105', '计算机导论', 825);
INSERT INTO COURSE(CNO, CNAME, TNO)
VALUES ('3-245', '操作系统', 804);
INSERT INTO COURSE(CNO, CNAME, TNO)
VALUES ('6-166', '数据电路', 856);
INSERT INTO COURSE(CNO, CNAME, TNO)
VALUES ('9-888', '高等数学', 100);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (103, '3-245', 86);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (105, '3-245', 75);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (109, '3-245', 68);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (103, '3-105', 92);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (105, '3-105', 88);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (109, '3-105', 76);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (101, '3-105', 64);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (107, '3-105', 91);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (108, '3-105', 78);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (101, '6-166', 85);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (107, '6-106', 79);
INSERT INTO SCORE(SNO, CNO, DEGREE)
VALUES (108, '6-166', 81);
INSERT INTO TEACHER(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (804, '李诚', '男', '1958-12-02', '副教授', '计算机系');
INSERT INTO TEACHER(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (856, '张旭', '男', '1969-03-12', '讲师', '电子工程系');
INSERT INTO TEACHER(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (825, '王萍', '女', '1972-05-05', '助教', '计算机系');
INSERT INTO TEACHER(TNO, TNAME, TSEX, TBIRTHDAY, PROF, DEPART)
VALUES (831, '刘冰', '女', '1977-08-14', '助教', '电子工程系');

SELECT *
FROM Score;
SELECT *
FROM Student;
# 题目：
# 1、 查询Student表中的所有记录的Sname、Ssex和Class列。
SELECT SNAME, SSEX, CLASS
FROM Student;
# 2、 查询教师所有的单位即不重复的Depart列。
SELECT DISTINCT DEPART
FROM Teacher;
# 3、 查询Student表的所有记录。
SELECT *
FROM Student;
# 4、 查询Score表中成绩在60到80之间的所有记录。
SELECT *
FROM Score
WHERE DEGREE between 60 and 80;
# 5、 查询Score表中成绩为85，86或88的记录。
SELECT *
FROM Score
WHERE DEGREE IN (85, 86, 88);
# 6、 查询Student表中“95031”班或性别为“女”的同学记录。
SELECT *
FROM Student
WHERE CLASS = 95031
   OR SSEX = '女';
# 7、 以Class降序查询Student表的所有记录。
SELECT *
FROM Student
ORDER BY CLASS DESC;
# 8、 以Cno升序、Degree降序查询Score表的所有记录。
SELECT *
FROM Score
ORDER BY CNO, DEGREE DESC;
# 9、 查询“95031”班的学生人数。
SELECT COUNT(*)
FROM Student
WHERE CLASS = 95031;
# 10、查询Score表中的最高分的学生学号和课程号。
SELECT *
FROM Score
WHERE DEGREE = (SELECT MAX(DEGREE) FROM Score);
SELECT SNO AS '学号', CNO AS '课程号'
FROM Score
order by DEGREE desc
limit 0,1;
# 11、查询‘3-105’号课程的平均分。
SELECT AVG(DEGREE) '3-105的平均分'
FROM SCORE
WHERE CNO = '3-105';
# 12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。81.5
SELECT AVG(DEGREE), CNO
FROM Score
WHERE CNO LIKE '3%'
GROUP BY CNO
HAVING COUNT(CNO) >= 5;
# 13、查询最低分大于70，最高分小于90的Sno列。
SELECT SNO
FROM Score
GROUP BY SNO
HAVING MAX(DEGREE) < 90
   AND MIN(DEGREE) > 70;
# 14、查询所有学生的Sname、Cno和Degree列。
SELECT SNAME, CNO, DEGREE
FROM Student
         JOIN Score S ON Student.SNO = S.SNO;

# 15、查询所有学生的Sno、Cname和Degree列。
SELECT SNO, CNAME, DEGREE
FROM Course
         JOIN Score S ON Course.CNO = S.CNO;
# 16、查询所有学生的Sname、Cname和Degree列。
SELECT SNAME, CNAME, DEGREE
FROM Student
         JOIN Score S on Student.SNO = S.SNO
         JOIN Course C on S.CNO = C.CNO;
# 17、查询“95033”班所选课程的平均分。79.67
SELECT AVG(DEGREE)
FROM Score
         JOIN Student S on Score.SNO = S.SNO
WHERE CLASS = 95033
GROUP BY CNO;
# 18、假设使用如下命令建立了一个grade表：
CREATE TABLE Grade
(
    low    NUMERIC(3, 0),
    upp    NUMERIC(3, 0),
    `rank` CHAR(1)
);
INSERT INTO grade
VALUES (90, 100, 'A');
INSERT INTO grade
VALUES (80, 89, 'B');
INSERT INTO grade
VALUES (70, 79, 'C');
INSERT INTO grade
VALUES (60, 69, 'D');
INSERT INTO grade
VALUES (0, 59, 'E');
# 现查询所有同学的Sno、Cno和rank列。
SELECT SNO, CNO, `rank`
FROM Score
         JOIN Grade ON DEGREE BETWEEN low AND upp;
# 19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
SELECT *
FROM Student
         JOIN Score S on Student.SNO = S.SNO
WHERE CNO = '3-105'
  AND DEGREE > (SELECT Degree FROM Score WHERE Sno = '109' and Cno = '3-105');

SELECT *
FROM Student
         JOIN Score S on Student.SNO = S.SNO
         JOIN Score S2 on S.CNO = S2.CNO AND S.CNO = '3-105' AND S2.SNO = '109' AND S.DEGREE > S2.DEGREE;
# 20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
SELECT *
FROM Score S
WHERE SNO IN (SELECT SNO FROM Score GROUP BY SNO HAVING COUNT(CNO) > 1)
  and DEGREE != (SELECT max(DEGREE) FROM Score WHERE SNO = S.SNO);
SELECT S.*
FROM Score S
JOIN (SELECT MAX(DEGREE) MAX,SNO FROM Score GROUP BY SNO )S2 ON S.SNO=S2.SNO
WHERE S.DEGREE!=S2.MAX;

# 21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
SELECT *
FROM Score
WHERE CNO = '3-105'
  AND DEGREE > (SELECT Degree FROM Score WHERE Sno = '109' AND CNO = '3-105');
# 22、查询和学号为108的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
SELECT SNO, SNAME, SBIRTHDAY
FROM Student
WHERE YEAR(SBIRTHDAY) = (SELECT YEAR(SBIRTHDAY) FROM Student WHERE SNO = 108);
# 23、查询“张旭“教师任课的学生成绩。
SELECT SNO, DEGREE
FROM Score
         JOIN Course C on Score.CNO = C.CNO
         JOIN Teacher T on C.TNO = T.TNO
WHERE TNAME = '张旭';
# 24、查询选修某课程的同学人数多于5人的教师姓名。
SELECT Tname
FROM Teacher T
         JOIN Course C on C.TNO = T.TNO
         JOIN Score S on C.CNO = S.CNO
GROUP BY S.CNO
HAVING COUNT(S.CNO) > 5;
# 25、查询95033班和95031班全体学生的记录。
SELECT *
FROM Student
WHERE CLASS IN (95033, 95031);
# 26、查询存在有85分以上成绩的课程Cno.
SELECT CNO
FROM Score
GROUP BY CNO
HAVING MAX(DEGREE) > 85;

SELECT DISTINCT CNO
FROM Score
WHERE DEGREE > 85;
# 27、查询出“计算机系“教师所教课程的成绩表。
SELECT TNAME, CNAME, SNO, DEGREE
FROM Score
         JOIN Course C on Score.CNO = C.CNO
         JOIN Teacher T on C.TNO = T.TNO
WHERE DEPART = '计算机系';
# 28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
SELECT A.TNAME, A.PROF
FROM Teacher A
WHERE DEPART IN ('计算机系','电子工程系')
  AND PROF NOT IN (SELECT PROF FROM Teacher B WHERE A.DEPART != B.DEPART);
# 29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
SELECT CNO, SNO, DEGREE
FROM Score
WHERE CNO = '3-105'
  AND DEGREE > (SELECT MIN(DEGREE) FROM Score WHERE CNO = '3-245')
ORDER BY DEGREE DESC;
# 30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.
SELECT CNO, SNO, DEGREE
FROM Score
WHERE CNO = '3-105'
  AND DEGREE > (SELECT MAX(DEGREE) FROM Score WHERE CNO = '3-245');
# 31、查询所有教师和同学的name、sex和birthday.
SELECT SNAME NAME, SSEX SEX, SBIRTHDAY BIRTHDAY
FROM Student
UNION ALL
SELECT TNAME NAME, TSEX SEX, TBIRTHDAY BIRTHDAY
FROM Teacher;
# 32、查询所有“女”教师和“女”同学的name、sex和birthday.
SELECT SNAME NAME, SSEX SEX, SBIRTHDAY BIRTHDAY
FROM Student
WHERE SSEX = '女'
UNION ALL
SELECT TNAME NAME, TSEX SEX, TBIRTHDAY BIRTHDAY
FROM Teacher
WHERE TSEX = '女';
# 33、查询成绩比该课程平均成绩低的同学的成绩表。
SELECT *
FROM Score S
WHERE SNO IN (SELECT SNO FROM Score WHERE S.DEGREE < (SELECT AVG(DEGREE) FROM Score WHERE CNO = S.CNO));
SELECT S.*
FROM Score S
         JOIN (
    SELECT AVG(DEGREE) AVG, CNO
    FROM Score
    GROUP BY CNO
) AVG_CNO ON S.CNO = AVG_CNO.CNO
WHERE DEGREE < AVG;
# 34、查询所有任课教师的Tname和Depart.
SELECT TNAME, DEPART
FROM Teacher T
         JOIN Course C on T.TNO = C.TNO;
# 35 查询所有未讲课的教师的Tname和Depart.
SELECT TNAME, DEPART
FROM Teacher
         LEFT JOIN Course C on Teacher.TNO = C.TNO
WHERE ISNULL(CNO);
# 36、查询至少有2名男生的班号。
SELECT CLASS
FROM Student
GROUP BY CLASS
HAVING COUNT(SSEX = '男') >= 2;
# 37、查询Student表中不姓“王”的同学记录。
SELECT *
FROM Student
WHERE SNAME NOT LIKE '王%';
# 38、查询Student表中每个学生的姓名和年龄。
SELECT SNAME '姓名', TIMESTAMPDIFF(YEAR, SBIRTHDAY, curdate()) '年龄'
FROM Student;
# 39、查询Student表中最大和最小的Sbirthday日期值。
SELECT MAX(DATE(SBIRTHDAY)), MIN(DATE(SBIRTHDAY))
FROM Student;
# 40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
SELECT *
FROM Student
ORDER BY CLASS DESC, SBIRTHDAY;
# 41、查询“男”教师及其所上的课程。
SELECT Teacher.*, CNO, CNAME
FROM Teacher
         JOIN Course C on Teacher.TNO = C.TNO
WHERE TSEX = '男';
# 42、查询最高分同学的Sno、Cno和Degree列。
SELECT SNO, CNO, DEGREE
FROM Score
ORDER BY DEGREE DESC
LIMIT 0,1;
# 43、查询和“李军”同性别的所有同学的Sname.
SELECT SNAME
FROM Student
WHERE SSEX = (SELECT SSEX FROM Student WHERE SNAME = '李军');

SELECT Student.SNAME
FROM Student
         JOIN Student S on Student.SSEX = S.SSEX
WHERE S.SNAME = '李军';
# 44、查询和“李军”同性别并同班的同学Sname.
SELECT S.SNAME
FROM Student S
         JOIN Student S1 ON S.SSEX = S1.SSEX AND S1.SNAME = '李军'
         JOIN Student S2 ON S.CLASS = S2.CLASS AND S2.SNAME = '李军';

SELECT S.SNAME
FROM Student S
         JOIN (
    SELECT SSEX, CLASS
    FROM Student
    WHERE SNAME = '李军'
) S2 on S.SSEX = s2.SSEX
WHERE S.CLASS = S2.CLASS;

SELECT S.SNAME
FROM Student S
         JOIN (
    SELECT SSEX, CLASS
    FROM Student
    WHERE SNAME = '李军'
) S2
WHERE S.CLASS = S2.CLASS
  AND S.SSEX = s2.SSEX;
# 45、查询所有选修“计算机导论”课程的“男”同学的成绩表
SELECT Score.*
FROM Score
         JOIN Course C
         JOIN Student S
WHERE CNAME = '计算机导论'
  AND S.SSEX = '男'
  AND Score.CNO = C.CNO
  and Score.SNO = S.SNO;

SELECT Score.*
FROM Score
         JOIN Course C
         JOIN Student S on Score.SNO = S.SNO
WHERE CNAME = '计算机导论'
  AND S.SSEX = '男'
  AND Score.CNO = C.CNO;

SELECT Score.*
FROM Score
         JOIN Course C on Score.CNO = C.CNO
         JOIN Student S on Score.SNO = S.SNO
WHERE CNAME = '计算机导论'
  AND S.SSEX = '男';

SELECT Score.*
FROM Score
         JOIN Course C on Score.CNO = C.CNO
         JOIN Student S on Score.SNO = S.SNO AND S.SSEX = '男'
WHERE CNAME = '计算机导论';

SELECT Score.*
FROM Score
         JOIN Course C on Score.CNO = C.CNO AND C.CNAME = '计算机导论'
         JOIN Student S on Score.SNO = S.SNO AND S.SSEX = '男';