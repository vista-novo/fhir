package org.hl7.fhir.utilities;


import java.io.*;

public class CSVProcessor {

  public class DataReader extends CSVReader {

    public DataReader(InputStream data) {
      super(data);
    }

    public void process() throws Exception {
      String[] titles = parseLine();
      while (ready())
      {
        String[] values = parseLine();
        processLine(titles, values);
      }     
      close();
    }

    private void processLine(String[] titles, String[] values) throws Exception {
      count++;
      String src = loop;
      while (src.contains("[%")) {
        int i1 = src.indexOf("[%");
        int i2 = src.indexOf("%]");
        String s1 = src.substring(0, i1);
        String s2 = src.substring(i1 + 2, i2).trim();
        String s3 = src.substring(i2+2);
        if ("count".equals(s2))
          src = s1+Integer.toString(count)+s3;
        else {
          boolean b = false;
          for (String t : titles) {
            if (t.equals(s2)) {
              src = s1+getColumn(titles, values, s2)+s3;
              b = true;
            }
          }
          if (!b)
            throw new Exception("unknown column: '"+s2+"'");
        }
      }
      dest.append(src);
    }
  }

  private InputStream source;
  private DataReader data;
  private OutputStreamWriter out;

  private String start;
  private String loop;
  private int count = 0;
  private String stop;
  private StringBuilder dest;
  
  public void setSource(InputStream source) {
    this.source = source;
  }

  public void setData(InputStream data) {
    this.data = new DataReader(data);   
  }

  public void setOutput(OutputStream out) {
    this.out = new OutputStreamWriter(out);   
  }

  public void process() throws Exception {
    buildTemplate(readSource());
    dest = new StringBuilder();
    dest.append(start);
    data.process();
    dest.append(stop);
    out.write(dest.toString());
    out.close();
  }

  private void buildTemplate(String template) throws Exception {
    int i = template.indexOf("[%loop");
    if (i < 0)
      throw new Exception("Unable to process template - didn't find [%loop");
    start = template.substring(0, i);
    template = template.substring(i+6);
    i = template.indexOf("%]");
    if (i < 0)
      throw new Exception("Unable to process template - didn't find %] matching [%loop");
    String tmp = template.substring(0, i);
    if (tmp != null && !tmp.equals("")) {
      if (!tmp.startsWith(" count="))
        throw new Exception("Unable to process template - unrecognised content on [%loop");
      count = Integer.parseInt(tmp.substring(7));
    }
    
    template = template.substring(i+2);
    i = template.indexOf("[%endloop%]");
    if (i < 0)
      throw new Exception("Unable to process template - didn't find [%endloop%]");
    loop = template.substring(0, i);
    stop = template.substring(i+11);
  }

  private String readSource() throws Exception {
    StringBuilder s = new StringBuilder();
    InputStreamReader r = new InputStreamReader(source);
    while (r.ready()) {
      s.append((char) r.read()); 
    }
    r.close();
    return s.toString();
  }

}
