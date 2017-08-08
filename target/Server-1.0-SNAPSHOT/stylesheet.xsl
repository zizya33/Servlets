<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version = "1.0"
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" encoding="iso-8859-1" />
<xsl:template match="Name"> 
     <h2 style="color:red; box-shadow: 10px 10px 10px black">
          <xsl:apply-templates/>
     </h2>
</xsl:template>
<xsl:template match="Note"> 
     <div style="color:green"><i>
          ---&#160;<xsl:value-of select="."/>---
     </i></div> 
</xsl:template>
<xsl:template match="Soil|ColorOfStem|ColorOfLeaf|AverageSize|Temperature|Lighting|Watering|Multiplying"> 
     <div style="text-shadow: 1px 1px 1px black">
          <xsl:value-of select="name()"/>:<div style="color:purple; display:inline-block"><xsl:apply-templates/></div>
     </div> 
</xsl:template>
<xsl:template match="Lighting"> 
</xsl:template>
</xsl:stylesheet> 