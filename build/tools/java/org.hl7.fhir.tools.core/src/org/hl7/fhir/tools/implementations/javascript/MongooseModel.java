package org.hl7.fhir.tools.implementations.javascript;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.tools.implementations.GenBlock;

public class MongooseModel {
    private String name;
    private File javaScriptFile;
    private Definitions definitions;
    
    public MongooseModel(String name, Definitions definitions, File javaScriptFile) {
      this.name = name;
      this.definitions = definitions;
      this.javaScriptFile = javaScriptFile;
    }
    
    public void generate() throws Exception {
      javaScriptFile.createNewFile();
      GenBlock fileBlock = new GenBlock();
      fileBlock.ln("var mongoose = require('mongoose');");
      fileBlock.ln();
      fileBlock.ln("var " + name + "Schema = new mongoose.Schema({");
      fileBlock.bs();
      
      ResourceDefn resource = definitions.getResourceByName(name);
      for (Iterator<ElementDefn> iterator = resource.getRoot().getElements().iterator(); iterator.hasNext();) {
        ElementDefn elementDefinition = iterator.next();
        generateElement(fileBlock, elementDefinition, iterator.hasNext());
      }
      fileBlock.es();
      fileBlock.ln("});");
      fileBlock.ln();
      fileBlock.ln("mongoose.model('" + name +"', " + name+ "Schema);");
      Writer modelFile = new BufferedWriter(new FileWriter(javaScriptFile));
      modelFile.write(fileBlock.toString());
      modelFile.flush();
      modelFile.close();
    }
    
    private void generateElement(GenBlock block, ElementDefn elementDefinition, boolean includeTrailingComma) {
      block.ln(elementDefinition.getName().replace("[x]", "") + ": {");
      block.bs();
      List<TypeRef> types = elementDefinition.getTypes();
      if(types.size() > 0) {
        String elementType = types.get(0).getName();
        if (elementType.equals("boolean")) {
          block.ln("value: Boolean");
        } else if(elementType.equals("integer") || elementType.equals("decimal")) {
          block.ln("value: Number");
        } else if(elementType.equals("instant") || elementType.equals("date") || elementType.equals("dateTime")) {
          block.ln("value: Date");
        } else if(elementType.equals("string") || elementType.equals("uri") || elementType.equals("code")) {
          block.ln("value: String");
        } else if(elementType.equals("Resource")) {
          generateResourceSchema(block);
        } else if(elementType.equals("CodeableConcept")) {
          generateCodeableConceptSchema(block);
        } else if(elementType.equals("Coding")) {
          generateCodingScheama(block);
        }
      } else if(types.size() == 0) {
        for (Iterator<ElementDefn> iterator = elementDefinition.getElements().iterator(); iterator.hasNext();) {
          ElementDefn nestedElement = iterator.next();
          generateElement(block, nestedElement, iterator.hasNext());
        }
      }
      block.es();
      block.ln("}" + (includeTrailingComma ? "," : ""));
    }
    
    private void generateResourceSchema(GenBlock block) {
      generateValueSchema(block, "type", true);
      generateValueSchema(block, "reference", false);
    }
    
    private void generateCodeableConceptSchema(GenBlock block) {
      block.ln("coding: [{");
      block.bs();
      generateValueSchema(block, "system", true);
      generateValueSchema(block, "code", true);
      generateValueSchema(block, "display", false);
      block.es();
      block.ln("}]");
    }
    
    private void generateValueSchema(GenBlock block, String valueName, boolean includeTrailingComma) {
      block.ln(valueName + ": {");
      block.bs();
      block.ln("value: String");
      block.es();
      block.ln("}" + (includeTrailingComma ? "," : ""));
    }
    
    private void generateCodingScheama(GenBlock block) {
      generateValueSchema(block, "system", true);
      generateValueSchema(block, "code", true);
      generateValueSchema(block, "display", false);
    }
}
