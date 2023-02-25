SELECT e.name AS Employee FROM (
    Employee AS e
    INNER JOIN
    Employee AS m
    ON e.managerId = m.id AND e.salary > m.salary
);

--

SELECT name AS Employee FROM Employee AS e
WHERE salary > (
    SELECT sum(salary) FROM Employee
    WHERE id = e.managerId
);