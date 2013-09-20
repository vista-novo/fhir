# FHIR JavaScript reference implementation

This repository is mostly a mirror of the FHIR SVN source code repository at the [HL7 GForge site](http://gforge.hl7.org/gf/project/fhir). It was created using git svn. For licensing information on this code, please see the HL7 Gforge Site.

The purpose of this repository is to be a holding place for code to generate a JavaScript reference implementation of FHIR. This RI will be built to run on top of [node.js](http://nodejs.org/) and [MongoDB](http://www.mongodb.org/). It will leverage the [express](http://expressjs.com/) web framework and [mongoose](http://mongoosejs.com/) for interaction with MongoDB.

The JavaScript RI can be built within this project using the regular [FHIR Build Process](http://wiki.hl7.org/index.php?title=FHIR_Build_Process).

The code to generate the JavaScript RI can be found in build/tools/java/org.hl7.fhir.tools.core/src/org/hl7/fhir/tools/implementations/javascript and is under the Apache License, Version 2.0

This code may ultimately make its way into the FHIR repository at some time in the future.