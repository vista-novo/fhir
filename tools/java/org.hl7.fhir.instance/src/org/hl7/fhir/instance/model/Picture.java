package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2012, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Thu, Jan 31, 2013 23:34+1100 for FHIR v0.07

/**
 * An Image used in healthcare. The actual pixels maybe inline or provided by direct reference
 */
public class Picture extends Resource {

    public enum ImageModality3 {
        XC, // External Camera (Photography - Still picture)
        VC, // Video Camera (Moving picture)
        DIA, // Diagram / Hand drawn image
        BI, // Biomagnetic Imaging
        CR, // Computed Radiography
        CT, // Computed Tomography
        DG, // Diaphanography
        DX, // Digital Radiography
        ECG, // Electrocardiograms
        EM, // Electron Microscope
        ES, // Endoscopy
        GM, // General Microscopy
        LS, // Laser Surface Scan
        MG, // Mammography
        MR, // Magnetic Resonance
        NM, // Nuclear Medicine
        OP, // Ophthalmic Photography
        OPM, // Ophthalmic Mapping
        OPR, // Ophthalmic Refraction
        OPV, // Ophthalmic Visual Field
        PT, // Positron Emission Tomography (PET)
        RD, // Radiotherapy Dose (a.k.a. RTDOSE)
        RF, // Radio Fluoroscopy
        RG, // Radiographic Imaging (conventional film screen)
        RTIMAG, // Radiotherapy Image
        RP, // Radiotherapy Plan (a.k.a. RTPLAN)
        RS, // Radiotherapy Structure Set (a.k.a. RTSTRUCT)
        RT, // Radiation Therapy
        SC, // Secondary Capture
        SM, // Slide Microscopy
        SR, // Structured Reporting
        TG, // Thermography
        US, // Ultrasound
        VL, // Visible Light
        XA, // X-Ray Angiography
        HC, // Hard Copy
        OT, // Other
        Null; // added to help the parsers
        public static ImageModality3 fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("XC".equals(codeString))
          return XC;
        if ("VC".equals(codeString))
          return VC;
        if ("DIA".equals(codeString))
          return DIA;
        if ("BI".equals(codeString))
          return BI;
        if ("CR".equals(codeString))
          return CR;
        if ("CT".equals(codeString))
          return CT;
        if ("DG".equals(codeString))
          return DG;
        if ("DX".equals(codeString))
          return DX;
        if ("ECG".equals(codeString))
          return ECG;
        if ("EM".equals(codeString))
          return EM;
        if ("ES".equals(codeString))
          return ES;
        if ("GM".equals(codeString))
          return GM;
        if ("LS".equals(codeString))
          return LS;
        if ("MG".equals(codeString))
          return MG;
        if ("MR".equals(codeString))
          return MR;
        if ("NM".equals(codeString))
          return NM;
        if ("OP".equals(codeString))
          return OP;
        if ("OPM".equals(codeString))
          return OPM;
        if ("OPR".equals(codeString))
          return OPR;
        if ("OPV".equals(codeString))
          return OPV;
        if ("PT".equals(codeString))
          return PT;
        if ("RD".equals(codeString))
          return RD;
        if ("RF".equals(codeString))
          return RF;
        if ("RG".equals(codeString))
          return RG;
        if ("RTIMAG".equals(codeString))
          return RTIMAG;
        if ("RP".equals(codeString))
          return RP;
        if ("RS".equals(codeString))
          return RS;
        if ("RT".equals(codeString))
          return RT;
        if ("SC".equals(codeString))
          return SC;
        if ("SM".equals(codeString))
          return SM;
        if ("SR".equals(codeString))
          return SR;
        if ("TG".equals(codeString))
          return TG;
        if ("US".equals(codeString))
          return US;
        if ("VL".equals(codeString))
          return VL;
        if ("XA".equals(codeString))
          return XA;
        if ("HC".equals(codeString))
          return HC;
        if ("OT".equals(codeString))
          return OT;
        throw new Exception("Unknown ImageModality3 code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case XC: return "XC";
            case VC: return "VC";
            case DIA: return "DIA";
            case BI: return "BI";
            case CR: return "CR";
            case CT: return "CT";
            case DG: return "DG";
            case DX: return "DX";
            case ECG: return "ECG";
            case EM: return "EM";
            case ES: return "ES";
            case GM: return "GM";
            case LS: return "LS";
            case MG: return "MG";
            case MR: return "MR";
            case NM: return "NM";
            case OP: return "OP";
            case OPM: return "OPM";
            case OPR: return "OPR";
            case OPV: return "OPV";
            case PT: return "PT";
            case RD: return "RD";
            case RF: return "RF";
            case RG: return "RG";
            case RTIMAG: return "RTIMAG";
            case RP: return "RP";
            case RS: return "RS";
            case RT: return "RT";
            case SC: return "SC";
            case SM: return "SM";
            case SR: return "SR";
            case TG: return "TG";
            case US: return "US";
            case VL: return "VL";
            case XA: return "XA";
            case HC: return "HC";
            case OT: return "OT";
            default: return "?";
          }
        }
    }

  public class ImageModality3EnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("XC".equals(codeString))
          return ImageModality3.XC;
        if ("VC".equals(codeString))
          return ImageModality3.VC;
        if ("DIA".equals(codeString))
          return ImageModality3.DIA;
        if ("BI".equals(codeString))
          return ImageModality3.BI;
        if ("CR".equals(codeString))
          return ImageModality3.CR;
        if ("CT".equals(codeString))
          return ImageModality3.CT;
        if ("DG".equals(codeString))
          return ImageModality3.DG;
        if ("DX".equals(codeString))
          return ImageModality3.DX;
        if ("ECG".equals(codeString))
          return ImageModality3.ECG;
        if ("EM".equals(codeString))
          return ImageModality3.EM;
        if ("ES".equals(codeString))
          return ImageModality3.ES;
        if ("GM".equals(codeString))
          return ImageModality3.GM;
        if ("LS".equals(codeString))
          return ImageModality3.LS;
        if ("MG".equals(codeString))
          return ImageModality3.MG;
        if ("MR".equals(codeString))
          return ImageModality3.MR;
        if ("NM".equals(codeString))
          return ImageModality3.NM;
        if ("OP".equals(codeString))
          return ImageModality3.OP;
        if ("OPM".equals(codeString))
          return ImageModality3.OPM;
        if ("OPR".equals(codeString))
          return ImageModality3.OPR;
        if ("OPV".equals(codeString))
          return ImageModality3.OPV;
        if ("PT".equals(codeString))
          return ImageModality3.PT;
        if ("RD".equals(codeString))
          return ImageModality3.RD;
        if ("RF".equals(codeString))
          return ImageModality3.RF;
        if ("RG".equals(codeString))
          return ImageModality3.RG;
        if ("RTIMAG".equals(codeString))
          return ImageModality3.RTIMAG;
        if ("RP".equals(codeString))
          return ImageModality3.RP;
        if ("RS".equals(codeString))
          return ImageModality3.RS;
        if ("RT".equals(codeString))
          return ImageModality3.RT;
        if ("SC".equals(codeString))
          return ImageModality3.SC;
        if ("SM".equals(codeString))
          return ImageModality3.SM;
        if ("SR".equals(codeString))
          return ImageModality3.SR;
        if ("TG".equals(codeString))
          return ImageModality3.TG;
        if ("US".equals(codeString))
          return ImageModality3.US;
        if ("VL".equals(codeString))
          return ImageModality3.VL;
        if ("XA".equals(codeString))
          return ImageModality3.XA;
        if ("HC".equals(codeString))
          return ImageModality3.HC;
        if ("OT".equals(codeString))
          return ImageModality3.OT;
        throw new Exception("Unknown ImageModality3 code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ImageModality3.XC)
        return "XC";
      if (code == ImageModality3.VC)
        return "VC";
      if (code == ImageModality3.DIA)
        return "DIA";
      if (code == ImageModality3.BI)
        return "BI";
      if (code == ImageModality3.CR)
        return "CR";
      if (code == ImageModality3.CT)
        return "CT";
      if (code == ImageModality3.DG)
        return "DG";
      if (code == ImageModality3.DX)
        return "DX";
      if (code == ImageModality3.ECG)
        return "ECG";
      if (code == ImageModality3.EM)
        return "EM";
      if (code == ImageModality3.ES)
        return "ES";
      if (code == ImageModality3.GM)
        return "GM";
      if (code == ImageModality3.LS)
        return "LS";
      if (code == ImageModality3.MG)
        return "MG";
      if (code == ImageModality3.MR)
        return "MR";
      if (code == ImageModality3.NM)
        return "NM";
      if (code == ImageModality3.OP)
        return "OP";
      if (code == ImageModality3.OPM)
        return "OPM";
      if (code == ImageModality3.OPR)
        return "OPR";
      if (code == ImageModality3.OPV)
        return "OPV";
      if (code == ImageModality3.PT)
        return "PT";
      if (code == ImageModality3.RD)
        return "RD";
      if (code == ImageModality3.RF)
        return "RF";
      if (code == ImageModality3.RG)
        return "RG";
      if (code == ImageModality3.RTIMAG)
        return "RTIMAG";
      if (code == ImageModality3.RP)
        return "RP";
      if (code == ImageModality3.RS)
        return "RS";
      if (code == ImageModality3.RT)
        return "RT";
      if (code == ImageModality3.SC)
        return "SC";
      if (code == ImageModality3.SM)
        return "SM";
      if (code == ImageModality3.SR)
        return "SR";
      if (code == ImageModality3.TG)
        return "TG";
      if (code == ImageModality3.US)
        return "US";
      if (code == ImageModality3.VL)
        return "VL";
      if (code == ImageModality3.XA)
        return "XA";
      if (code == ImageModality3.HC)
        return "HC";
      if (code == ImageModality3.OT)
        return "OT";
      return "?";
      }
    }

    /**
     * Who/What this image is taken of
     */
    private ResourceReference subject;

    /**
     * When the image was taken
     */
    private DateTime dateTime;

    /**
     * The person who generated the image
     */
    private ResourceReference operator;

    /**
     * Identifier for the image
     */
    private Identifier identifier;

    /**
     * An identifier for the order that is used by the application/system that requested the image to link back to the original context (if there was such a system). This is not the identity of the image, but of the "request for an image to be generated"
     */
    private Identifier accessionNo;

    /**
     * The session in which the picture was taken.
     */
    private Identifier studyId;

    /**
     * The series of images in which this picture was taken
     */
    private Identifier seriesId;

    /**
     * A reference to the method/protocol that was followed when the images were taken
     */
    private CodeableConcept method;

    /**
     * Who asked that this image be collected
     */
    private ResourceReference requester;

    /**
     * Type of the image capturing machinery
     */
    private Enumeration<ImageModality3> modality;

    /**
     * Name of the manufacturer
     */
    private String_ deviceName;

    /**
     * Height of the image
     */
    private Integer height;

    /**
     * Width of the image
     */
    private Integer width;

    /**
     * Number of bits of colour (2..32)
     */
    private Integer bits;

    /**
     * Number of frames
     */
    private Integer frames;

    /**
     * Length of time between frames
     */
    private Duration frameDelay;

    /**
     * The name of the imaging view e.g Lateral or Antero-posterior (AP).
     */
    private CodeableConcept view;

    /**
     * Actual picture - reference or data
     */
    private Attachment content;

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public DateTime getDateTime() { 
      return this.dateTime;
    }

    public void setDateTime(DateTime value) { 
      this.dateTime = value;
    }

    public String getDateTimeSimple() { 
      return this.dateTime == null ? null : this.dateTime.getValue();
    }

    public void setDateTimeSimple(String value) { 
      if (value == null)
        this.dateTime = null;
      else {
        if (this.dateTime == null)
          this.dateTime = new DateTime();
        this.dateTime.setValue(value);
      }
    }

    public ResourceReference getOperator() { 
      return this.operator;
    }

    public void setOperator(ResourceReference value) { 
      this.operator = value;
    }

    public Identifier getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(Identifier value) { 
      this.identifier = value;
    }

    public Identifier getAccessionNo() { 
      return this.accessionNo;
    }

    public void setAccessionNo(Identifier value) { 
      this.accessionNo = value;
    }

    public Identifier getStudyId() { 
      return this.studyId;
    }

    public void setStudyId(Identifier value) { 
      this.studyId = value;
    }

    public Identifier getSeriesId() { 
      return this.seriesId;
    }

    public void setSeriesId(Identifier value) { 
      this.seriesId = value;
    }

    public CodeableConcept getMethod() { 
      return this.method;
    }

    public void setMethod(CodeableConcept value) { 
      this.method = value;
    }

    public ResourceReference getRequester() { 
      return this.requester;
    }

    public void setRequester(ResourceReference value) { 
      this.requester = value;
    }

    public Enumeration<ImageModality3> getModality() { 
      return this.modality;
    }

    public void setModality(Enumeration<ImageModality3> value) { 
      this.modality = value;
    }

    public ImageModality3 getModalitySimple() { 
      return this.modality == null ? null : this.modality.getValue();
    }

    public void setModalitySimple(ImageModality3 value) { 
      if (value == null)
        this.modality = null;
      else {
        if (this.modality == null)
          this.modality = new Enumeration<ImageModality3>();
        this.modality.setValue(value);
      }
    }

    public String_ getDeviceName() { 
      return this.deviceName;
    }

    public void setDeviceName(String_ value) { 
      this.deviceName = value;
    }

    public String getDeviceNameSimple() { 
      return this.deviceName == null ? null : this.deviceName.getValue();
    }

    public void setDeviceNameSimple(String value) { 
      if (value == null)
        this.deviceName = null;
      else {
        if (this.deviceName == null)
          this.deviceName = new String_();
        this.deviceName.setValue(value);
      }
    }

    public Integer getHeight() { 
      return this.height;
    }

    public void setHeight(Integer value) { 
      this.height = value;
    }

    public int getHeightSimple() { 
      return this.height == null ? null : this.height.getValue();
    }

    public void setHeightSimple(int value) { 
      if (value == -1)
        this.height = null;
      else {
        if (this.height == null)
          this.height = new Integer();
        this.height.setValue(value);
      }
    }

    public Integer getWidth() { 
      return this.width;
    }

    public void setWidth(Integer value) { 
      this.width = value;
    }

    public int getWidthSimple() { 
      return this.width == null ? null : this.width.getValue();
    }

    public void setWidthSimple(int value) { 
      if (value == -1)
        this.width = null;
      else {
        if (this.width == null)
          this.width = new Integer();
        this.width.setValue(value);
      }
    }

    public Integer getBits() { 
      return this.bits;
    }

    public void setBits(Integer value) { 
      this.bits = value;
    }

    public int getBitsSimple() { 
      return this.bits == null ? null : this.bits.getValue();
    }

    public void setBitsSimple(int value) { 
      if (value == -1)
        this.bits = null;
      else {
        if (this.bits == null)
          this.bits = new Integer();
        this.bits.setValue(value);
      }
    }

    public Integer getFrames() { 
      return this.frames;
    }

    public void setFrames(Integer value) { 
      this.frames = value;
    }

    public int getFramesSimple() { 
      return this.frames == null ? null : this.frames.getValue();
    }

    public void setFramesSimple(int value) { 
      if (value == -1)
        this.frames = null;
      else {
        if (this.frames == null)
          this.frames = new Integer();
        this.frames.setValue(value);
      }
    }

    public Duration getFrameDelay() { 
      return this.frameDelay;
    }

    public void setFrameDelay(Duration value) { 
      this.frameDelay = value;
    }

    public CodeableConcept getView() { 
      return this.view;
    }

    public void setView(CodeableConcept value) { 
      this.view = value;
    }

    public Attachment getContent() { 
      return this.content;
    }

    public void setContent(Attachment value) { 
      this.content = value;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Picture;
   }


}

