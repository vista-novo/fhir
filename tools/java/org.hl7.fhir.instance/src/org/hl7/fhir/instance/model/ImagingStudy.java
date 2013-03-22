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

// Generated on Mon, Mar 4, 2013 20:03+1100 for FHIR v0.07

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
/**
 * Manifest of a set of images produced in study. The set of images may include every image in the study, or it may be an incomplete sample, such as a list of key images
 */
public class ImagingStudy extends Resource {

    public enum ImageModality {
        xC, // External Camera (Photography)
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
        public static ImageModality fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("XC".equals(codeString))
          return xC;
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
        throw new Exception("Unknown ImageModality code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case xC: return "XC";
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

  public class ImageModalityEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("XC".equals(codeString))
          return ImageModality.xC;
        if ("DIA".equals(codeString))
          return ImageModality.dIA;
        if ("BI".equals(codeString))
          return ImageModality.bI;
        if ("CR".equals(codeString))
          return ImageModality.cR;
        if ("CT".equals(codeString))
          return ImageModality.cT;
        if ("DG".equals(codeString))
          return ImageModality.dG;
        if ("DX".equals(codeString))
          return ImageModality.dX;
        if ("ECG".equals(codeString))
          return ImageModality.eCG;
        if ("EM".equals(codeString))
          return ImageModality.eM;
        if ("ES".equals(codeString))
          return ImageModality.eS;
        if ("GM".equals(codeString))
          return ImageModality.gM;
        if ("LS".equals(codeString))
          return ImageModality.lS;
        if ("MG".equals(codeString))
          return ImageModality.mG;
        if ("MR".equals(codeString))
          return ImageModality.mR;
        if ("NM".equals(codeString))
          return ImageModality.nM;
        if ("OP".equals(codeString))
          return ImageModality.oP;
        if ("OPM".equals(codeString))
          return ImageModality.oPM;
        if ("OPR".equals(codeString))
          return ImageModality.oPR;
        if ("OPV".equals(codeString))
          return ImageModality.oPV;
        if ("PT".equals(codeString))
          return ImageModality.pT;
        if ("RD".equals(codeString))
          return ImageModality.rD;
        if ("RF".equals(codeString))
          return ImageModality.rF;
        if ("RG".equals(codeString))
          return ImageModality.rG;
        if ("RTIMAG".equals(codeString))
          return ImageModality.rTIMAG;
        if ("RP".equals(codeString))
          return ImageModality.rP;
        if ("RS".equals(codeString))
          return ImageModality.rS;
        if ("RT".equals(codeString))
          return ImageModality.rT;
        if ("SC".equals(codeString))
          return ImageModality.sC;
        if ("SM".equals(codeString))
          return ImageModality.sM;
        if ("SR".equals(codeString))
          return ImageModality.sR;
        if ("TG".equals(codeString))
          return ImageModality.tG;
        if ("US".equals(codeString))
          return ImageModality.uS;
        if ("VL".equals(codeString))
          return ImageModality.vL;
        if ("XA".equals(codeString))
          return ImageModality.xA;
        if ("HC".equals(codeString))
          return ImageModality.hC;
        if ("OT".equals(codeString))
          return ImageModality.oT;
        throw new Exception("Unknown ImageModality code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ImageModality.xC)
        return "XC";
      if (code == ImageModality.dIA)
        return "DIA";
      if (code == ImageModality.bI)
        return "BI";
      if (code == ImageModality.cR)
        return "CR";
      if (code == ImageModality.cT)
        return "CT";
      if (code == ImageModality.dG)
        return "DG";
      if (code == ImageModality.dX)
        return "DX";
      if (code == ImageModality.eCG)
        return "ECG";
      if (code == ImageModality.eM)
        return "EM";
      if (code == ImageModality.eS)
        return "ES";
      if (code == ImageModality.gM)
        return "GM";
      if (code == ImageModality.lS)
        return "LS";
      if (code == ImageModality.mG)
        return "MG";
      if (code == ImageModality.mR)
        return "MR";
      if (code == ImageModality.nM)
        return "NM";
      if (code == ImageModality.oP)
        return "OP";
      if (code == ImageModality.oPM)
        return "OPM";
      if (code == ImageModality.oPR)
        return "OPR";
      if (code == ImageModality.oPV)
        return "OPV";
      if (code == ImageModality.pT)
        return "PT";
      if (code == ImageModality.rD)
        return "RD";
      if (code == ImageModality.rF)
        return "RF";
      if (code == ImageModality.rG)
        return "RG";
      if (code == ImageModality.rTIMAG)
        return "RTIMAG";
      if (code == ImageModality.rP)
        return "RP";
      if (code == ImageModality.rS)
        return "RS";
      if (code == ImageModality.rT)
        return "RT";
      if (code == ImageModality.sC)
        return "SC";
      if (code == ImageModality.sM)
        return "SM";
      if (code == ImageModality.sR)
        return "SR";
      if (code == ImageModality.tG)
        return "TG";
      if (code == ImageModality.uS)
        return "US";
      if (code == ImageModality.vL)
        return "VL";
      if (code == ImageModality.xA)
        return "XA";
      if (code == ImageModality.hC)
        return "HC";
      if (code == ImageModality.oT)
        return "OT";
      return "?";
      }
    }

