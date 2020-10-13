#HWDB01
#1
select * from EMP where year(HIREDATE) = 2014;
#2
select * from EMP where ENAME like'%S%';
#3
select * from EMP where COMM is NULL;
#4
select ENAME, DEPTNO, SAL, SAL*12+(SAL*1.5) as YEARSAL  from EMP where DEPTNO=30;
#5
select ENAME, SAL, (SAL*0.15) '경조비' from EMP where SAL>=2000;