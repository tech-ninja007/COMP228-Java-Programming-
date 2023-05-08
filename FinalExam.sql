
CREATE TABLE Doctor (
    DocId NUMBER (6) PRIMARY KEY,
    DocName VARCHAR (35) NOT NULL, 
    DocGrSal NUMBER (8,2) NOT NULL
);
    
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (1,'Dr. Syed Ikramuddin',120000);
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (2,'Dr. John Carter',115000);
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (3,'Dr. Wayne',112000);
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (4,'Dr. Tony Stark',130000);
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (5,'Dr. Natalia Romanoff',105000);
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (6,'Dr. Harry Potter',112000);
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (7,'Dr. Chris Rogers',130000);
INSERT INTO Doctor (DocId, DocName, DocGrSal) VALUES (8,'Dr. Ashwariya',105000);

COMMIT;