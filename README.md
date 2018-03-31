- Lists usernames of the students that are added to the chosen course<br/>
/api/getStudentsFromCourse?courseId={Id of the course}

- Adds student to the course and assigns teacher to the student<br/>
/api/assignStudentToCourse?studentId={Id of the student}&teacherId={Id of the teacher}&courseId={Id of the course}

- Assigns grade to the student for the course<br/>
/api/gradeStudent?studentId={Id of the course}&courseId={Id of the course}&grade={Student's grade}

- Returns name of the department with best average grade in the last 5 years<br/>
/api/getBestDepartment

Application is created with create-drop option so schema named "prosolo" will be populated with tables. There is option to intialize tables with testing data by using api call:<br/>
/api/initialize

Testing data:

Student table (usename is student's id):<br/>

username | department | enrollment_year | index_no 
--- | --- | --- | --- 
mikamikic150121 | rti | 2015 | 15/121
peraperic140125 | rti | 2014 | 14/125
ivanivic130222 | tel | 2013 | 13/222
majamajic050121 | rti | 2005 | 05/121
studentbezkursa150122 | rti | 2015 | 15/122
iovajbezkursa100345 | tel | 2010 | 10/345

Teacher table (usename is teacher's id):<br/>

username | address | phone | title 
--- | --- | --- | --- 
jovajovic | home | 064/1122333 | dr
ivkaivic | kuca | 061/1122333 | mr

Course table:<br/>

id | creator_username 
--- | --- 
1 | ivkaivic
2 | ivkaivic
3 | ivkaivic

Course realistaors connection:<br/>

course_id | realisators_username 
--- | --- 
1 | jovajovic
2 | jovajovic
2 | ivkaivic
3 | ivkaivic
3 | jovajovic
