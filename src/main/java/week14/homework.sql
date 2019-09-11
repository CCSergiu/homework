USE hr;
# 1. Să se selecteze deptno, enume, job și sal pentru angajatii care au sef-ul cu id-ul 7902.

Select deptno, ename, job, sal
from hr.EMP
where mgr = 7902;

#2. Să se selecteze numele, funcția și salariu pentru angajații care au aceași funcție.

Select ename, job, sal
from hr.EMP
order by job ; #sau : where job = "MANAGER";

#3. Să se selecteze numele, funcția și salariul anual pentru toți angajații din același departament.

Select ename, job, (12*(sal+ifnull(comm,0))) as anualsal, deptno
from hr.emp
order by deptno; #sau: where deptno = 20 ;

#4. Să se selecteze numele, funcția și venitul lunar pentru toți angajații care au venitul lunar mai mare de 2000.
#   Venitul lunar este o funcție care are formula salariu + ifnull(comision, 0)

Select ename, job, (sal+ifnull(comm,0)) as monthlysal
from hr.emp
where (sal+ifnull(comm,0)) > 2000;


#5.Să se selecteze id-ul angajatului, numele, funcția și data angajării pentru toți angajații care au aceași funcție
#  și au venit în firmă după o anumită dată.

Select empno, ename, job, hiredate
from hr.emp
where hiredate>'1982-01-01';


#6. Să se adauge 10 noi angajati.
INSERT INTO EMP VALUES
(7869, 'JOHN', 'CLERK', 7902, '1980-12-17', 800, NULL, 20),
(7899, 'ADRIAN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30),
(7901, 'WINGS', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30),
(7906, 'JIMMY', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20),
(7914, 'MERCEDES', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30),
(7919, 'BORIS', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30),
(7920, 'COLT', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10),
(7922, 'SAM', 'ANALYST', 7566, '1982-12-09', 3000, NULL, 20),
(7939, 'ALISSON', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10),
(7944, 'TIMMY', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30);

#7. Să se calculeze o primă de 15% pentur toți angajații din departamentul 20.

Select ename, deptno, (15*(12*(sal+ifnull(comm,0)))/100) as anualpremium
from hr.emp
where deptno = 20;

#8. Să se selecteze id-ul și numele departamentului din tabela departamente.

Select deptno, dname
from hr.dept;

#9. Să se selecteze id-ul, numele, funcția și data angajării pentru toți angajații din firmă.
# Ordonați descrescător în funcție de id. Concatenați id-ul cu numele.

Select concat(empno, ' ', ename) as id_name, job, hiredate
from hr.emp
order by empno desc;

#10. Să se selecteze id-ul, numele, fucția și venitul lunar pentru toți angajatii din firmă.
# Să se adauge la select o coloană goală care să se numească semnătura. Concatenați id-ul cu numele.
# Ordonați după departament.

Select concat(empno, ' ', ename) as id_name, job, (sal+ifnull(comm,0)) as monthlysal, "" as Signature
from hr.emp
order by deptno;


#11. Să se selecteze numele și funcția angajaților.

Select ename, job
from hr.emp;

#12. Să se facă o listă cu numele departamentului și codul acestuia. Ordonați după numele departamentului.

Select dname, deptno
from hr.dept
order by dname;

#13. Să se selecteze toți angajații care au funcția manager. Ordonați după id-ul departamentului

Select *
from hr.emp
where job = 'MANAGER'
order by deptno;

#14. Selectați toate persoanele care s-au angajat intr-o anumită perioadă aleasa de voi.

Select *
from hr.emp
where Hiredate > '1982-01-01' && Hiredate < '1983-01-01';

#15. Să se listeze id-ul, numele, funcția, venitul lunar pentru angajații care au următoarele
# id-uri: 7499,7902, 7876

Select empno, ename, job, (sal+ifnull(comm,0)) as monthlysal
from hr.emp
where empno = 7499 || empno = 7902 || empno = 7876;

#16. Să se selecteze toate persoanele care au fost angajate în anul 1980

Select *
from hr.emp
where Hiredate >= '1980-01-01' && Hiredate < ' 1981-01-01';

#17. Să se selecteze toate persoanele al căror nume începe cu litera F și numele funcției are 7 caractere.

Select *
from hr.emp
where ename like 'F%' && LENGTH(job) = 7;

#18. Să se listeze angajații din departamentul 20 care nu au primit comision.

Select *
from hr.emp
where deptno = 20 && (comm is null || comm = 0);

#19. Să se listeze angajații care au primit comision și au funcția SALESMAN

Select *
from hr.emp
where comm > 0 && job = 'SALESMAN';

#20. Să se selecteze toți angajații care au funcția MANAGER și salariul peste 1500 și toți angajații care
# au funcția ANALYST.

Select *
from hr.emp
where (JOB = 'MANAGER' && sal > 1500) || (JOB = 'ANALYST');

#21. Selectați toți angajații care s-au angajat înainte de anul 1982 și nu au primit comision.

Select *
from hr.emp
where HIREDATE < '1982-01-01' && (comm is null || comm = 0);

#22. Selectați toți angajații care au salariul peste 3000 și nu au șefi, ordonați după departament.

Select *
from hr.emp
where (sal > 3000 && mgr is null)
order by deptno;

#23. Selectați numele, funcția și venitul anual al angajaților care nu au funcția MANAGER pentru un departament
# ales de voi.

select ename, job, (12*(sal+ifnull(comm,0))) as anualsal
from hr.emp
where deptno = 20 && (job != 'MANAGER');

#24. Selectați departamentul, numele, data angajării și salariul tuturor persoanelor angajate
# în anul 1981 din două departamente alese de voi.

select deptno, ename, hiredate, sal
from hr.emp
where (deptno = 10 || deptno = 20) && (hiredate >= '1981-01-01' && hiredate < '1982-01-01');
