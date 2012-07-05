<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:svrl="http://purl.oclc.org/dsdl/svrl" version="2.0">
  <xsl:output method="html" indent="yes"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>
          <xsl:value-of select="//svrl:text"/>
        </title>
      </head>
      <body>
        <xsl:apply-templates/>
      </body>
    </html>
  </xsl:template>
  <xsl:template match="svrl:text">
    <h2 align="center">
      <xsl:apply-templates/>
    </h2>
  </xsl:template>
  <xsl:template match="svrl:text[2]">
    <h3 align="left">
      <font color="magenta">
        <xsl:value-of select="substring-after(., '/')"/>
      </font>
    </h3>
  </xsl:template>
  <xsl:template match="svrl:failed-assert">
    <p>
      <font color="green">
        <xsl:value-of select="concat(@line, '-', @column, ': ')"/>
      </font>
      <xsl:choose>
        <xsl:when test="@flag = 'fatal'">
          <font color="red">
            <xsl:value-of select="concat('ERROR: ', svrl:text)"/>
          </font>
        </xsl:when>
        <xsl:when test="@flag = 'warning'">
          <font color="blue">
            <xsl:value-of select="concat('WARNING: ', svrl:text)"/>
          </font>
        </xsl:when>
      </xsl:choose>
    </p>
  </xsl:template>
</xsl:stylesheet>
