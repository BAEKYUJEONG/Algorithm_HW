#HWDB03

use ssafydb;

#1 
select e.employee_id, e.first_name, job_id, d.department_id, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where e.job_id in (select job_id from employees where first_name = 'Diana');
#"in"과 "="이 둘 다 사용가능


#2
select a.employee_id, a.first_name, j.job_title, d.department_name
from (select employee_id, first_name, job_id, department_id
		from employees
        where manager_id = (select manager_id
							from employees
                            where first_name = 'Bruce')
		) a
inner join jobs j
on a.job_id = j.job_id
inner join departments d
on a.department_id = d.department_id;
# select 해두고 전체를 a로 alias 설정할 수도 있다.


#3
select employee_id, first_name, hire_date
from employees
order by hire_date limit 5, 5;
#0부터 시작이므로 6~10번째는 5항부터 5개

