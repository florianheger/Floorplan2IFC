// This file was automatically generated from IFCDOC at https://technical.buildingsmart.org/.
// Very slight modifications were made to made content align with ifcXML reference examples.
// Use this class library to create IFC-compliant (web) applications with XML and JSON data.
// Author: Pieter Pauwels, Eindhoven University of Technology

package com.buildingsmart.tech.ifc.IfcProductExtension;

import com.buildingsmart.tech.annotations.*;
import com.buildingsmart.tech.ifc.IfcMeasureResource.IfcIdentifier;
import com.buildingsmart.tech.ifc.IfcSharedBldgElements.IfcRelCoversBldgElements;
import com.buildingsmart.tech.ifc.IfcSharedComponentElements.IfcElementComponent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.HashSet;
import java.util.Set;

@Guid("9ab3f33b-7e80-4290-afe5-1e7a055cd3ac")
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = IfcBuildingElement.class, name = "IfcBuildingElement"), @JsonSubTypes.Type(value = IfcCivilElement.class, name = "IfcCivilElement"), @JsonSubTypes.Type(value = IfcDistributionElement.class, name = "IfcDistributionElement"), @JsonSubTypes.Type(value = IfcElementAssembly.class, name = "IfcElementAssembly"), @JsonSubTypes.Type(value = IfcElementComponent.class, name = "IfcElementComponent"), @JsonSubTypes.Type(value = IfcFeatureElement.class, name = "IfcFeatureElement"), @JsonSubTypes.Type(value = IfcFurnishingElement.class, name = "IfcFurnishingElement"), @JsonSubTypes.Type(value = IfcGeographicElement.class, name = "IfcGeographicElement"), @JsonSubTypes.Type(value = IfcTransportElement.class, name = "IfcTransportElement"), @JsonSubTypes.Type(value = IfcVirtualElement.class, name = "IfcVirtualElement")})
public abstract class IfcElement extends com.buildingsmart.tech.ifc.IfcKernel.IfcProduct implements com.buildingsmart.tech.ifc.IfcStructuralAnalysisDomain.IfcStructuralActivityAssignmentSelect
{
	@Description("The tag (or label) identifier at the particular instance of a product, e.g. the serial number, or the position number. It is the identifier at the occurrence level.")
	@DataMember(Order = 0)
	@Guid("dcdb600f-7074-41a2-b876-9fb8a9bdb8ec")
	@JacksonXmlProperty(isAttribute=false, localName = "tag")
	private IfcIdentifier tag;

	@Description("Reference to the <em>IfcRelFillsElement</em> Relationship that puts the element as a filling into the opening created within another element.")
	@InverseProperty(InverseProp = "relatedBuildingElement", Range = "IfcRelFillsElement")
	@Guid("013896b3-ab8f-4c8f-b6e5-b79d6fd26de9")
	@MaxLength(1)
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelFillsElement")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "fillsVoids")
	private Set<IfcRelFillsElement> fillsVoids = new HashSet<>();

	@Description("Reference to the element connection relationship. The relationship then refers to the other element to which this element is connected to.")
	@InverseProperty(InverseProp = "relatingElement", Range = "IfcRelConnectsElements")
	@Guid("5cf4ed22-8e56-4d03-b682-58bb0794ddac")
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelConnectsElements")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "connectedTo")
	private Set<IfcRelConnectsElements> connectedTo;

	@Description("Reference to the interference relationship to indicate the element that is interfered. The relationship, if provided, indicates that this element has an interference with one or many other elements.  <blockquote class=\"note\">NOTE&nbsp; There is no indication of precedence between <em>IsInterferedByElements</em> and <em>InterferesElements</em>. </blockquote>  <blockquote class=\"change-ifc2x4\">IFC4 CHANGE  New inverse relationship.</blockquote>")
	@InverseProperty(InverseProp = "relatedElement", Range = "IfcRelInterferesElements")
	@Guid("3c54bf0c-7ae9-4dc5-ab08-97a56e21f509")
	/*@JacksonXmlProperty(isAttribute = false, localName = "IfcRelInterferesElements")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "isInterferedByElements")*/
	@JsonIgnore
	private Set<IfcRelInterferesElements> isInterferedByElements;

	@Description("Reference to the interference relationship to indicate the element that interferes. The relationship, if provided, indicates that this element has an interference with one or many other elements.  <blockquote class=\"note\">NOTE&nbsp; There is no indication of precedence between <em>IsInterferedByElements</em> and <em>InterferesElements</em>.</blockquote>  <blockquote class=\"change-ifc2x4\">IFC4 CHANGE  New inverse relationship.</blockquote>")
	@InverseProperty(InverseProp = "relatingElement", Range = "IfcRelInterferesElements")
	@Guid("458d5013-ddf1-45f7-b9e5-f043c827ad9c")
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelInterferesElements")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "interferesElements")
	private Set<IfcRelInterferesElements> interferesElements;

	@Description("Projection relationship that adds a feature (using a Boolean union) to the <em>IfcBuildingElement</em>.")
	@InverseProperty(InverseProp = "relatingElement", Range = "IfcRelProjectsElement")
	@Guid("4faee8d9-3beb-4087-9728-11eb04b2e9dd")
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelProjectsElement")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "hasProjections")
	private Set<IfcRelProjectsElement> hasProjections;

