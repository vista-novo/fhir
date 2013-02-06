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

// Generated on Sat, Feb 2, 2013 11:50+1100 for FHIR v0.07

import java.util.*;

import java.net.*;
/**
 * Manifest of a set of images produced in study. The set of images may include every image in the study, or it may be an incomplete sample, such as a list of key images
 */
public class ImagingStudy extends Resource {

    public enum ImageModality {
        XC, // External Camera (Photography)
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
        public static ImageModality fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("XC".equals(codeString))
          return XC;
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
        throw new Exception("Unknown ImageModality code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case XC: return "XC";
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

  public class ImageModalityEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("XC".equals(codeString))
          return ImageModality.XC;
        if ("DIA".equals(codeString))
          return ImageModality.DIA;
        if ("BI".equals(codeString))
          return ImageModality.BI;
        if ("CR".equals(codeString))
          return ImageModality.CR;
        if ("CT".equals(codeString))
          return ImageModality.CT;
        if ("DG".equals(codeString))
          return ImageModality.DG;
        if ("DX".equals(codeString))
          return ImageModality.DX;
        if ("ECG".equals(codeString))
          return ImageModality.ECG;
        if ("EM".equals(codeString))
          return ImageModality.EM;
        if ("ES".equals(codeString))
          return ImageModality.ES;
        if ("GM".equals(codeString))
          return ImageModality.GM;
        if ("LS".equals(codeString))
          return ImageModality.LS;
        if ("MG".equals(codeString))
          return ImageModality.MG;
        if ("MR".equals(codeString))
          return ImageModality.MR;
        if ("NM".equals(codeString))
          return ImageModality.NM;
        if ("OP".equals(codeString))
          return ImageModality.OP;
        if ("OPM".equals(codeString))
          return ImageModality.OPM;
        if ("OPR".equals(codeString))
          return ImageModality.OPR;
        if ("OPV".equals(codeString))
          return ImageModality.OPV;
        if ("PT".equals(codeString))
          return ImageModality.PT;
        if ("RD".equals(codeString))
          return ImageModality.RD;
        if ("RF".equals(codeString))
          return ImageModality.RF;
        if ("RG".equals(codeString))
          return ImageModality.RG;
        if ("RTIMAG".equals(codeString))
          return ImageModality.RTIMAG;
        if ("RP".equals(codeString))
          return ImageModality.RP;
        if ("RS".equals(codeString))
          return ImageModality.RS;
        if ("RT".equals(codeString))
          return ImageModality.RT;
        if ("SC".equals(codeString))
          return ImageModality.SC;
        if ("SM".equals(codeString))
          return ImageModality.SM;
        if ("SR".equals(codeString))
          return ImageModality.SR;
        if ("TG".equals(codeString))
          return ImageModality.TG;
        if ("US".equals(codeString))
          return ImageModality.US;
        if ("VL".equals(codeString))
          return ImageModality.VL;
        if ("XA".equals(codeString))
          return ImageModality.XA;
        if ("HC".equals(codeString))
          return ImageModality.HC;
        if ("OT".equals(codeString))
          return ImageModality.OT;
        throw new Exception("Unknown ImageModality code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ImageModality.XC)
        return "XC";
      if (code == ImageModality.DIA)
        return "DIA";
      if (code == ImageModality.BI)
        return "BI";
      if (code == ImageModality.CR)
        return "CR";
      if (code == ImageModality.CT)
        return "CT";
      if (code == ImageModality.DG)
        return "DG";
      if (code == ImageModality.DX)
        return "DX";
      if (code == ImageModality.ECG)
        return "ECG";
      if (code == ImageModality.EM)
        return "EM";
      if (code == ImageModality.ES)
        return "ES";
      if (code == ImageModality.GM)
        return "GM";
      if (code == ImageModality.LS)
        return "LS";
      if (code == ImageModality.MG)
        return "MG";
      if (code == ImageModality.MR)
        return "MR";
      if (code == ImageModality.NM)
        return "NM";
      if (code == ImageModality.OP)
        return "OP";
      if (code == ImageModality.OPM)
        return "OPM";
      if (code == ImageModality.OPR)
        return "OPR";
      if (code == ImageModality.OPV)
        return "OPV";
      if (code == ImageModality.PT)
        return "PT";
      if (code == ImageModality.RD)
        return "RD";
      if (code == ImageModality.RF)
        return "RF";
      if (code == ImageModality.RG)
        return "RG";
      if (code == ImageModality.RTIMAG)
        return "RTIMAG";
      if (code == ImageModality.RP)
        return "RP";
      if (code == ImageModality.RS)
        return "RS";
      if (code == ImageModality.RT)
        return "RT";
      if (code == ImageModality.SC)
        return "SC";
      if (code == ImageModality.SM)
        return "SM";
      if (code == ImageModality.SR)
        return "SR";
      if (code == ImageModality.TG)
        return "TG";
      if (code == ImageModality.US)
        return "US";
      if (code == ImageModality.VL)
        return "VL";
      if (code == ImageModality.XA)
        return "XA";
      if (code == ImageModality.HC)
        return "HC";
      if (code == ImageModality.OT)
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

    public List<Series> getSeries() { 
      return this.series;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ImagingStudy;
   }


}