    public class Series extends Element {
        /**
         * The number of this series in the overall sequence
         */
        private Integer number;

        /**
         * The modality of this sequence
         */
        private Enumeration<ImageModality> modality;

        /**
         * When the series started
         */
        private DateTime datetime;

        /**
         * Formal identifier for this series
         */
        private Oid uid;

        /**
         * A description of the series
         */
        private String_ description;

        /**
         * Body part examined
         */
        private Coding bodySite;

        /**
         * A single image taken from a patient
         */
        private List<Image> image = new ArrayList<Image>();

        public Integer getNumber() { 
          return this.number;
        }

        public void setNumber(Integer value) { 
          this.number = value;
        }

        public int getNumberSimple() { 
          return this.number == null ? null : this.number.getValue();
        }

        public void setNumberSimple(int value) { 
          if (value == -1)
            this.number = null;
          else {
            if (this.number == null)
              this.number = new Integer();
            this.number.setValue(value);
          }
        }

        public Enumeration<ImageModality> getModality() { 
          return this.modality;
        }

        public void setModality(Enumeration<ImageModality> value) { 
          this.modality = value;
        }

        public ImageModality getModalitySimple() { 
          return this.modality == null ? null : this.modality.getValue();
        }

        public void setModalitySimple(ImageModality value) { 
          if (value == null)
            this.modality = null;
          else {
            if (this.modality == null)
              this.modality = new Enumeration<ImageModality>();
            this.modality.setValue(value);
          }
        }

        public DateTime getDatetime() { 
          return this.datetime;
        }

        public void setDatetime(DateTime value) { 
          this.datetime = value;
        }

        public String getDatetimeSimple() { 
          return this.datetime == null ? null : this.datetime.getValue();
        }

        public void setDatetimeSimple(String value) { 
          if (value == null)
            this.datetime = null;
          else {
            if (this.datetime == null)
              this.datetime = new DateTime();
            this.datetime.setValue(value);
          }
        }

        public Oid getUid() { 
          return this.uid;
        }

        public void setUid(Oid value) { 
          this.uid = value;
        }

        public String getUidSimple() { 
          return this.uid == null ? null : this.uid.getValue();
        }

        public void setUidSimple(String value) { 
          if (value == null)
            this.uid = null;
          else {
            if (this.uid == null)
              this.uid = new Oid();
            this.uid.setValue(value);
          }
        }

        public String_ getDescription() { 
          return this.description;
        }

        public void setDescription(String_ value) { 
          this.description = value;
        }

        public String getDescriptionSimple() { 
          return this.description == null ? null : this.description.getValue();
        }

        public void setDescriptionSimple(String value) { 
          if (value == null)
            this.description = null;
          else {
            if (this.description == null)
              this.description = new String_();
            this.description.setValue(value);
          }
        }

        public Coding getBodySite() { 
          return this.bodySite;
        }

        public void setBodySite(Coding value) { 
          this.bodySite = value;
        }

        public List<Image> getImage() { 
          return this.image;
        }

  }

    public class Image extends Element {
        /**
         * The number of this image in the series
         */
        private Integer number;

        /**
         * When this image was taken
         */
        private DateTime dateTime;

        /**
         * Formal identifier for this image
         */
        private Oid uid;

        /**
         * DICOM Image type
         */
        private Oid dicomClass;

        /**
         * WADO url where image is available
         */
        private Uri url;

        public Integer getNumber() { 
          return this.number;
        }

        public void setNumber(Integer value) { 
          this.number = value;
        }

        public int getNumberSimple() { 
          return this.number == null ? null : this.number.getValue();
        }

