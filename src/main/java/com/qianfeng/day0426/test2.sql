# 问题描述：
# 为管理岗位业务培训信息，建立3个表:
# S (S#,SN,SD,SA)   S#,SN,SD,SA 分别代表学号、学员姓名、所属单位、学员年龄
# C (C#,CN )        C#,CN       分别代表课程编号、课程名称
# SC ( S#,C#,G )    S#,C#,G     分别代表学号、所选修的课程编号、学习成绩

CREATE TABLE S(
    S INT,
    SN VARCHAR(20),
    SD VARCHAR(20),
    SA INT
);
CREATE TABLE C(
    C VARCHAR(25),
    CN VARCHAR(25)
);
CREATE TABLE SC(
    S INT,
    C VARCHAR(25),
    G INT
);
# 要求实现如下5个处理：
#   1. 使用标准SQL嵌套语句查询选修课程名称为’税收基础’的学员学号和姓名
SELECT S1.S,SN FROM S S1 JOIN SC ON S1.S=SC.S JOIN C ON C.C=SC.C WHERE CN='税收基础';
#   2. 使用标准SQL嵌套语句查询选修课程编号为’C2’的学员姓名和所属单位
SELECT S1.S,SN FROM S S1 JOIN SC ON S1.S=SC.S JOIN C ON C.C=SC.C WHERE CN='税收基础';
#   3. 使用标准SQL嵌套语句查询不选修课程编号为’C5’的学员姓名和所属单位
SELECT SN,SD FROM S S1 JOIN SC ON S1.S=SC.S JOIN C ON C.C=SC.C WHERE C.C!='C5';
#   4. 使用标准SQL嵌套语句查询选修全部课程的学员姓名和所属单位
SELECT COUNT(C)FROM C;
SELECT COUNT(c) FROM SC GROUP BY S;
SELECT SN,SD FROM S S1
    JOIN (SELECT COUNT(c) SCC,S FROM SC GROUP BY S)S2 ON S1.S=S2.S
    JOIN (SELECT COUNT(C) CC FROM C)C
WHERE SCC=CC;
#   5. 查询选修了课程的学员人数
SELECT COUNT(*) FROM SC GROUP BY S;
#   6. 查询选修课程超过5门的学员学号和所属单位
SELECT S.S,SD FROM S JOIN (SELECT COUNT(c) SCC,S FROM SC GROUP BY S)S2 ON S.S=S2.S WHERE SCC>5
#

