package org.hl7.fhir.tools.implementations.javascript;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.lang.model.element.Element;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.tools.implementations.GenBlock;

public class MongooseModel {
    private String name;
    private File javaScriptFile;
    private ResourceDefn definition;
    
    public MongooseModel(String name, ResourceDefn definition, File javaScriptFile) {
      this.name = name;
      this.definition = definition;
      this.javaScriptFile = javaScriptFile;
    }
    
    public void generate() throws IOException {
      javaScriptFile.createNewFile();
      GenBlock fileBlock = new GenBlock();
      fileBlock.ln("var mongoose = require('mongoose');");
      fileBlock.ln();
      fileBlock.ln("var " + name + "Schema = new mongoose.Schema({");
      fileBlock.bs();
      for (ElementDefn elementDefinition: definition.getContents()) {
        fileBlock.ln(elementDefinition.getName() + ": " + elementDefinition.getStatedType());
      }
      fileBlock.es();
      fileBlock.ln("};");
      fileBlock.ln();
      fileBlock.ln("mongoose.model('" + name +"', " + name+ "Schema);");
      Writer modelFile = new BufferedWriter(new FileWriter(javaScriptFile));
      modelFile.write(fileBlock.toString());
      modelFile.flush();
      modelFile.close();
    }
    
    
}
