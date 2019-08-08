-- Selecting TCASASCH and running the following SQL
SELECT DISTINCT uc.constraint_name,
                ucc1.TABLE_NAME  as source_table,
                ucc1.column_name as source_column,
                ucc2.TABLE_NAME  as reference_table,
                ucc2.column_name as reference_column,
                uc.OWNER
FROM all_constraints uc,
     all_cons_columns ucc1,
     all_cons_columns ucc2
WHERE uc.constraint_name = ucc1.constraint_name
  AND uc.r_constraint_name = ucc2.constraint_name
  AND ucc1.POSITION = ucc2.POSITION -- Correction for multiple column primary keys.
  AND uc.constraint_type = 'R'
  AND (ucc2.TABLE_NAME = 'TMNVIOL' OR ucc1.TABLE_NAME = 'TMNVIOL')
--AND (ucc2.column_name = 'SURVEY_FK' OR ucc1.column_name = 'SURVEY_FK')
  AND uc.OWNER IN ('UTV80')
ORDER BY ucc1.TABLE_NAME;

--INSERT query with initial table
INSERT INTO AMALYUCHIK.DTM_QRY(QRY_ID,
                               QRY_NAME,
                               QRY_NOTES,
                               QRY_TABLE,
                               QRY_CR_TS,
                               QRY_MD_TS,
                               QRY_CR_BY,
                               QRY_MD_BY,
                               QRY_SCHEMA)
SELECT amalyuchik.dtm_qry_seq.NEXTVAL,
       'Query with Rob on TMNVIOL table',
       'TMNVIOL table start',
       'TMNVIOL',
       TO_DATE('07-18-2019', 'mm-dd-yyyy'),
       null,
       'amalyuchik@utah.gov',
       null,
       'UTV80'
FROM DUAL;

--INSERT JOIN based on the results of constrains pulled
INSERT INTO AMALYUCHIK.DTM_JOIN (JOIN_ID,
                                 JOIN_NAME,
                                 JOIN_LEFT_TABLE,
                                 JOIN_RIGHT_TABLE,
                                 JOIN_LEFT_FIELD,
                                 JOIN_RIGHT_FIELD,
                                 JOIN_NOTES,
                                 JOIN_CR_TS,
                                 JOIN_MD_TS,
                                 JOIN_CR_BY,
                                 JOIN_MD_BY)
SELECT amalyuchik.dtm_join_seq.NEXTVAL,
       'Second Join to Second Query to include TMNVIOL table',
       'TMNVIOL',
       'TCCVIOL',
       'TMNVTYPE_IS_NUMBER',
       'TMNVTYPE_IS_NUMBER',
       'Another Join with Rob on TMNVIOL table',
       TO_DATE('07-18-2019', 'mm-dd-yyyy'),
       null,
       'amalyuchik@utah.gov',
       null
from DUAL;

--INSERT Join Type (JOIN) for the previous join
INSERT INTO AMALYUCHIK.DTM_JOIN2JOIN_TYP(JOIN_ID,
                                         JOIN_TYPE_ID,
                                         QRY_ID,
                                         JOIN2JOIN_TYPE_CR_TS,
                                         JOIN2JOIN_TYPE_MD_TS,
                                         JOIN2JOIN_TYPE_CR_BY,
                                         JOIN2JOIN_TYPE_MD_BY)
SELECT amalyuchik.dtm_join_seq.CURRVAL, 2, 3, TO_DATE('07-18-2019', 'mm-dd-yyyy'), null, 'amalyuchik@utah.gov', null
from DUAL;

--CONNECT Query to JOIN child record
INSERT INTO AMALYUCHIK.DTM_QRY2JOIN(QRY2JOIN_ID,
                                    QRY_ID,
                                    JOIN_ID,
                                    QRY2JOIN_CR_TS,
                                    QRY2JOIN_MD_TS,
                                    QRY2JOIN_CR_BY,
                                    QRY2JOIN_MD_BY)
SELECT amalyuchik.dtm_qry2join_seq.NEXTVAL,
       3,
       5,
       TO_DATE('07-18-2019', 'mm-dd-yyyy'),
       null,
       'amalyuchik@utah.gov',
       null
from DUAL;

--INSERT another join (LEFT OUTER)
INSERT INTO AMALYUCHIK.DTM_JOIN (JOIN_ID,
                                 JOIN_NAME,
                                 JOIN_LEFT_TABLE,
                                 JOIN_RIGHT_TABLE,
                                 JOIN_LEFT_FIELD,
                                 JOIN_RIGHT_FIELD,
                                 JOIN_NOTES,
                                 JOIN_CR_TS,
                                 JOIN_MD_TS,
                                 JOIN_CR_BY,
                                 JOIN_MD_BY)
SELECT amalyuchik.dtm_join_seq.NEXTVAL,
       'Third Join to Second Query to include TCASASCH table',
       'TCASASCH',
       'TMNMNR',
       'TMNMNR_ST_CODE',
       'TMNMNR_ST_CODE',
       'Third Join Notes Left OUter Join',
       TO_DATE('07-18-2019', 'mm-dd-yyyy'),
       null,
       'amalyuchik@utah.gov',
       null
from DUAL;

