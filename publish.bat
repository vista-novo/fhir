@ECHO off
ECHO Running publication process now

java -jar tools\bin\org.hl7.fhir.tools.jar "%CD%"

PAUSE