SELECT
    score,
    DENSE_RANK() OVER w AS 'rank'
FROM Scores
    WINDOW w AS (ORDER BY score DESC);