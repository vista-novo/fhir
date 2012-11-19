@ECHO off
ECHO Running publication process now

"C:\Program Files\Java\jdk1.7.0_02\bin\java" -classpath C:\workspace\projects\org.hl7.fhir\tools\java\imports\xmlpull_1_1_3_4b.jar -jar tools\bin\org.hl7.fhir.tools.jar "%CD%" 

PAUSE