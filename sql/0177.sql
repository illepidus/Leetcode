CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SELECT N - 1 INTO N;
    RETURN (
        SELECT
            IF(count(*) > 0, salary, null) AS SecondHighestSalary
        FROM (
                 SELECT salary FROM Employee
                 GROUP BY salary
                 ORDER BY salary DESC
                 LIMIT 1 OFFSET N
             ) AS employee
    );
END