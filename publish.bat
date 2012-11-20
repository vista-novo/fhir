@ECHO off
ECHO Running publication process now

"C:\Program Files\Java\jdk1.7.0_02\bin\java" -jar tools\bin\org.hl7.fhir.tools.jar "%CD%" 

PAUSE