--INSERT Join Type (LEFT OUTER JOIN) for the previous join
INSERT INTO AMALYUCHIK.DTM_JOIN2JOIN_TYP(JOIN_ID,
                                         JOIN_TYPE_ID,
                                         JOIN2JOIN_TYPE_CR_TS,
                                         JOIN2JOIN_TYPE_MD_TS,
                                         JOIN2JOIN_TYPE_CR_BY,
                                         JOIN2JOIN_TYPE_MD_BY,
                                         QRY_ID)
SELECT amalyuchik.dtm_join_seq.CURRVAL, 2, TO_DATE('07-18-2019', 'mm-dd-yyyy'), null, 'amalyuchik@utah.gov', null, 2
from DUAL;

--INSERT Query to JOIN second child record
INSERT INTO AMALYUCHIK.DTM_QRY2JOIN(QRY2JOIN_ID,
                                    QRY_ID,
                                    JOIN_ID,
                                    QRY2JOIN_CR_TS,
                                    QRY2JOIN_MD_TS,
                                    QRY2JOIN_CR_BY,
                                    QRY2JOIN_MD_BY)
SELECT amalyuchik.dtm_qry2join_seq.NEXTVAL,
       2,
       4,
       TO_DATE('07-18-2019', 'mm-dd-yyyy'),
       null,
       'amalyuchik@utah.gov',
       null
from DUAL;

--INSERT additional join filter TSAANLYT_IS_NUMBER = 18
INSERT INTO AMALYUCHIK.DTM_JOIN_FLTR(JOIN_FLTR_ID,
                                     JOIN_FLTR_FIELD,
                                     JOIN_FLTR_COMPARATOR,
                                     JOIN_FLTR_ARGUMENT,
                                     JOIN_FLTR_NOTES,
                                     JOIN_FLTR_CR_TS,
                                     JOIN_FLTR_MD_TS,
                                     JOIN_FLTR_CR_BY,
                                     JOIN_FLTR_MD_BY)
SELECT amalyuchik.dtm_join_fltr_seq.NEXTVAL,
       'CCR_REPORTING_YEAR',
       'eq',
       2009,
       'Filter Notes with Rob Just for fun',
       TO_DATE('07-18-2019', 'mm-dd-yyyy'),
       null,
       'amalyuchik@utah.gov',
       null
from DUAL;

--Connect FILTER to JOIN
INSERT INTO AMALYUCHIK.DTM_JOIN2JOIN_FLTR(JOIN_ID,
                                          JOIN_FLTR_ID,
                                          JOIN2JOIN_FLTR_CR_TS,
                                          JOIN2JOIN_FLTR_MD_TS,
                                          JOIN2JOIN_FLTR_CR_BY,
                                          JOIN2JOIN_FLTR_MD_BY)
VALUES (5, 4, TO_DATE('07-18-2019', 'mm-dd-yyyy'), null, 'amalyuchik@utah.gov', null);

--connect Filter to logic gate
INSERT INTO AMALYUCHIK.DTM_JOIN_FLTR2LGC_GT(JOIN_FLTR_ID,
                                            LOGIC_GATE_ID,
                                            JOIN_FLTR_LG_CR_TS,
                                            JOIN_FLTR_LG_MD_TS,
                                            JOIN_FLTR_LG_CR_BY,
                                            JOIN_FLTR_LG_MD_BY)
VALUES (4, 2, TO_DATE('07-18-2019', 'mm-dd-yyyy'), null, 'amalyuchik@utah.gov', null);

--SELECT ALL QUERIES WITH THEIR JOINS AND FILTERS
SELECT qry.QRY_NAME,
       qry.QRY_SCHEMA,
       qry.QRY_TABLE,
       typ.JOIN_TYPE_NAME,
       oin.JOIN_LEFT_TABLE,
       oin.JOIN_LEFT_FIELD,
       oin.JOIN_RIGHT_TABLE,
       oin.JOIN_RIGHT_FIELD,
       gt.LOGIC_GATE_NAME,
       fltr.JOIN_FLTR_FIELD,
       fltr.JOIN_FLTR_COMPARATOR,
       fltr.JOIN_FLTR_ARGUMENT
FROM DTM_QRY qry
         JOIN DTM_QRY2JOIN oin2 ON qry.qry_id = oin2.QRY_ID
         JOIN DTM_JOIN oin ON oin2.JOIN_ID = oin.JOIN_ID
         JOIN DTM_JOIN2JOIN_TYP typ2 ON oin.JOIN_ID = typ2.JOIN_ID and qry.QRY_ID = typ2.QRY_ID
         JOIN DTM_JOIN_TYPE typ ON typ2.JOIN_TYPE_ID = typ.JOIN_TYPE_ID
         LEFT OUTER JOIN DTM_JOIN2JOIN_FLTR fltr2 ON fltr2.JOIN_ID = oin.JOIN_ID
         LEFT OUTER JOIN DTM_JOIN_FLTR fltr ON fltr2.JOIN_FLTR_ID = fltr.JOIN_FLTR_ID
         LEFT OUTER JOIN DTM_JOIN_FLTR2LGC_GT gt2 ON gt2.JOIN_FLTR_ID = fltr.JOIN_FLTR_ID
         LEFT OUTER JOIN DTM_LOGIC_GATE gt ON gt2.LOGIC_GATE_ID = gt.LOGIC_GATE_ID
ORDER BY qry.QRY_ID;