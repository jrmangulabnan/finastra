package org.finastra.exam.repository.data;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pacs008")
public class Pacs008 {

	List<Document> document;

	public List<Document> getDocument() {
		return document;
	}

	@XmlElement(name = "document")
	public void setDocument(List<Document> document) {
		this.document = document;
	}

	@XmlRootElement(name = "document")
	public static class Document {
		private GrpHdr grpHdr;
		private CdtTrfTxInf cdtTrfTxInf;

		public GrpHdr getGrpHdr() {
			return grpHdr;
		}

		@XmlElement(name = "grpHdr")
		public void setGrpHdr(GrpHdr grpHdr) {
			this.grpHdr = grpHdr;
		}

		public CdtTrfTxInf getCdtTrfTxInf() {
			return cdtTrfTxInf;
		}

		@XmlElement(name = "cdtTrfTxInf")
		public void setCdtTrfTxInf(CdtTrfTxInf cdtTrfTxInf) {
			this.cdtTrfTxInf = cdtTrfTxInf;
		}

	}

	@XmlRootElement(name = "grpHdr")
	public static class GrpHdr {
		private String msgId;
		// TODO: Complete all fields

		public String getMsgId() {
			return msgId;
		}

		@XmlElement(name = "msgId")
		public void setMsgId(String msgId) {
			this.msgId = msgId;
		}
	}

	@XmlRootElement(name = "cdtTrfTxInf")
	public static class CdtTrfTxInf {
		private long intrBkSttlmAmt;
		// TODO: Complete all fields

		public long getIntrBkSttlmAmt() {
			return intrBkSttlmAmt;
		}

		@XmlElement(name = "intrBkSttlmAmt")
		public void setIntrBkSttlmAmt(long intrBkSttlmAmt) {
			this.intrBkSttlmAmt = intrBkSttlmAmt;
		}
	}
}
