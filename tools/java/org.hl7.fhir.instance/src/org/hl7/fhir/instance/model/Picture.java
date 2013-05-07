package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2013, HL7, Inc.
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

// Generated on Tue, May 7, 2013 23:53+1000 for FHIR v0.09

/**
 * An Image used in healthcare. The actual pixels maybe inline or provided by direct reference
 */
public class Picture extends Resource {

    public enum ImageModality3 {
        xC, // External Camera (Photography - Still picture)
        vC, // Video Camera (Moving picture)
        dIA, // Diagram / Hand drawn image
        bI, // Biomagnetic Imaging
        cR, // Computed Radiography
        cT, // Computed Tomography
        dG, // Diaphanography
        dX, // Digital Radiography
        eCG, // Electrocardiograms
        eM, // Electron Microscope
        eS, // Endoscopy
        gM, // General Microscopy
        lS, // Laser Surface Scan
        mG, // Mammography
        mR, // Magnetic Resonance
        nM, // Nuclear Medicine
        oP, // Ophthalmic Photography
        oPM, // Ophthalmic Mapping
        oPR, // Ophthalmic Refraction
        oPV, // Ophthalmic Visual Field
        pT, // Positron Emission Tomography (PET)
        rD, // Radiotherapy Dose (a.k.a. RTDOSE)
        rF, // Radio Fluoroscopy
        rG, // Radiographic Imaging (conventional film screen)
        rTIMAG, // Radiotherapy Image
        rP, // Radiotherapy Plan (a.k.a. RTPLAN)
        rS, // Radiotherapy Structure Set (a.k.a. RTSTRUCT)
        rT, // Radiation Therapy
        sC, // Secondary Capture
        sM, // Slide Microscopy
        sR, // Structured Reporting
        tG, // Thermography
        uS, // Ultrasound
        vL, // Visible Light
        xA, // X-Ray Angiography
        hC, // Hard Copy
        oT, // Other
        Null; // added to help the parsers
        public static ImageModality3 fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("XC".equals(codeString))
          return xC;
        if ("VC".equals(codeString))
          return vC;
        if ("DIA".equals(codeString))
          return dIA;
        if ("BI".equals(codeString))
          return bI;
        if ("CR".equals(codeString))
          return cR;
        if ("CT".equals(codeString))
          return cT;
        if ("DG".equals(codeString))
          return dG;
        if ("DX".equals(codeString))
          return dX;
        if ("ECG".equals(codeString))
          return eCG;
        if ("EM".equals(codeString))
          return eM;
        if ("ES".equals(codeString))
          return eS;
        if ("GM".equals(codeString))
          return gM;
        if ("LS".equals(codeString))
          return lS;
        if ("MG".equals(codeString))
          return mG;
        if ("MR".equals(codeString))
          return mR;
        if ("NM".equals(codeString))
          return nM;
        if ("OP".equals(codeString))
          return oP;
        if ("OPM".equals(codeString))
          return oPM;
        if ("OPR".equals(codeString))
          return oPR;
        if ("OPV".equals(codeString))
          return oPV;
        if ("PT".equals(codeString))
          return pT;
        if ("RD".equals(codeString))
          return rD;
        if ("RF".equals(codeString))
          return rF;
        if ("RG".equals(codeString))
          return rG;
        if ("RTIMAG".equals(codeString))
          return rTIMAG;
        if ("RP".equals(codeString))
          return rP;
        if ("RS".equals(codeString))
          return rS;
        if ("RT".equals(codeString))
          return rT;
        if ("SC".equals(codeString))
          return sC;
        if ("SM".equals(codeString))
          return sM;
        if ("SR".equals(codeString))
          return sR;
        if ("TG".equals(codeString))
          return tG;
        if ("US".equals(codeString))
          return uS;
        if ("VL".equals(codeString))
          return vL;
        if ("XA".equals(codeString))
          return xA;
        if ("HC".equals(codeString))
          return hC;
        if ("OT".equals(codeString))
          return oT;
        throw new Exception("Unknown ImageModality3 code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case xC: return "XC";
            case vC: return "VC";
            case dIA: return "DIA";
            case bI: return "BI";
            case cR: return "CR";
            case cT: return "CT";
            case dG: return "DG";
            case dX: return "DX";
            case eCG: return "ECG";
            case eM: return "EM";
            case eS: return "ES";
            case gM: return "GM";
            case lS: return "LS";
            case mG: return "MG";
            case mR: return "MR";
            case nM: return "NM";
            case oP: return "OP";
            case oPM: return "OPM";
            case oPR: return "OPR";
            case oPV: return "OPV";
            case pT: return "PT";
            case rD: return "RD";
            case rF: return "RF";
            case rG: return "RG";
            case rTIMAG: return "RTIMAG";
            case rP: return "RP";
            case rS: return "RS";
            case rT: return "RT";
            case sC: return "SC";
            case sM: return "SM";
            case sR: return "SR";
            case tG: return "TG";
            case uS: return "US";
            case vL: return "VL";
            case xA: return "XA";
            case hC: return "HC";
            case oT: return "OT";
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
          return ImageModality3.xC;
        if ("VC".equals(codeString))
          return ImageModality3.vC;
        if ("DIA".equals(codeString))
          return ImageModality3.dIA;
        if ("BI".equals(codeString))
          return ImageModality3.bI;
        if ("CR".equals(codeString))
          return ImageModality3.cR;
        if ("CT".equals(codeString))
          return ImageModality3.cT;
        if ("DG".equals(codeString))
          return ImageModality3.dG;
        if ("DX".equals(codeString))
          return ImageModality3.dX;
        if ("ECG".equals(codeString))
          return ImageModality3.eCG;
        if ("EM".equals(codeString))
          return ImageModality3.eM;
        if ("ES".equals(codeString))
          return ImageModality3.eS;
        if ("GM".equals(codeString))
          return ImageModality3.gM;
        if ("LS".equals(codeString))
          return ImageModality3.lS;
        if ("MG".equals(codeString))
          return ImageModality3.mG;
        if ("MR".equals(codeString))
          return ImageModality3.mR;
        if ("NM".equals(codeString))
          return ImageModality3.nM;
        if ("OP".equals(codeString))
          return ImageModality3.oP;
        if ("OPM".equals(codeString))
          return ImageModality3.oPM;
        if ("OPR".equals(codeString))
          return ImageModality3.oPR;
        if ("OPV".equals(codeString))
          return ImageModality3.oPV;
        if ("PT".equals(codeString))
          return ImageModality3.pT;
        if ("RD".equals(codeString))
          return ImageModality3.rD;
        if ("RF".equals(codeString))
          return ImageModality3.rF;
        if ("RG".equals(codeString))
          return ImageModality3.rG;
        if ("RTIMAG".equals(codeString))
          return ImageModality3.rTIMAG;
        if ("RP".equals(codeString))
          return ImageModality3.rP;
        if ("RS".equals(codeString))
          return ImageModality3.rS;
        if ("RT".equals(codeString))
          return ImageModality3.rT;
        if ("SC".equals(codeString))
          return ImageModality3.sC;
        if ("SM".equals(codeString))
          return ImageModality3.sM;
        if ("SR".equals(codeString))
          return ImageModality3.sR;
        if ("TG".equals(codeString))
          return ImageModality3.tG;
        if ("US".equals(codeString))
          return ImageModality3.uS;
        if ("VL".equals(codeString))
          return ImageModality3.vL;
        if ("XA".equals(codeString))
          return ImageModality3.xA;
        if ("HC".equals(codeString))
          return ImageModality3.hC;
        if ("OT".equals(codeString))
          return ImageModality3.oT;
        throw new Exception("Unknown ImageModality3 code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ImageModality3.xC)
        return "XC";
      if (code == ImageModality3.vC)
        return "VC";
      if (code == ImageModality3.dIA)
        return "DIA";
      if (code == ImageModality3.bI)
        return "BI";
      if (code == ImageModality3.cR)
        return "CR";
      if (code == ImageModality3.cT)
        return "CT";
      if (code == ImageModality3.dG)
        return "DG";
      if (code == ImageModality3.dX)
        return "DX";
      if (code == ImageModality3.eCG)
        return "ECG";
      if (code == ImageModality3.eM)
        return "EM";
      if (code == ImageModality3.eS)
        return "ES";
      if (code == ImageModality3.gM)
        return "GM";
      if (code == ImageModality3.lS)
        return "LS";
      if (code == ImageModality3.mG)
        return "MG";
      if (code == ImageModality3.mR)
        return "MR";
      if (code == ImageModality3.nM)
        return "NM";
      if (code == ImageModality3.oP)
        return "OP";
      if (code == ImageModality3.oPM)
        return "OPM";
      if (code == ImageModality3.oPR)
        return "OPR";
      if (code == ImageModality3.oPV)
        return "OPV";
      if (code == ImageModality3.pT)
        return "PT";
      if (code == ImageModality3.rD)
        return "RD";
      if (code == ImageModality3.rF)
        return "RF";
      if (code == ImageModality3.rG)
        return "RG";
      if (code == ImageModality3.rTIMAG)
        return "RTIMAG";
      if (code == ImageModality3.rP)
        return "RP";
      if (code == ImageModality3.rS)
        return "RS";
      if (code == ImageModality3.rT)
        return "RT";
      if (code == ImageModality3.sC)
        return "SC";
      if (code == ImageModality3.sM)
        return "SM";
      if (code == ImageModality3.sR)
        return "SR";
      if (code == ImageModality3.tG)
        return "TG";
      if (code == ImageModality3.uS)
        return "US";
      if (code == ImageModality3.vL)
        return "VL";
      if (code == ImageModality3.xA)
        return "XA";
      if (code == ImageModality3.hC)
        return "HC";
      if (code == ImageModality3.oT)
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