	@Description("Reference relationship to the spatial structure element, to which the element is additionally associated. This relationship may not be hierarchical, an element may be referenced by zero, one or many spatial structure elements.  <blockquote class=\"change-ifc2x3\">IFC2x3 CHANGE&nbsp; The inverse attribute has been added with upward compatibility for file based exchange.</blockquote>")
	@InverseProperty(InverseProp = "relatedElements", Range = "IfcRelReferencedInSpatialStructure")
	@Guid("f72e6148-b614-4908-b276-5d15ac3222ce")
	/*@JacksonXmlProperty(isAttribute = false, localName = "IfcRelReferencedInSpatialStructure")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "referencedInStructures")*/
	@JsonIgnore
	private Set<IfcRelReferencedInSpatialStructure> referencedInStructures;

	@Description("Reference to the <em>IfcRelVoidsElement</em> relationship that creates an opening in an element. An element can incorporate zero-to-many openings. For each opening, that voids the element, a new relationship <em>IfcRelVoidsElement</em> is generated.")
	@InverseProperty(InverseProp = "relatingBuildingElement", Range = "IfcRelVoidsElement")
	@Guid("887366e1-d446-4f3b-8643-605d00ce2c16")
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelVoidsElement")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "hasOpenings")
	private Set<IfcRelVoidsElement> hasOpenings = new HashSet<>();

	@Description("Reference to the connection relationship with realizing element. The relationship, if provided, assigns this element as the realizing element to the connection, which provides the physical manifestation of the connection relationship.")
	@InverseProperty(InverseProp = "realizingElements", Range = "IfcRelConnectsWithRealizingElements")
	@Guid("093ff6ec-c8af-4a34-8578-91694c1273f1")
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelConnectsWithRealizingElements")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "isConnectionRealization")
	private Set<IfcRelConnectsWithRealizingElements> isConnectionRealization;

	@Description("Reference to space boundaries by virtue of the objectified relationship <em>IfcRelSpaceBoundary</em>. It defines the concept of an element bounding spaces.")
	@InverseProperty(InverseProp = "relatedBuildingElement", Range = "IfcRelSpaceBoundary")
	@Guid("94ab1bc4-3273-4afe-998f-9be7c26a2294")
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelSpaceBoundary")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "providesBoundaries")
	private Set<IfcRelSpaceBoundary> providesBoundaries;

	@Description("Reference to the element connection relationship. The relationship then refers to the other element that is connected to this element.")
	@InverseProperty(InverseProp = "relatedElement", Range = "IfcRelConnectsElements")
	@Guid("2bd302cf-6ded-4b81-ae7b-34c479d3014c")
	@JsonIgnore
	/*@JacksonXmlProperty(isAttribute = false, localName = "IfcRelConnectsElements")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "connectedFrom")*/
	private Set<IfcRelConnectsElements> connectedFrom;

	@Description("Containment relationship to the spatial structure element, to which the element is primarily associated. This containment relationship has to be hierachical, i.e. an element may only be assigned directly to zero or one spatial structure.")
	@InverseProperty(InverseProp = "relatedElements", Range = "IfcRelContainedInSpatialStructure")
	@Guid("e0676768-f79e-407b-9147-49374bb82e14")
	@MaxLength(1)
	/*@JacksonXmlProperty(isAttribute = false, localName = "IfcRelContainedInSpatialStructure")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "containedInStructure")*/
	@JsonIgnore
	private Set<IfcRelContainedInSpatialStructure> containedInStructure;

	@Description("Reference to <em>IfcCovering</em> by virtue of the objectified relationship <em>IfcRelCoversBldgElement</em>. It defines the concept of an element having coverings associated.")
	@InverseProperty(InverseProp = "relatingBuildingElement", Range = "IfcRelCoversBldgElements")
	@Guid("e73f220c-19f9-4fbd-9302-9b407708ffdf")
	@JacksonXmlProperty(isAttribute = false, localName = "IfcRelCoversBldgElements")
	@JacksonXmlElementWrapper(useWrapping = true, localName = "hasCoverings")
	private Set<IfcRelCoversBldgElements> hasCoverings;


	public IfcElement()
	{
	}

	public IfcElement(String globalId)
	{
		super(globalId);
	}

	public IfcIdentifier getTag() {
		return this.tag;
	}

	public void setTag(IfcIdentifier tag) {
		this.tag = tag;
	}

	public Set<IfcRelFillsElement> getFillsVoids() {
		return this.fillsVoids;
	}

	public Set<IfcRelConnectsElements> getConnectedTo() {
		return this.connectedTo;
	}

	public Set<IfcRelInterferesElements> getIsInterferedByElements() {
		return this.isInterferedByElements;
	}

	public Set<IfcRelInterferesElements> getInterferesElements() {
		return this.interferesElements;
	}

	public Set<IfcRelProjectsElement> getHasProjections() {
		return this.hasProjections;
	}

	public Set<IfcRelReferencedInSpatialStructure> getReferencedInStructures() {
		return this.referencedInStructures;
	}

	public Set<IfcRelVoidsElement> getHasOpenings() {
		return this.hasOpenings;
	}

	public Set<IfcRelConnectsWithRealizingElements> getIsConnectionRealization() {
		return this.isConnectionRealization;
	}

	public Set<IfcRelSpaceBoundary> getProvidesBoundaries() {
		return this.providesBoundaries;
	}

	public Set<IfcRelConnectsElements> getConnectedFrom() {
		return this.connectedFrom;
	}

	public Set<IfcRelContainedInSpatialStructure> getContainedInStructure() {
		return this.containedInStructure;
	}

	public Set<IfcRelCoversBldgElements> getHasCoverings() {
		return this.hasCoverings;
	}


}

