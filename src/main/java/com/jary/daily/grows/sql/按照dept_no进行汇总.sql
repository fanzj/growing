select dept_no,group_concat(emp_no) employees
from dept_emp
group by dept_no;