        public void setNumberSimple(int value) { 
          if (value == -1)
            this.number = null;
          else {
            if (this.number == null)
              this.number = new Integer();
            this.number.setValue(value);
          }
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

        public Oid getUid() { 
          return this.uid;
        }

        public void setUid(Oid value) { 
          this.uid = value;
        }

        public String getUidSimple() { 
          return this.uid == null ? null : this.uid.getValue();
        }

        public void setUidSimple(String value) { 
          if (value == null)
            this.uid = null;
          else {
            if (this.uid == null)
              this.uid = new Oid();
            this.uid.setValue(value);
          }
        }

        public Oid getDicomClass() { 
          return this.dicomClass;
        }

        public void setDicomClass(Oid value) { 
          this.dicomClass = value;
        }

        public String getDicomClassSimple() { 
          return this.dicomClass == null ? null : this.dicomClass.getValue();
        }

        public void setDicomClassSimple(String value) { 
          if (value == null)
            this.dicomClass = null;
          else {
            if (this.dicomClass == null)
              this.dicomClass = new Oid();
            this.dicomClass.setValue(value);
          }
        }

        public Uri getUrl() { 
          return this.url;
        }

        public void setUrl(Uri value) { 
          this.url = value;
        }

        public URI getUrlSimple() { 
          return this.url == null ? null : this.url.getValue();
        }

        public void setUrlSimple(URI value) { 
          if (value == null)
            this.url = null;
          else {
            if (this.url == null)
              this.url = new Uri();
            this.url.setValue(value);
          }
        }

  }

    /**
     * Date and Time the study took place
     */
    private DateTime dateTime;

    /**
     * Who the images are of
     */
    private ResourceReference subject;

    /**
     * Formal identifier for the study
     */
    private Oid uid;

    /**
     * Other identifiers for the study
     */
    private List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * The requesting/referring physician
     */
    private ResourceReference requester;

    /**
     * Accession Number
     */
    private Identifier accessionNo;

    /**
     * Diagnoses etc provided with request
     */
    private String_ clinicalInformation;

    /**
     * Type of procedure performed
     */
    private List<Coding> procedure = new ArrayList<Coding>();

    /**
     * Who read study and interpreted the images
     */
    private ResourceReference interpreter;

    /**
     * Institution-generated description or classification of the Study (component) performed
     */
    private String_ description;

    /**
     * Each study has one or more series of image instances
     */
    private List<Series> series = new ArrayList<Series>();

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

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public Oid getUid() { 
      return this.uid;
    }

    public void setUid(Oid value) { 
      this.uid = value;
    }

    public String getUidSimple() { 
      return this.uid == null ? null : this.uid.getValue();
    }

    public void setUidSimple(String value) { 
      if (value == null)
        this.uid = null;
      else {
        if (this.uid == null)
          this.uid = new Oid();
        this.uid.setValue(value);
      }
    }

    public List<Identifier> getIdentifier() { 
      return this.identifier;
    }

    public ResourceReference getRequester() { 
      return this.requester;
    }

    public void setRequester(ResourceReference value) { 
      this.requester = value;
    }

    public Identifier getAccessionNo() { 
      return this.accessionNo;
    }

    public void setAccessionNo(Identifier value) { 
      this.accessionNo = value;
    }

    public String_ getClinicalInformation() { 
      return this.clinicalInformation;
    }

    public void setClinicalInformation(String_ value) { 
      this.clinicalInformation = value;
    }

    public String getClinicalInformationSimple() { 
      return this.clinicalInformation == null ? null : this.clinicalInformation.getValue();
    }

    public void setClinicalInformationSimple(String value) { 
      if (value == null)
        this.clinicalInformation = null;
      else {
        if (this.clinicalInformation == null)
          this.clinicalInformation = new String_();
        this.clinicalInformation.setValue(value);
      }
    }

    public List<Coding> getProcedure() { 
      return this.procedure;
    }

    public ResourceReference getInterpreter() { 
      return this.interpreter;
    }

    public void setInterpreter(ResourceReference value) { 
      this.interpreter = value;
    }

    public String_ getDescription() { 
      return this.description;
    }

    public void setDescription(String_ value) { 
      this.description = value;
    }

    public String getDescriptionSimple() { 
      return this.description == null ? null : this.description.getValue();
    }

    public void setDescriptionSimple(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new String_();
        this.description.setValue(value);
      }
    }

    public List<Series> getSeries() { 
      return this.series;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ImagingStudy;
   }


}

