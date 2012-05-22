package org.hl7.fhir.definitions.parsers;

import org.hl7.fhir.utilities.IniFile;

public class BindingNameRegistry {

  private String srcDir;

  public BindingNameRegistry(String srcDir) {
    this.srcDir = srcDir;
  }

  public String idForName(String name) {
    IniFile ini = new IniFile(srcDir+"bindings.ini");
    if (ini.getIntegerProperty("Binding Names", name) != null)
      return ini.getIntegerProperty("Binding Names", name).toString();
    else {
      Integer last;
      if (ini.getIntegerProperty("Key", "Last") != null)
        last = ini.getIntegerProperty("Key", "Last")+1;
      else 
        last = 1;
      ini.setIntegerProperty("Key", "Last", last, null);
      ini.setIntegerProperty("Binding Names", name, last, null);
      ini.save();
      return last.toString();
    }
  }

}
