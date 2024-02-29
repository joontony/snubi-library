/**************************************************************************************** 
 * File Name    : BioEmrFormXml.java
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : 
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.06.19  mh.choi    Create
****************************************************************************************/
package org.snubi.lib.xml;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.snubi.lib.model.xml.ModelBioEmrCrf;
import org.snubi.lib.model.xml.ModelBioEmrCrfForm;
import org.snubi.lib.model.xml.ModelBioEmrCrfJaxB;
import org.snubi.lib.model.xml.ModelBioEmrCrfQuestion;
import org.snubi.lib.model.xml.ModelBioEmrCrfSection;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class BioEmrFormXml extends XmlUtil {
	
	ModelBioEmrCrfJaxB clsModelBioEmrCrfJaxB = new ModelBioEmrCrfJaxB();
	
	public Map<String,ModelBioEmrCrfQuestion> getMapParameterMap() {
		Map<String,ModelBioEmrCrfQuestion> mapModelBioEmrCrfQuestion = new HashMap<String,ModelBioEmrCrfQuestion>();
		List<ModelBioEmrCrfSection> listModelBioEmrCrfSection = clsModelBioEmrCrfJaxB.getListModelBioEmrCrfSection();
		for (int i = 0; i < listModelBioEmrCrfSection.size(); i++) {
			List<ModelBioEmrCrfQuestion> listModelBioEmrCrfQuestion = listModelBioEmrCrfSection.get(i).getListModelBioEmrCrfQuestion();
			if (listModelBioEmrCrfQuestion != null) {
				for(int j = 0; j < listModelBioEmrCrfQuestion.size(); j++) {
					mapModelBioEmrCrfQuestion.put(listModelBioEmrCrfQuestion.get(j).getParameterName(),listModelBioEmrCrfQuestion.get(j));
				}
			}
		}
		return mapModelBioEmrCrfQuestion;
	}
	
	public ModelBioEmrCrfJaxB parseXMLByJaxB(File clsFileParamter) throws Exception {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ModelBioEmrCrfJaxB.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			this.clsModelBioEmrCrfJaxB = (ModelBioEmrCrfJaxB) jaxbUnmarshaller.unmarshal(clsFileParamter);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return this.clsModelBioEmrCrfJaxB;
	}
	
	/**
	 * 가능하다면 parseXMLByJaxB 를 사용하라.
	 * 아래 메쏘드는 실제 xml 엔티티명을 명시해야 한다.
	 */
	public ModelBioEmrCrf parseXML(File clsFileParamter) throws Exception {
		
		InputSource clsInputSource = new InputSource(new FileReader(clsFileParamter.getAbsolutePath()));
		DocumentBuilderFactory clsDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		clsDocumentBuilderFactory.setNamespaceAware(true);
        DocumentBuilder clsDocumentBuilder = clsDocumentBuilderFactory.newDocumentBuilder();
        Document clsDocument = clsDocumentBuilder.parse(clsInputSource);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        
        ModelBioEmrCrf clsModelBioEmrCrf = new ModelBioEmrCrf();
        ModelBioEmrCrfForm clsModelBioEmrCrfForm = new ModelBioEmrCrfForm();
        ModelBioEmrCrfSection clsModelBioEmrCrfSection = new ModelBioEmrCrfSection();
        
        clsModelBioEmrCrfForm.setId(Long.parseLong(xpath.compile("/form/id").evaluate(clsDocument)));
        clsModelBioEmrCrfForm.setName(xpath.compile("/form/name").evaluate(clsDocument));
        clsModelBioEmrCrf.setClsModelBioEmrCrfForm(clsModelBioEmrCrfForm);
        		
        XPathExpression clsXPathExpression = xpath.compile("/form/section");
        NodeList clsNodeList = (NodeList) clsXPathExpression.evaluate(clsDocument, XPathConstants.NODESET);
        NodeList clsNodeListChild = null;
        Node clsNode = null;
        
        for(int i = 0; i < clsNodeList.getLength(); i++) {
        	clsNodeListChild = clsNodeList.item(i).getChildNodes();        	
            for (int j = 0; j < clsNodeListChild.getLength(); j++) {
            	clsNode = clsNodeListChild.item(j);
                if(clsNode.getNodeType() == 1) {                	
                	if(clsNode.getNodeName().equals("question") == true) {
                		clsModelBioEmrCrfSection.addListModelBioEmrCrfQuestion(parseNodeQuestion(clsNode));
                	} else {
                		System.out.println("node : " + clsNode.getNodeName() + " >> " + clsNode.getTextContent());
                	}
                }
            }
        }		
		return null;
	}	
	/**
	 * 가능하다면 parseXMLByJaxB 를 사용하라.
	 */
	private ModelBioEmrCrfQuestion parseNodeQuestion(Node clsNode) {
		ModelBioEmrCrfQuestion clsModelBioEmrCrfQuestion = new ModelBioEmrCrfQuestion();
		NodeList listNode = clsNode.getChildNodes();
		Node clsChildNode = null;
		for(int i = 0; i < listNode.getLength(); i ++) {
			clsChildNode = listNode.item(i);
			if(clsNode.getNodeType() == 1) {	
				/**
				 * 아래 실제 엔티티명으로 할당해야한다.
				 */
				System.out.println("Question >> " + clsChildNode.getNodeName() + " >> " + clsChildNode.getTextContent());
			}
		}
		return clsModelBioEmrCrfQuestion;
	}
}