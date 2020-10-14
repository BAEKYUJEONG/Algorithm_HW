#HWDB02

use ssafydb;

#1
select e.ENAME, e.DEPTNO, d.DNAME  
from EMP e, DEPT d
where e.DEPTNO = d.DEPTNO
and e.DEPTNO = 30;

#2
select distinct e.job, d.loc from EMP e, DEPT d
where e.DEPTNO = d.DEPTNO and e.DEPTNO = 30;

#3
select ename, dname, loc from emp e, dept d
where comm is not null and e.deptno = d.deptno;

#4
select ename, dname from emp e, dept d
where ename like '%A%' and e.deptno = d.deptno;

#5
select ename, job, d.deptno, dname from emp e, dept d
where loc = 'Dallas' and e.deptno = d.deptno;

#6 ★ 방법을 유심히
select e.ename employee, e.empno 'emp#', m.ename manager, m.empno 'mgr#'
from emp e, emp m
where e.mgr = m.empno;

#7 ★ 3개 테이블과 between
select ename, job, dname, sal, grade from emp e, dept d, salgrade s
where e.deptno = d.deptno and e.sal between s.losal and s.hisal;

#8
select ename, hiredate from emp
where hiredate > (select hiredate from emp where ename='Smith');

#9
select e.ename Employee, e.hiredate EmpHiredate, m.ename Manager, m.hiredate MgrHiredate
from emp e, emp m
where e.mgr = m.empno
and e.hiredate < m.hiredate;

#10 ★ date_format 이용가능
select ename, date_format(hiredate, '%Y-%m-%d') '입사일' from emp
where deptno in (select deptno from emp where ename='Smith')
and ename != 'Smith';

#11 ★ avg 구할때는 반드시 한번더 select문을 사용
select empno, ename, sal from emp
where sal > (select AVG(sal) from emp)
order by sal DESC;

#12
select empno, ename from emp
where deptno in (select deptno from emp where ename like '%T%');

#13
select empno, ename, sal from emp
where sal > (select AVG(sal) from emp)
and deptno in (select deptno from emp where ename like '%T%');

#14 ★ ALL
select empno, ename, sal from emp
where sal > ALL(select sal from emp where job='Clerk')
order by sal DESC;

#15 ★ ifnull
select ename, dname from emp e, dept d
where e.deptno = d.deptno
and sal in (select sal from emp e, dept d 
			where e.deptno = d.deptno and loc='New York')
and ifnull(comm,0) in (select ifnull(comm,0) from emp e, dept d 
			where e.deptno = d.deptno and loc='New York');
